package com.arasu.bar.bar.application.controller.user;

import com.arasu.bar.bar.application.EmailServiceImpl;
import com.arasu.bar.bar.application.model.*;
import com.arasu.bar.bar.application.repository.UserRepository;
import com.arasu.bar.bar.application.entities.User;
import com.arasu.bar.bar.application.exception.ResourceNotFoundException;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.LoginResponse;
import com.arasu.bar.bar.utils.PasswordChecker;
import com.arasu.bar.bar.utils.Utils;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service(value = "userService")
public class UserService implements UserDetailsService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailServiceImpl emailService;

    public UserService() {
    }
    public Page<User> getAllUsers(Integer page, Integer size) {
        Page pageOfUser = userRepository.findAll(PageRequest.of(page, size));
      return pageOfUser;
    }
    public User getUser(long id) {
        return userRepository.findUserById(id);
    }
    public LoginResponse login(Login login) {
        User user = findOne(login.getUserEmail());
        if (PasswordChecker.checkPassword(login.getPassword(), user.getPassword())) {
            return new LoginResponse(true,"success", user);
        }

        return new LoginResponse(false, "Email is not there or email or password is not match", null);
    }

    public GeneralResponse register(Register user) throws Exception {
        boolean isEmailThere = findUserEmail(user.getUserFirstName());
        if (!isEmailThere) {
            String randomPassword = Utils.RandomPassword();
            String encodedPassword = PasswordChecker.encodedPassword(randomPassword);
            User user1 = userRepository.save(new User(user.getUserFirstName(), user.getUserLastName(), user.getUserMobileNumber(), user.getUserEmail(),user.getUserVenueName(),user.getUserCountry(), user.getUserOftenInventory(),user.getUserInventoryTime(), encodedPassword, user.getUserRole(), Utils.getCurrentDate()));
            if (user1 == null) {
                return new GeneralResponse(false, "User is not Registered!");
            }
            emailService.sendEmail(user.getUserEmail(),Utils.BODY + randomPassword,Utils.SUBJECT);
            return new GeneralResponse(true, "Password sent to registered e-mail!");
        }
        return new GeneralResponse(false, "Email is already registered!");

    }
    public Long registerUserManagement(Register user) throws Exception {
        boolean isEmailThere = findUserEmail(user.getUserFirstName());
        if (!isEmailThere) {
            String randomPassword = Utils.RandomPassword();
            User user1 = userRepository.save(new User(user.getUserFirstName(), user.getUserLastName(), user.getUserMobileNumber(), user.getUserEmail(),user.getUserVenueName(),user.getUserCountry(), user.getUserOftenInventory(),user.getUserInventoryTime(), Utils.encodedString(randomPassword), user.getUserRole(), Utils.getCurrentDate()));
            if (user1 == null) {
                return 0L;
            }
            emailService.sendEmail(user.getUserEmail(),Utils.BODY + randomPassword,Utils.SUBJECT);
            return user1.getId();
        }
        return 0L;

    }
    public Long updateUserManagement(UserManagementUpdate userManagementUpdate, Long userManagementId) throws Exception {
        User user = this.userRepository.findById(userManagementId).orElseThrow(() -> new ResourceNotFoundException("UserProfileId : " +userManagementId));
        user.setUserFirstName(userManagementUpdate.getUserFirstName());
        user.setUserLastName(userManagementUpdate.getUserLastName());
        user.setUserVenueName(userManagementUpdate.getUserVenueName());
        user.setUserCountry(userManagementUpdate.getUserCountry());
        user.setUserMobileNumber(userManagementUpdate.getUserMobileNumber());
        user.setModifiedOn(Utils.getCurrentDate());
        user.setUserRole(userManagementUpdate.getUserRole());
        user.setParentUserProfileId(userManagementUpdate.getParentUserProfileId());
        User user1 = this.userRepository.save(user);
        return user1.getId();

    }
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("LoadUserByUserEmail: "+ userId);
        User user = userRepository.findByUserEmail(userId);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserFirstName(), user.getPassword(), getAuthority());
    }
    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    private boolean findUserEmail(String email) {
        User user = userRepository.findByUserEmail(email);
        log.info("User Info : "+ new Gson().toJson(user));
        if (user == null) {
            return false;
        }
        return true;
    }
    public User findOne(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    public GeneralResponse forgetPassword(ForgetPasswordInput forgetPasswordInput) throws Exception {
        String userEmail = forgetPasswordInput.getUserEmail();
        log.info("ForgetPassword: userEmail:  : " +userEmail);
       User user = findOne(userEmail);
       if (user == null) {
           return new GeneralResponse(false, "User email id does not exist!");
       }
       String randomPassword = Utils.RandomPassword();
       userRepository.forgetPassword(userEmail, PasswordChecker.encodedPassword(randomPassword));
        emailService.sendEmail(user.getUserEmail(),Utils.BODY + randomPassword,Utils.SUBJECT);

        return new GeneralResponse(true, "Password sent to registered email");
    }
    public LoginResponse updatePassword(UpdatePasswordInput updatePasswordInput) {
        User user = userRepository.findById(updatePasswordInput.getUserProfileId()).orElseThrow(() -> new ResourceNotFoundException("UserProfileId : "+ updatePasswordInput.getUserProfileId()));

        if (PasswordChecker.checkPassword(updatePasswordInput.getOldPassword(),user.getPassword())) {
            user.setPassword(PasswordChecker.encodedPassword(updatePasswordInput.getNewPassword()));
            User user1 = userRepository.save(user);
            return new LoginResponse(true, "success", user1);
        }
        return new LoginResponse(false, "Old password does not match!", null);
    }
    public LoginResponse updateProfile(Register register, Long userProfileId) {
        User user = userRepository.findById(userProfileId).orElseThrow(() -> new ResourceNotFoundException("UserProfileId : "+ userProfileId));
        user.setUserFirstName(register.getUserFirstName());
        user.setUserLastName(register.getUserLastName());
        user.setUserEmail(register.getUserEmail());
        user.setUserVenueName(register.getUserVenueName());
        user.setUserCountry(register.getUserCountry());
        user.setUserMobileNumber(register.getUserMobileNumber());
        user.setUserOftenInventory(register.getUserOftenInventory());
        user.setUserInventoryTime(register.getUserInventoryTime());
        User user1 = userRepository.save(user);
        return new LoginResponse(true,"success", user1);
    }


}
