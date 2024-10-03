package org.notes.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.notes.dto.Note;
import org.notes.dto.NoteEntity;

@Mapper
public interface NoteMapper {
    NoteMapper INSTANCE = Mappers.getMapper(NoteMapper.class);
    Note toNote(NoteEntity noteEntity);
    NoteEntity toNoteEntity(Note note);
}