package com.signal.uichallenge;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.signal.uichallenge.mediapicker.MediaPickerDataSource;
import com.signal.uichallenge.model.Track;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private ListAdapter adapter;

    private MediaPickerDataSource mediaPickerDataSource = new MediaPickerDataSource();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
    }

    private void initRecyclerView(){
        //adapter = new ListAdapter(getApplicationContext()); //careful about using getApplicationContext() in the very beginning, it would be null
        adapter = new ListAdapter(new ListAdapter.OnItemClickListener() {
            @Override public void onItemClick(Track item) {
                Toast.makeText(getApplicationContext(), "Item Clicked in Main", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("artist", item.getArtist());
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        adapter.setTracks(mediaPickerDataSource.getTracks());
    }
}
