package tech.przybysz.songbook_mobile.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
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
        list.setAdapter(new SongTableAdapter(getApplicationContext(), getSongs()));
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
        list.add(new Song("Lalalalalaalalalalallalalaalalalalalal", "Autor", false));
        list.add(new Song("Nieoficjalny hymn STK", "Andrzej Reszelski", true));
        list.add(new Song("STK", "Heheh", true));
        list.add(new Song("Bieszczadzki Trakt", "Andrzej Starzec", false));
        list.add(new Song("Lalalalalaalalalalallalalaalalalalalal", "Autor", false));
        return list;
    }
}