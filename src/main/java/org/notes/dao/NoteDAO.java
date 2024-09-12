package org.notes.dao;

import org.notes.dto.Note;

import java.util.List;

public interface NoteDAO {
    void save(Note theNote);

    Note findById(Integer id);

    List<Note> findAll();

    void update(Integer noteId, Note theNote);

    void delete(Integer id);
}
