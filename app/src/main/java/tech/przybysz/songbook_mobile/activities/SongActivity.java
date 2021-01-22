package tech.przybysz.songbook_mobile.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.math.BigDecimal;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.activities.dialogs.RateDialogFragment;
import tech.przybysz.songbook_mobile.model.Song;
import tech.przybysz.songbook_mobile.services.SongService;

public class SongActivity extends AppCompatActivity implements RateDialogFragment.RateDialogListener {

    public static final String SongExtra = "song";

    private Song song;
    private ImageButton ratingButton;
    private Button likeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        this.song = (Song) getIntent().getExtras().get(SongExtra);
        init();
    }

    private void init() {
        ((TextView) findViewById(R.id.title_tv)).setText(song.getTitle());
        ((TextView) findViewById(R.id.author_tv)).setText(song.getAuthor().getName());
        ((TextView) findViewById(R.id.rating_tv)).setText(String.valueOf(song.getAverageRating()));
        ratingButton = findViewById(R.id.ratingBar);
        Log.d("Rating", "" + song.getUserRating());
        if (song.getUserRating() != null) {
            ratingButton.setImageResource(R.drawable.mrb_star_icon_black_36dp);
        }
        ratingButton.setOnClickListener(this::ratingClicked);
        likeBtn = findViewById(R.id.like_btn);
        if(song.isInUserLib()) {
            likeBtn.setBackgroundResource(R.drawable.ic_like_filled);
        }
        likeBtn.setOnClickListener(this::likeClicked);
        Button settings = findViewById(R.id.settings_btn);
        settings.setOnClickListener(this::settingsClicked);
        ((TextView) findViewById(R.id.lyrics_tv)).setText(song.getLyrics());
        ((TextView) findViewById(R.id.cords_tv)).setText(song.getGuitarTabs());
    }

    private void likeClicked(View view) {
        if(!song.isInUserLib()) {
            SongService.getInstance().likeSong(song.getId());
            song.setInUserLib(true);
            likeBtn.setBackgroundResource(R.drawable.ic_like_filled);
        } else {
            SongService.getInstance().dislikeSong(song.getId());
            song.setInUserLib(false);
            likeBtn.setBackgroundResource(R.drawable.ic_like_border);
        }
    }

    private void settingsClicked(View view) {
        // TODO
    }

    private void ratingClicked(View view) {
        DialogFragment dialog = new RateDialogFragment(song.getUserRating() != null ? song.getUserRating().floatValue() * 5 : null);
        dialog.show(getSupportFragmentManager(), "RateDialogFragment");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, float result) {
        Log.d("RATED", String.valueOf(result));
        song.setUserRating(BigDecimal.valueOf(result));
        SongService.getInstance().rateSong(song.getId(), result/5);
        ratingButton.setImageResource(R.drawable.mrb_star_icon_black_36dp);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Log.d("RATED", "rating cancelled");
    }

    @Override
    public void onDialogDeleteClick(DialogFragment dialog) {
        song.setUserRating(null);
        SongService.getInstance().rateSong(song.getId(), null);
        ratingButton.setImageResource(R.drawable.mrb_star_border_icon_black_36dp);
    }
}