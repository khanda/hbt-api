package com.hbt.gd.reposity;

import com.hbt.gd.entity.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Created by quyen on 05/02/2018.
 */
public interface EmployeeRepository extends
        PagingAndSortingRepository<Employee, Long>,
        EmployeeRepositoryCustom,
        JpaSpecificationExecutor<Employee> {
    @Query("SELECT max(e.code) FROM Employee e")
    Optional<Long> getMaxEmployeeCode();
}
