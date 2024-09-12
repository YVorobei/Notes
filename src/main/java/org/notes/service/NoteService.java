package org.notes.service;

import org.notes.dto.Note;

import java.util.List;

public interface NoteService {

    void save(Note theNote);

    Note findById(Integer id);

    List<Note> findAll();

    void update(Integer noteId, Note theNote);

    void delete(Integer id);

}
