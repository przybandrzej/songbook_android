package tech.przybysz.songbook_mobile.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import tech.przybysz.songbook_mobile.api_client.domain.UserRoleDTO;

public class UserSimple implements Serializable {
    private Long id;
    private boolean activated;
    private LocalDateTime registrationDate;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private UserRoleDTO role;

    public UserSimple(Long id, boolean activated, LocalDateTime registrationDate, String email, String username, String firstName, String lastName, String imageUrl, UserRoleDTO role) {
        this.id = id;
        this.activated = activated;
        this.registrationDate = registrationDate;
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSimple that = (UserSimple) o;
        return activated == that.activated &&
                id.equals(that.id) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(email, that.email) &&
                Objects.equals(username, that.username) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, activated, registrationDate, email, username, firstName, lastName, imageUrl, role);
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
}
