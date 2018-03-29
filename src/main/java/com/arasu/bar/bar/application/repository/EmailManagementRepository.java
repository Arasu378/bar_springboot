package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmailManagementRepository extends PagingAndSortingRepository<Email, Long> {
    Page findEmailsByUserProfileId(Long userProfileId, Pageable pageable);
}
