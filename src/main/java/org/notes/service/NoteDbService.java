package org.notes.service;

import org.notes.model.NoteDb;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NoteDbService {

    private final EntityManager entityManager;

    public NoteDbService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //@Override
    public void save(NoteDb theNote) {
        entityManager.persist(theNote);
    }

    //@Override
    public NoteDb findById(Integer id) {
        return entityManager.find(NoteDb.class, id);
    }

    //@Override
    public List<NoteDb> findAll() {
        TypedQuery<NoteDb> theQuery = entityManager.createQuery("from NoteDb", NoteDb.class);

        return theQuery.getResultList();
    }

    //@Override
    public void delete(Integer id) {
        var theNote = entityManager.find(NoteDb.class, id);
        if (theNote == null) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        entityManager.remove(theNote);
    }

    //@Override
    public void update(Integer id, NoteDb theNote) {
        var targetNote = entityManager.find(NoteDb.class, id);
        if (targetNote == null) {
            throw new RuntimeException("Note with id " + id + " not found");
        }

        theNote.setDateCreation(targetNote.getDateCreation());

        entityManager.merge(theNote);
    }

    public NoteDb getLastNote() {
        TypedQuery<NoteDb> theQuery = entityManager.createQuery("from NoteDb order by id desc", NoteDb.class);
        theQuery.setMaxResults(1);
        return theQuery.getSingleResult();
    }
}
