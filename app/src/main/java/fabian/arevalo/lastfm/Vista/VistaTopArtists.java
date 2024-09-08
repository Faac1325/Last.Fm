package fabian.arevalo.lastfm.Vista;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import fabian.arevalo.lastfm.Adapter.AdapterTopArtists;
import fabian.arevalo.lastfm.Interface.Interfaces;
import fabian.arevalo.lastfm.Modelo.Artists;
import fabian.arevalo.lastfm.Presentador.PresentadorTopArtists;
import fabian.arevalo.lastfm.R;

public class VistaTopArtists extends AppCompatActivity implements Interfaces.VistaTopArtists {
    private RecyclerView recyclerArtist;
    private Interfaces.PresentadorTopArtists presentadorTopArtists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artists);
        presentadorTopArtists = new PresentadorTopArtists(this,getApplicationContext());
        ImageSlider imageSlider = findViewById(R.id.imagen_slider);
        recyclerArtist =findViewById(R.id.recyclerArtist);

        List<SlideModel> imagenList = new ArrayList<>();
        imagenList.add(new SlideModel(R.raw.splash1, getString(R.string.topArtist), ScaleTypes.CENTER_CROP));
        imagenList.add(new SlideModel(R.raw.splash2, getString(R.string.lastFm), ScaleTypes.CENTER_CROP));
        imagenList.add(new SlideModel(R.raw.splash3, getString(R.string.mensaje), ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(imagenList, ScaleTypes.CENTER_CROP);
        requestDataTopArtist();
    }
    @Override
    public void requestDataTopArtist() {
        presentadorTopArtists.requestDataTopArtist();
    }

    public void successfulQuery(List<Artists> artistsList) {
        AdapterTopArtists adapterPopularArtists = new AdapterTopArtists(artistsList, this);
        recyclerArtist.setAdapter(adapterPopularArtists);
        recyclerArtist.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}