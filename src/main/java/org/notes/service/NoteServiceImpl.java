package org.notes.service;

import org.notes.dao.NoteDAO;
import org.notes.dto.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private NoteDAO noteDAO;

    @Autowired
    public NoteServiceImpl(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Transactional
    @Override
    public void save(Note theNote) {
        noteDAO.save(theNote);
    }

    @Override
    public Note findById(Integer id) {
        return noteDAO.findById(id);
    }

    @Override
    public List<Note> findAll() {
        return noteDAO.findAll();
    }

    @Transactional
    @Override
    public void update(Integer noteId, Note theNote) {
        noteDAO.update(noteId, theNote);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        noteDAO.delete(id);
    }
}
