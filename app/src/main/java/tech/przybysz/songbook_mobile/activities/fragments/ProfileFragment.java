package tech.przybysz.songbook_mobile.activities.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Consumer;

import tech.przybysz.songbook_mobile.R;
import tech.przybysz.songbook_mobile.api_client.domain.SongDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;
import tech.przybysz.songbook_mobile.api_client.domain.UserRoleDTO;
import tech.przybysz.songbook_mobile.services.AuthService;
import tech.przybysz.songbook_mobile.services.DownloadImageTask;
import tech.przybysz.songbook_mobile.services.UserService;


public class ProfileFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        UserDTO user = AuthService.getInstance().getUser();
        new DownloadImageTask(root.findViewById(R.id.imageView)).execute(user.getImageUrl());
        Consumer<UserRoleDTO> roleCallback = role -> {
            getActivity().runOnUiThread(() -> {
                TextView tv = root.findViewById(R.id.role);
                tv.setText(role.getName());
                int color = R.color.user;
                if(role.getId() == 1L) {
                    color = R.color.superuser;
                } else if(role.getId() == 2L) {
                    color = R.color.admin;
                } else if(role.getId() == 3L) {
                    color = R.color.moderator;
                }
                tv.setTextColor(color);
            });
        };
        UserService.getInstance().getRole(user.getUserRoleId(), roleCallback);
        ((TextView) root.findViewById(R.id.username)).setText(user.getUsername());
        ((TextView) root.findViewById(R.id.name)).setText(user.getFirstName() + " " + user.getLastName());
        ((TextView) root.findViewById(R.id.email)).setText(user.getEmail());
        TextView edits = root.findViewById(R.id.songs_no);
        TextView adds = root.findViewById(R.id.adds_no);
        ((TextView) root.findViewById(R.id.reg_date)).setText(user.getRegistrationDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

        Consumer<List<SongDTO>> callback1 = songs -> getActivity().runOnUiThread(() -> adds.setText("" + songs.size()));
        Consumer<List<SongDTO>> callback2 = songs -> getActivity().runOnUiThread(() -> edits.setText("" + songs.size()));
        UserService.getInstance().getAdds(user.getId(), callback1);
        UserService.getInstance().getEdits(user.getId(), callback2);
        return root;
    }
}