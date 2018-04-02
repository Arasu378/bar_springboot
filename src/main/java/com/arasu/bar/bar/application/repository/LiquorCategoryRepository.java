package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.LiquorCategory;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LiquorCategoryRepository extends PagingAndSortingRepository<LiquorCategory, Long> {
}
