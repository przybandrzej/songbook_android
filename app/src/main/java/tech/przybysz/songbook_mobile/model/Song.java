package tech.przybysz.songbook_mobile.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import tech.przybysz.songbook_mobile.api_client.domain.AuthorDTO;
import tech.przybysz.songbook_mobile.api_client.domain.CategoryDTO;
import tech.przybysz.songbook_mobile.api_client.domain.TagDTO;

public class Song implements Serializable {

    private Long id;
    private String title;
    private AuthorDTO author;
    private boolean isInUserLib;
    private BigDecimal averageRating;
    private CategoryDTO category;
    private String guitarTabs;
    private String lyrics;
    private boolean isAwaiting;
    private List<TagDTO> tags;
    private String trivia;
    private List<Coauthor> coauthors;
    private SongAdd songAdd;
    private List<SongEdit> edits;

    public Song(Long id, String title, AuthorDTO author, boolean isInUserLib, BigDecimal averageRating, CategoryDTO category, String guitarTabs, String lyrics, boolean isAwaiting, List<TagDTO> tags, String trivia, List<Coauthor> coauthors, SongAdd songAdd, List<SongEdit> edits) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isInUserLib = isInUserLib;
        this.averageRating = averageRating;
        this.category = category;
        this.guitarTabs = guitarTabs;
        this.lyrics = lyrics;
        this.isAwaiting = isAwaiting;
        this.tags = tags;
        this.trivia = trivia;
        this.coauthors = coauthors;
        this.songAdd = songAdd;
        this.edits = edits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public boolean isInUserLib() {
        return isInUserLib;
    }

    public void setInUserLib(boolean inUserLib) {
        isInUserLib = inUserLib;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getGuitarTabs() {
        return guitarTabs;
    }

    public void setGuitarTabs(String guitarTabs) {
        this.guitarTabs = guitarTabs;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public boolean isAwaiting() {
        return isAwaiting;
    }

    public void setAwaiting(boolean awaiting) {
        isAwaiting = awaiting;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    public String getTrivia() {
        return trivia;
    }

    public void setTrivia(String trivia) {
        this.trivia = trivia;
    }

    public List<Coauthor> getCoauthors() {
        return coauthors;
    }

    public void setCoauthors(List<Coauthor> coauthors) {
        this.coauthors = coauthors;
    }

    public SongAdd getSongAdd() {
        return songAdd;
    }

    public void setSongAdd(SongAdd songAdd) {
        this.songAdd = songAdd;
    }

    public List<SongEdit> getEdits() {
        return edits;
    }

    public void setEdits(List<SongEdit> edits) {
        this.edits = edits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return isInUserLib == song.isInUserLib &&
                isAwaiting == song.isAwaiting &&
                id.equals(song.id) &&
                Objects.equals(title, song.title) &&
                Objects.equals(averageRating, song.averageRating) &&
                Objects.equals(guitarTabs, song.guitarTabs) &&
                Objects.equals(lyrics, song.lyrics) &&
                Objects.equals(trivia, song.trivia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isInUserLib, averageRating, guitarTabs, lyrics, isAwaiting, trivia);
    }
}
