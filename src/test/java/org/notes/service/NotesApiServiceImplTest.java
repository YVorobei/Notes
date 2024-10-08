package org.notes.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.notes.controller.NotesApiController;
import org.notes.dto.AllNotes;
import org.notes.dto.NoteRegistrationInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.Collections;
import org.notes.dto.Note;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class NotesApiServiceImplTest {

    @Mock
    private NoteService noteService;
    private NotesApiController notesApiController;

    @BeforeEach
    void setUp() {
        noteService = mock(NoteService.class);
        notesApiController = new NotesApiController(noteService);
    }

    @Test
    void shouldSearchNoteByIdWhenNoteGetByIdIsCalled() {
        Note note = new Note();
        when(noteService.findById(anyInt())).thenReturn(note);

        ResponseEntity<Note> response = notesApiController.getById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(note, response.getBody());
        verify(noteService, times(1)).findById(anyInt());
    }

    @Test
    void shouldCreateNoteWhenNoteCreateIsCalled() {
        NoteRegistrationInfo noteRegistrationInfo = new NoteRegistrationInfo();
        noteRegistrationInfo.setTitle("Test Title");
        noteRegistrationInfo.setMessage("Test Message");

        Note note = new Note();
        note.setId(0);
        note.setTitle(noteRegistrationInfo.getTitle());
        note.setMessage(noteRegistrationInfo.getMessage());
        note.setDateCreation(OffsetDateTime.now());
        note.setDateUpdate(OffsetDateTime.now());

        doNothing().when(noteService).save(any(Note.class));

        ResponseEntity<Note> response = notesApiController.createNote(noteRegistrationInfo);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(noteService, times(1)).save(any(Note.class));
    }

    @Test
    void shouldSearchAllNotesWhenGetNotesIsCalled() {
        AllNotes allNotes = new AllNotes();
        Note note = new Note();

        allNotes.setNotes(Collections.emptyList());
        when(noteService.findAll()).thenReturn(allNotes.getNotes());

        ResponseEntity<AllNotes> response = notesApiController.getNotes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(allNotes.getNotes(), response.getBody().getNotes());
        verify(noteService, times(1)).findAll();
    }

    @Test
    void shouldDeleteNoteWhenDeleteNoteIsCalled() {
        doNothing().when(noteService).delete(anyInt());

        ResponseEntity<Note> response = notesApiController.deleteNote(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(noteService, times(1)).delete(anyInt());
    }

    @Test
    void shouldUpdateNoteWhenUpdateNoteIsCalled() {
        NoteRegistrationInfo noteRegistrationInfo = new NoteRegistrationInfo();
        noteRegistrationInfo.setTitle("Updated Title");
        noteRegistrationInfo.setMessage("Updated Message");

        Note note = new Note();
        note.setId(1);
        note.setTitle(noteRegistrationInfo.getTitle());
        note.setMessage(noteRegistrationInfo.getMessage());
        note.setDateUpdate(OffsetDateTime.now());

        doNothing().when(noteService).update(anyInt(), any(Note.class));

        ResponseEntity<Note> response = notesApiController.updateNote(1, noteRegistrationInfo);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(noteService, times(1)).update(anyInt(), any(Note.class));
    }
}