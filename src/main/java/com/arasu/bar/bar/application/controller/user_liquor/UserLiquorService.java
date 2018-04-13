package com.arasu.bar.bar.application.controller.user_liquor;

import com.arasu.bar.bar.application.entities.Distributor;
import com.arasu.bar.bar.application.entities.UserLiquor;
import com.arasu.bar.bar.application.entities.UserLiquorPicture;
import com.arasu.bar.bar.application.model.Distributors;
import com.arasu.bar.bar.application.model.LiquorCategory;
import com.arasu.bar.bar.application.model.UserLiquorInput;
import com.arasu.bar.bar.application.repository.UserLiquorPictureRepository;
import com.arasu.bar.bar.application.repository.UserLiquorRepository;
import com.arasu.bar.bar.application.exception.ResourceNotFoundException;
import com.arasu.bar.bar.responses.DistributorResponse;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.UserLiquorPictureResponse;
import com.arasu.bar.bar.responses.UserLiquorResponse;
import com.arasu.bar.bar.utils.Constants;
import com.arasu.bar.bar.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserLiquorService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserLiquorRepository userLiquorRepository;

    @Autowired
    private UserLiquorPictureRepository pictureRepository;



    public Page<UserLiquor> getLiquorsByUserProfileId(Integer page, Integer size, Long userProfileId) {
        return userLiquorRepository.findUserLiquorsByUserProfileId(userProfileId, PageRequest.of(page,size));
    }
    public Page<UserLiquor> getLiquorByBarId(Integer page, Integer size, Long barId) {
        return userLiquorRepository.findUserLiquorsByBarId(barId, PageRequest.of(page,size));
    }
    public Page<UserLiquor> getLiquorBySectionId(Integer page, Integer size, Long sectionId) {
        return userLiquorRepository.findUserLiquorsBySectionId(sectionId, PageRequest.of(page,size));
    }
    public UserLiquorResponse getUserLiquorById(Long userLiquorId) {
        UserLiquor userLiquor = userLiquorRepository.findById(userLiquorId).orElseThrow(() -> new ResourceNotFoundException("UserLiquorId: "+ userLiquorId));
        return new UserLiquorResponse(true, "success", userLiquor);
    }
    public UserLiquorResponse insertUserLiquor(UserLiquorInput userLiquorInput) {
//        UserLiquor userLiquor = new UserLiquor();
//        userLiquor.setUserProfileId(userLiquorInput.getUserProfileId());
//        userLiquor.setBarId(userLiquorInput.getBarId());
//        userLiquor.setSectionId(userLiquorInput.getSectionId());
//        userLiquor.setLiquorName(userLiquorInput.getLiquorName());
//        userLiquor.setLiquorCapacity(userLiquorInput.getLiquorCapacity());
//        userLiquor.setShots(userLiquorInput.getShots());
//        userLiquor.setCategory(userLiquorInput.getCategory());
//        userLiquor.setSubCategory(userLiquorInput.getSubCategory());
//        userLiquor.setParLevel(userLiquorInput.getParLevel());
//        userLiquor.setDistributorName(userLiquorInput.getDistributorName());
//        userLiquor.setPriceUnit(userLiquorInput.getPriceUnit());
//        userLiquor.setBinNumber(userLiquorInput.getBinNumber());
//        userLiquor.setProductCode(userLiquorInput.getProductCode());
//        userLiquor.setCreatedOn(Utils.getCurrentDate());
//        userLiquor.setType(userLiquorInput.getType());
//        userLiquor.setFullWeight(userLiquorInput.getFullWeight());
//        userLiquor.setEmptyWeight(userLiquorInput.getEmptyWeight());
//        userLiquor.setTotalBottles(userLiquorInput.getTotalBottles());
//        userLiquor.setPictureId(userLiquorInput.getPictureId());


       // UserLiquor userLiquorInsert = userLiquorRepository.save(userLiquor);

        Integer userLiquorInsert = userLiquorRepository.insertUserLiquorQuery(userLiquorInput.getUserProfileId(),userLiquorInput.getBarId(),
                userLiquorInput.getSectionId(), userLiquorInput.getLiquorName(), userLiquorInput.getLiquorCapacity(), userLiquorInput.getShots(),
                userLiquorInput.getCategory(), userLiquorInput.getSubCategory(), userLiquorInput.getParLevel(), userLiquorInput.getDistributorName(),
                userLiquorInput.getPriceUnit(), userLiquorInput.getBinNumber(), userLiquorInput.getProductCode(), Utils.getCurrentDate(),
                userLiquorInput.getMinValue(), userLiquorInput.getMaxValue(), userLiquorInput.getType(), userLiquorInput.getFullWeight(),
                userLiquorInput.getEmptyWeight(), userLiquorInput.getTotalBottles(),userLiquorInput.getPictureId(),userLiquorInput.getDistributorId());
        if (userLiquorInsert == 0) {
            return new UserLiquorResponse(false, "user liquor is not inserted!", null);
        }
        return new UserLiquorResponse(true, "Added Successfully", null);

    }

    public UserLiquorResponse insertUserLiquorWithPictureURL(UserLiquorInput userLiquorInput) throws Exception {

        Long isPictureInserted = insertUserLiquorWithPicture(userLiquorInput.getLiquorName(), userLiquorInput.getUserProfileId(), userLiquorInput.pictureURL);
        if (isPictureInserted == 0L) {
            return new UserLiquorResponse(false, "user liquor picture is not inserted!", null);
        }
        Integer userLiquorInsert = userLiquorRepository.insertUserLiquorQuery(userLiquorInput.getUserProfileId(),userLiquorInput.getBarId(),
                userLiquorInput.getSectionId(), userLiquorInput.getLiquorName(), userLiquorInput.getLiquorCapacity(), userLiquorInput.getShots(),
                userLiquorInput.getCategory(), userLiquorInput.getSubCategory(), userLiquorInput.getParLevel(), userLiquorInput.getDistributorName(),
                userLiquorInput.getPriceUnit(), userLiquorInput.getBinNumber(), userLiquorInput.getProductCode(), Utils.getCurrentDate(),
                userLiquorInput.getMinValue(), userLiquorInput.getMaxValue(), userLiquorInput.getType(), userLiquorInput.getFullWeight(),
                userLiquorInput.getEmptyWeight(), userLiquorInput.getTotalBottles(),isPictureInserted, userLiquorInput.getDistributorId());
        if (userLiquorInsert == 0) {
            return new UserLiquorResponse(false, "user liquor is not inserted!", null);
        }
        return new UserLiquorResponse(true, "Added Successfully", null);
    }
    public UserLiquorResponse updateUserLiquorPicture(UserLiquorInput userLiquorInput, Long userLiquorId) throws Exception {
        UserLiquor userLiquor = this.userLiquorRepository.findById(userLiquorId).orElseThrow(() -> new ResourceNotFoundException("UserLiquorId: "+ userLiquorId));
        UserLiquorPicture userLiquorPicture = this.pictureRepository.findById(userLiquor.getPictureId()).orElseThrow(() -> new ResourceNotFoundException("PictureId : " + userLiquor.getPictureId()));
       Long isPictureUpdated =  updateUserLiquorWithPicture(userLiquorInput.getLiquorName(), userLiquorInput.getUserProfileId(), userLiquorInput.pictureURL, userLiquorInput.getPictureId());
       if (isPictureUpdated == 0L) {
           return  new UserLiquorResponse(false, "Liquor picture is not updated!", null);
       }
        Integer userLiquorInsert = userLiquorRepository.updateUserLiquorQuery(userLiquorInput.getUserProfileId(),userLiquorInput.getBarId(),
                userLiquorInput.getSectionId(), userLiquorInput.getLiquorName(), userLiquorInput.getLiquorCapacity(), userLiquorInput.getShots(),
                userLiquorInput.getCategory(), userLiquorInput.getSubCategory(), userLiquorInput.getParLevel(), userLiquorInput.getDistributorName(),
                userLiquorInput.getPriceUnit(), userLiquorInput.getBinNumber(), userLiquorInput.getProductCode(), Utils.getCurrentDate(),
                userLiquorInput.getMinValue(), userLiquorInput.getMaxValue(), userLiquorInput.getType(), userLiquorInput.getFullWeight(),
                userLiquorInput.getEmptyWeight(), userLiquorInput.getTotalBottles(),isPictureUpdated, userLiquorId, userLiquorInput.getDistributorId());
        if (userLiquorInsert == 0) {
            return new UserLiquorResponse(false, "user liquor is not updated!", null);
        }
        return new UserLiquorResponse(true, "Updated Successfully", null);
    }
    public Long insertUserLiquorWithPicture(String pictureName, Long userProfileId, String pictureURL) throws Exception{
        UserLiquorPicture inputField = new UserLiquorPicture();
        inputField.setPictureName(pictureName);
        inputField.setCreatedOn(Utils.getCurrentDate());
        inputField.setUserProfileId(userProfileId);
        inputField.setData(Utils.recoverImageFromUrl(pictureURL));
        UserLiquorPicture userLiquorPicture = pictureRepository.save(inputField);
        if (userLiquorPicture == null) {
            return 0L;
        }
        return userLiquorPicture.getId();
    }

    public Long updateUserLiquorWithPicture(String pictureName, Long userProfileId, String pictureURL, Long pictureId) throws Exception {
        UserLiquorPicture userLiquorPicture = pictureRepository.findById(pictureId).orElseThrow(() -> new ResourceNotFoundException("PictureId : "+ pictureId));
        userLiquorPicture.setData(Utils.recoverImageFromUrl(pictureURL));
        userLiquorPicture.setPictureName(pictureName);
        userLiquorPicture.setUserProfileId(userProfileId);
        userLiquorPicture.setModifiedOn(Utils.getCurrentDate());
        UserLiquorPicture updatedPicture = pictureRepository.save(userLiquorPicture);
        if (updatedPicture == null) {
            return 0L;
        }
        return updatedPicture.getId();
    }
    public UserLiquorResponse updateUserLiquor(UserLiquorInput userLiquorInput, Long userLiquorId) {
        UserLiquor userLiquor = this.userLiquorRepository.findById(userLiquorId).orElseThrow(() -> new ResourceNotFoundException("UserLiquorId: "+ userLiquorId));

//        userLiquor.setUserProfileId(userLiquorInput.getUserProfileId());
//        userLiquor.setBarId(userLiquorInput.getBarId());
//        userLiquor.setSectionId(userLiquorInput.getSectionId());
//        userLiquor.setLiquorName(userLiquorInput.getLiquorName());
//        userLiquor.setLiquorCapacity(userLiquorInput.getLiquorCapacity());
//        userLiquor.setShots(userLiquorInput.getShots());
//        userLiquor.setCategory(userLiquorInput.getCategory());
//        userLiquor.setSubCategory(userLiquorInput.getSubCategory());
//        userLiquor.setParLevel(userLiquorInput.getParLevel());
//        userLiquor.setDistributorName(userLiquorInput.getDistributorName());
//        userLiquor.setPriceUnit(userLiquorInput.getPriceUnit());
//        userLiquor.setBinNumber(userLiquorInput.getBinNumber());
//        userLiquor.setProductCode(userLiquorInput.getProductCode());
//        userLiquor.setModifiedOn(Utils.getCurrentDate());
//        userLiquor.setType(userLiquorInput.getType());
//        userLiquor.setFullWeight(userLiquorInput.getFullWeight());
//        userLiquor.setEmptyWeight(userLiquorInput.getEmptyWeight());
//        userLiquor.setTotalBottles(userLiquorInput.getTotalBottles());
//        userLiquor.setPictureId(userLiquorInput.getPictureId());

        Integer userLiquorInsert = userLiquorRepository.updateUserLiquorQuery(userLiquorInput.getUserProfileId(),userLiquorInput.getBarId(),
                userLiquorInput.getSectionId(), userLiquorInput.getLiquorName(), userLiquorInput.getLiquorCapacity(), userLiquorInput.getShots(),
                userLiquorInput.getCategory(), userLiquorInput.getSubCategory(), userLiquorInput.getParLevel(), userLiquorInput.getDistributorName(),
                userLiquorInput.getPriceUnit(), userLiquorInput.getBinNumber(), userLiquorInput.getProductCode(), Utils.getCurrentDate(),
                userLiquorInput.getMinValue(), userLiquorInput.getMaxValue(), userLiquorInput.getType(), userLiquorInput.getFullWeight(),
                userLiquorInput.getEmptyWeight(), userLiquorInput.getTotalBottles(),userLiquorInput.getPictureId(), userLiquorId, userLiquorInput.getDistributorId());
        if (userLiquorInsert == 0) {
            return new UserLiquorResponse(false, "user liquor is not updated!", null);
        }
        return new UserLiquorResponse(true, "Updated Successfully", null);


//        UserLiquor userLiquorInsert = userLiquorRepository.save(userLiquor);
//        if (userLiquorInsert == null) {
//            return new UserLiquorResponse(false, "user liquor is not updated!", null);
//        }
//        return new UserLiquorResponse(true, "success", userLiquorInsert);

    }



    public GeneralResponse deleteUserLiquor(Long userLiquorId) {
        UserLiquor userLiquor = this.userLiquorRepository.findById(userLiquorId).orElseThrow(() -> new ResourceNotFoundException("UserLiquorId: "+userLiquorId));
        userLiquorRepository.delete(userLiquor);
        return new GeneralResponse(true, "Deleted Successfully");
    }
    public List<Distributors> getDistributors(Long userProfileId) {
      List<Object[]> userLiquorList =  userLiquorRepository.getDistributorsList(userProfileId);
        List<Distributors>distributorsList = new ArrayList<>();
        for (Object[] obj: userLiquorList) {
            Distributors distributors = new Distributors();
            distributors.setDistributorName(obj[0].toString());
            distributors.setLiquorId(Long.parseLong(obj[1].toString()));
            distributorsList.add(distributors);
        }
        return distributorsList;

    }
    public List<UserLiquor> getParList(Long userProfileId) {
        return userLiquorRepository.getParList(userProfileId);
    }

}
