package fabian.arevalo.lastfm.Network;

import fabian.arevalo.lastfm.Interface.ApiArtists;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static ApiArtists getServer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Links.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiArtists.class);
    }

}
