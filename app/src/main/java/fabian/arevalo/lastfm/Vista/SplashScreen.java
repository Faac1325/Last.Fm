package fabian.arevalo.lastfm.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import fabian.arevalo.lastfm.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.movement_up);
        Animation logoAnimation = AnimationUtils.loadAnimation(this, R.anim.movement_down);

        TextView textSplash = findViewById(R.id.textsplash);
        ImageView icoLastFm = findViewById(R.id.lastfm);
        ImageView nameLastFm = findViewById(R.id.namelast);

        textSplash.setAnimation(textAnimation);
        icoLastFm.setAnimation(logoAnimation);
        nameLastFm.setAnimation(textAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, VistaTopArtists.class);
                startActivity(intent);
                finish();
            }
        }, 3500);
    }
}