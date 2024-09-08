package fabian.arevalo.lastfm.Interface;

import fabian.arevalo.lastfm.Network.Links;
import fabian.arevalo.lastfm.Serializables.RequestHeaders;
import fabian.arevalo.lastfm.Serializables.Songs.RequestSongs;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiArtists {

    @GET(Links.URL_TOP_ARTISTS)
    Call<RequestHeaders> getTopArtists();

    @GET(Links.URL_POPULAR_SONGS)
    Call<RequestSongs> getTopSongs(@Query("artist") String nameartista);


}
