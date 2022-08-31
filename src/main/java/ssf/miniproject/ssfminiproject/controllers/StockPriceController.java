package ssf.miniproject.ssfminiproject.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.json.JsonObject;
import ssf.miniproject.ssfminiproject.services.StockPriceService;

@Controller
@RequestMapping(path={"/", "/home", "/index"})
public class StockPriceController {

    @Autowired
    private StockPriceService stockPriceSvc;

    @Value("${welcome.message}")
    private String message;
    
    // @GetMapping(value = { "/", "/home", "/index" })
    // public String index(Model model) {
    //     model.addAttribute("message", message);

    //     return "index";
    // }

    @GetMapping(value = { "/stockprice1" })
    public String stocksearch(Model model, HttpSession sess) {
        sess.setAttribute("message", message);
        model.addAttribute("message", message);

        return "stockprice1";
    }

    @GetMapping(path={"/stockprice2"})
        public String getStockNews(
            Model model, 
            HttpSession sess,
            @RequestParam(name="symbol") String symbol) {

            List<JsonObject> stockprice = stockPriceSvc.getStockPrice(symbol);
            
            sess.setAttribute("stockprice", stockprice);
            model.addAttribute("stockprice", stockprice);

            return "stockprice2";
    } 
}