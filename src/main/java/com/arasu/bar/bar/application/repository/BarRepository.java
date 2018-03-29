package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.Bar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BarRepository extends PagingAndSortingRepository<Bar, Long> {
    Bar findBarById(Long barId);
    Page findBarsByUserProfileId(Long userProfileId, Pageable pageable);

}
