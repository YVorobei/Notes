package org.notes.service;

import org.notes.dto.NoteResponseById;

import java.util.List;

public interface NoteService {

    void save(NoteResponseById theNote);

    NoteResponseById findById(Integer id);

    List<NoteResponseById> findAll();

    void update(Integer noteId, NoteResponseById theNote);

    void delete(Integer id);

}
