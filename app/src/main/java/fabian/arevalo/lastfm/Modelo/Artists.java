package fabian.arevalo.lastfm.Modelo;

import java.util.List;

import fabian.arevalo.lastfm.Serializables.Image;

public class Artists {
    private String name;
    private String listeners;
    private String url;
    private List<Image> image;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
