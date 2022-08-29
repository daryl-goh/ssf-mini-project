package ssf.miniproject.ssfminiproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.miniproject.ssfminiproject.models.StockNews;
import ssf.miniproject.ssfminiproject.services.StockNewsService;

@Controller
@RequestMapping(path={"/", "/home", "/index"})
public class StockNewsController {

    @Autowired
    private StockNewsService stockNewsSvc;

    @Value("${welcome.message}")
    private String message;
    
    // @GetMapping(value = { "/", "/home", "/index" })
    // public String index(Model model) {
    //     model.addAttribute("message", message);

    //     return "index";
    // }

    @GetMapping(value = { "/stocknews1" })
    public String stocksearch(Model model) {
        model.addAttribute("message", message);

        return "stocknews1";
    }

    @GetMapping(path={"/stocknews2"})
        public String getStockNews(
            Model model, 
            @RequestParam(name="tickers") String tickers, 
            @RequestParam(name="limit") Integer limit) {

            List<StockNews> stock = stockNewsSvc.getStockNews(tickers, limit);

            model.addAttribute("stock", stock);

            return "stocknews2";
    } 
}