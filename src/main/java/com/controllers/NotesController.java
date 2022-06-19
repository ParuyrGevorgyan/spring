package com.controllers;

import com.domain.Note;
import com.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NotesController {
    @Autowired
    private NoteService noteService;

    // Get All Notes
    @GetMapping("/notes")
    public String listAllNotes(Model model) {
        List<Note> notes =  noteService.listOfNotes();
        model.addAttribute("notes", notes);

        return "notes";
    }

    // Create a new Note
    @PostMapping("add")
    public void createNote(@RequestBody Note note) {
        noteService.addNote(note);
    }

}
