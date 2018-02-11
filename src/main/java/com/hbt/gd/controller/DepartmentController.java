package com.hbt.gd.controller;

import com.hbt.gd.dto.DepartmentDto;
import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Department;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;
import com.hbt.gd.helper.PagingParameter;
import com.hbt.gd.service.DepartmentService;
import com.hbt.gd.service.EmployeeService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quyen on 05/02/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/department", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
public class DepartmentController {
    private final static Logger logger = Logger.getLogger(DepartmentController.class);
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/getList")
    public @ResponseBody
    List<DepartmentDto> getListDepartment() {
        List<Department> departmentList = departmentService.getList();
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Department department : departmentList) {
            departmentDtos.add(modelMapper.map(department, DepartmentDto.class));
        }
        return departmentDtos;
    }
} 
