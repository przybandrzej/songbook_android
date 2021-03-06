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
import tech.przybysz.songbook_mobile.api_client.domain.AuthorDTO;
import tech.przybysz.songbook_mobile.api_client.domain.CategoryDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongAddDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongCoauthorDTO;
import tech.przybysz.songbook_mobile.api_client.domain.SongEditDTO;
import tech.przybysz.songbook_mobile.api_client.domain.TagDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * SongDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-19T15:40:15.848+01:00")
public class SongDTO {
  @SerializedName("addedBy")
  private SongAddDTO addedBy = null;

  @SerializedName("author")
  private AuthorDTO author = null;

  @SerializedName("averageRating")
  private BigDecimal averageRating = null;

  @SerializedName("category")
  private CategoryDTO category = null;

  @SerializedName("coauthors")
  private List<SongCoauthorDTO> coauthors = new ArrayList<>();

  @SerializedName("edits")
  private List<SongEditDTO> edits = new ArrayList<>();

  @SerializedName("guitarTabs")
  private String guitarTabs = null;

  @SerializedName("id")
  private Long id = null;

  @SerializedName("isAwaiting")
  private Boolean isAwaiting = null;

  @SerializedName("lyrics")
  private String lyrics = null;

  @SerializedName("tags")
  private List<TagDTO> tags = new ArrayList<>();

  @SerializedName("title")
  private String title = null;

  @SerializedName("trivia")
  private String trivia = null;

  public SongDTO addedBy(SongAddDTO addedBy) {
    this.addedBy = addedBy;
    return this;
  }

   /**
   * Get addedBy
   * @return addedBy
  **/
  @ApiModelProperty(value = "")
  public SongAddDTO getAddedBy() {
    return addedBy;
  }

  public void setAddedBy(SongAddDTO addedBy) {
    this.addedBy = addedBy;
  }

  public SongDTO author(AuthorDTO author) {
    this.author = author;
    return this;
  }

   /**
   * Get author
   * @return author
  **/
  @ApiModelProperty(value = "")
  public AuthorDTO getAuthor() {
    return author;
  }

  public void setAuthor(AuthorDTO author) {
    this.author = author;
  }

  public SongDTO averageRating(BigDecimal averageRating) {
    this.averageRating = averageRating;
    return this;
  }

   /**
   * Get averageRating
   * @return averageRating
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getAverageRating() {
    return averageRating;
  }

  public void setAverageRating(BigDecimal averageRating) {
    this.averageRating = averageRating;
  }

  public SongDTO category(CategoryDTO category) {
    this.category = category;
    return this;
  }

   /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")
  public CategoryDTO getCategory() {
    return category;
  }

  public void setCategory(CategoryDTO category) {
    this.category = category;
  }

  public SongDTO coauthors(List<SongCoauthorDTO> coauthors) {
    this.coauthors = coauthors;
    return this;
  }

  public SongDTO addCoauthorsItem(SongCoauthorDTO coauthorsItem) {
    this.coauthors.add(coauthorsItem);
    return this;
  }

   /**
   * Get coauthors
   * @return coauthors
  **/
  @ApiModelProperty(required = true, value = "")
  public List<SongCoauthorDTO> getCoauthors() {
    return coauthors;
  }

  public void setCoauthors(List<SongCoauthorDTO> coauthors) {
    this.coauthors = coauthors;
  }

  public SongDTO edits(List<SongEditDTO> edits) {
    this.edits = edits;
    return this;
  }

  public SongDTO addEditsItem(SongEditDTO editsItem) {
    this.edits.add(editsItem);
    return this;
  }

   /**
   * Get edits
   * @return edits
  **/
  @ApiModelProperty(required = true, value = "")
  public List<SongEditDTO> getEdits() {
    return edits;
  }

  public void setEdits(List<SongEditDTO> edits) {
    this.edits = edits;
  }

  public SongDTO guitarTabs(String guitarTabs) {
    this.guitarTabs = guitarTabs;
    return this;
  }

   /**
   * Get guitarTabs
   * @return guitarTabs
  **/
  @ApiModelProperty(value = "")
  public String getGuitarTabs() {
    return guitarTabs;
  }

  public void setGuitarTabs(String guitarTabs) {
    this.guitarTabs = guitarTabs;
  }

  public SongDTO id(Long id) {
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

  public SongDTO isAwaiting(Boolean isAwaiting) {
    this.isAwaiting = isAwaiting;
    return this;
  }

   /**
   * Get isAwaiting
   * @return isAwaiting
  **/
  @ApiModelProperty(value = "")
  public Boolean isIsAwaiting() {
    return isAwaiting;
  }

  public void setIsAwaiting(Boolean isAwaiting) {
    this.isAwaiting = isAwaiting;
  }

  public SongDTO lyrics(String lyrics) {
    this.lyrics = lyrics;
    return this;
  }

   /**
   * Get lyrics
   * @return lyrics
  **/
  @ApiModelProperty(value = "")
  public String getLyrics() {
    return lyrics;
  }

  public void setLyrics(String lyrics) {
    this.lyrics = lyrics;
  }

  public SongDTO tags(List<TagDTO> tags) {
    this.tags = tags;
    return this;
  }

  public SongDTO addTagsItem(TagDTO tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @ApiModelProperty(required = true, value = "")
  public List<TagDTO> getTags() {
    return tags;
  }

  public void setTags(List<TagDTO> tags) {
    this.tags = tags;
  }

  public SongDTO title(String title) {
    this.title = title;
    return this;
  }

   /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(required = true, value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public SongDTO trivia(String trivia) {
    this.trivia = trivia;
    return this;
  }

   /**
   * Get trivia
   * @return trivia
  **/
  @ApiModelProperty(value = "")
  public String getTrivia() {
    return trivia;
  }

  public void setTrivia(String trivia) {
    this.trivia = trivia;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SongDTO songDTO = (SongDTO) o;
    return Objects.equals(this.addedBy, songDTO.addedBy) &&
        Objects.equals(this.author, songDTO.author) &&
        Objects.equals(this.averageRating, songDTO.averageRating) &&
        Objects.equals(this.category, songDTO.category) &&
        Objects.equals(this.coauthors, songDTO.coauthors) &&
        Objects.equals(this.edits, songDTO.edits) &&
        Objects.equals(this.guitarTabs, songDTO.guitarTabs) &&
        Objects.equals(this.id, songDTO.id) &&
        Objects.equals(this.isAwaiting, songDTO.isAwaiting) &&
        Objects.equals(this.lyrics, songDTO.lyrics) &&
        Objects.equals(this.tags, songDTO.tags) &&
        Objects.equals(this.title, songDTO.title) &&
        Objects.equals(this.trivia, songDTO.trivia);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addedBy, author, averageRating, category, coauthors, edits, guitarTabs, id, isAwaiting, lyrics, tags, title, trivia);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SongDTO {\n");
    
    sb.append("    addedBy: ").append(toIndentedString(addedBy)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    averageRating: ").append(toIndentedString(averageRating)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    coauthors: ").append(toIndentedString(coauthors)).append("\n");
    sb.append("    edits: ").append(toIndentedString(edits)).append("\n");
    sb.append("    guitarTabs: ").append(toIndentedString(guitarTabs)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    isAwaiting: ").append(toIndentedString(isAwaiting)).append("\n");
    sb.append("    lyrics: ").append(toIndentedString(lyrics)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    trivia: ").append(toIndentedString(trivia)).append("\n");
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

