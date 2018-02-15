package com.hbt.gd.mapper;

import com.hbt.gd.dto.KhoiDto;
import com.hbt.gd.entity.Khoi;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public class KhoiMapper {
    private static ModelMapper modelMapper = new ModelMapper();
    private final static Logger logger = Logger.getLogger(KhoiMapper.class);
    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public KhoiMapper() {

    }

    public static Khoi toEntity(KhoiDto dto) {
        return modelMapper.map(dto, Khoi.class);
    }

    public static KhoiDto toDto(Khoi bo) {
        return modelMapper.map(bo, KhoiDto.class);
    }

    public static List<Khoi> toListEntity(List<KhoiDto> listDto) {
        if (null != listDto && !listDto.isEmpty()) {
            try {
                List<Khoi> listEntity = new ArrayList<>();
                for (int i = 0; i < listEntity.size(); i++) {
                    listEntity.add(toEntity(listDto.get(i)));
                }
                return listEntity;
            } catch (Exception e) {
                logger.error("KhoiMapper:toListBo", e);
            }
        }
        return new ArrayList<>();
    }

    public static List<KhoiDto> toListDto(List<Khoi> listEntity) {
        if (null != listEntity && !listEntity.isEmpty()) {
            try {
                List<KhoiDto> listDto = new ArrayList<>();
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
