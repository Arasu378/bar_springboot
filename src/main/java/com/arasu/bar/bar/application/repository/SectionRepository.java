package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SectionRepository extends PagingAndSortingRepository<Section,Long> {
    Page findSectionsByUserProfileId(Long userProfileId, Pageable pageable);
    Page findSectionsByBarId(Long barId, Pageable pageable);

}
