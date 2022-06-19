package com.services;

import com.domain.Note;
import com.repositories.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class NoteServiceImp implements  NoteService{
    @Autowired
    private NoteRepo noteRepo;

    @Override
    public List<Note> listOfNotes() {
        return noteRepo.findAll();
    }

    @Override
    public void addNote(@RequestBody Note note) {
        noteRepo.save(note);
    }
}
