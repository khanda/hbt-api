package com.hbt.gd.reposity;

import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.mapper.EmployeeMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by quyen on 05/02/2018.
 */
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EmployeeDto> getManagers(Long departmentId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT e FROM Employee e WHERE e.status = 1 AND e.departmentId = :departmentId AND e.isLeader = 1 ORDER BY id ");
        TypedQuery<Employee> typedQuery = entityManager.createQuery(stringBuilder.toString(), Employee.class);
        typedQuery.setParameter("departmentId", departmentId);
        List<Employee> employees = typedQuery.getResultList();
        List<EmployeeDto> employeeDtos = EmployeeMapper.toListDto(employees);
        return employeeDtos;
    }
}
