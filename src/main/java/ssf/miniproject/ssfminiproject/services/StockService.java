package ssf.miniproject.ssfminiproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssf.miniproject.ssfminiproject.models.StockNews;
import ssf.miniproject.ssfminiproject.repositories.StockRepository;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepo;
    
    public void saveStock(List<StockNews> stockToSave) {
        for (StockNews sp : stockToSave) {
            stockRepo.save(sp);
        }
        
    }

    public Optional<StockNews> get(String symbol) {
		return stockRepo.get(symbol);
	}

    // public StockNews getNewsBySymbol (String symbol){
    //     System.out.println("StockService - getNewsBySymbol symbol: " + symbol);
    //     Optional<String> opt = stockRepo.getArticle(symbol);
    //     String payload;
    //     if (opt.isEmpty()){
    //       return null;
    //     } else{
    //       payload = opt.get();
    //       System.out.println("StockService - getNewsBySymbol -[PAYLOAD]:  " + payload);
    //       // Convert Payload to JsonObject
    //       // Convert the String to a Reader
    //       Reader strReader = new StringReader(payload);
    //       // Create a JsonReader from reader
    //       JsonReader jsonReader = Json.createReader(strReader);
    //       JsonObject newsObject = jsonReader.readObject();
    //       return StockNews.create(newsObject);
    //     }
    //   }
}
