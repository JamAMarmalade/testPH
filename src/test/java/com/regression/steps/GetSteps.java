package com.regression.steps;

import apiCalls.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonObject;
import io.qameta.allure.Step;
import okhttp3.OkHttpClient;
import org.junit.Assert;


public class GetSteps extends ApiPaths{
    private JsonObject JsonBody;
    private ApiResponse apiResponse;
    private GetPlaceholder placeHolder;

    public GetSteps(){
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        ApiFunctions apiFunctions = new ApiFunctions(client, gson);
        placeHolder = new GetPlaceholder(apiFunctions);
    }

    @Step("I want to operate on {site}")
    @Given("^I want to operate on \"([^\"]*)\"$")
    public void iWantToOperateOn(String site) {
        Assert.assertTrue(placeHolder.addressUrl().contains(site));
    }

    @Step("I want to intitialise a patch request to {type} with {data} in {field} ")
    @Given("^I want to intitialise a patch request to \"([^\"]*)\" with \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iWantToIntitialiseAPatchRequestToWithIn(String type, String data, String field) {
        Assert.assertTrue(className(type).contains(field));
        JsonBody = new JsonObject();
        JsonBody.addProperty(field, data);
    }

    @Step("I want to intitialise a post request to {type} with {field} to {id}")
    @Given("^I want to intitialise a post request to \"([^\"]*)\" with \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iWantToIntitialiseAPostRequestToWithInTo(String type, String field, int id) {
        JsonBody = jsonBuild(type, id);
    }

    @Step("I want to intitialise a put request to {type} with {data} in {field} to {id}")
    @Given("^I want to intitialise a put request to \"([^\"]*)\" with \"([^\"]*)\" in \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iWantToIntitialiseAPutRequestToWithInTo(String type, String data, String field, int id) {
        Assert.assertTrue(className(type).contains(field));
        JsonBody = jsonBuild(type, id);
        JsonBody.remove(field);
        JsonBody.addProperty(field, data);
    }

    @Step("I get the body of {type} number {num}")
    @When("^I get the body of \"([^\"]*)\" number \"([^\"]*)\"$")
    public void iGetTheBodyOfNumber(String type, String num) {
        apiResponse = placeHolder.GetDetails(type, num);
        Assert.assertEquals(apiResponse.getResponseCode(), 200);
    }

    @Step("I get the body of {type} number {num} with {code}")
    @When("I get the body of \"([^\"]*)\" number \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_get_the_body_of_number_with(String type, String num, int code) {
        apiResponse = placeHolder.GetDetails(type, num);
        Assert.assertEquals(apiResponse.getResponseCode(), code);
    }


    @Step("I delete the body of {type} number {num]")
    @When("^I delete the body of \"([^\"]*)\" number \"([^\"]*)\"$")
    public void iDeleteTheBodyOfNumber(String type, String num) {
        apiResponse = placeHolder.DeleteDetails(type, num);
        Assert.assertEquals(apiResponse.getResponseCode(), 200);
    }

    @Step("I patch the body of {type} number {num]")
    @When("^I patch the body of \"([^\"]*)\" number \"([^\"]*)\"$")
    public void iPatchTheBodyOfNumber(String type, String num) {
        apiResponse = placeHolder.PatchDetails(type, num, JsonBody);
        Assert.assertEquals(apiResponse.getResponseCode(), 200);
    }

    @Step("I post the body of {type} number {num] with status {code}")
    @When("^I post the body of \"([^\"]*)\" number \"([^\"]*)\" with status \"([^\"]*)\"$")
    public void iPostTheBodyOfNumberWithStatus(String type, String num, int code) {
        apiResponse = placeHolder.PatchDetails(type, num, JsonBody);
        int a = apiResponse.getResponseCode();
        Assert.assertEquals(a, code);
    }

    @Step("I put the body of {type} number {num]")
    @When("^I put the body of \"([^\"]*)\" number \"([^\"]*)\"$")
    public void i_put_the_body_of_number(String type, String num) {
        apiResponse = placeHolder.PatchDetails(type, num, JsonBody);
        Assert.assertEquals(apiResponse.getResponseCode(), 200);
    }

    @Step("I can see the response {apiValue} in {apiKey} is {bool}")
    @Then("^I can see the response \"([^\"]*)\" in \"([^\"]*)\" is \"([^\"]*)\"$")
    public void iCanSeeTheResponseIs(String apiValue, String apiKey, String bool) {
        Assert.assertTrue(Boolean.valueOf(bool) == apiResponse
                .getResponse()
                .getAsJsonObject()
                .get(apiKey)
                .getAsString()
                .equals(apiValue));
    }
}
