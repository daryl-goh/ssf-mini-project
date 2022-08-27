package ssf.miniproject.ssfminiproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.miniproject.ssfminiproject.models.Stock;
import ssf.miniproject.ssfminiproject.services.StockService;

@Controller
@RequestMapping(path={"/", "/home", "/index"})
public class StockController {
 
    @Autowired
    private StockService stockSvc;

    @Value("${welcome.message}")
    private String message;

    @GetMapping(value = { "/", "/home", "/index" })
    public String index(Model model) {
        model.addAttribute("message", message);

        return "index";
    }

    @GetMapping(value = { "/stockscreener1" })
    public String stocksearch(Model model) {
        model.addAttribute("message", message);

        return "stockscreener1";
    }

    @GetMapping(path={"/stockscreener2"})
        public String getStock(
            Model model, 
            @RequestParam(name="limit") String limit, 
            @RequestParam(name="priceMoreThan") String priceMoreThan, 
            @RequestParam(name="priceLowerThan") String priceLowerThan,
            @RequestParam(name="dividendMoreThan") String dividendMoreThan, 
            @RequestParam(name="dividendLowerThan") String dividendLowerThan,
            @RequestParam(name="volumeMoreThan") String volumeMoreThan,
            @RequestParam(name="volumeLowerThan") String volumeLowerThan,
            @RequestParam(name="country") String country, 
            @RequestParam(name="exchange") String exchange) {

            List<Stock> stock = stockSvc.getStock(limit, priceMoreThan, priceLowerThan, dividendMoreThan, dividendLowerThan,
            volumeMoreThan, volumeLowerThan, country, exchange);

            model.addAttribute("stock", stock);

            return "stockscreener2";
    } 
}