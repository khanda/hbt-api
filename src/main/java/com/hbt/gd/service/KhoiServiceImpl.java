package com.hbt.gd.service;

import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.entity.Employee;
import com.hbt.gd.entity.Khoi;
import com.hbt.gd.exception.ErrorEnum;
import com.hbt.gd.exception.HBTException;
import com.hbt.gd.mapper.KhoiMapper;
import com.hbt.gd.reposity.EmployeeRepository;
import com.hbt.gd.reposity.KhoiRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hbt.gd.mapper.KhoiMapper.toListDto;

@Service
public class KhoiServiceImpl implements KhoiService {
    @Autowired
    KhoiRepository khoiRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    private final static Logger logger = Logger.getLogger(KhoiServiceImpl.class);

    @Override
    public KhoiDto save(Khoi khoi) throws HBTException {

        boolean validLeader = !isLeaderAssigned(khoi);
        if (!validLeader) {
            throw new HBTException(HttpStatus.CONFLICT, ErrorEnum.DUPLICATED);
        }
        Khoi savedKhoi = khoiRepository.save(khoi);
        Employee employee = employeeRepository.findOne(savedKhoi.getLeaderId());
        savedKhoi.setLeader(employee);
        return KhoiMapper.toDto(savedKhoi);
    }

    private boolean isLeaderAssigned(Khoi khoi) {
        return khoiRepository.isLeaderAssigned(khoi.getLeaderId());
    }

    @Override
    public List<KhoiDto> getList() {
        List<Khoi> khois = khoiRepository.getList();
        return toListDto(khois);
    }

}