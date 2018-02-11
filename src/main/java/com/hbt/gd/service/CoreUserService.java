package com.hbt.gd.service;

import com.hbt.gd.entity.CoreUser;
import com.hbt.gd.entity.UserRole;

import java.util.List;

public interface CoreUserService {
    boolean save(CoreUser coreUser);

    CoreUser getCoreUser(Long id);

    List<CoreUser> getListCoreUser(Integer page, Integer itemPerPage);

    Long getListCoreUserCount(Integer page, Integer itemPerPage);

    List<UserRole> getAccountRoles();

    boolean delete(Long id);

    boolean login(String userName, String password);

} 
