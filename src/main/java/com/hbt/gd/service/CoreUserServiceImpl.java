package com.hbt.gd.service;

import com.hbt.gd.controller.CoreUserController;
import com.hbt.gd.entity.CoreUser;
import com.hbt.gd.entity.UserRole;
import com.hbt.gd.reposity.CoreUserRepository;
import com.hbt.gd.reposity.UserRoleRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CoreUserServiceImpl implements CoreUserService {
    private final static Logger logger = Logger.getLogger(CoreUserController.class);
    @Autowired
    private
    EntityManager entityManager;
    @Autowired
    private
    CoreUserRepository userRepository;
    @Autowired
    private
    UserRoleRepository userRoleRepository;

    @Override
    public boolean save(CoreUser coreUser) {
        try {
            CoreUser userOriginal = userRepository.findOne(coreUser.getId());
            //update
            if (userOriginal != null) {
                userOriginal.setRoleId(coreUser.getRoleId());
                CoreUser user = userRepository.save(userOriginal);
                logger.info("save success: " + user.toString());
            }
            //create new
            else {
                CoreUser user = userRepository.save(coreUser);
                logger.info("save success: " + user.toString());
            }


        } catch (Exception e) {
            logger.error("save error", e);
            return false;
        }

        return true;
    }

    @Override
    public CoreUser getCoreUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<CoreUser> getListCoreUser(Integer page, Integer itemPerPage) {
        Query query = entityManager.createQuery("FROM CoreUser WHERE status = 1 ");

        query.setFirstResult((page - 1) * itemPerPage);
        query.setMaxResults(itemPerPage);
        List<CoreUser> myList = query.getResultList();

        return myList;
    }

    @Override
    public Long getListCoreUserCount(Integer page, Integer itemPerPage) {
        Query query = entityManager.createQuery("FROM CoreUser WHERE status = 1 ");
        List<CoreUser> myList = query.getResultList();
        Long count = Long.valueOf(myList.size());
        return count;
    }

    @Override
    public List<UserRole> getAccountRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public boolean delete(Long id) {
        CoreUser coreUser = userRepository.findOne(id);
        if (coreUser == null)
            return false;
        try {
            coreUser.setStatus(0);
            userRepository.save(coreUser);

            return true;
        } catch (Exception e) {
            logger.error("delete: ", e);
            return false;
        }
    }

    @Override
    public boolean login(String userName, String password) {
        return userRepository.login(userName, password);
    }
}
