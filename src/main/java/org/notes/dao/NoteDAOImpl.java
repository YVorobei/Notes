package org.notes.dao;

import org.notes.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NoteDAOImpl implements NoteDAO {

    private EntityManager entityManager;

    @Autowired
    public NoteDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Note note) {
        entityManager.persist(note);
    }

    @Override
    public Note findById(Integer id) {
        return entityManager.find(Note.class, id);
    }

    @Override
    public List<Note> findAll() {
        TypedQuery<Note> theQuery = entityManager.createQuery("from Note", Note.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        var theNote = entityManager.find(Note.class, id);
        entityManager.remove(theNote);
    }

    @Override
    public void update(Note theNote) {
        entityManager.merge(theNote);
    }
}
