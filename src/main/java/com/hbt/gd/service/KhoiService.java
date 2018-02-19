package com.hbt.gd.service;

import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.entity.Khoi;
import com.hbt.gd.exception.HBTException;

import java.util.List;

public interface KhoiService {
    KhoiDto save(Khoi khoi) throws HBTException;
    boolean deleteLeader(Khoi khoi) throws HBTException;

    List<KhoiDto> getList();

}
