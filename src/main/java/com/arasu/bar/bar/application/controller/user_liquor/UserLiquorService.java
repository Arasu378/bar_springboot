package com.arasu.bar.bar.application.controller.user_liquor;

import com.arasu.bar.bar.application.entities.User;
import com.arasu.bar.bar.application.entities.UserLiquor;
import com.arasu.bar.bar.application.model.UserLiquorInput;
import com.arasu.bar.bar.application.model.UserLiquorPictureInput;
import com.arasu.bar.bar.application.repository.UserLiquorRepository;
import com.arasu.bar.bar.exception.ResourceNotFoundException;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.UserLiquorResponse;
import com.arasu.bar.bar.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserLiquorService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserLiquorRepository userLiquorRepository;

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
                userLiquorInput.getEmptyWeight(), userLiquorInput.getTotalBottles(),userLiquorInput.getPictureId());
        if (userLiquorInsert == 0) {
            return new UserLiquorResponse(false, "user liquor is not inserted!", null);
        }
        return new UserLiquorResponse(true, "success", null);

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
                userLiquorInput.getEmptyWeight(), userLiquorInput.getTotalBottles(),userLiquorInput.getPictureId(), userLiquorId);
        if (userLiquorInsert == 0) {
            return new UserLiquorResponse(false, "user liquor is not updated!", null);
        }
        return new UserLiquorResponse(true, "success", null);


//        UserLiquor userLiquorInsert = userLiquorRepository.save(userLiquor);
//        if (userLiquorInsert == null) {
//            return new UserLiquorResponse(false, "user liquor is not updated!", null);
//        }
//        return new UserLiquorResponse(true, "success", userLiquorInsert);

    }
    public GeneralResponse deleteUserLiquor(Long userLiquorId) {
        UserLiquor userLiquor = this.userLiquorRepository.findById(userLiquorId).orElseThrow(() -> new ResourceNotFoundException("UserLiquorId: "+userLiquorId));
        userLiquorRepository.delete(userLiquor);
        return new GeneralResponse(true, "deleted successfully!");
    }
    public Set<UserLiquor> getDistributors(Long userProfileId) {
      List<UserLiquor> userLiquorList =  userLiquorRepository.getDistributors(userProfileId);
        Set set = new HashSet(userLiquorList);
        return set;

    }
    public List<UserLiquor> getParList(Long userProfileId) {
        return userLiquorRepository.getParList(userProfileId);
    }

}
