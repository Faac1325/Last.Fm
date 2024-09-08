package fabian.arevalo.lastfm.Interface;

import fabian.arevalo.lastfm.Network.Links;
import fabian.arevalo.lastfm.Serializables.RequestHeaders;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiArtists {

    @GET(Links.URL_TOP_ARTISTS)
    Call<RequestHeaders> getTopArtists();


}
