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

@Controller
@RequestMapping(path={"/"})
public class LoginController {

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    //Login Page Controller
    @GetMapping(path={"/login"})
    public String loginPrompt(Model model) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        Object login = ops.get("login");
        model.addAttribute("hello", login.toString());
        return "login";
    }

    @PostMapping(path={"/login2"})
    public String postLogin(@RequestBody MultiValueMap<String, String> form, Model model) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String text = form.getFirst("text");
        ops.set("greetings", text);
        model.addAttribute("hello", text);
        return "login2";
    }
    
}
