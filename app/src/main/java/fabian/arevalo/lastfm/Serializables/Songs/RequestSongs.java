package fabian.arevalo.lastfm.Serializables.Songs;

import com.google.gson.annotations.SerializedName;

public class RequestSongs {

    @SerializedName("toptracks")
    private TopTracks topTracks;

    public TopTracks getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(TopTracks topTracks) {
        this.topTracks = topTracks;
    }

}
