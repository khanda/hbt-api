package com.hbt.gd.service;

import com.hbt.gd.entity.Employee;
import com.hbt.gd.reposity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**leader
 * Created by quyen on 05/02/2018.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getListEmployee(int page, int pageSize) {
        //page start at 0
        int pageIndex = page - 1;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }
}
