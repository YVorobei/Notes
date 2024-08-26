package org.notes.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.notes.dto.NoteResponseById;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * NotesResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-26T20:58:07.952931800+02:00[Europe/Warsaw]")
public class NotesResponse   {

  @JsonProperty("notes")
  @Valid
  private List<NoteResponseById> notes = null;

  public NotesResponse notes(List<NoteResponseById> notes) {
    this.notes = notes;
    return this;
  }

  public NotesResponse addNotesItem(NoteResponseById notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Get notes
   * @return notes
  */
  @Valid 
  @Schema(name = "notes", required = false)
  public List<NoteResponseById> getNotes() {
    return notes;
  }

  public void setNotes(List<NoteResponseById> notes) {
    this.notes = notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NotesResponse notesResponse = (NotesResponse) o;
    return Objects.equals(this.notes, notesResponse.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NotesResponse {\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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

