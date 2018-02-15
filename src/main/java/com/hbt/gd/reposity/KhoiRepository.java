package com.hbt.gd.reposity;

import com.hbt.gd.entity.Khoi;
import org.springframework.data.repository.CrudRepository;

public interface KhoiRepository extends CrudRepository<Khoi, Long>, KhoiRepositoryCustom {
} 
