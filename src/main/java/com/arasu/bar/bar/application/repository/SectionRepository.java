package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SectionRepository extends PagingAndSortingRepository<Section,Long> {
    Page findSectionsByUserProfileId(Long userProfileId, Pageable pageable);
    Page findSectionsByBarId(Long barId, Pageable pageable);
    @Transactional
    @Modifying
    void deleteSectionsByBarId(Long BarId);

}
