package tech.przybysz.songbook_mobile.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.activities.adapters.SongTableAdapter;
import tech.przybysz.songbook_mobile.api_client.domain.AuthorDTO;
import tech.przybysz.songbook_mobile.model.Song;

public class SongbookTableOfContentsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songbook_table_of_contents);

        ListView list = findViewById(R.id.song_list);
        SongTableAdapter adapter = new SongTableAdapter(getApplicationContext(), getSongs());
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view, position, id) -> {
            Log.d("POSITION", String.valueOf(position));
            Log.d("ID", String.valueOf(id));
            Song song = adapter.getSong(position);
            Intent i = new Intent(SongbookTableOfContentsActivity.this, SongActivity.class);
            i.putExtra(SongActivity.SongExtra, song);
            startActivity(i);
        });
    }

    private List<Song> getSongs() {
        List<Song> list = new ArrayList<>(4);
        Song song = new Song();
        song.setId(1L);
        song.setAuthor(new AuthorDTO().id(1L).name("Andrzej Starzec"));
        song.setAverageRating(new BigDecimal("0.40"));
        song.setGuitarTabs("CD E D");
        //song.setUserRating();
        song.setTitle("Bieszczadzki trakt");
        list.add(song);
        return list;
    }
}