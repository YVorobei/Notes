package org.notes.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * NoteResponseById
 */
@Entity
@Table(name = "notes")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-26T20:58:07.952931800+02:00[Europe/Warsaw]")
public class NoteResponseById   {

  @Id
  @JsonProperty("id")
  @Column(name="id")
  private Integer id;

  @JsonProperty("title")
  @Column(name="title")
  private String title;

  @JsonProperty("message")
  @Column(name="message")
  private String message;

  @JsonProperty("date_creation")
  @Column(name="date_creation")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateCreation;

  @JsonProperty("date_update")
  @Column(name="date_update")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime dateUpdate;

  public NoteResponseById id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", example = "777", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public NoteResponseById title(String title) {
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

  public NoteResponseById message(String message) {
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

  public NoteResponseById dateCreation(OffsetDateTime dateCreation) {
    this.dateCreation = dateCreation;
    return this;
  }

  /**
   * Get dateCreation
   * @return dateCreation
  */
  @Valid 
  @Schema(name = "date_creation", required = false)
  public OffsetDateTime getDateCreation() {
    return dateCreation;
  }

  public void setDateCreation(OffsetDateTime dateCreation) {
    this.dateCreation = dateCreation;
  }

  public NoteResponseById dateUpdate(OffsetDateTime dateUpdate) {
    this.dateUpdate = dateUpdate;
    return this;
  }

  /**
   * Get dateUpdate
   * @return dateUpdate
  */
  @Valid 
  @Schema(name = "date_update", required = false)
  public OffsetDateTime getDateUpdate() {
    return dateUpdate;
  }

  public void setDateUpdate(OffsetDateTime dateUpdate) {
    this.dateUpdate = dateUpdate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NoteResponseById noteResponseById = (NoteResponseById) o;
    return Objects.equals(this.id, noteResponseById.id) &&
        Objects.equals(this.title, noteResponseById.title) &&
        Objects.equals(this.message, noteResponseById.message) &&
        Objects.equals(this.dateCreation, noteResponseById.dateCreation) &&
        Objects.equals(this.dateUpdate, noteResponseById.dateUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, message, dateCreation, dateUpdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NoteResponseById {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    dateCreation: ").append(toIndentedString(dateCreation)).append("\n");
    sb.append("    dateUpdate: ").append(toIndentedString(dateUpdate)).append("\n");
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
