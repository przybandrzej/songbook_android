package tech.przybysz.songbook_mobile.activities.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;

public class SongTableAdapter extends ArrayAdapter<SongDTO> {

    private final Context context;
    private final List<SongDTO> songs;

    public SongTableAdapter(Context context, List<SongDTO> songs) {
        super(context, R.layout.fragment_table_of_content_item, songs);
        this.context = context;
        this.songs = songs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_table_of_content_item, parent, false);
        }
        SongDTO song = songs.get(position);
        ((TextView) convertView.findViewById(R.id.count_tv)).setText((position + 1) + ".");
        ((TextView) convertView.findViewById(R.id.text_1)).setText(song.getTitle());
        ((TextView) convertView.findViewById(R.id.text_2)).setText(song.getAuthor().getName());
        Button likeButton = convertView.findViewById(R.id.like_button);
        Button settingsButton = convertView.findViewById(R.id.settings_button);
        likeButton.setFocusable(false);
        settingsButton.setFocusable(false);
        settingsButton.setOnClickListener(view -> {
            Log.d("Settings button", "clicked");
        });
        likeButton.setOnClickListener(view -> {
            Log.d("Like button", "clicked");
        });

        /*if (song.isLiked()) {
            likeButton.setBackgroundResource(R.drawable.ic_like_filled);
        } else {
            likeButton.setBackgroundResource(R.drawable.ic_like_border);
        }*/
        return convertView;
    }

    public SongDTO getSong(int position) {
        return songs.get(position);
    }

}
