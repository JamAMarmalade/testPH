package apiCalls;

import gherkin.deps.com.google.gson.JsonObject;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PHComments {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("postId",postId)
                .append("id", id)
                .append("name", name)
                .append("email", email)
                .append("body", body)
                .toString();
    }

    public JsonObject JsonGen(int idGs) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("postId", 100);
        jsonBody.addProperty("id", idGs);
        jsonBody.addProperty("name", "The mind of fire");
        jsonBody.addProperty("email", "L.Descartes@phili.net");
        jsonBody.addProperty("body", "The last thing we discover in composing a work is what to put down first");
        return jsonBody;
    }

    public JsonObject JsonVar(String postIdJs, String idJs, String nameJs, String emailJs, String bodyJs) {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("postId", postIdJs);
        jsonBody.addProperty("id", idJs);
        jsonBody.addProperty("name", nameJs);
        jsonBody.addProperty("email", emailJs);
        jsonBody.addProperty("body", bodyJs);
        return jsonBody;
    }
}
