package com.hbt.gd.reposity;

import com.hbt.gd.dto.EmployeeDto;

import java.util.List;

/**
 * Created by quyen on 05/02/2018.
 */
public interface EmployeeRepositoryCustom {
    List<EmployeeDto> getManagers(Long departmentId);
} 
