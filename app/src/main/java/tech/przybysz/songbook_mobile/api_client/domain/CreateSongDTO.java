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
import tech.przybysz.songbook_mobile.api_client.domain.CreateCoauthorDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a DTO for creating songs in the application.
 */
@ApiModel(description = "Class representing a DTO for creating songs in the application.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-19T15:40:15.848+01:00")
public class CreateSongDTO {
  @SerializedName("authorName")
  private String authorName = null;

  @SerializedName("categoryId")
  private Long categoryId = null;

  @SerializedName("title")
  private String title = null;

  @SerializedName("coauthors")
  private List<CreateCoauthorDTO> coauthors = new ArrayList<>();

  @SerializedName("lyrics")
  private String lyrics = null;

  @SerializedName("guitarTabs")
  private String guitarTabs = null;

  @SerializedName("trivia")
  private String trivia = null;

  @SerializedName("tags")
  private List<String> tags = new ArrayList<>();

  public CreateSongDTO authorName(String authorName) {
    this.authorName = authorName;
    return this;
  }

   /**
   * Author&#39;s name (doesn&#39;t have to exist)
   * @return authorName
  **/
  @ApiModelProperty(example = "John the band", required = true, value = "Author's name (doesn't have to exist)")
  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public CreateSongDTO categoryId(Long categoryId) {
    this.categoryId = categoryId;
    return this;
  }

   /**
   * Category
   * @return categoryId
  **/
  @ApiModelProperty(required = true, value = "Category")
  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public CreateSongDTO title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(example = "Rolling in the deep", required = true, value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public CreateSongDTO coauthors(List<CreateCoauthorDTO> coauthors) {
    this.coauthors = coauthors;
    return this;
  }

  public CreateSongDTO addCoauthorsItem(CreateCoauthorDTO coauthorsItem) {
    this.coauthors.add(coauthorsItem);
    return this;
  }

   /**
   * Get coauthors
   * @return coauthors
  **/
  @ApiModelProperty(required = true, value = "")
  public List<CreateCoauthorDTO> getCoauthors() {
    return coauthors;
  }

  public void setCoauthors(List<CreateCoauthorDTO> coauthors) {
    this.coauthors = coauthors;
  }

  public CreateSongDTO lyrics(String lyrics) {
    this.lyrics = lyrics;
    return this;
  }

   /**
   * Get lyrics
   * @return lyrics
  **/
  @ApiModelProperty(required = true, value = "")
  public String getLyrics() {
    return lyrics;
  }

  public void setLyrics(String lyrics) {
    this.lyrics = lyrics;
  }

  public CreateSongDTO guitarTabs(String guitarTabs) {
    this.guitarTabs = guitarTabs;
    return this;
  }

   /**
   * Get guitarTabs
   * @return guitarTabs
  **/
  @ApiModelProperty(required = true, value = "")
  public String getGuitarTabs() {
    return guitarTabs;
  }

  public void setGuitarTabs(String guitarTabs) {
    this.guitarTabs = guitarTabs;
  }

  public CreateSongDTO trivia(String trivia) {
    this.trivia = trivia;
    return this;
  }

   /**
   * Get trivia
   * @return trivia
  **/
  @ApiModelProperty(example = "Has written it for his wife.", value = "")
  public String getTrivia() {
    return trivia;
  }

  public void setTrivia(String trivia) {
    this.trivia = trivia;
  }

  public CreateSongDTO tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public CreateSongDTO addTagsItem(String tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @ApiModelProperty(required = true, value = "")
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSongDTO createSongDTO = (CreateSongDTO) o;
    return Objects.equals(this.authorName, createSongDTO.authorName) &&
        Objects.equals(this.categoryId, createSongDTO.categoryId) &&
        Objects.equals(this.title, createSongDTO.title) &&
        Objects.equals(this.coauthors, createSongDTO.coauthors) &&
        Objects.equals(this.lyrics, createSongDTO.lyrics) &&
        Objects.equals(this.guitarTabs, createSongDTO.guitarTabs) &&
        Objects.equals(this.trivia, createSongDTO.trivia) &&
        Objects.equals(this.tags, createSongDTO.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorName, categoryId, title, coauthors, lyrics, guitarTabs, trivia, tags);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSongDTO {\n");
    
    sb.append("    authorName: ").append(toIndentedString(authorName)).append("\n");
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    coauthors: ").append(toIndentedString(coauthors)).append("\n");
    sb.append("    lyrics: ").append(toIndentedString(lyrics)).append("\n");
    sb.append("    guitarTabs: ").append(toIndentedString(guitarTabs)).append("\n");
    sb.append("    trivia: ").append(toIndentedString(trivia)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

