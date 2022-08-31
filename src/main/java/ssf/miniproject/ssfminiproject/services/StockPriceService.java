package ssf.miniproject.ssfminiproject.services;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class StockPriceService {
    
    private static final String URL ="https://financialmodelingprep.com/api/v4/company-outlook";

    @Value("${API_KEY}")
    private String apikey;

    public List<JsonObject> getStockPrice(String symbol) {
        String payload;

        String url = UriComponentsBuilder.fromUriString(URL)
            .queryParam("symbol", symbol)
            .queryParam("apikey", apikey)
            .toUriString();

            RequestEntity<Void> req = RequestEntity.get(url).build();

            RestTemplate template = new RestTemplate();

            ResponseEntity<String> resp = template.exchange(req, String.class);

            payload = resp.getBody();
            System.out.println("payload: " + payload);

            Reader stringReader = new StringReader(payload);
            JsonReader jsonReader = Json.createReader(stringReader);
            JsonObject data = jsonReader.readObject();
           
            JsonObject data2 = data.getJsonObject("profile");

            List<JsonObject> list = new LinkedList<>();
            list.add(data2);

            System.out.println("Data: " + list);
            
            return list;
    } 
            
}