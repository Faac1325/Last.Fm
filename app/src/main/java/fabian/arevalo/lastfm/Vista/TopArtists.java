package fabian.arevalo.lastfm.Vista;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import fabian.arevalo.lastfm.R;

public class TopArtists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_artists);
        ImageSlider imageSlider = findViewById(R.id.imagen_slider);

        List<SlideModel> imagenList = new ArrayList<>();
        imagenList.add(new SlideModel(R.raw.splash1, getString(R.string.topArtist), ScaleTypes.CENTER_CROP));
        imagenList.add(new SlideModel(R.raw.splash2, getString(R.string.lastFm), ScaleTypes.CENTER_CROP));
        imagenList.add(new SlideModel(R.raw.splash3, getString(R.string.mensaje), ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(imagenList, ScaleTypes.CENTER_CROP);
    }
}