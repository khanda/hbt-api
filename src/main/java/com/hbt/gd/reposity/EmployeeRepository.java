package com.hbt.gd.reposity;

import com.hbt.gd.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by quyen on 05/02/2018.
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>, EmployeeRepositoryCustom {
}
