package fabian.arevalo.lastfm.Serializables;

import com.google.gson.annotations.SerializedName;

public class RequestHeaders {

    @SerializedName("topartists")
    private TopArtists topArtists;


    public TopArtists getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(TopArtists topArtists) {
        this.topArtists = topArtists;
    }

}
