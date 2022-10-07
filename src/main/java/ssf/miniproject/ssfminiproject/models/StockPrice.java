package ssf.miniproject.ssfminiproject.models;

import jakarta.json.Json;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;

public class StockPrice {

    private String symbol;
    private JsonNumber price;
    private JsonNumber beta;
    private Integer volAvg;
    private Integer mktCap;
    private JsonNumber lastDiv;
    private String range;
    private JsonNumber changes;
    private String companyName;
    private String currency;
    private String isin;
    private String exchangeShortName;
    private String industry;
    private String description;
    private String website;
    private String sector;
    private String ceo;

   
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public JsonNumber getPrice() {
        return price;
    }
    public void setPrice(JsonNumber price) {
        this.price = price;
    }
    public JsonNumber getBeta() {
        return beta;
    }
    public void setBeta(JsonNumber beta) {
        this.beta = beta;
    }
    public Integer getVolAvg() {
        return volAvg;
    }
    public void setVolAvg(Integer volAvg) {
        this.volAvg = volAvg;
    }
    public Integer getMktCap() {
        return mktCap;
    }
    public void setMktCap(Integer mktCap) {
        this.mktCap = mktCap;
    }
    public JsonNumber getLastDiv() {
        return lastDiv;
    }
    public void setLastDiv(JsonNumber lastDiv) {
        this.lastDiv = lastDiv;
    }
    public String getRange() {
        return range;
    }
    public void setRange(String range) {
        this.range = range;
    }
    public JsonNumber getChanges() {
        return changes;
    }
    public void setChanges(JsonNumber changes) {
        this.changes = changes;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {
        this.isin = isin;
    }
    public String getExchangeShortName() {
        return exchangeShortName;
    }
    public void setExchangeShortName(String exchangeShortName) {
        this.exchangeShortName = exchangeShortName;
    }

    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getCeo() {
        return ceo;
    }
    public void setCeo(String ceo) {
        this.ceo = ceo;
    }
    public static StockPrice create(JsonObject jo) {
        StockPrice sp = new StockPrice();
        sp.setSymbol(jo.getString("symbol"));
        sp.setPrice(jo.getJsonNumber("price"));
        sp.setBeta(jo.getJsonNumber("beta"));
        sp.setVolAvg(jo.getInt("volAvg"));
        sp.setMktCap(jo.getInt("mktCap"));
        sp.setLastDiv(jo.getJsonNumber("lastDiv"));
        sp.setRange(jo.getString("range"));
        sp.setChanges(jo.getJsonNumber("changes"));
        sp.setCompanyName(jo.getString("companyName"));
        sp.setCurrency(jo.getString("currency"));
        sp.setIsin(jo.getString("isin"));
        sp.setExchangeShortName(jo.getString("exchangeShortName"));
        sp.setIndustry(jo.getString("industry"));
        sp.setDescription(jo.getString("description"));
        sp.setWebsite(jo.getString("website"));
        sp.setSector(jo.getString("sector"));
        sp.setCeo(jo.getString("ceo"));

        return sp;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("symbol", symbol)
        .add("price", price)
        .add("beta", beta)
        .add("volAvg", volAvg)
        .add("mktCap", mktCap)
        .add("lastDiv", lastDiv)
        .add("range", range)
        .add("changes", changes)
        .add("companyName", companyName)
        .add("currency", currency)
        .add("isin", isin)
        .add("exchangeShortName", exchangeShortName)
        .add("industry", industry)
        .add("description", description)
        .add("website", website)
        .add("sector", sector)
        .add("ceo", ceo)
        .build();
    }


    
}
