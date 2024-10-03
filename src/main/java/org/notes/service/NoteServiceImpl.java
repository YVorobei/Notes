package org.notes.service;

import org.notes.dto.Note;
import org.notes.mapper.NoteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteDbService noteDbService;

    public NoteServiceImpl(NoteDbService noteDbService) {
        this.noteDbService = noteDbService;
    }

    @Transactional
    @Override
    public void save(Note theNote) {
        var newestNoteId = getLastNoteId() + 1;
        theNote.setId(newestNoteId);

        noteDbService.save(NoteMapper.INSTANCE.toNoteDb(theNote));
    }

    @Override
    public Note findById(Integer id) {

        return NoteMapper.INSTANCE.toNote(noteDbService.findById(id));
    }

    @Override
    public List<Note> findAll() {
        List<Note> notes = new ArrayList<>();
        var listNoteDb = noteDbService.findAll();
        listNoteDb.forEach(noteDb -> notes.add(NoteMapper.INSTANCE.toNote(noteDb)));

        return notes;
    }

    @Transactional
    @Override
    public void update(Integer noteId, Note theNote) {
        noteDbService.update(noteId, NoteMapper.INSTANCE.toNoteDb(theNote));
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        noteDbService.delete(id);
    }

    private Integer getLastNoteId() {
        return noteDbService.getLastNote().getId();
    }
}
