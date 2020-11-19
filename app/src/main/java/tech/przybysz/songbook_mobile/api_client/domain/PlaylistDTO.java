/*
 * Songbook API
 * Tourist songs application
 *
 * OpenAPI spec version: 1.5.5
 * Contact: andrzej.przybysz01@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package tech.przybysz.songbook_mobile.api_client.domain;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * PlaylistDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-19T15:40:15.848+01:00")
public class PlaylistDTO {
  @SerializedName("creationTime")
  private Instant creationTime = null;

  @SerializedName("id")
  private Long id = null;

  @SerializedName("isPrivate")
  private Boolean isPrivate = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("ownerId")
  private Long ownerId = null;

  @SerializedName("songs")
  private List<Long> songs = new ArrayList<>();

  public PlaylistDTO creationTime(Instant creationTime) {
    this.creationTime = creationTime;
    return this;
  }

   /**
   * Get creationTime
   * @return creationTime
  **/
  @ApiModelProperty(value = "")
  public Instant getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Instant creationTime) {
    this.creationTime = creationTime;
  }

  public PlaylistDTO id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PlaylistDTO isPrivate(Boolean isPrivate) {
    this.isPrivate = isPrivate;
    return this;
  }

   /**
   * Get isPrivate
   * @return isPrivate
  **/
  @ApiModelProperty(required = true, value = "")
  public Boolean isIsPrivate() {
    return isPrivate;
  }

  public void setIsPrivate(Boolean isPrivate) {
    this.isPrivate = isPrivate;
  }

  public PlaylistDTO name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PlaylistDTO ownerId(Long ownerId) {
    this.ownerId = ownerId;
    return this;
  }

   /**
   * Get ownerId
   * @return ownerId
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public PlaylistDTO songs(List<Long> songs) {
    this.songs = songs;
    return this;
  }

  public PlaylistDTO addSongsItem(Long songsItem) {
    this.songs.add(songsItem);
    return this;
  }

   /**
   * Get songs
   * @return songs
  **/
  @ApiModelProperty(required = true, value = "")
  public List<Long> getSongs() {
    return songs;
  }

  public void setSongs(List<Long> songs) {
    this.songs = songs;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaylistDTO playlistDTO = (PlaylistDTO) o;
    return Objects.equals(this.creationTime, playlistDTO.creationTime) &&
        Objects.equals(this.id, playlistDTO.id) &&
        Objects.equals(this.isPrivate, playlistDTO.isPrivate) &&
        Objects.equals(this.name, playlistDTO.name) &&
        Objects.equals(this.ownerId, playlistDTO.ownerId) &&
        Objects.equals(this.songs, playlistDTO.songs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creationTime, id, isPrivate, name, ownerId, songs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaylistDTO {\n");
    
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isPrivate: ").append(toIndentedString(isPrivate)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    songs: ").append(toIndentedString(songs)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

