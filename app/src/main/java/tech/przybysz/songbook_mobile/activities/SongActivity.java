package tech.przybysz.songbook_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

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
        init();
    }

    private void init() {
        Log.d("Song", "init");
        ((TextView) findViewById(R.id.title_tv)).setText(song.getTitle());
        ((TextView) findViewById(R.id.author_tv)).setText(song.getAuthor().getName());
        ((TextView) findViewById(R.id.rating_tv)).setText("Average rating: " + song.getAverageRating());
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setRating(song.getUserRating().floatValue());
        ratingBar.setOnClickListener(view -> {
            // TODO
        });
        Button like = findViewById(R.id.like_btn);
        like.setOnClickListener(this::likeClicked);
        Button settings = findViewById(R.id.settings_btn);
        settings.setOnClickListener(this::settingsClicked);
        ((TextView) findViewById(R.id.lyrics_tv)).setText(song.getLyrics());
        ((TextView) findViewById(R.id.cords_tv)).setText(song.getGuitarTabs());
    }

    private void likeClicked(View view) {
        // TODO
    }

    private void settingsClicked(View view) {
        // TODO
    }
}