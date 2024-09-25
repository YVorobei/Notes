package org.notes.service;

import org.springframework.stereotype.Repository;
import org.notes.dto.Note;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DbNoteServiceImpl implements NoteService {

    private final EntityManager entityManager;

    public DbNoteServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Note theNote) {
        entityManager.persist(theNote);
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
    public void delete(Integer id) {
        var theNote = entityManager.find(Note.class, id);
        if (theNote == null) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        entityManager.remove(theNote);
    }

    @Override
    public void update(Integer id, Note theNote) {
        var targetNote = entityManager.find(Note.class, id);
        if (targetNote == null) {
            throw new RuntimeException("Note with id " + id + " not found");
        }

        theNote.setDateCreation(targetNote.getDateCreation());

        entityManager.merge(theNote);
    }

    public Note getLastNote() {
        TypedQuery<Note> theQuery = entityManager.createQuery("from Note order by id desc", Note.class);
        theQuery.setMaxResults(1);
        return theQuery.getSingleResult();
    }
}
