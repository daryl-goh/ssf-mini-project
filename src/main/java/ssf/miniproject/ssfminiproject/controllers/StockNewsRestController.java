package ssf.miniproject.ssfminiproject.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import ssf.miniproject.ssfminiproject.models.StockNews;
import ssf.miniproject.ssfminiproject.services.StockService;

@RestController
@RequestMapping(path="/savednews", produces = MediaType.APPLICATION_JSON_VALUE)
public class StockNewsRestController {
  @Autowired
  private StockService stockSvc;


  @GetMapping(path="{symbol}")
	public ResponseEntity<String> getNews(@PathVariable(name="symbol") String symbol) {
		Optional<StockNews> opt = stockSvc.get(symbol);
		if (opt.isEmpty()) {
			JsonObject payload = Json.createObjectBuilder()
				.add("error", "Cannot find article %s".formatted(symbol))
				.build();
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(payload.toString());
		}
		StockNews article = opt.get();
		return ResponseEntity.ok(article.toJson().toString());
	}

//    @GetMapping(value="/{symbol}", produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<String> getRollAsJson(@PathVariable("symbol") String symbol, Model model) {

//         StockNews snResult = stockNewsSvc.getNewsBySymbol(symbol);

//         if (snResult == null){
//            JsonObject errResp = Json
//                     .createObjectBuilder()
//                     .add("error", "Cannot find news article %s".formatted(symbol))
//                     .build();
//             String payload = errResp.toString();
//             // Return 400
//             return ResponseEntity
//                     //.status(HttpStatus.BAD_REQUEST)
//                     .badRequest() //400
//                     .body(payload);
//         }

//         // Create the response payload
//         JsonObjectBuilder builder = Json
//                 .createObjectBuilder()
//                 .add("symbol", snResult.getSymbol())
//                 .add("publishedDate", snResult.getPublishedDate())
//                 .add("title", snResult.getTitle())
//                 .add("image", snResult.getImage())
//                 .add("site", snResult.getSite())
//                 .add("text", snResult.getText())
//                 .add("url", snResult.getUrl());
             

//         // Get the JsonObject object from JsonBuilder
//         JsonObject resp = builder.build();

//         return ResponseEntity.ok(resp.toString());
//     }

}