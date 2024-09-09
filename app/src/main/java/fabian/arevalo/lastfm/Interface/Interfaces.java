package fabian.arevalo.lastfm.Interface;

import java.util.List;

import fabian.arevalo.lastfm.Modelo.Artists;
import fabian.arevalo.lastfm.Serializables.Songs.Track;

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
        void requestDataSongs(String artista);
        void successfulSongs(List<Track> trackList);
        void showError(String message);

    }

    interface PresentadorSonsgs {
        void requestDataSongs(String artista);
        void successfulSongs(List<Track> trackList);
        void showError(String message);

    }

    interface ModeloSonsgs {
        void requestDataSongs(String artista);
        void successfulSongs(List<Track> trackList);

    }



}
