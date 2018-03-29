package com.arasu.bar.bar.application.controller.user_management;

import com.arasu.bar.bar.application.controller.user.UserService;
import com.arasu.bar.bar.application.entities.User;
import com.arasu.bar.bar.application.entities.UserManagement;
import com.arasu.bar.bar.application.entities.UserManagementBar;
import com.arasu.bar.bar.application.model.*;
import com.arasu.bar.bar.application.repository.UserManagementBarRepository;
import com.arasu.bar.bar.application.repository.UserManagementRepository;
import com.arasu.bar.bar.exception.ResourceNotFoundException;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.UserManagementResponse;
import com.arasu.bar.bar.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManagementService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserManagementRepository userManagementRepository;

    @Autowired
    private UserManagementBarRepository userManagementBarRepository;

    @Autowired
    private UserService userService;

    public Page<UserManagement> getUserManagementByUserProfileId(Integer page, Integer size, Long userProfileId) {
        Page pageOfUserManagement = userManagementRepository.findAllByUserProfileId(userProfileId, PageRequest.of(page,size));
        return pageOfUserManagement;
    }
    public UserManagementResponse getUserManagementById(Long userManagementId) {
        UserManagement userManagement = userManagementRepository.findById(userManagementId).orElseThrow(() -> new ResourceNotFoundException("UserManagementId : "+ userManagementId));
        return new UserManagementResponse(true, "success", userManagement);
    }
    public UserManagementResponse insertUserManagement(UserManagementInput userManagementInput) {
        UserManagement userManagement = new UserManagement();
        userManagement.setUserProfileId(userManagementInput.getUserProfileId());
        userManagement.setUserFirstName(userManagementInput.getUserFirstName());
        userManagement.setUserLastName(userManagementInput.getUserLastName());
        userManagement.setUserEmail(userManagementInput.getUserEmail());
        userManagement.setCreatedOn(Utils.getCurrentDate());
        userManagement.setUserRole(userManagementInput.getUserRole());
        userManagement.setParentUserProfileId(userManagementInput.getParentUserProfileId());
        UserManagement userManagement1 = userManagementRepository.save(userManagement);
        List<UserManagementBarInput>userManagementBarInputs = userManagementInput.getUserManagementBar();
        for (UserManagementBarInput userManagementBarInput: userManagementBarInputs) {
            this.insertUserManagementBar(userManagementBarInput);
        }


        if (userManagement1 == null) {
            return new UserManagementResponse(false, "user management is not inserted", null);
        }
        return new UserManagementResponse(true, "success", userManagement1);
    }

    public UserManagementResponse updateUserManagement(UserManagementUpdate userManagementInput, Long userManagementId) {
        UserManagement userManagement = userManagementRepository.findById(userManagementId).orElseThrow(() -> new ResourceNotFoundException("UserManagementId : "+userManagementId));

        userManagement.setUserProfileId(userManagementInput.getUserProfileId());
        userManagement.setUserFirstName(userManagementInput.getUserFirstName());
        userManagement.setUserLastName(userManagementInput.getUserLastName());
        userManagement.setModifiedOn(Utils.getCurrentDate());
        userManagement.setUserRole(userManagementInput.getUserRole());
        userManagement.setParentUserProfileId(userManagementInput.getParentUserProfileId());
        UserManagement userManagement1 = userManagementRepository.save(userManagement);

        List<UserManagementBarUpdate>userManagementBarUpdates = userManagementInput.getUserManagementBar();
        for (UserManagementBarUpdate userManagementBarUpdate: userManagementBarUpdates) {
            updateUserManagementBar(userManagementBarUpdate);
        }
        if (userManagement1 == null) {
            return new UserManagementResponse(false, "user management is not updated", null);
        }
        return new UserManagementResponse(true, "success", userManagement1);
    }
    public GeneralResponse deleteUserManagement(Long userManagementId) {
        UserManagement userManagement = userManagementRepository.findById(userManagementId).orElseThrow(() -> new ResourceNotFoundException("UserManagementId : "+ userManagementId));
        userManagementRepository.delete(userManagement);
        return new GeneralResponse(true, "success");
    }

    public UserManagementResponse insertUserProfileToUserMangement(UserManagementInput userManagementInput) throws Exception {
        Register register = new Register();
        register.setUserFirstName(userManagementInput.getUserFirstName());
        register.setUserLastName(userManagementInput.getUserLastName());
        register.setUserMobileNumber("");
        register.setUserEmail(userManagementInput.getUserEmail());
        register.setUserVenueName(userManagementInput.getUserVenueName());
        register.setUserCountry(userManagementInput.getUserCountry());
        register.setUserOftenInventory("");
        register.setUserInventoryTime(0);
        register.setUserRole(userManagementInput.getUserRole());
        register.setParentUserProfileId((userManagementInput.getParentUserProfileId()));
            Long isInserted = this.userService.registerUserManagement(register);
            if (isInserted != 0L) {
                this.insertUserManagement(userManagementInput);
            }
        return new UserManagementResponse(false, "User data is not inserted into the userProfile", null);
    }
    public UserManagementResponse updateUserProfileToUserManagement(UserManagementUpdate userManagementInput, Long userProfileId) throws Exception {
      Long isUpdated =  this.userService.updateUserManagement(userManagementInput,userProfileId);
      if (isUpdated != 0L ) {
          this.updateUserManagement(userManagementInput,userProfileId);
      }
        return new UserManagementResponse(false, "User data is not updated into the userProfile", null);

    }
    public void insertUserManagementBar(UserManagementBarInput userManagementBarInput) {
        UserManagementBar userManagementBar = new UserManagementBar();
        userManagementBar.setUserManagementId(userManagementBarInput.getUserManagementId());
        userManagementBar.setBarName(userManagementBarInput.getBarName());
        userManagementBar.setCreatedOn(Utils.getCurrentDate());
        userManagementBar.setUserProfileId(userManagementBarInput.getUserProfileId());
        userManagementBar.setBarId(userManagementBarInput.getBarId());
        userManagementBar.setParentUserProfileId(userManagementBarInput.getParentUserProfileId());

        UserManagementBar userManagementBar1 = this.userManagementBarRepository.save(userManagementBar);

    }
    public void updateUserManagementBar(UserManagementBarUpdate  userManagementBarUpdate) {
        UserManagementBar userManagementBar = this.userManagementBarRepository.findById(userManagementBarUpdate.getId()).orElseThrow(() -> new ResourceNotFoundException("UserManagementBarId : "+ userManagementBarUpdate.getId()));
        userManagementBar.setUserManagementId(userManagementBarUpdate.getUserManagementId());
        userManagementBar.setBarId(userManagementBarUpdate.getBarId());
        userManagementBar.setBarName(userManagementBarUpdate.getBarName());
        userManagementBar.setModifiedOn(Utils.getCurrentDate());
        userManagementBar.setUserProfileId(userManagementBarUpdate.getUserProfileId());
        userManagementBar.setParentUserProfileId(userManagementBarUpdate.getParentUserProfileId());
        UserManagementBar userManagementBar1 = this.userManagementBarRepository.save(userManagementBar);
    }
// TODO: 28-03-2018  UserManagementService is pending  delete method need to finish.

}
