package com.hbt.gd;

import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.service.EmployeeService;
import com.hbt.gd.service.KhoiService;
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
    @Autowired
    KhoiService khoiService;

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
        employeeService.filter(1, 10, "H");
        return;
    }

    @Test
    public void getManagers() {
        List<EmployeeDto> l = employeeService.getManagers(1l);
        return;
    }
    @Test
    public void getKhois() {
        List<KhoiDto> khois = khoiService.getList();
        return;
    }

    @Test
    public void isLeaderAssigned() {
        List<KhoiDto> khois = khoiService.getList();
        return;
    }

}
