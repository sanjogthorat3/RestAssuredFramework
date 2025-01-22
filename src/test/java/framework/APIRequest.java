package framework;

import data.validResponse.Playlist;
import io.restassured.response.Response;
import utils.ConfigLoader;

import static framework.GenerateAccessToken.refreshAccessToken;
import static framework.Route.PLAYLISTS;
import static framework.Route.USERS;

public class APIRequest {

    public static Response postRequest(Playlist requestPayload){
        return RestResource.postRequest(USERS + "/" + ConfigLoader.getInstance().getUserID() + PLAYLISTS, refreshAccessToken(), requestPayload);
    }

    public static Response postRequest(Playlist requestPayload , String accessToken){
        return RestResource.postRequest(USERS + "/" + ConfigLoader.getInstance().getUserID() + PLAYLISTS, accessToken, requestPayload);
    }

    public static Response getRequest(String id){
        return RestResource.getRequest(PLAYLISTS + "/" + id , refreshAccessToken());
    }

    public static Response putRequest(Playlist requestPayload , String id){
        return RestResource.putRequest(PLAYLISTS + "/" + id, refreshAccessToken(), requestPayload);
    }
}