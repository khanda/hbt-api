package com.hbt.gd.service;

import com.hbt.gd.entity.Department;
import com.hbt.gd.reposity.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by quyen on 05/02/2018.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getList() {
       return departmentRepository.findAll();
    }
}
