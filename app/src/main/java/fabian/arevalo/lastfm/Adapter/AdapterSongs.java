package fabian.arevalo.lastfm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fabian.arevalo.lastfm.R;
import fabian.arevalo.lastfm.Serializables.Songs.Track;

public class AdapterSongs extends RecyclerView.Adapter<AdapterSongs.ViewHolderSongs> {
    private List<Track> trackList;
    private Context context;

    public AdapterSongs(List<Track> trackList, Context context) {
        this.trackList = trackList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderSongs onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_songs, null, false);
        return new ViewHolderSongs(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSongs holder, int position) {
        Track track = trackList.get(position);
        holder.nombre.setText(track.getName());
        holder.reproducciones.setText(track.getPlaycount());
        holder.oyentes.setText(track.getListeners());
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class ViewHolderSongs extends RecyclerView.ViewHolder {
        private TextView nombre,reproducciones,oyentes;

        public ViewHolderSongs(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nameSongs);
            reproducciones=itemView.findViewById(R.id.playSongs);
            oyentes=itemView.findViewById(R.id.oyentesSongs);
        }
    }
}
