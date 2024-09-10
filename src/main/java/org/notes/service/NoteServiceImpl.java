package org.notes.service;

import org.notes.dao.NoteDAO;
import org.notes.dto.NoteResponseById;
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
    public void save(NoteResponseById theNote) {
        noteDAO.save(theNote);
    }

    @Override
    public NoteResponseById findById(Integer id) {
        return noteDAO.findById(id);
    }

    @Override
    public List<NoteResponseById> findAll() {
        return noteDAO.findAll();
    }

    @Transactional
    @Override
    public void update(Integer noteId, NoteResponseById theNote) {
        noteDAO.update(noteId, theNote);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        noteDAO.delete(id);
    }
}
