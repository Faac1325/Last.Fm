package fabian.arevalo.lastfm.Modelo;

import android.content.Context;
import java.util.List;

import fabian.arevalo.lastfm.Interface.Interfaces;
import fabian.arevalo.lastfm.Network.ApiClient;
import fabian.arevalo.lastfm.Network.NetworkUtil;
import fabian.arevalo.lastfm.R;
import fabian.arevalo.lastfm.Serializables.Songs.RequestSongs;
import fabian.arevalo.lastfm.Serializables.Songs.TopTracks;
import fabian.arevalo.lastfm.Serializables.Songs.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloSongs implements Interfaces.ModeloSonsgs {
    Interfaces.PresentadorSonsgs presentadorSonsgs;
    private Context context;

    public ModeloSongs(Interfaces.PresentadorSonsgs presentadorSongs, Context context) {
        this.presentadorSonsgs = presentadorSongs;
        this.context = context;
    }

    @Override
    public void requestDataSongs(String artista) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            presentadorSonsgs.showError(context.getString(R.string.ErrorConexion));
        }else{
            Call<RequestSongs> topSongsArtists = ApiClient.getServer().getTopSongs(artista);
            topSongsArtists.enqueue(new Callback<RequestSongs>() {
                @Override
                public void onResponse(Call<RequestSongs> call, Response<RequestSongs> response) {

                    RequestSongs listRequestSongs = response.body();
                    TopTracks topTracks = listRequestSongs.getTopTracks();
                    List<Track> tracks =topTracks.getTrack();

                    if(!tracks.isEmpty()){
                        successfulSongs(tracks);
                    }else {
                        presentadorSonsgs.showError(context.getString(R.string.Errorinformacion));
                    }
                }
                @Override
                public void onFailure(Call<RequestSongs> call, Throwable t) {
                    presentadorSonsgs.showError(context.getString(R.string.ErrorInesperado));
                }
            });
        }
    }
    @Override
    public void successfulSongs(List<Track> trackList) {
        presentadorSonsgs.successfulSongs(trackList);
    }
}
