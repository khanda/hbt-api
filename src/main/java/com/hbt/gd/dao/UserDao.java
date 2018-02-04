package com.hbt.gd.dao;

import java.util.List;


public interface UserDao {
    List<Note> getAllNote();

    void addNote(Note note) throws RuntimeException;
} 
