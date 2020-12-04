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
import java.time.LocalDateTime;

/**
 * SongEditDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-19T15:40:15.848+01:00")
public class SongEditDTO {
  @SerializedName("editedBy")
  private Long editedBy = null;

  @SerializedName("editedSong")
  private Long editedSong = null;

  @SerializedName("id")
  private Long id = null;

  @SerializedName("timestamp")
  private LocalDateTime timestamp = null;

  public SongEditDTO editedBy(Long editedBy) {
    this.editedBy = editedBy;
    return this;
  }

   /**
   * Get editedBy
   * @return editedBy
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getEditedBy() {
    return editedBy;
  }

  public void setEditedBy(Long editedBy) {
    this.editedBy = editedBy;
  }

  public SongEditDTO editedSong(Long editedSong) {
    this.editedSong = editedSong;
    return this;
  }

   /**
   * Get editedSong
   * @return editedSong
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getEditedSong() {
    return editedSong;
  }

  public void setEditedSong(Long editedSong) {
    this.editedSong = editedSong;
  }

  public SongEditDTO id(Long id) {
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

  public SongEditDTO timestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(value = "")
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SongEditDTO songEditDTO = (SongEditDTO) o;
    return Objects.equals(this.editedBy, songEditDTO.editedBy) &&
        Objects.equals(this.editedSong, songEditDTO.editedSong) &&
        Objects.equals(this.id, songEditDTO.id) &&
        Objects.equals(this.timestamp, songEditDTO.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(editedBy, editedSong, id, timestamp);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SongEditDTO {\n");
    
    sb.append("    editedBy: ").append(toIndentedString(editedBy)).append("\n");
    sb.append("    editedSong: ").append(toIndentedString(editedSong)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
