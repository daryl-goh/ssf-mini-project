package ssf.miniproject.ssfminiproject.services;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import ssf.miniproject.ssfminiproject.models.Traffic;

@Service
public class TrafficService {
    
    private static final String URL ="https://api.data.gov.sg/v1/transport/traffic-images";

    // @Value("${API_KEY}")
    // private String api_key;

    public List<Traffic> getTraffic(String date_time){
        String payload;

        String url = UriComponentsBuilder.fromUriString(URL)
            .queryParam("date_time", date_time)
            // .queryParam("api_key", api_key)
            .toUriString();

            RequestEntity<Void> req = RequestEntity.get(url).build();

            RestTemplate template = new RestTemplate();

            ResponseEntity<String> resp = template.exchange(req, String.class);

            payload = resp.getBody();
            System.out.println("payload: " + payload);

            Reader stringReader = new StringReader(payload);
            JsonReader jsonReader = Json.createReader(stringReader);
            JsonObject jsonObject = jsonReader.readObject();
            JsonArray data = jsonObject.getJsonArray("items");
            List<Traffic> list = new LinkedList<>();
            for (int i = 0; i < data.size(); i++) {
                JsonObject jo = data.getJsonObject(i);
                list.add(Traffic.create(jo));
            }
            return list;
            
    } 
            
}