package com.hbt.gd.reposity;

import com.hbt.gd.entity.Khoi;

import java.util.List;

public interface KhoiRepositoryCustom {
    List<Khoi> getList();

    boolean isLeaderAssigned(Long id);

}
