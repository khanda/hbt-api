package com.hbt.gd.dao;

import com.hbt.gd.entity.Note;

import java.util.List;


public interface UserDao {
    List<Note> getAllNote();

    void addNote(Note note) throws RuntimeException;
} 
