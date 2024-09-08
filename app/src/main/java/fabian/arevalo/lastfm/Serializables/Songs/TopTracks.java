package fabian.arevalo.lastfm.Serializables.Songs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopTracks {
    @SerializedName("track")
    List<Track> track;


    public List<Track> getTrack() {
        return track;
    }

    public void setTrack(List<Track> track) {
        this.track = track;
    }
}
