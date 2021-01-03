package tech.przybysz.songbook_mobile.model;

import tech.przybysz.songbook_mobile.api_client.domain.AuthorDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongCoauthorDTO;

public class Coauthor {

    private AuthorDTO author;
    private Song song;
    private SongCoauthorDTO.CoauthorFunctionEnum function;

    public Coauthor(AuthorDTO author, Song song, SongCoauthorDTO.CoauthorFunctionEnum function) {
        this.author = author;
        this.song = song;
        this.function = function;
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
