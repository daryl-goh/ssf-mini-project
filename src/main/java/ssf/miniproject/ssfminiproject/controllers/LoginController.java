package ssf.miniproject.ssfminiproject.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;
import ssf.miniproject.ssfminiproject.repositories.RedisRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path={"/"})
public class LoginController {


    @Autowired
    private RedisRepository repository;

    //Login Controller
    @GetMapping(path={"/login"})
    public String loginPrompt(Model model) {

        return "login";
    }

	//After Username Entered
    @PostMapping(path={"/login2"})
    public String postLogin(@RequestBody MultiValueMap<String, String> form, Model model, RedirectAttributes redirectAttributes) {

        String username = form.getFirst("username");
        redirectAttributes.addFlashAttribute("username", username);
        return "redirect:/showData";
    }

    @GetMapping(path={"/showData"})
    public String showData(HttpServletRequest request, Model model) {
        String username;
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        username =  (String) flashMap.get("username");

        List<String> values = repository.get(username);

        String symbol = "No data available";

        if (values != null && values.size() > 0) {
            symbol = values.stream().collect(
                    Collectors.joining(", "));
        }
        model.addAttribute("username", username);
        model.addAttribute("symbol", symbol);
        return "login2";
    }

    // Add Ticker
    @PostMapping(path={"/login3"}, params = "symbol=add")
    public RedirectView addTicker(@RequestBody MultiValueMap<String, String> form, RedirectAttributes redirectAttributes) {

        String username = form.getFirst("username");
        String value = form.getFirst("list");

        repository.add(username, value);
        redirectAttributes.addFlashAttribute("username", username);
        return new RedirectView("/showData", true);
    }

    // Remove Ticker
    @PostMapping(path={"/login3"}, params = "symbol=remove")
    public RedirectView removeTicker(@RequestBody MultiValueMap<String, String> form, RedirectAttributes redirectAttributes) {

        String username = form.getFirst("username");
        String value = form.getFirst("list");

        repository.remove(username, value);
        redirectAttributes.addFlashAttribute("username", username);
        return new RedirectView("/showData", true);
    }

}