package apiCalls;

import gherkin.deps.com.google.gson.JsonObject;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PHPost {
    private int userId;
    private int id;
    private String title;
    private String body;

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("userId",userId)
                .append("id", id)
                .append("title", title)
                .append("body", body)
                .toString();
    }

    public JsonObject JsonGen(int idGs)
    {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userId", 10);
        jsonBody.addProperty("id", idGs);
        jsonBody.addProperty("title", "Pensees");
        jsonBody.addProperty("body", "The last thing one discovers in composing a work is what to put first");

        return jsonBody;
    }

    public JsonObject JsonVar(String userIdJs, String idJs, String titleJs, String bodyJs)
    {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userId",userIdJs);
        jsonBody.addProperty("id", idJs);
        jsonBody.addProperty("title", titleJs);
        jsonBody.addProperty("body", bodyJs);

        return jsonBody;
    }
}
