package tech.przybysz.songbook_mobile.activities.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.activities.SongActivity;
import tech.przybysz.songbook_mobile.activities.adapters.SongTableAdapter;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.services.SongService;


public class SongbookFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_songbook, container, false);
        ListView list = root.findViewById(R.id.song_list);
        List<SongDTO> songs = new ArrayList<>();
        SongTableAdapter adapter = new SongTableAdapter(getActivity(), songs);
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view, position, id) -> {
            SongDTO song = ((SongTableAdapter) list.getAdapter()).getSong(position);
            Executors.newSingleThreadExecutor().execute(() -> {
                Intent i = new Intent(getActivity(), SongActivity.class);
                i.putExtra(SongActivity.SongExtra, SongService.getInstance().fromDto(song));
                startActivity(i);
            });
        });
        Executors.newSingleThreadExecutor().execute(() -> {
            List<SongDTO> result = SongService.getInstance().songList().blockingFirst();
            list.post(() -> list.setAdapter(new SongTableAdapter(getActivity(), result)));
        });
        return root;
    }
}