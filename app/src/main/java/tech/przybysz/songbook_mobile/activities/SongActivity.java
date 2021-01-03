package tech.przybysz.songbook_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.model.Song;

public class SongActivity extends AppCompatActivity {

    public static final String SongExtra = "song";

    private Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        this.song = (Song) getIntent().getExtras().get(SongExtra);
    }
}