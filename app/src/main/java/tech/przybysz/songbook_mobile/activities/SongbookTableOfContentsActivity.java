package tech.przybysz.songbook_mobile.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.activities.adapters.SongTableAdapter;
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
        list.add(new Song("Nieoficjalny hymn STK", "Andrzej Reszelski", true));
        list.add(new Song("STK", "Heheh", true));
        list.add(new Song("Bieszczadzki Trakt", "Andrzej Starzec", false));
        list.add(new Song("Lalalalalaalalalalallalalaalalalalalal", "Autor", false));
        list.add(new Song("Nieoficjalny hymn STK", "Andrzej Reszelski", true));
        list.add(new Song("STK", "Heheh", true));
        list.add(new Song("Bieszczadzki Trakt", "Andrzej Starzec", false));
        list.add(new Song("Lalalalalaalalalalallalalaalalalalalal", "Autor", false));
        list.add(new Song("Nieoficjalny hymn STK", "Andrzej Reszelski", true));
        list.add(new Song("STK", "Heheh", true));
        list.add(new Song("Bieszczadzki Trakt", "Andrzej Starzec", false));
        list.add(new Song("Lalalalalaalalalalallalalaalalalalalallalalalalalalalalalalal", "Autor", false));
        list.add(new Song("Nieoficjalny hymn STK", "Andrzej Reszelski", true));
        list.add(new Song("STK", "Heheh", true));
        list.add(new Song("Bieszczadzki Trakt", "Andrzej Starzec", false));
        list.add(new Song("Lalalalalaalalalalallalalaalalalalalal", "Autor", false));
        return list;
    }
}