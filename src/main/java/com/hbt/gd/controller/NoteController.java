package com.hbt.gd.controller;

import com.hbt.gd.entity.Note;
import com.hbt.gd.reposity.NoteRepository;
import com.hbt.gd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserService userService;

    @GetMapping("/note/all")
    public List<Note> getAllNotes() {
//        List<Note> list = noteRepository.findAll();

        List<Note> list = null;
        try {
            list = userService.getAllNote();
        } catch (Exception e) {
            list = new ArrayList<>();
        }
        return list;
    }

    @PostMapping("/note/save")
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/note/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findOne(noteId);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(note);
    }

    @PutMapping("/note/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(value = "id") Long noteId,
                                           @RequestBody Note noteDetails) {
        Note note = noteRepository.findOne(noteId);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return ResponseEntity.ok(updatedNote);
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findOne(noteId);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }

        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/users")
    public @ResponseBody String getUsers() {
        return "{\"users\":[{\"firstname\":\"Richard\", \"lastname\":\"Feynman\"}," +
                "{\"firstname\":\"Marie\",\"lastname\":\"Curie\"}]}";
    }
} 
