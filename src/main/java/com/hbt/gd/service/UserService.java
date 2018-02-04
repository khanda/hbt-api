package com.hbt.gd.service;

import com.hbt.gd.entity.Note;

import java.util.List;


public interface UserService {
    List<Note> getAllNote() throws Exception;
} 
