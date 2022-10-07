package ssf.miniproject.ssfminiproject.models;

import java.io.StringReader;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Symbols {
    private String symbols;
    private String username;
    
    public String getSymbols() {
        return symbols;
    }
    public void setSymbols(String symbols) {
        this.symbols = symbols;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public static Symbols create(String jsonStr) {
        StringReader reader = new StringReader(jsonStr);
        JsonReader r = Json.createReader(reader);
        return create(r.readObject());
    }

    public static Symbols create(JsonObject jo) {
        Symbols symbol = new Symbols();
        symbol.setSymbols(jo.getString("symbols"));
        symbol.setUsername(jo.getString("username"));
        return symbol;
    }
    

  
    
}
