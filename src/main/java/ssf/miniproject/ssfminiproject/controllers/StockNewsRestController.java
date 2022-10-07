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

}