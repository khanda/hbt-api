package com.hbt.gd.service;

import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by quyen on 05/02/2018.
 */
public interface EmployeeService {
    Page<Employee> getList(int page, int pageSize);
    boolean save(Employee employee );
    boolean delete(Long id);
    PagingData<EmployeeDto> filter(int page, int pageSize, String searchTerm);
    List<EmployeeDto> getManagers(Long departmentId);
}
