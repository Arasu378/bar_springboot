package com.arasu.bar.bar.application.repository;

import com.arasu.bar.bar.application.entities.UserLiquor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserLiquorRepository extends PagingAndSortingRepository<UserLiquor,Long> {
    Page findUserLiquorsByUserProfileId(Long userProfileId, Pageable pageable);
    Page findUserLiquorsByBarId(Long barId, Pageable pageable);
    Page findUserLiquorsBySectionId(Long sectionId, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `bar`.`user_liquor`" +
            " (`UserProfileId`, `BarId`, `SectionId`, `LiquorName`, `LiquorCapacity`, `Shots`, `Category`, `SubCategory`," +
            " `ParLevel`, `DistributorName`, `PriceUnit`, `BinNumber`, `ProductCode`, `CreatedOn`, `MinValue`, `MaxValue`," +
            " `Type`, `FullWeight`, `EmptyWeight`, `TotalBottles`, `PictureId`) " +
            "VALUES" +
            " (:UserProfileId, :BarId, :SectionId, :LiquorName, :LiquorCapacity, :Shots, :Category, :SubCategory," +
            " :ParLevel, :DistributorName, :PriceUnit, :BinNumber, :ProductCode, :CreatedOn, :MinValue, :MaxValue," +
            " :Type, :FullWeight, :EmptyWeight, :TotalBottles, :PictureId)", nativeQuery = true)
    Integer insertUserLiquorQuery(@Param("UserProfileId")Long UserProfileId,
                                     @Param("BarId") Long BarId,
                                     @Param("SectionId") Long SectionId,
                                     @Param("LiquorName") String LiquorName,
                                     @Param("LiquorCapacity") String LiquorCapacity,
                                     @Param("Shots") String Shots,
                                     @Param("Category") String Category,
                                     @Param("SubCategory") String SubCategory,
                                     @Param("ParLevel") String ParLevel,
                                     @Param("DistributorName") String DistributorName,
                                     @Param("PriceUnit") String PriceUnit,
                                     @Param("BinNumber") String BinNumber,
                                     @Param("ProductCode") String ProductCode,
                                     @Param("CreatedOn") String CreatedOn,
                                     @Param("MinValue") Double MinValue,
                                     @Param("MaxValue") Double MaxValue,
                                     @Param("Type") String Type,
                                     @Param("FullWeight") String FullWeight,
                                     @Param("EmptyWeight") String EmptyWeight,
                                     @Param("TotalBottles") String TotalBottles,
                                     @Param("PictureId") Long PictureId
                                     );

     @Transactional
    @Modifying
    @Query(value = "UPDATE `bar`.`user_liquor` SET" +
            " `UserProfileId` = :UserProfileId, `BarId` = :BarId, `SectionId` = :SectionId, `LiquorName` = :LiquorName, `LiquorCapacity` = :LiquorCapacity" +
            ", `Shots` = :Shots, `Category` = :Category, `SubCategory` = :SubCategory," +
            " `ParLevel` = :ParLevel, `DistributorName` = :DistributorName, `PriceUnit` = :PriceUnit, `BinNumber` = :BinNumber, `ProductCode` = :ProductCode," +
            " `ModifiedOn` = :ModifiedOn, `MinValue` = :MinValue, `MaxValue` = :MaxValue," +
            " `Type` = :Type, `FullWeight` = :FullWeight, `EmptyWeight` = :EmptyWeight, `TotalBottles` = :TotalBottles, `PictureId` = :PictureId " +
            "WHERE `Id` = :Id", nativeQuery = true)
    Integer updateUserLiquorQuery(@Param("UserProfileId")Long UserProfileId,
                                     @Param("BarId") Long BarId,
                                     @Param("SectionId") Long SectionId,
                                     @Param("LiquorName") String LiquorName,
                                     @Param("LiquorCapacity") String LiquorCapacity,
                                     @Param("Shots") String Shots,
                                     @Param("Category") String Category,
                                     @Param("SubCategory") String SubCategory,
                                     @Param("ParLevel") String ParLevel,
                                     @Param("DistributorName") String DistributorName,
                                     @Param("PriceUnit") String PriceUnit,
                                     @Param("BinNumber") String BinNumber,
                                     @Param("ProductCode") String ProductCode,
                                     @Param("ModifiedOn") String ModifiedOn,
                                     @Param("MinValue") Double MinValue,
                                     @Param("MaxValue") Double MaxValue,
                                     @Param("Type") String Type,
                                     @Param("FullWeight") String FullWeight,
                                     @Param("EmptyWeight") String EmptyWeight,
                                     @Param("TotalBottles") String TotalBottles,
                                     @Param("PictureId") Long PictureId,
                                     @Param("Id") Long Id
                                     );

}
