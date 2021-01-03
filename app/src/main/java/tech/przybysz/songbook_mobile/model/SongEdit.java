package tech.przybysz.songbook_mobile.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;

public class SongEdit implements Serializable {

    private Long id;
    private UserDTO user;
    private Song song;
    private LocalDateTime timestamp;

    public SongEdit(Long id, UserDTO user, Song song, LocalDateTime timestamp) {
        this.id = id;
        this.user = user;
        this.song = song;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongEdit songEdit = (SongEdit) o;
        return Objects.equals(id, songEdit.id) &&
                Objects.equals(user.getId(), songEdit.user.getId()) &&
                Objects.equals(song.getId(), songEdit.song.getId()) &&
                Objects.equals(timestamp, songEdit.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user.getId(), song.getId(), timestamp);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
