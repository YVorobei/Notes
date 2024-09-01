package org.notes.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Entity
@Table(name = "notes")
public class Note {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("message")
    private String message;

    @JsonProperty("date_creation")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name="date_creation")
    private OffsetDateTime dateCreation;

    @JsonProperty("date_update")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name="date_update")
    private OffsetDateTime dateUpdate;

    public Note() {
    }

    public Note(String title, String message, OffsetDateTime dateCreation, OffsetDateTime dateUpdate) {
        this.title = title;
        this.message = message;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OffsetDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(OffsetDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public OffsetDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(OffsetDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", dateCreation=" + dateCreation +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
