package org.notes.service;

import org.notes.dto.Note;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final DbNoteServiceImpl dbNoteService;

    public NoteServiceImpl(DbNoteServiceImpl dbNoteService) {
        this.dbNoteService = dbNoteService;
    }

    @Transactional
    @Override
    public void save(Note theNote) {
        var newestNoteId = getLastNoteId() + 1;
        theNote.setId(newestNoteId);
        dbNoteService.save(theNote);
    }

    @Override
    public Note findById(Integer id) {
        return dbNoteService.findById(id);
    }

    @Override
    public List<Note> findAll() {
        return dbNoteService.findAll();
    }

    @Transactional
    @Override
    public void update(Integer noteId, Note theNote) {
        dbNoteService.update(noteId, theNote);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        dbNoteService.delete(id);
    }

    private Integer getLastNoteId() {
        return dbNoteService.getLastNote().getId();
    }
}
