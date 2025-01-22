
package data.validResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalUrls {

    @JsonProperty("spotify")
    private String spotify;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ExternalUrls() {
    }

    public ExternalUrls(String spotify) {
        super();
        this.spotify = spotify;
    }

    @JsonProperty("spotify")
    public String getSpotify() {
        return spotify;
    }

    @JsonProperty("spotify")
    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

}
