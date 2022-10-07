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

}
