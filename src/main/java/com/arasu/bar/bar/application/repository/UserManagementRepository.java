package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.UserManagement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserManagementRepository extends PagingAndSortingRepository<UserManagement,Long> {
    Page findAllByUserProfileId(Long userProfileId, Pageable pageable);

}
