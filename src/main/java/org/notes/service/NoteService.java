package org.notes.service;

import org.notes.builder.NoteResponseByIdBuilder;
import org.notes.dto.NoteRegistrationInfo;
import org.notes.dto.NoteResponseById;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class NoteService {

    private final List<NoteResponseById> db = new ArrayList<>();

    public NoteResponseById saveNote(NoteRegistrationInfo noteInfo) {
        var note = buildNoteResponseById(noteInfo);
        db.add(note);
        return note;
    }

    private NoteResponseById buildNoteResponseById(NoteRegistrationInfo noteInfo) {
        OffsetDateTime currentDate = OffsetDateTime.now();
        int id = new Random().nextInt(1000000);

        return NoteResponseByIdBuilder.builder().build()
                .id(id)
                .title(noteInfo.getTitle())
                .message(noteInfo.getMessage())
                .dateCreation(currentDate)
                .dateUpdate(currentDate);
    }

    public NoteResponseById getNoteById(int id) {
        return db.stream().filter(note -> note.getId().equals(id))
                .findFirst().orElse(null);
    }

    public List<NoteResponseById> getAllNotes() {
        return db;
    }

    public NoteResponseById removeNoteById(int noteId) {
        var removedNote = getNoteById(noteId);
        db.removeIf(note -> note.getId().equals(noteId));

        return removedNote;
    }

    public NoteResponseById updatedNoteById(int noteId, NoteRegistrationInfo body) {
        //todo move currentDate!!
        OffsetDateTime currentDate = OffsetDateTime.now();
        var updatedNote = getNoteById(noteId);
        updatedNote.setTitle(body.getTitle());
        updatedNote.setMessage(body.getMessage());
        updatedNote.setDateUpdate(currentDate);

        return updatedNote;
    }
}
