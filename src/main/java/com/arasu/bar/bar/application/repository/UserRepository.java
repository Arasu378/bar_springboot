package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findUserById(Long id);
    Page findAll(Pageable pageable);
    User findUserByUserEmailAndPassword(String userEmail, String password);
    @Query(value = "SELECT * FROM userprofile  where UserEmail = :UserEmail and Password = :Password", nativeQuery = true)
    User login(@Param("UserEmail")String UserEmail, @Param("Password")String Password);
    User findUserByUserEmail(String userEmail);
//    User findByUserEmail(String username);
    @Query(value = "SELECT * FROM userprofile  where UserEmail = :UserEmail", nativeQuery = true)
    User findByUserEmail(@Param("UserEmail") String UserEmail);
    @Transactional
    @Modifying
    @Query(value = "UPDATE `bar`.`userprofile` SET `Password`= :Password WHERE `UserEmail`= :UserEmail", nativeQuery = true)
    void forgetPassword(@Param("UserEmail") String UserEmail, @Param("Password")String Password);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `bar`.`userprofile` SET `Password`= :Password WHERE `Id`= :Id", nativeQuery = true)
    void updatePassword(@Param("Password") String Password, @Param("Id") Long Id);


}
