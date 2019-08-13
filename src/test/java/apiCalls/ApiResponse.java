package apiCalls;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;

public class ApiResponse {
    private final int responseCode;
    private final Gson gson;
    private final JsonElement responseBody;

    /**
     * This class method intitialises the body and status code of the response
     * @param responseCode of the response
     * @param responseBody body as a json object
     */
    public ApiResponse(Gson gson, int responseCode, JsonElement responseBody){
        this.gson = gson;
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public int getResponseCode() { return responseCode; }

    public JsonObject getResponseBody() {return responseBody.getAsJsonObject(); }

    public JsonElement getResponse() {return responseBody;}

    private JsonArray getListResponse() { return responseBody.getAsJsonArray(); }

    public <T> T serializeResponse(Class<T> classOfT) {
        return gson.fromJson(getResponseBody().getAsJsonObject(), classOfT);
    }

    public JsonObject getObjectInArray(String key, String val) {
        JsonObject container = new JsonObject();
        for (int i = 0; i < getListResponse().size(); i++) {
            container = getListResponse().get(i).getAsJsonObject();
            if (container.get(key).getAsString().contains(val)) {
                i=getListResponse().size();
            }
        }
        return container;
    }

}
