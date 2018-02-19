package com.hbt.gd.reposity;

import com.hbt.gd.entity.Khoi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class KhoiRepositoryImpl implements KhoiRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Khoi> getList() {
        String stringQuery = "SELECT k FROM Khoi k WHERE k.status = 1";
        TypedQuery<Khoi> typedQuery = entityManager.createQuery(stringQuery, Khoi.class);
        return typedQuery.getResultList();
    }

    @Override
    public boolean isLeaderAssigned(Long id) {
        String stringQuery = "SELECT k FROM Khoi k WHERE k.status = 1 AND leaderId = :leaderId";
        TypedQuery<Khoi> typedQuery = entityManager.createQuery(stringQuery, Khoi.class);
        typedQuery.setParameter("leaderId", id);
        List<Khoi> khois = typedQuery.getResultList();
        if (khois == null || khois.isEmpty())
            return false;
        return true;
    }
}
