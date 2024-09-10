package org.notes.dao;

import org.notes.dto.NoteResponseById;
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
    //@Transactional// move to service layer
    public void save(NoteResponseById theNote) {
        entityManager.persist(theNote);
    }

    @Override
    public NoteResponseById findById(Integer id) {
        return entityManager.find(NoteResponseById.class, id);
    }

    @Override
    public List<NoteResponseById> findAll() {
        TypedQuery<NoteResponseById> theQuery = entityManager.createQuery("from NoteResponseById", NoteResponseById.class);

        return theQuery.getResultList();
    }

    @Override
    //@Transactional //move to service layer
    public void delete(Integer id) {
        var theNote = entityManager.find(NoteResponseById.class, id);
        if (theNote == null) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        entityManager.remove(theNote);
    }

    @Override
    //@Transactional
    public void update(Integer id, NoteResponseById theNote) {
        var targetNote = entityManager.find(NoteResponseById.class, id);
        if (targetNote == null) {
            throw new RuntimeException("Note with id " + id + " not found");
        }

        //todo move logic
        theNote.setDateCreation(targetNote.getDateCreation());

        entityManager.merge(theNote);
    }
}
