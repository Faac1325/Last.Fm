package fabian.arevalo.lastfm.Serializables.Songs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Track {

    private String name;
    private String playcount;
    private String listeners;
    private List<Image> image;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
