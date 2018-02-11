package com.hbt.gd.controller;

import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;
import com.hbt.gd.helper.PagingParameter;
import com.hbt.gd.service.EmployeeService;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quyen on 05/02/2018.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/employee",
        produces = {
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_FORM_URLENCODED_VALUE})
public class EmployeeController {
    private final static Logger logger = Logger.getLogger(EmployeeController.class);
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/getList")
    public @ResponseBody
    PagingData<EmployeeDto> getListEmployee(@RequestBody PagingParameter pagingParameter) {
        Integer page = pagingParameter.getPage();
        Integer pageSize = pagingParameter.getPageSize();
        Page<Employee> employeePage = employeeService.getList(page, pageSize);
        List<Employee> employeeList = employeePage.getContent();

        PagingData<EmployeeDto> pagingData = new PagingData<>();
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        for (Employee employee : employeeList) {
            if (null != employee && null != employee.getAccount())
                employee.getAccount().setPassword("");
            employeeDtos.add(modelMapper.map(employee, EmployeeDto.class));

        }
        pagingData.setData(employeeDtos);
        pagingData.setPage(page);
        pagingData.setPageSize(pageSize);
        pagingData.setTotal(employeePage.getTotalElements());
        pagingData.setTotalPages(employeePage.getTotalPages());
        return pagingData;
    }

    @PostMapping("/save")
    public @ResponseBody
    boolean saveEmployee(@RequestBody EmployeeDto employeeDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        return employeeService.save(employee);
    }

    @PostMapping("/delete")
    public @ResponseBody
    boolean deleteEmployee(@RequestBody Long id) {
        return employeeService.delete(id);
    }

} 
