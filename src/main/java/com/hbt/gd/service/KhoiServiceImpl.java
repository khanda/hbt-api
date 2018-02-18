package com.hbt.gd.service;

import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.entity.Khoi;
import com.hbt.gd.mapper.KhoiMapper;
import com.hbt.gd.reposity.KhoiRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.hbt.gd.mapper.KhoiMapper.toListDto;

@Service
public class KhoiServiceImpl implements KhoiService {
    @Autowired
    KhoiRepository khoiRepository;
    private final static Logger logger = Logger.getLogger(KhoiServiceImpl.class);

    @Override
    public KhoiDto save(Khoi khoi) {
        try {
            Khoi savedKhoi = khoiRepository.save(khoi);
            return KhoiMapper.toDto(savedKhoi);
        } catch (Exception e) {
            logger.error("KhoiServiceImpl: save", e);
        }
        return new KhoiDto();
    }

    @Override
    public List<KhoiDto> getList() {
        List<Khoi> khois = khoiRepository.getList();
        return toListDto(khois);
    }

}