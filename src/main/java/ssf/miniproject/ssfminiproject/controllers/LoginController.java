package ssf.miniproject.ssfminiproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path={"/"})
public class LoginController {

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    //Update Name Page Controller
    @GetMapping(path={"/login"})
    public String updateName(Model model) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        Object greetings = ops.get("greetings");
        model.addAttribute("hello", greetings.toString());
        return "login";
    }

    
}
