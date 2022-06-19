package com.services;

import com.domain.Note;

import java.util.List;

public interface NoteService {

    List<Note> listOfNotes();
    void addNote(Note n);
}
