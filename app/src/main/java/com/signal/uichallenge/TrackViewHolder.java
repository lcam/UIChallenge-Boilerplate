package com.signal.uichallenge;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.signal.uichallenge.model.Track;

public class TrackViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView textView;
    ImageView artistImage;
    public MyViewHolderClicks listener;

    public TrackViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.musicText);
        artistImage = itemView.findViewById(R.id.artist_image);
    }

    public void bind(final Track track, final ListAdapter.OnItemClickListener listener){
        String musicText = String.format("%s - %s", track.getArtist(), track.getTitle());
        textView.setText(musicText);
        artistImage.setImageResource(track.getImageRes());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(track);
            }
        });
    }

    @Override
    public void onClick(View view) {
        listener.onItemClick(view);
    }

    public interface MyViewHolderClicks {
        void onItemClick(View item);
    }
}
