package com.hbt.gd.reposity;

import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.helper.PagingData;
import com.hbt.gd.mapper.EmployeeMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by quyen on 05/02/2018.
 */
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PagingData<EmployeeDto> filterEmployees(int page, int pageSize, Employee employee) {
        PagingData<EmployeeDto> pagingData = new PagingData<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT e FROM Employee e WHERE status = 1 ORDER BY id ");
        TypedQuery<Employee> typedQuery = entityManager.createQuery(stringBuilder.toString(), Employee.class);
        typedQuery.setFirstResult(page);
        typedQuery.setMaxResults(pageSize);
        List<Employee> employees = typedQuery.getResultList();
        //count
        stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT count(e.id) FROM Employee e WHERE status = 1 ORDER BY id ");
        Query countQuery = entityManager.createQuery(stringBuilder.toString());
        long count = (long) countQuery.getSingleResult();

        pagingData.setData(EmployeeMapper.toListDto(employees));
        pagingData.setTotal(count);
        pagingData.setPage(page);
        pagingData.setPageSize(pageSize);
        int pageNumber = (int) ((count / pageSize) + 1);
        pagingData.setTotalPages(pageNumber);

        return pagingData;
    }

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
