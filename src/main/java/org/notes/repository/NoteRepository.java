package org.notes.repository;

import org.notes.dto.NoteEntity;
import org.springframework.stereotype.Repository;
import org.notes.dto.Note;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class NoteRepository {

    private final EntityManager entityManager;

    public NoteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(NoteEntity theNote) {
        entityManager.persist(theNote);
    }

    public NoteEntity findById(Integer id) {
        return entityManager.find(NoteEntity.class, id);
    }

    public List<NoteEntity> findAll() {
        TypedQuery<NoteEntity> theQuery = entityManager.createQuery("from NoteEntity", NoteEntity.class);

        return theQuery.getResultList();
    }

    public void delete(Integer id) {
        var theNote = entityManager.find(NoteEntity.class, id);
        if (theNote == null) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        entityManager.remove(theNote);
    }

    public void update(Integer id, NoteEntity theNote) {
        var targetNote = entityManager.find(NoteEntity.class, id);
        if (targetNote == null) {
            throw new RuntimeException("Note with id " + id + " not found");
        }

        theNote.setDateCreation(targetNote.getDateCreation());

        entityManager.merge(theNote);
    }
}
