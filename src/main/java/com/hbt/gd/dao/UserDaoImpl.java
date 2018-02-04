package com.hbt.gd.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Note> getAllNote() {
        Session session = sessionFactory.openSession();
        List<Note> list = session.createQuery("FROM Note").list();
        return list;

    }

    @Override
    public void addNote(Note note) throws RuntimeException {
        if(note.getId() == 0){
            Session session = sessionFactory.openSession();
            session.save(note);
        }else {
            throw new RuntimeException("error");
        }

    }
}
