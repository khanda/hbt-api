package com.hbt.gd.reposity;

import com.hbt.gd.entity.CoreUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CoreUserRepositoryImpl implements CoreUserRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean login(String userName, String password) {

        return true;
    }

    @Override
    public CoreUser findUserByUserName(String userName) {
        String hql = "FROM CoreUser WHERE username = :username";
        Query query = entityManager.createQuery(hql, CoreUser.class);
        query.setParameter("username", userName);
        List<CoreUser> users = query.getResultList();
        if (users != null && !users.isEmpty()) {
            return users.get(0);
        }
        return new CoreUser();
    }
}
