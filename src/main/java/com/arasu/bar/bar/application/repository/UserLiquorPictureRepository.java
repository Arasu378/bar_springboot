package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.UserLiquorPicture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserLiquorPictureRepository extends PagingAndSortingRepository<UserLiquorPicture, Long> {
    Page findUserLiquorPicturesByUserProfileId(Long userProfileId, Pageable pageable);

}
