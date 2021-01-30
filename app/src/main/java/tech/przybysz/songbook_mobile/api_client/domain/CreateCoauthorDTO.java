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

/**
 * CreateCoauthorDTO
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-11-19T15:40:15.848+01:00")
public class CreateCoauthorDTO {
  @SerializedName("authorName")
  private String authorName = null;

  /**
   * Gets or Sets coauthorFunction
   */
  @JsonAdapter(CoauthorFunctionEnum.Adapter.class)
  public enum CoauthorFunctionEnum {
    MUSIC("MUSIC"),
    
    TEXT("TEXT");

    private String value;

    CoauthorFunctionEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static CoauthorFunctionEnum fromValue(String text) {
      for (CoauthorFunctionEnum b : CoauthorFunctionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<CoauthorFunctionEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final CoauthorFunctionEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public CoauthorFunctionEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return CoauthorFunctionEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("coauthorFunction")
  private CoauthorFunctionEnum coauthorFunction = null;

  public CreateCoauthorDTO authorName(String authorName) {
    this.authorName = authorName;
    return this;
  }

   /**
   * Get authorName
   * @return authorName
  **/
  @ApiModelProperty(value = "")
  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public CreateCoauthorDTO coauthorFunction(CoauthorFunctionEnum coauthorFunction) {
    this.coauthorFunction = coauthorFunction;
    return this;
  }

   /**
   * Get coauthorFunction
   * @return coauthorFunction
  **/
  @ApiModelProperty(required = true, value = "")
  public CoauthorFunctionEnum getCoauthorFunction() {
    return coauthorFunction;
  }

  public void setCoauthorFunction(CoauthorFunctionEnum coauthorFunction) {
    this.coauthorFunction = coauthorFunction;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCoauthorDTO createCoauthorDTO = (CreateCoauthorDTO) o;
    return Objects.equals(this.authorName, createCoauthorDTO.authorName) &&
        Objects.equals(this.coauthorFunction, createCoauthorDTO.coauthorFunction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorName, coauthorFunction);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCoauthorDTO {\n");
    
    sb.append("    authorName: ").append(toIndentedString(authorName)).append("\n");
    sb.append("    coauthorFunction: ").append(toIndentedString(coauthorFunction)).append("\n");
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

