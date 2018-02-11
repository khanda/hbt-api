package com.hbt.gd.service;

import com.hbt.gd.entity.Employee;
import org.springframework.data.domain.Page;

/**
 * Created by quyen on 05/02/2018.
 */
public interface EmployeeService {
    Page<Employee> getList(int page, int pageSize);
    boolean save(Employee employee );
}
