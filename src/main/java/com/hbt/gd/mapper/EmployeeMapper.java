package com.hbt.gd.mapper;

import com.hbt.gd.controller.EmployeeController;
import com.hbt.gd.dto.EmployeeDto;
import com.hbt.gd.entity.Employee;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    private final static Logger logger = Logger.getLogger(EmployeeController.class);
    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public EmployeeMapper() {

    }

    public static Employee toEntity(EmployeeDto dto) {
        return modelMapper.map(dto, Employee.class);
    }

    public static EmployeeDto toDto(Employee bo) {
        return modelMapper.map(bo, EmployeeDto.class);
    }

    public static List<Employee> toListEntity(List<EmployeeDto> listDto) {
        if (null != listDto && !listDto.isEmpty()) {
            try {
                List<Employee> listEntity = new ArrayList<>();
                for (int i = 0; i < listEntity.size(); i++) {
                    listEntity.add(toEntity(listDto.get(i)));
                }
                return listEntity;
            } catch (Exception e) {
                logger.error("EmployeeMapper:toListBo", e);
            }
        }
        return new ArrayList<>();
    }

    public static List<EmployeeDto> toListDto(List<Employee> listEntity) {
        if (null != listEntity && !listEntity.isEmpty()) {
            try {
                List<EmployeeDto> listDto = new ArrayList<>();
                for (int i = 0; i < listEntity.size(); i++) {
                    listDto.add(toDto(listEntity.get(i)));
                }
                return listDto;
            } catch (Exception e) {
                logger.error("EmployeeMapper:toListDto", e);
            }
        }
        return new ArrayList<>();
    }
}
