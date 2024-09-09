package fabian.arevalo.lastfm.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import fabian.arevalo.lastfm.Modelo.Artists;
import fabian.arevalo.lastfm.R;
import fabian.arevalo.lastfm.Vista.VistaSongs;

public class AdapterTopArtists extends RecyclerView.Adapter<AdapterTopArtists.ViewHolder> {
    private List<Artists> artistsList;
    private Context context;

    public AdapterTopArtists(List<Artists> artistsList, Context context) {
        this.artistsList = artistsList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterTopArtists.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_artists,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTopArtists.ViewHolder holder, int position) {
        Artists artist = artistsList.get(position);
        holder.cantante.setText(artist.getName());
        holder.oyentes.setText(artist.getListeners());
        holder.enlace.setText(artist.getUrl());
        String urlImg = artist.getImage().get(2).getText();
        Glide.with(context).load(urlImg)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(context, VistaSongs.class);
                intent.putExtra("nombre",artist.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artistsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView cantante,oyentes, enlace;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cantante = itemView.findViewById(R.id.numbArtis);
            oyentes = itemView.findViewById(R.id.numlisteners);
            enlace = itemView.findViewById(R.id.url);
            img = itemView.findViewById(R.id.imaTopArt);
        }
    }
}
