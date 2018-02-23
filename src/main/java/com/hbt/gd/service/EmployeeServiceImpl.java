package com.hbt.gd.service;

import com.hbt.gd.controller.CoreUserController;
import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;
import com.hbt.gd.reposity.EmployeeRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * leader
 * Created by quyen on 05/02/2018.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    private final static Logger logger = Logger.getLogger(CoreUserController.class);

    @Override
    public Page<Employee> getList(int page, int pageSize) {
        //page start at 0
        int pageIndex = page - 1;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = new PageRequest(pageIndex, pageSize, sort);

        return employeeRepository.findAll(pageable);
    }

    @Override
    public boolean save(Employee employee) {
        employee.setStatus(1);
        employee.setId(0l);
        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            logger.error("EmployeeServiceImpl: save().", e);
            return false;
        }
        logger.info("EmployeeServiceImpl: save()." + employee.toString());
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Employee employee = employeeRepository.findOne(id);
        if (employee == null)
            return false;
        try {
            employee.setStatus(0);
            employeeRepository.save(employee);
            return true;
        } catch (Exception e) {
            logger.error("Delete: ", e);
            return false;
        }
    }

    @Override
    public PagingData<EmployeeDto> filter(int page, int pageSize, String searchTerm) {
        return employeeRepository.filterEmployees(page, pageSize, searchTerm);
    }

    @Override
    public List<EmployeeDto> getManagers(Long departmentId) {
        return employeeRepository.getManagers(departmentId);
    }
}
