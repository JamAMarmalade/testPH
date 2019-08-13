package apiCalls;

import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PHTodos {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId",userId)
                .append("id", id)
                .append("title", title)
                .append("completed", completed)
                .toString();
    }

    public JsonObject JsonGen(int idGs) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userId", 10);
        jsonBody.addProperty("id", idGs);
        jsonBody.addProperty("title", "Le present est la seule chose qui n'a pas de fin");
        jsonBody.addProperty("completed", true);
        return jsonBody;
    }

    public JsonObject JsonVar(String userIdJs, String idJs, String titleJs, String completedJs) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("userId", userIdJs);
        jsonBody.addProperty("id", idJs);
        jsonBody.addProperty("title", titleJs);
        jsonBody.addProperty("completed", completedJs);
        return jsonBody;
    }

}
