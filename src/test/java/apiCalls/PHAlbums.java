package apiCalls;

import gherkin.deps.com.google.gson.JsonObject;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PHAlbums {
    private int userId ;
    private int id;
    private String title;

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("userId",userId)
                .append("id", id)
                .append("title", title)
                .toString();
    }

    public JsonObject JsonGen(int idGs) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userId", 10);
        jsonBody.addProperty("id", idGs);
        jsonBody.addProperty("title", "Le coeur a ses raisons que le raison ne connait point");
        return jsonBody;
    }

    public JsonObject JsonVar(String userIdJs, String idJs, String titleJs, String bodyJs) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userId", userIdJs);
        jsonBody.addProperty("id", idJs);
        jsonBody.addProperty("title", titleJs);
        return jsonBody;
    }
}
