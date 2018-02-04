package com.hbt.gd.service;

import com.hbt.gd.dao.UserDao;
import com.hbt.gd.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<Note> getAllNote() throws RuntimeException {
        return userDao.getAllNote();
    }
}
