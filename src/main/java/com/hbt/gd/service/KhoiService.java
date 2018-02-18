package com.hbt.gd.service;

import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.entity.Khoi;

import java.util.List;

public interface KhoiService {
    KhoiDto save(Khoi khoi);

    List<KhoiDto> getList();

}
