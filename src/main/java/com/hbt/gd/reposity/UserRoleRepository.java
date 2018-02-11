package com.hbt.gd.reposity;

import com.hbt.gd.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>, UserRoleRepositoryCustom {
} 
