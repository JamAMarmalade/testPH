package apiCalls;

import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonParser;

public class ApiPaths {
    /**
     * This method will return an api endpoint
     * you will get RuntimeException if the xpath cannot be found
     * @param pathName the element name
     * @return the class of that path
     */
    protected String className(String pathName) {

        String endpoint;
        switch (pathName) {
            case "albums":
                endpoint = new PHAlbums().toString();
                break;

            case "comments":
                endpoint = new PHComments().toString();
                break;

            case "photos":
                endpoint = new PHPhotos().toString();
                break;

            case "posts":
                endpoint = new PHPost().toString();
                break;

            case "todos":
                endpoint = new PHTodos().toString();
                break;

            case "Users":
                endpoint = new PHUsers().toString();
                break;default:
                throw new RuntimeException("Cannot find path" + pathName);
        }
        return endpoint;
    }

    /**
     * This method will return an api endpoint
     * you will get RuntimeException if the xpath cannot be found
     * @param jsonName the element name
     * @return the generic json of that path
     */
    protected JsonObject jsonBuild(String jsonName, int genS) {

        JsonObject jsonEndpoint;
        switch (jsonName) {
            case "albums":
                jsonEndpoint = new PHAlbums().JsonGen(genS);
                break;

            case "comments":
                jsonEndpoint = new PHComments().JsonGen(genS);
                break;

            case "photos":
                jsonEndpoint = new PHPhotos().JsonGen(genS);
                break;

            case "posts":
                jsonEndpoint = new PHPost().JsonGen(genS);
                break;

            case "todos":
                jsonEndpoint = new PHTodos().JsonGen(genS);
                break;

            case "Users":
                jsonEndpoint = new PHUsers().JsonGen(genS);
                break;default:
                throw new RuntimeException("Cannot find path" + jsonName);
        }
        return jsonEndpoint;
    }

    protected JsonObject toJson(String jString){
        JsonParser parser = new JsonParser();
        return parser.parse(jString).getAsJsonObject();
    }

}
