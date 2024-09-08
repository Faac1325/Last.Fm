package fabian.arevalo.lastfm.Presentador;

import android.content.Context;
import java.util.List;
import fabian.arevalo.lastfm.Interface.Interfaces;
import fabian.arevalo.lastfm.Modelo.Artists;
import fabian.arevalo.lastfm.Modelo.ModeloTopArtists;

public class PresentadorTopArtists implements Interfaces.PresentadorTopArtists {
    private Interfaces.VistaTopArtists vistaTopArtists;
    private Interfaces.ModeloTopArtists modeloTopArtists;

    public PresentadorTopArtists(Interfaces.VistaTopArtists vistaTopArtists, Context context) {
        this.modeloTopArtists = new ModeloTopArtists(this, context);
        this.vistaTopArtists = vistaTopArtists;
    }


    @Override
    public void requestDataTopArtist() {
       modeloTopArtists.requestDataTopArtist();
    }

    @Override
    public void successfulQuery(List<Artists> artistsList) {
        vistaTopArtists.successfulQuery(artistsList);
    }
    @Override
    public void showError(String message) {
        // Enviar el mensaje de error a la vista
        vistaTopArtists.showError(message);
    }
}
