package ssf.miniproject.ssfminiproject.models;

import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;

public class StockScreener {
    
    private String symbol;
    private String companyName;
    private Integer marketCap;
    private String sector;
    private String industry;
    private JsonNumber price;
    private JsonNumber lastAnnualDividend;
    private Integer volume;
    private String exchangeShortName;
    private String country;

    

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Integer marketCap) {
        this.marketCap = marketCap;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public JsonNumber getPrice() {
        return price;
    }

    public void setPrice(JsonNumber price) {
        this.price = price;
    }

    public JsonNumber getLastAnnualDividend() {
        return lastAnnualDividend;
    }

    public void setLastAnnualDividend(JsonNumber lastAnnualDividend) {
        this.lastAnnualDividend = lastAnnualDividend;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getExchangeShortName() {
        return exchangeShortName;
    }

    public void setExchangeShortName(String exchangeShortName) {
        this.exchangeShortName = exchangeShortName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static StockScreener create(JsonObject jo) {
        StockScreener s = new StockScreener();
        s.setSymbol(jo.getString("symbol"));
        s.setCompanyName(jo.getString("companyName"));
        s.setMarketCap(jo.getInt("marketCap"));
        s.setSector(jo.getString("sector"));
        s.setIndustry(jo.getString("industry"));
        s.setPrice(jo.getJsonNumber("price"));
        s.setLastAnnualDividend(jo.getJsonNumber("lastAnnualDividend"));
        s.setVolume(jo.getInt("volume"));
        s.setExchangeShortName(jo.getString("exchangeShortName"));
        s.setCountry(jo.getString("country"));

        return s;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("symbol", symbol)
        .add("companyName", companyName)
        .add("marketCap", marketCap)
        .add("sector", sector)
        .add("industry", industry)
        .add("price", price)
        .add("lastAnnualDividend", lastAnnualDividend)
        .add("volume", volume)
        .add("exchangeShortName", exchangeShortName)
        .add("country", country)
        .build();
    }

   
}