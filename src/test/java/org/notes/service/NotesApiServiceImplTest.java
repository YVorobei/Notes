package org.notes.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.notes.controller.NotesApiControllerImpl;
import org.notes.dto.NoteRegistrationInfo;
import org.notes.dto.NoteResponseById;
import org.notes.dto.NotesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.Collections;

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
    private NotesApiControllerImpl notesApiController;

    @BeforeEach
    void setUp() {
        noteService = mock(NoteService.class);
        notesApiController = new NotesApiControllerImpl(noteService);
    }

    @Test
    void shouldSearchNoteByIdWhenNoteGetByIdIsCalled() {
        NoteResponseById note = new NoteResponseById();
        when(noteService.findById(anyInt())).thenReturn(note);

        ResponseEntity<NoteResponseById> response = notesApiController.getById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(note, response.getBody());
        verify(noteService, times(1)).findById(anyInt());
    }

    @Test
    void shouldCreateNoteWhenNoteCreateIsCalled() {
        NoteRegistrationInfo noteRegistrationInfo = new NoteRegistrationInfo();
        noteRegistrationInfo.setTitle("Test Title");
        noteRegistrationInfo.setMessage("Test Message");

        NoteResponseById note = new NoteResponseById();
        note.setId(0);
        note.setTitle(noteRegistrationInfo.getTitle());
        note.setMessage(noteRegistrationInfo.getMessage());
        note.setDateCreation(OffsetDateTime.now());
        note.setDateUpdate(OffsetDateTime.now());

        doNothing().when(noteService).save(any(NoteResponseById.class));

        ResponseEntity<NoteResponseById> response = notesApiController.createNote(noteRegistrationInfo);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(noteService, times(1)).save(any(NoteResponseById.class));
    }

    @Test
    void shouldSearchAllNotesWhenGetNotesIsCalled() {
        NotesResponse notesResponse = new NotesResponse();
        notesResponse.setNotes(Collections.emptyList());
        when(noteService.findAll()).thenReturn(notesResponse.getNotes());

        ResponseEntity<NotesResponse> response = notesApiController.getNotes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notesResponse.getNotes(), response.getBody().getNotes());
        verify(noteService, times(1)).findAll();
    }

    @Test
    void shouldDeleteNoteWhenDeleteNoteIsCalled() {
        doNothing().when(noteService).delete(anyInt());

        ResponseEntity<NoteResponseById> response = notesApiController.deleteNote(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(noteService, times(1)).delete(anyInt());
    }

    @Test
    void shouldUpdateNoteWhenUpdateNoteIsCalled() {
        NoteRegistrationInfo noteRegistrationInfo = new NoteRegistrationInfo();
        noteRegistrationInfo.setTitle("Updated Title");
        noteRegistrationInfo.setMessage("Updated Message");

        NoteResponseById note = new NoteResponseById();
        note.setId(1);
        note.setTitle(noteRegistrationInfo.getTitle());
        note.setMessage(noteRegistrationInfo.getMessage());
        note.setDateUpdate(OffsetDateTime.now());

        doNothing().when(noteService).update(anyInt(), any(NoteResponseById.class));

        ResponseEntity<NoteResponseById> response = notesApiController.updateNote(1, noteRegistrationInfo);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(noteService, times(1)).update(anyInt(), any(NoteResponseById.class));
    }
}