package tech.przybysz.songbook_mobile.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Playlist implements Serializable {
    private Long id;
    private String name;
    private LocalDateTime creationTime;
    private boolean isPrivate;
    private User owner;
    private List<Song> songs;

    public Playlist(Long id, String name, LocalDateTime creationTime, boolean isPrivate, User owner, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.creationTime = creationTime;
        this.isPrivate = isPrivate;
        this.owner = owner;
        this.songs = songs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return isPrivate == playlist.isPrivate &&
                id.equals(playlist.id) &&
                Objects.equals(name, playlist.name) &&
                Objects.equals(creationTime, playlist.creationTime) &&
                Objects.equals(owner.getId(), playlist.owner.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationTime, isPrivate, owner.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
