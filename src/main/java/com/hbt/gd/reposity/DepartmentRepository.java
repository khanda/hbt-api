package com.hbt.gd.reposity;

import com.hbt.gd.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by quyen on 05/02/2018.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>, DepartmentRepositoryCustom {
} 
