package com.hbt.gd.reposity;

import com.hbt.gd.entity.CoreUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoreUserRepository extends PagingAndSortingRepository<CoreUser, Long>, CoreUserRepositoryCustom {
} 
