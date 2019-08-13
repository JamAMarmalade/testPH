package apiCalls;

import gherkin.deps.com.google.gson.JsonObject;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class PHUsers {
    private int id;
    private String name;
    private String username;
    private String email;
    private JsonObject address;
    private String street() {return address.get("street").getAsString();}
    private String suite() {return address.get("suite").getAsString();}
    private String city() {return address.get("city").getAsString();}
    private String zipcode() {return address.get("zipcode").getAsString();}
    private JsonObject geo() { return address.get("geo").getAsJsonObject();}
    private String lat() {return geo().get("lat").getAsString();}
    private String lng() {return geo().get("lng").getAsString();}
    private String phone;
    private String website;
    private JsonObject company;
    private String name() {return company.get("name").getAsString();}
    private String catchPhrase() {return company.get("catchPhrase").getAsString();}
    private String bs() {return company.get("bs").getAsString();}

    @Override
    public String toString()
    {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name",name)
                .append("username", username)
                .append("email", email)
                .append("street", street())
                .append("suite", suite())
                .append("city", city())
                .append("zipcode", zipcode())
                .append("lat", lat())
                .append("lng", lng())
                .append("phone", phone)
                .append("website", website)
                .append("name", name())
                .append("catchPhrase", catchPhrase())
                .append("bs", bs())
                .toString();
    }

    public JsonObject JsonGen(int idGs) {
        JsonObject jsonBody = new JsonObject();
        JsonObject jsonAddress = new JsonObject();
        JsonObject geo = new JsonObject();
        JsonObject company = new JsonObject();

        jsonBody.addProperty("id", idGs);
        jsonBody.addProperty("name", "Pascal");
        jsonBody.addProperty("username", "Gambler");
        jsonBody.addProperty("email", "Pascal@gmail.com");

        jsonBody.add("jsonAddress", jsonAddress);

        jsonAddress.addProperty("street", "Clemont Ferrad");
        jsonAddress.addProperty("suite", "Suite 555");
        jsonAddress.addProperty("city", "France");
        jsonAddress.addProperty("zipcode", "99501-1623");

        jsonAddress.add("geo", geo);

        geo.addProperty("lat", "-19.4547");
        geo.addProperty("lng", "-35.3524");

        jsonBody.addProperty("phone", "717-288-7922");
        jsonBody.addProperty("website", "https://www.freepascal.org");

        jsonBody.add("company", company);

        jsonBody.addProperty("name", " Cour des Aides");
        jsonBody.addProperty("catchPhrase", "Little things console us because little things afflict us");
        jsonBody.addProperty("bs", " vicious satire");

        return jsonBody;
    }

    public JsonObject JsonVar(String idJs, String nameJs, String usernameJs, String emailJs, String streetJs,
                              String suiteJs, String cityJs, String zipcodeJs, String latJs, String lngJs,
                              String phoneJs, String websiteJs, String webnameJs, String catchPhraseJs, String bsjs) {
        JsonObject jsonBody = new JsonObject();
        JsonObject jsonAddress = new JsonObject();
        JsonObject geo = new JsonObject();
        JsonObject company = new JsonObject();

        jsonBody.addProperty("id", idJs);
        jsonBody.addProperty("name", nameJs);
        jsonBody.addProperty("username", usernameJs);
        jsonBody.addProperty("email", emailJs);

        jsonBody.add("jsonAddress", jsonAddress);

        jsonAddress.addProperty("street", streetJs);
        jsonAddress.addProperty("suite", suiteJs);
        jsonAddress.addProperty("city", cityJs);
        jsonAddress.addProperty("zipcode", zipcodeJs);

        jsonAddress.add("geo", geo);

        geo.addProperty("lat", latJs);
        geo.addProperty("lng", lngJs);

        jsonBody.addProperty("phone", phoneJs);
        jsonBody.addProperty("website", websiteJs);

        jsonBody.add("company", company);

        jsonBody.addProperty("name", webnameJs);
        jsonBody.addProperty("catchPhrase", catchPhraseJs);
        jsonBody.addProperty("bs", bsjs);

        return jsonBody;
    }
}
