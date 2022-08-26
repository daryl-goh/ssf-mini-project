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
import ssf.miniproject.ssfminiproject.models.Stock;

@Service
public class StockService {
    
    private static final String URL ="https://financialmodelingprep.com/api/v3/stock-screener";

    @Value("${API_KEY}")
    private String apikey;

    public List<Stock> getStock(String limit, String priceMoreThan, String priceLowerThan, String dividendMoreThan, 
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
            // String data2 = data.toString();

            // JsonArray data = new JsonArray(symbol);
            List<Stock> list = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                JsonObject jo = data.getJsonObject(i);
                System.out.println(jo);
                list.add(Stock.create(jo));
            //     String data3 = jo.getString("symbol");
            //     String data4 = jo.getString("sector");
            //     list.add(data3);
            //     list.add(data4);
            }

            System.out.println("READ THIS: " + list);
            return list;
             
            
    } 
            
}