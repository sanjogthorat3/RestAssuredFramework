package test;

import data.invalidResponse.ErrorMain;
import data.validResponse.Playlist;
import framework.APIRequest;
import framework.StatusCode;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static utils.TestDataUtils.generateDescription;
import static utils.TestDataUtils.generateName;

public class SpotifyPlaylistTest extends BaseTest{

    @Test
    public void shouldAbleToCreatePlaylist(){
        //Playlist requestPayload = new Playlist().setName("New Playlist").setDescription("New playlist description").setPublic(false);


        String name = generateName();
        System.out.println(name);

        String description = generateDescription();
        System.out.println(description);

        Playlist requestPayload = Playlist.builder().name(name).description(description)._public(false).build();

        Response response = APIRequest.postRequest(requestPayload);

        assertThat(response.getStatusCode(), equalTo(201));
        //assertThat(response.getContentType(), equalTo("application/json; charset=utf-8"));

        Playlist responsePayload = response.as(Playlist.class);

        assertThat(responsePayload.getName(), equalTo(name));
        assertThat(responsePayload.getDescription(), equalTo(description));
        assertThat(responsePayload.get_public(), equalTo(responsePayload.get_public()));
    }

    @Test
    public void shouldAbleToGetPlaylist(){

        Response response = APIRequest.getRequest("4zPXEYvF7EpGDX750GT30I");

        assertThat(response.getStatusCode(), equalTo(200));
        //assertThat(response.getContentType(), equalTo("application/json; charset=utf-8"));

        Playlist responsePayload = response.as(Playlist.class);

        assertThat(responsePayload.getName(), equalTo("Updated Playlist Name"));
        assertThat(responsePayload.getDescription(), equalTo("Updated playlist description"));
        assertThat(responsePayload.get_public(), equalTo(true));
    }

    @Test
    public void shouldAbleToUpdatePlaylist(){
        //Playlist requestPayload = new Playlist().setName("Updated Playlist Name").setDescription("Updated playlist description").setPublic(false);

        Playlist requestPayload = Playlist.builder().name("Updated Playlist Name").description("Updated playlist description")._public(false).build();

        Response response = APIRequest.putRequest(requestPayload, "4zPXEYvF7EpGDX750GT30I");

        //Way - 1
        assertThat(response.getStatusCode(), equalTo(200));

        //Way - 2
        assertThat(response.getStatusCode(), equalTo(StatusCode.CODE_200.code));

        //Playlist responsePayload = response.as(Playlist.class);
    }

    @Test
    public void shouldNotAbleToCreatePlaylistWithoutName(){
        //Playlist requestPayload = new Playlist().setName("").setDescription("New playlist description").setPublic(false);
        Playlist requestPayload = Playlist.builder().name("").description("New playlist description")._public(false).build();

        Response response = APIRequest.postRequest(requestPayload);

        assertThat(response.getStatusCode(), equalTo(400));
        //assertThat(response.getContentType(), equalTo("application/json; charset=utf-8"));

        ErrorMain responsePayload = response.as(ErrorMain.class);

//        //Way - 1
//        assertThat(responsePayload.getErrorBase().getStatus(), equalTo(400));
//        assertThat(responsePayload.getErrorBase().getMessage(), equalTo("Missing required field: name"));

        //Way - 2
        assertThat(responsePayload.getErrorBase().getStatus(), equalTo(StatusCode.CODE_400.code));
        assertThat(responsePayload.getErrorBase().getMessage(), equalTo(StatusCode.CODE_400.msg));
    }

    @Test
    public void shouldNotAbleToCreatePlaylistWithInvalidAccessToken(){
        //Playlist requestPayload = new Playlist().setName("New Playlist").setDescription("New playlist description").setPublic(false);

        Playlist requestPayload = Playlist.builder().name("New Playlist").description("New playlist description")._public(false).build();

        Response response = APIRequest.postRequest(requestPayload, "1234");

        assertThat(response.getStatusCode(), equalTo(401));
        //assertThat(response.getContentType(), equalTo("application/json"));

        ErrorMain responsePayload = response.as(ErrorMain.class);

//        //Way - 1
//        assertThat(responsePayload.getErrorBase().getStatus(), equalTo(401));
//        assertThat(responsePayload.getErrorBase().getMessage(), equalTo("Invalid access token"));

        //Way - 2
        assertThat(responsePayload.getErrorBase().getStatus(), equalTo(StatusCode.CODE_401.code));
        assertThat(responsePayload.getErrorBase().getMessage(), equalTo(StatusCode.CODE_401.msg));
    }
}