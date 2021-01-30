package tech.przybysz.songbook_mobile.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.activities.adapters.SongTableAdapter;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.services.SongService;

public class SongbookTableOfContentsActivity extends Activity {


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songbook_table_of_contents);

        ListView list = findViewById(R.id.song_list);
        List<SongDTO> songs = new ArrayList<>();
        SongTableAdapter adapter = new SongTableAdapter(getApplicationContext(), songs);
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view, position, id) -> {
            Log.d("POSITION", String.valueOf(position));
            Log.d("ID", String.valueOf(id));
            SongDTO song = ((SongTableAdapter) list.getAdapter()).getSong(position);
            Executors.newSingleThreadExecutor().execute(() -> {
                Intent i = new Intent(SongbookTableOfContentsActivity.this, SongActivity.class);
                i.putExtra(SongActivity.SongExtra, SongService.getInstance().fromDto(song));
                startActivity(i);
            });
        });
        Executors.newSingleThreadExecutor().execute(() -> {
            List<SongDTO> result = SongService.getInstance().songList().blockingFirst();
            list.post(() -> list.setAdapter(new SongTableAdapter(getApplicationContext(), result)));
        });
    }
}