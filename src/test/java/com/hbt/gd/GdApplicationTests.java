package com.hbt.gd;

import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;
import com.hbt.gd.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GdApplicationTests {
    @Autowired
    EmployeeService employeeService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getListEmployee() {
        Page<Employee> employeePage = employeeService.getList(0, 10);
        return;
    }

    @Test
    public void filterEmployee() {
        employeeService.filter(0, 5, new Employee());
        return;
    }

    @Test
    public void getManagers() {
        List<EmployeeDto> l = employeeService.getManagers(1l);
        return;
    }
}
