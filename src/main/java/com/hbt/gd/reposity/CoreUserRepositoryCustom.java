package com.hbt.gd.reposity;

import com.hbt.gd.entity.CoreUser;

public interface CoreUserRepositoryCustom {
    boolean login(String userName, String password);

    CoreUser findUserByUserName(String userName);
} 
