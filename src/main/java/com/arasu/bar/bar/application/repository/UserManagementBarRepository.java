package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.UserManagementBar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserManagementBarRepository extends PagingAndSortingRepository<UserManagementBar, Long> {
    Page findAllByUserProfileId(Long userProfileId, Pageable pageable);
    Page findAllByUserManagementId(Long userManagementId, Pageable pageable);
    Page findAllByParentUserProfileId(Long parentUserProfileId, Pageable pageable);

}
