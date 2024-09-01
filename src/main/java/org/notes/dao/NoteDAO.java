package org.notes.dao;

import org.notes.dto.NoteResponseById;

import java.util.List;

public interface NoteDAO {
    void save(NoteResponseById theNote);

    NoteResponseById findById(Integer id);

    List<NoteResponseById> findAll();

    void update(Integer noteId, NoteResponseById theNote);

    void delete(Integer id);
}
