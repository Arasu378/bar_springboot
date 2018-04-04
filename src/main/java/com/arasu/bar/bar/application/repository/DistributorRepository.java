package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DistributorRepository extends PagingAndSortingRepository<Distributor, Long> {
    @Query(value = "SELECT *  FROM distributor WHERE  `UserProfileId` = :UserProfileId", nativeQuery = true)
    Page<Distributor> findAllDistributors(@Param("UserProfileId") Long UserProfileId, Pageable pageable);

}
