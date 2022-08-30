package ssf.miniproject.ssfminiproject.services;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import ssf.miniproject.ssfminiproject.models.StockScreener;

@Service
public class StockScreenerService {
    
    private static final String URL ="https://financialmodelingprep.com/api/v3/stock-screener";

    @Value("${API_KEY}")
    private String apikey;

    public List<StockScreener> getStock(String limit, String priceMoreThan, String priceLowerThan, String dividendMoreThan, 
    String dividendLowerThan, String volumeMoreThan, String volumeLowerThan, String country, String exchange) {
        String payload;

        String url = UriComponentsBuilder.fromUriString(URL)
            .queryParam("limit", limit)
            .queryParam("priceMoreThan", priceMoreThan)
            .queryParam("priceLowerThan", priceLowerThan)
            .queryParam("dividendMoreThan ", dividendMoreThan )
            .queryParam("dividendLowerThan ", dividendLowerThan )
            .queryParam("volumeMoreThan", volumeMoreThan)
            .queryParam("volumeLowerThan", volumeLowerThan)
            .queryParam("country", country)
            .queryParam("exchange", exchange)
            .queryParam("apikey", apikey)
            .toUriString();

            RequestEntity<Void> req = RequestEntity.get(url).build();

            RestTemplate template = new RestTemplate();

            ResponseEntity<String> resp = template.exchange(req, String.class);

            payload = resp.getBody();
            System.out.println("payload: " + payload);

            Reader stringReader = new StringReader(payload);
            JsonReader jsonReader = Json.createReader(stringReader);
            JsonArray data = jsonReader.readArray();
 
            List<StockScreener> list = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                JsonObject jo = data.getJsonObject(i);
                System.out.println("Json Object: " + jo);
                list.add(StockScreener.create(jo));
            }

            // System.out.println("Stock Screener: " + list);
            return list;
             
            
    } 
            
}