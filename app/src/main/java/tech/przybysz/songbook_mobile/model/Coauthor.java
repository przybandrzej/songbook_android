package tech.przybysz.songbook_mobile.model;

import java.io.Serializable;
import java.util.Objects;

import tech.przybysz.songbook_mobile.api_client.domain.AuthorDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongCoauthorDTO;

public class Coauthor implements Serializable {

    private AuthorDTO author;
    private Song song;
    private SongCoauthorDTO.CoauthorFunctionEnum function;

    public Coauthor(AuthorDTO author, Song song, SongCoauthorDTO.CoauthorFunctionEnum function) {
        this.author = author;
        this.song = song;
        this.function = function;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coauthor coauthor = (Coauthor) o;
        return Objects.equals(author.getId(), coauthor.author.getId()) &&
                Objects.equals(song.getId(), coauthor.song.getId()) &&
                function == coauthor.function;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author.getId(), song.getId(), function);
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public SongCoauthorDTO.CoauthorFunctionEnum getFunction() {
        return function;
    }

    public void setFunction(SongCoauthorDTO.CoauthorFunctionEnum function) {
        this.function = function;
    }
}
