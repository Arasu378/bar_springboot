package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.Liquor;
import com.arasu.bar.bar.application.model.LiquorCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface LiquorRepository extends PagingAndSortingRepository <Liquor, Integer> {
    @Query(value = "SELECT *  FROM liquor_list WHERE  `alcohol_type` = :alcohol_type", nativeQuery = true)
    Page<Liquor> findAllByAlcohol_type( @Param("alcohol_type") String alcohol_type, Pageable pageable);
    Page findAllBy(Pageable pageable);
    @Query(value = "SELECT  DISTINCT `alcohol_type`, `Category_Id` FROM liquor_list", nativeQuery = true)
    List<Object[]> findAllByCategory();

   // Page findAllByAlcohol_type(String alcohol_type, Pageable pageable);

}
