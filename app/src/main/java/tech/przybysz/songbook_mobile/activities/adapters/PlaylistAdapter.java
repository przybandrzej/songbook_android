package tech.przybysz.songbook_mobile.activities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.SongbookAndroidApplication;
import tech.przybysz.songbook_mobile.api_client.domain.PlaylistDTO;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder> {

    private int numCreated = 0;
    private List<PlaylistDTO> playlists = new ArrayList<>();

    public PlaylistAdapter(List<PlaylistDTO> playlists) {
        this.playlists = playlists;
    }

    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        numCreated++;
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.playlist_view, null);
        return new PlaylistViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        PlaylistDTO item = playlists.get(position);
        holder.name.setText(item.getName());
        holder.date.setText(item.getCreationTime().format(SongbookAndroidApplication.APP_FORMATTER));
        holder.songs.setText(item.getSongs().size());
    }

    @Override
    public int getItemCount() {
        return numCreated;
    }

    public static class PlaylistViewHolder extends RecyclerView.ViewHolder {

        protected TextView name;
        protected TextView date;
        protected TextView songs;

        private PlaylistViewHolder(View v) {
            super(v);
            this.name = v.findViewById(R.id.playlist_name);
            this.date = v.findViewById(R.id.playlist_date);
            this.songs = v.findViewById(R.id.playlist_songs);
        }
    }
}
