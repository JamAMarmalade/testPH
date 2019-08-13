package apiCalls;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class ApiFunctions {
    private final OkHttpClient client;
    private final Gson gson;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public ApiFunctions(OkHttpClient client, Gson gson) {
        this.client = client;
        this.gson = gson;
    }

    /**
     * A get function of ApiFunctions
     * initialises the expected response body, executes request
     * @param webUrl the request is addressed to
     */
    public ApiResponse get(String webUrl, String contentType){
        Request request = new Request.Builder()
                .url(webUrl)
                .get()
                .addHeader("Content-Type", contentType)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
        } catch (IOException e) {
             e.printStackTrace();
        }
        return getResponse(response);
    }

    /**
     * A post function of ApiFunctions
     * initialises the expected response body, executes request
     * @param webUrl the request is addressed to
     * @param json data we want to send
     */
    public ApiResponse post(String webUrl, String contentType, String json){
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(webUrl)
                .post(body)
                .addHeader("Content-Type", contentType)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse(response);
    }

    /**
     * A delete function of ApiFunctions
     * initialises the expected response body, executes request
     * @param webUrl the request is addressed to
     */
    public ApiResponse delete(String webUrl){
        Request request = new Request.Builder()
                .url(webUrl)
                .delete()
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse(response);
    }

    /**
     * A patch function of ApiFunctions
     * initialises the expected response body, executes request
     * @param webUrl the request is addressed to
     * @param json data we want to send
     */
    public ApiResponse patch(String webUrl, String contentType, String json){
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(webUrl)
                .patch(body)
                .addHeader("Content-Type", contentType)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse(response);
    }

    /**
     * A put function of ApiFunctions
     * initialises the expected response body, executes request
     * @param webUrl the request is addressed to
     * @param json data we want to send
     */
    public ApiResponse put(String webUrl, String contentType, String json){
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(webUrl)
                .put(body)
                .addHeader("Content-Type", contentType)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getResponse(response);
    }

    /**
     * Handles the response for ApiFunction
     * if body is empty an empty json is returned
     * @param response returned from the server
     */
    private ApiResponse getResponse(Response response){

        if (response != null){
            try{
                String message = response.body().string();
                return message != null
                        ? new ApiResponse(gson, response.code(), new JsonParser().parse(message).getAsJsonObject())
                        : new ApiResponse(gson, response.code(), new JsonObject());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ApiResponse(gson, 404, new JsonObject());
    }

}
