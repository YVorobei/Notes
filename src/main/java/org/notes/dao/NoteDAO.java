package org.notes.dao;

import org.notes.entity.Note;

import java.util.List;

public interface NoteDAO {
    void save(Note theNote);

    Note findById(Integer id);

    List<Note> findAll();

    void update(Note theNote);

    void delete(Integer id);
}
