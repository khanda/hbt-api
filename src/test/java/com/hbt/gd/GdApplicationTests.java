package com.hbt.gd;

import com.hbt.gd.controller.EmployeeController;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;
import com.hbt.gd.helper.PagingParameter;
import com.hbt.gd.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    }
}
