package com.hbt.gd.reposity;

import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;

import java.util.List;

/**
 * Created by quyen on 05/02/2018.
 */
public interface EmployeeRepositoryCustom {
    PagingData<EmployeeDto> filterEmployees(int page, int pageSize, String searchTerm);
    List<EmployeeDto> getManagers(Long departmentId);
} 
