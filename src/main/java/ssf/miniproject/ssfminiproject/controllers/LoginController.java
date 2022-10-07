package ssf.miniproject.ssfminiproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ssf.miniproject.ssfminiproject.models.StockNews;

@Controller
@RequestMapping(path={"/"})
public class LoginController {

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> template;

    //Login Page Controller
    @GetMapping(path={"/login"})
    public String loginPrompt(Model model) {

        return "login";
    }

	//Username Entered
    @PostMapping(path={"/login2"})
    public String postLogin(@RequestBody MultiValueMap<String, String> form, Model model) {
        ValueOperations<String, String> ops = template.opsForValue();
        String username = form.getFirst("username");
		String symbol = "TSLA";
        ops.set(username, symbol);
        model.addAttribute("username", username);
        model.addAttribute("symbol", symbol);
        return "login2";
    }


}