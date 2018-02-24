package com.hbt.gd.specification;

import com.hbt.gd.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSpecificationsBuilder {
    private final List<SearchCriteria> params;

    public EmployeeSpecificationsBuilder() {
        params = new ArrayList<>();
    }

    public EmployeeSpecificationsBuilder(boolean status) {
        params = new ArrayList<>();
        SearchCriteria searchCriteriaStatus = new SearchCriteria("status", ":", 1);
        params.add(searchCriteriaStatus);
    }

    public EmployeeSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Employee> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<Employee>> specs = new ArrayList<>();

        for (SearchCriteria param : params) {
            specs.add(new EmployeeSpecification(param));
        }

        Specification<Employee> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }

    public Specification<Employee> build(boolean status) {
        List<Specification<Employee>> specs = new ArrayList<>();
        for (SearchCriteria param : params) {
            specs.add(new EmployeeSpecification(param));
        }
        Specification<Employee> result = null;
        if (specs.size() > 2) {
            result = specs.get(1);
            for (int i = 2; i < specs.size() - 1; i++) {
                result = Specifications.where(result).or(specs.get(i));
            }
        }
        result = Specifications.where(result).and(specs.get(0));
        return result;
    }
}
