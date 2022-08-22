package ssf.miniproject.ssfminiproject.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Traffic {
    
    private String date_time;
    private String timestamp;
    private String cameras;
    private String image;

       
 
    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCameras() {
        return cameras;
    }

    public void setCameras(String cameras) {
        this.cameras = cameras;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Traffic create(JsonObject jo) {
        Traffic m = new Traffic();
        m.setDate_time(jo.getString("date_time"));
        m.setTimestamp(jo.getString("timestamp"));
        m.setCameras(jo.getString("cameras"));
        m.setImage(jo.getString("image"));
  
        return m;
    }
    
    public JsonObject toJson() {
        return Json.createObjectBuilder()
        .add("date_time", date_time)
        .add("timestamp", timestamp)
        .add("cameras", cameras)
        .add("image", image)
        .build();
    }

   
}