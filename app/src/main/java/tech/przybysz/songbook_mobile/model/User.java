package tech.przybysz.songbook_mobile.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import tech.przybysz.songbook_mobile.api_client.domain.UserRoleDTO;

public class User implements Serializable {

    private Long id;
    private boolean activated;
    private LocalDateTime registrationDate;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private UserRoleDTO role;
    private List<Song> library;
    private List<SongAdd> addedSongs;
    private List<SongEdit> editedSongs;
    private List<Playlist> playlists;

    public User(Long id, boolean activated, LocalDateTime registrationDate, String email, String username, String firstName, String lastName, String imageUrl, UserRoleDTO role, List<Song> library, List<SongAdd> addedSongs, List<SongEdit> editedSongs, List<Playlist> playlists) {
        this.id = id;
        this.activated = activated;
        this.registrationDate = registrationDate;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.role = role;
        this.library = library;
        this.addedSongs = addedSongs;
        this.editedSongs = editedSongs;
        this.playlists = playlists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return activated == user.activated &&
                id.equals(user.id) &&
                Objects.equals(registrationDate, user.registrationDate) &&
                Objects.equals(email, user.email) &&
                Objects.equals(username, user.username) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(imageUrl, user.imageUrl) &&
                Objects.equals(role.getId(), user.role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activated, registrationDate, email, username, firstName, lastName, imageUrl, role.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserRoleDTO getRole() {
        return role;
    }

    public void setRole(UserRoleDTO role) {
        this.role = role;
    }

    public List<Song> getLibrary() {
        return library;
    }

    public void setLibrary(List<Song> library) {
        this.library = library;
    }

    public List<SongAdd> getAddedSongs() {
        return addedSongs;
    }

    public void setAddedSongs(List<SongAdd> addedSongs) {
        this.addedSongs = addedSongs;
    }

    public List<SongEdit> getEditedSongs() {
        return editedSongs;
    }

    public void setEditedSongs(List<SongEdit> editedSongs) {
        this.editedSongs = editedSongs;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
