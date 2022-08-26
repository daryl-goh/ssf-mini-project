package ssf.miniproject.ssfminiproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.miniproject.ssfminiproject.models.Stock;
import ssf.miniproject.ssfminiproject.services.StockService;

@Controller
@RequestMapping(path={"/", ""})
public class StockController {
 
    @Autowired
    private StockService stockSvc;

    @GetMapping(path={"/stockscreener"})
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

            return "stockscreener";
    } 
}