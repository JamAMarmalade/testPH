package apiCalls;

import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import okhttp3.HttpUrl;
import org.apache.http.client.utils.URIBuilder;

import java.net.URL;

public class GetPlaceholder {
    private JsonObject getPlaceHolder;
    private ApiFunctions placeHolderClient;
    private String urlBuild = "https://jsonplaceholder.typicode.com/";

    public GetPlaceholder(ApiFunctions placeHolderClient) {
        this.placeHolderClient = placeHolderClient;
    }

    public String addressUrl() { return urlBuild;}

    public ApiResponse GetDetails(String type, String num) {
        return placeHolderClient
                .get(urlBuild+type+"/"+num,"application/json");
    }

    public ApiResponse DeleteDetails(String type, String num){
        return placeHolderClient
                .delete(urlBuild+type+"/"+num);
    }

    public ApiResponse PostDetails(String type, String num, JsonObject body){
        return placeHolderClient
                .post(urlBuild+type+"/"+num,"application/json", body.toString());
    }

    public ApiResponse PatchDetails(String type, String num, JsonObject body){
        return placeHolderClient
                .patch(urlBuild+type+"/"+num,"application/json", body.toString());
    }

    public ApiResponse PutDetails(String type, String num, JsonObject body){
        return placeHolderClient
                .put(urlBuild+type+"/"+num,"application/json", body.toString());
    }


    public PHPost GetPosts(String type, String num) {
        return placeHolderClient
                .get(urlBuild+type+"/"+num,"application/json")
                .serializeResponse(PHPost.class);
    }

    public PHAlbums GetAlbums(String type, String num) {
        return placeHolderClient
                .get(urlBuild+type+"/"+num,"application/json")
                .serializeResponse(PHAlbums.class);
    }

    public PHComments GetComments(String type, String num) {
        return placeHolderClient
                .get(urlBuild+type+"/"+num,"application/json")
                .serializeResponse(PHComments.class);
    }

    public PHPhotos GetPhotos(String type, String num) {
        return placeHolderClient
                .get(urlBuild+type+"/"+num,"application/json")
                .serializeResponse(PHPhotos.class);
    }

    public PHTodos GetTodos(String type, String num) {
        return placeHolderClient
                .get(urlBuild+type+"/"+num,"application/json")
                .serializeResponse(PHTodos.class);
    }

    public PHUsers GeUsers(String type, String num) {
        return placeHolderClient
                .get(urlBuild+type+"/"+num,"application/json")
                .serializeResponse(PHUsers.class);
    }
}


