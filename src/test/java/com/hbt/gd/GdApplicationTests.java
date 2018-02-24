package com.hbt.gd;

import com.hbt.gd.constant.MyConstant;
import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;
import com.hbt.gd.reposity.EmployeeRepository;
import com.hbt.gd.service.EmployeeService;
import com.hbt.gd.service.KhoiService;
import com.hbt.gd.specification.EmployeeSpecification;
import com.hbt.gd.specification.EmployeeSpecificationsBuilder;
import com.hbt.gd.specification.SearchCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GdApplicationTests {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    KhoiService khoiService;
    @Autowired
    EmployeeRepository employeeRepository;

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

    @Test
    public void givenLast_whenGettingListOfUsers_thenCorrect() {
        EmployeeSpecification spec = new EmployeeSpecification(
                new SearchCriteria("firstName", ":", "L"));
        List<Employee> results = employeeRepository.findAll(spec);
        return;
    }

    @Test
    public void givenLastAndAge_whenGettingListOfUsers_thenCorrect() {
        EmployeeSpecification spec1 =
                new EmployeeSpecification(new SearchCriteria("lastName", ":", "L"));
        EmployeeSpecification spec2 =
                new EmployeeSpecification(new SearchCriteria("firstName", ":", "L"));
        EmployeeSpecification spec3 =
                new EmployeeSpecification(new SearchCriteria("midName", ":", "L"));
        List<Employee> results =
                employeeRepository.findAll(Specifications.where(spec1).or(spec2).or(spec3));

        return;
    }

    @Test
    public void multiSpecicification() {
        String search = "firstName:l,lastName:l,midName:L";

        EmployeeSpecificationsBuilder builder = new EmployeeSpecificationsBuilder();
        Pattern pattern = Pattern.compile(MyConstant.searchPatern);
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }

        Specification<Employee> spec = builder.build();

        int pageIndex = 0;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "id"));
        Pageable pageable = new PageRequest(pageIndex, 10, sort);

        Page<Employee> page = employeeRepository.findAll(spec, pageable);
        return;
    }

    @Test
    public void testFilter() {
        String search = "firstName:loc,lastName:loc,midName:loc";
        PagingData<EmployeeDto> employeePagingData = employeeService.filter(0, 10, search);
        return;
    }
}
