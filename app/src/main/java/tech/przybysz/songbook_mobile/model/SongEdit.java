package tech.przybysz.songbook_mobile.model;

import java.time.LocalDateTime;

import tech.przybysz.songbook_mobile.api_client.domain.UserDTO;

public class SongEdit {

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
