package tech.przybysz.songbook_mobile.model;

import java.io.Serializable;

public class Song implements Serializable {

    private String title;
    private String author;
    private boolean isLiked;

    public Song(String title, String author, boolean isLiked) {
        this.title = title;
        this.author = author;
        this.isLiked = isLiked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }
}
