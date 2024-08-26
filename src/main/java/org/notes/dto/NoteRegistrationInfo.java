package org.notes.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * NoteRegistrationInfo
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-26T20:58:07.952931800+02:00[Europe/Warsaw]")
public class NoteRegistrationInfo   {

  @JsonProperty("title")
  private String title;

  @JsonProperty("message")
  private String message;

  public NoteRegistrationInfo title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  
  @Schema(name = "title", example = "TestNoteTitle", required = false)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public NoteRegistrationInfo message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
  */
  
  @Schema(name = "message", example = "test note description", required = false)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NoteRegistrationInfo noteRegistrationInfo = (NoteRegistrationInfo) o;
    return Objects.equals(this.title, noteRegistrationInfo.title) &&
        Objects.equals(this.message, noteRegistrationInfo.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NoteRegistrationInfo {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

