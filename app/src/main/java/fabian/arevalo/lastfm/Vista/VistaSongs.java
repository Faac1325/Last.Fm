package fabian.arevalo.lastfm.Vista;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import fabian.arevalo.lastfm.Interface.Interfaces;
import fabian.arevalo.lastfm.R;

public class VistaSongs extends AppCompatActivity implements Interfaces.VistaSonsgs {
    TextView txcancion;
    private RecyclerView recyclerSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vista_songs);
        txcancion = findViewById(R.id.txcanciones);
        recyclerSongs = findViewById(R.id.recyclerSongs);

    }
}