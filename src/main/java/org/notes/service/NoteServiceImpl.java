package org.notes.service;

import org.notes.dto.Note;
import org.notes.mapper.NoteMapper;
import org.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository NoteRepository) {
        this.noteRepository = NoteRepository;
    }

    @Transactional
    @Override
    public void save(Note theNote) {
        noteRepository.save(NoteMapper.INSTANCE.toNoteEntity(theNote));
    }

    @Override
    public Note findById(Integer id) {

        return NoteMapper.INSTANCE.toNote(noteRepository.findById(id));
    }

    @Override
    public List<Note> findAll() {
        List<Note> notes = new ArrayList<>();
        var listNoteDb = noteRepository.findAll();
        listNoteDb.forEach(noteDb -> notes.add(NoteMapper.INSTANCE.toNote(noteDb)));

        return notes;
    }

    @Transactional
    @Override
    public void update(Integer noteId, Note theNote) {
        noteRepository.update(noteId, NoteMapper.INSTANCE.toNoteEntity(theNote));
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        noteRepository.delete(id);
    }

}
