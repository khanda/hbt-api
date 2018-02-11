package com.hbt.gd.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

}
