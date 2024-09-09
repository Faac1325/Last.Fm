package fabian.arevalo.lastfm.Vista;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fabian.arevalo.lastfm.Adapter.AdapterSongs;
import fabian.arevalo.lastfm.Interface.Interfaces;
import fabian.arevalo.lastfm.Presentador.PresentadorSongs;
import fabian.arevalo.lastfm.R;
import fabian.arevalo.lastfm.Serializables.Songs.Track;

public class VistaSongs extends AppCompatActivity implements Interfaces.VistaSonsgs {
    TextView txcancion;
    private RecyclerView recyclerSongs;
    Interfaces.PresentadorSonsgs presentadorSonsgs;
    AdapterSongs adapterSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_songs);
        presentadorSonsgs = new PresentadorSongs(this,getApplicationContext());
        txcancion = findViewById(R.id.txcanciones);
        recyclerSongs = findViewById(R.id.recyclerSongs);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            requestDataSongs(bundle.getString("nombre"));
        }
    }
    public void requestDataSongs(String artista) {
        presentadorSonsgs.requestDataSongs(artista);
    }
    @Override
    public void successfulSongs(List<Track> trackList) {
        adapterSongs = new AdapterSongs(trackList,this);
        recyclerSongs.setAdapter(adapterSongs);
        recyclerSongs.setLayoutManager(new GridLayoutManager(this,1));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}