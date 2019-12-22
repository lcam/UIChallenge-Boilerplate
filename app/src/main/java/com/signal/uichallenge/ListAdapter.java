package com.signal.uichallenge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.signal.uichallenge.model.Track;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Track> tracks = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new TrackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TrackViewHolder)holder).bind(tracks.get(position));
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
        notifyDataSetChanged();
    }

    public class TrackViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView artist;
        ImageView artistImage;

        public TrackViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            artist = itemView.findViewById(R.id.artist);
            artistImage = itemView.findViewById(R.id.artist_image);
        }

        public void bind(Track track){
            title.setText(track.getTitle());
            artist.setText(track.getArtist());
            artistImage.setImageResource(track.getImageRes());
        }
    }
}
