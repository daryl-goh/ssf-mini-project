package ssf.miniproject.ssfminiproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.miniproject.ssfminiproject.models.Traffic;
import ssf.miniproject.ssfminiproject.services.TrafficService;

@Controller
@RequestMapping(path={"/", ""})
public class TrafficController {
    
    @Autowired
    private TrafficService trafficSvc;

    @GetMapping(path={"/traffic"})
        private String trafficimages(
            Model model,
            @RequestParam(name="date_time") String date_time
          
        ) {

            List<Traffic> data = trafficSvc.getTraffic(date_time);
            model.addAttribute("date_time", date_time);
            model.addAttribute("data", data);

            return "traffic";
    } 
}
