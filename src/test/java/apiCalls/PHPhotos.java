package apiCalls;

import gherkin.deps.com.google.gson.JsonObject;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PHPhotos {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("userId",albumId)
                .append("id", id)
                .append("title", title)
                .append("url", url)
                .append("thumbnailUrl", thumbnailUrl)
                .toString();
    }

    public JsonObject JsonGen(int idGs) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userId", 100);
        jsonBody.addProperty("id", idGs);
        jsonBody.addProperty("title", " From about half past ten at night");
        jsonBody.addProperty("url", "https://via.placeholder.com/600/14e02");
        jsonBody.addProperty("thumbnailUrl", "https://via.placeholder.com/150/14e02");
        return jsonBody;
    }

    public JsonObject JsonVar(String albumIdJs, String idJs, String titleJs, String urlJs, String thumbnailUrlJs) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userId", albumIdJs);
        jsonBody.addProperty("id", idJs);
        jsonBody.addProperty("title", titleJs);
        jsonBody.addProperty("url", urlJs);
        jsonBody.addProperty("thumbnailUrl", thumbnailUrlJs);
        return jsonBody;
    }
}
