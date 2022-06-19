package com.controllers;

import com.domain.Note;
import com.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NotesController {
    @Autowired
    private NoteService noteService;

    // Get All Notes
    @RequestMapping("/")
    public String index(Model model) {
        List<Note> notes =  noteService.listOfNotes();
        model.addAttribute("notes", notes);
        model.addAttribute("add", new Note());

        return "index";
    }

    // Create a new Note
    @RequestMapping("/add")
    public String createNote(@ModelAttribute Note requestNote) {
        Note localNote = new Note(requestNote.getText(), requestNote.getImportance());
        noteService.addNote(localNote);
        return "redirect:/";
    }

}
