package fabian.arevalo.lastfm.Serializables;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import fabian.arevalo.lastfm.Modelo.Artists;

public class TopArtists {

    @SerializedName("artist")
    private List<Artists> artist;


    public List<Artists> getArtist() {
        return artist;
    }

    public void setArtist(List<Artists> artist) {
        this.artist = artist;
    }

}
