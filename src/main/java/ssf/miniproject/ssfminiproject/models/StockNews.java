package ssf.miniproject.ssfminiproject.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class StockNews {
    private String symbol;
    private String publishedDate;
    private String title;
    private String image;
    private String site;
    private String text;
    private String url;

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public static StockNews create(JsonObject data) {
        StockNews sn = new StockNews();
        sn.setSymbol(data.getString("symbol"));
        sn.setPublishedDate(data.getString("publishedDate"));
        sn.setTitle(data.getString("title"));
        sn.setImage(data.getString("image"));
        sn.setSite(data.getString("site"));
        sn.setText(data.getString("text"));
        sn.setUrl(data.getString("url"));

        return sn;
    }

    public static StockNews create(String json) {
		try (StringReader strReader = new StringReader(json)) {
			JsonReader j = Json.createReader(strReader);
			return create(j.readObject());
		}
	}

    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("symbol", symbol)
        .add("publishedDate", publishedDate)
        .add("title", title)
        .add("image", image)
        .add("site", site)
        .add("text", text)
        .add("url", url)
        .build();
    }

    
}
