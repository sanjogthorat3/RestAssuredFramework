package framework;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static framework.Route.BASE_PATH;

public class Specifications {

    public static RequestSpecification getRequestSpec(){
       return new RequestSpecBuilder().
                //setBaseUri("https://api.spotify.com").
                setBaseUri(System.getProperty("BASE_URL")).
                setBasePath(BASE_PATH).
                setContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }

    public static RequestSpecification getAccessTokenRequestSpec(){
        return new RequestSpecBuilder().
                //setBaseUri("https://accounts.spotify.com").
                setBaseUri(System.getProperty("ACCOUNT_BASE_URL")).
                setContentType(ContentType.URLENC).
                log(LogDetail.ALL).
                build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).build();
    }
}