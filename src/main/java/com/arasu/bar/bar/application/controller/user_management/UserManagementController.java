package com.arasu.bar.bar.application.controller.user_management;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.entities.User;
import com.arasu.bar.bar.application.entities.UserManagement;
import com.arasu.bar.bar.application.model.Login;
import com.arasu.bar.bar.application.model.UserManagementInput;
import com.arasu.bar.bar.application.model.UserManagementUpdate;
import com.arasu.bar.bar.responses.LoginResponse;
import com.arasu.bar.bar.responses.UserManagementResponse;
import com.arasu.bar.bar.utils.Constants;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api (tags = {"UserManagement"})
@RequestMapping(value = "userManagement")
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "false")
public class UserManagementController extends AbstractRestHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(value = Constants.USER_MANAGEMENT,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all userManagement.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)" )
    public
    @ResponseBody
    Page<UserManagement> getAllUserManagementByUserProfileId(@ApiParam(value = "The page number (zero-based)", required = true)
                           @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                     @ApiParam(value = "The page size" , required = true)
                           @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                     HttpServletRequest request,
                                                             @ApiParam(value = "User Profile Id is required.", required = true)
                                                                     @PathVariable("userProfileId")Long userProfileId,
                                                             HttpServletResponse response) {

        return this.userManagementService.getUserManagementByUserProfileId(page, size, userProfileId);
    }

    @RequestMapping(value = Constants.USER_MANAGEMENT_BY_ID,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single User.", notes = "You have to provide a valid UserProfileId.")
    public
    @ResponseBody
    UserManagementResponse getUserManagementById(@ApiParam(value = "The UserManagementId of the User.", required = true)
                 @PathVariable("userManagementId") Long id,
                                   HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserManagementResponse userManagementResponse = this.userManagementService.getUserManagementById(id);
        checkResourceFound(userManagementResponse);
        return  userManagementResponse;
    }
    @RequestMapping(value = Constants.INSERT_USER_MANAGEMENT,
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Inserting user management.", notes = "Returns the controller response.")
    public
    @ResponseBody
    UserManagementResponse insertUserProfileToUserManagement(@ApiParam(value = "User Management input is required.", required = true)
                                                             @RequestBody UserManagementInput userManagementInput,
                                                             HttpServletRequest request, HttpServletResponse response) throws  Exception {
        UserManagementResponse userManagementResponse = this.userManagementService.insertUserProfileToUserManagement(userManagementInput);
        checkResourceFound(userManagementResponse);
        return userManagementResponse;

    }
    @RequestMapping(value = Constants.UPDATE_USER_MANAGEMENT,
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Inserting user management.", notes = "Returns the controller response.")
    public
    @ResponseBody
    UserManagementResponse insertUserProfileToUserManagement(@ApiParam(value = "User Management input is required.", required = true)
                                                             @RequestBody UserManagementUpdate userManagementInput,
                                                             HttpServletRequest request, HttpServletResponse response,
                                                             @ApiParam(value = "UserManagementId is required.", required = true)
                                                             @PathVariable("userManagementId")Long userManagementId) throws  Exception {
        UserManagementResponse userManagementResponse = this.userManagementService.updateUserProfileToUserManagement(userManagementInput,userManagementId);
        checkResourceFound(userManagementResponse);
        return userManagementResponse;

    }

}
