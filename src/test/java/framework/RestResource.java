package framework;

import io.restassured.response.Response;

import java.util.Map;

import static framework.Route.API;
import static framework.Route.TOKEN;
import static framework.Specifications.*;
import static io.restassured.RestAssured.given;

public class RestResource {
    public static Response postRequest(String path, String accessToken, Object requestPayload){
        return given(getRequestSpec()).
                auth().oauth2(accessToken).
                //header("Authorization", "Bearer " + accessToken).
                body(requestPayload).
                when().
                post(path).
                then().
                spec(getResponseSpec()).
                extract().response();
    }

    public static Response postAccessTokenRequest(Map<String, String> parameters){
        return  given(getAccessTokenRequestSpec()).
                formParams(parameters).
                when().
                post(API + TOKEN).
                then().
                spec(Specifications.getResponseSpec()).
                extract().response();
    }

    public static Response getRequest(String path, String accessToken){
        return given(getRequestSpec()).
                auth().oauth2(accessToken).
                //header("Authorization", "Bearer " + accessToken).
                when().
                get(path).
                then().
                spec(getResponseSpec()).
                extract().response();
    }

    public static Response putRequest(String path, String accessToken, Object requestPayload){
        return given(getRequestSpec()).
                auth().oauth2(accessToken).
                //header("Authorization", "Bearer " + accessToken).
                body(requestPayload).
                when().
                put(path).
                then().
                spec(getResponseSpec()).
                extract().response();
    }
}