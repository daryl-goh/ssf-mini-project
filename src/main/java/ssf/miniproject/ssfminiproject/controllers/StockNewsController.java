package ssf.miniproject.ssfminiproject.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.miniproject.ssfminiproject.models.StockNews;
import ssf.miniproject.ssfminiproject.models.StockPrice;
import ssf.miniproject.ssfminiproject.services.StockNewsService;
import ssf.miniproject.ssfminiproject.services.StockService;

@Controller
@RequestMapping(path={"/", "/home", "/index"})
public class StockNewsController {

    @Autowired
    private StockNewsService stockNewsSvc;

    @Autowired
    private StockService stockSvc;


    @Value("${welcome.message}")
    private String message;
    
    // @GetMapping(value = { "/", "/home", "/index" })
    // public String index(Model model) {
    //     model.addAttribute("message", message);

    //     return "index";
    // }

    @GetMapping(value = { "/stocknews1" })
    public String stocksearch(Model model, HttpSession sess) {
        sess.setAttribute("message", message);
        model.addAttribute("message", message);

        return "stocknews1";
    }

    @GetMapping(path={"/stocknews2"})
        public String getStockNews(
            Model model, 
            HttpSession sess,
            @RequestParam(name="tickers") String tickers, 
            @RequestParam(name="limit") Integer limit) {

            List<StockNews> stock = stockNewsSvc.getStockNews(tickers, limit);
            
            sess.setAttribute("stock", stock);
            model.addAttribute("stock", stock);

            return "stocknews2";
    } 

    // @PostMapping(path={"/stocknews2"})
    // public String saveStock(@RequestBody MultiValueMap<String, String> form,
    //         Model model,
    //         @RequestParam(name="tickers") String tickers, 
    //         @RequestParam(name="limit") Integer limit) {

    //         List<StockNews> stock = stockNewsSvc.getStockNews(tickers, limit);
            
    //         model.addAttribute("stock", stock);


    //         if (form == null) {
    //             System.out.println("No news to save.");
    //             return "stocknews2";
    //         }

    //         List<String> symbols = form.get("symbol");
            
    //         List<StockNews> newsToSave = new LinkedList<>();
    //         for (String symbol: symbols){
    //             System.out.println("StockNewsController - saveNews - symbol: " + symbol);
    //             for (StockNews sp: stock) {
    //                 if (symbol.equals(sp.getSymbol())){
    //                     newsToSave.add(sp);
    //                 }
    //             }
    //         }
                            
    //         System.out.println("StockNewsController: saveNews - newsToSave: " + newsToSave);

    //         stockSvc.saveStock(newsToSave);
            
    //         return "stocknews2";
                
    //         }
}