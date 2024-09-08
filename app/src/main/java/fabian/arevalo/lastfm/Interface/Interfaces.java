package fabian.arevalo.lastfm.Interface;

import java.util.List;

import fabian.arevalo.lastfm.Modelo.Artists;

public interface Interfaces {

    interface VistaTopArtists {
        void requestDataTopArtist();
        void successfulQuery(List<Artists> artistsList);
        void showError(String message);
    }

    interface PresentadorTopArtists {
        void requestDataTopArtist();
        void successfulQuery(List<Artists> artistsList);
        void showError(String message);
    }

    interface ModeloTopArtists {
        void requestDataTopArtist();
        void successfulTopArtist(List<Artists> artistsList);
    }

    interface VistaSonsgs {

    }

    interface PresentadorSonsgs {

    }

    interface ModeloSonsgs {

    }



}
