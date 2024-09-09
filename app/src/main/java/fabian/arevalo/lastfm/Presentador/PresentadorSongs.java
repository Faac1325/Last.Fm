package fabian.arevalo.lastfm.Presentador;

import android.content.Context;

import java.util.List;

import fabian.arevalo.lastfm.Interface.Interfaces;
import fabian.arevalo.lastfm.Modelo.ModeloSongs;
import fabian.arevalo.lastfm.Serializables.Songs.Track;

public class PresentadorSongs implements Interfaces.PresentadorSonsgs {
    Interfaces.VistaSonsgs vistaSonsgs;
    Interfaces.ModeloSonsgs modeloSonsgs;

    public PresentadorSongs(Interfaces.VistaSonsgs vistaSongs, Context context) {
        this.modeloSonsgs = new ModeloSongs(this, context);
        this.vistaSonsgs = vistaSongs;
    }

    @Override
    public void requestDataSongs(String artista) {
        modeloSonsgs.requestDataSongs(artista);

    }

    @Override
    public void successfulSongs(List<Track> trackList) {
        vistaSonsgs.successfulSongs(trackList);
    }

    @Override
    public void showError(String message) {
        vistaSonsgs.showError(message);

    }
}
