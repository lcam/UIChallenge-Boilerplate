package com.signal.uichallenge.mediapicker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.signal.uichallenge.DetailsActivity;
import com.signal.uichallenge.ListAdapter;
import com.signal.uichallenge.R;
import com.signal.uichallenge.model.Track;

public class MediaPickerFragment extends Fragment {
    private static final String TAG = "MediaPickerFragment";

    private RecyclerView recyclerView;

    private ListAdapter adapter;// = new ListAdapter(getActivity().getApplicationContext());

    private MediaPickerDataSource mediaPickerDataSource = new MediaPickerDataSource();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tracks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);
        Log.e(TAG, "onViewCreated: I'm here");
        initRecyclerView();
    }

    private void initRecyclerView(){
        //adapter = new ListAdapter(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new ListAdapter(new ListAdapter.OnItemClickListener() {
            @Override public void onItemClick(Track item) {
                Toast.makeText(getContext(), "Item Clicked", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("artist", item.getArtist());
                getActivity().startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.setTracks(mediaPickerDataSource.getTracks());
    }
}
