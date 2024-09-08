package fabian.arevalo.lastfm.Modelo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.List;
import fabian.arevalo.lastfm.Interface.Interfaces;
import fabian.arevalo.lastfm.Network.ApiClient;
import fabian.arevalo.lastfm.R;
import fabian.arevalo.lastfm.Serializables.RequestHeaders;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModeloTopArtists implements Interfaces.ModeloTopArtists {
    private Interfaces.PresentadorTopArtists presentadorTopArtists;
    private Context context;

    public ModeloTopArtists(Interfaces.PresentadorTopArtists presentadorTopArtists, Context context) {
        this.presentadorTopArtists = presentadorTopArtists;
        this.context = context;
    }


    @Override
    public void requestDataTopArtist() {

            if (!isNetworkAvailable()) {
                presentadorTopArtists.showError(context.getString(R.string.ErrorConexion));
            } else {
                Call<RequestHeaders> topArtistsCall = ApiClient.getServer().getTopArtists();
                topArtistsCall.enqueue(new Callback<RequestHeaders>() {
                    @Override
                    public void onResponse(Call<RequestHeaders> call, Response<RequestHeaders> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<Artists> artistsList = response.body().getTopArtists().getArtist();
                            if (!artistsList.isEmpty()) {
                                successfulTopArtist(artistsList);
                            } else {
                                presentadorTopArtists.showError(context.getString(R.string.Errorinformacion));
                            }
                        } else {
                            presentadorTopArtists.showError(context.getString(R.string.ErrorServer));
                        }
                    }
                    @Override
                    public void onFailure(Call<RequestHeaders> call, Throwable t) {
                        presentadorTopArtists.showError(context.getString(R.string.Error));

                    }
                });
            }
    }

    @Override
    public void successfulTopArtist(List<Artists> artistsList) {
        presentadorTopArtists.successfulQuery(artistsList);
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
