package framework;

import io.restassured.response.Response;
import utils.ConfigLoader;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class GenerateAccessToken {

    private static String accessToken;
    private static Instant expiryTime;

    public synchronized static String refreshAccessToken(){
        try {
            if (accessToken == null || Instant.now().isAfter(expiryTime)) {
                System.out.println("Generating Access Code.......");
                Response response = getTokenResponse();
                accessToken = response.path("access_token");
                int expiryTimeInSeconds = response.path("expires_in");
                expiryTime = Instant.now().plusSeconds(expiryTimeInSeconds - 120);
            } else {
                System.out.println("Access code is good to use");
            }
        }
        catch (Exception e){
            throw new RuntimeException("Error: Cannot generate code");
        }
        return accessToken;
    }

    private static Response getTokenResponse() {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("client_id", ConfigLoader.getInstance().getClientId());
        parameters.put("client_secret", ConfigLoader.getInstance().getClientSecret());
        parameters.put("grant_type", ConfigLoader.getInstance().getGrantType());
        parameters.put("refresh_token", ConfigLoader.getInstance().getRefreshToken());

        return RestResource.postAccessTokenRequest(parameters);
    }
}