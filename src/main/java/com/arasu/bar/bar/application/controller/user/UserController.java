package com.arasu.bar.bar.application.controller.user;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.authentication.JwtTokenUtil;
import com.arasu.bar.bar.application.controller.token.AuthenticationService;
import com.arasu.bar.bar.application.model.ForgetPasswordInput;
import com.arasu.bar.bar.application.model.Login;
import com.arasu.bar.bar.application.model.Register;
import com.arasu.bar.bar.application.entities.User;
import com.arasu.bar.bar.application.model.UpdatePasswordInput;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.LoginResponse;
import com.arasu.bar.bar.utils.Constants;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(tags = {"User"})
@RequestMapping(value = "user")
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "false")
public class UserController extends AbstractRestHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationService authenticationService;



    @Autowired
    private UserService userService;
    @RequestMapping(value = Constants.USERS,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all users.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)" )
    public
    @ResponseBody
    Page<User> getAllUsers(@ApiParam(value = "The page number (zero-based)", required = true)
                           @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                           @ApiParam(value = "The page size" , required = true)
                           @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                           HttpServletRequest request, HttpServletResponse response) {

        return this.userService.getAllUsers(page, size);
    }
    @RequestMapping(value = Constants.USER,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single User.", notes = "You have to provide a valid UserProfileId.")
    public
    @ResponseBody
    User getUser(@ApiParam(value = "The UserProfileId of the User.", required = true)
                 @PathVariable("userProfileId") Long id,
                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = this.userService.getUser(id);
        checkResourceFound(user);
        return  user;
    }
    @RequestMapping(value = Constants.LOGIN,
    method = RequestMethod.POST,
    consumes = {"application/json", "application/xml"},
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Login Users.", notes = "Returns the controller response.")
    public
    @ResponseBody
    LoginResponse login(@RequestBody Login login,
                               HttpServletRequest request, HttpServletResponse response) throws  Exception {
        LoginResponse loginResponse = this.userService.login(login);
        if (loginResponse.getIsSuccess()) {
            String token = this.authenticationService.getToken(login.getUserEmail(), login.getPassword());
            loginResponse.getUser().setUserAuthorizationKey(token);
        }
        checkResourceFound(loginResponse);
        return loginResponse;

    }
    @RequestMapping(value = Constants.REGISTER,
    method = RequestMethod.POST,
    consumes = {"application/json", "application/xml"},
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registration for Users.", notes = "Returns the controller response message.")
    public
    @ResponseBody
    GeneralResponse registration(@ApiParam(value = "User Input .", required = true)
                                 @RequestBody Register register, HttpServletRequest request, HttpServletResponse  response) throws Exception {
        GeneralResponse generalResponse = this.userService.register(register);
        checkResourceFound(generalResponse);
        return generalResponse;
    }

    @RequestMapping(value = Constants.FORGET_PASSWORD,
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Forget password for users", notes = "Returns the controller response message.")
    public
    @ResponseBody
    GeneralResponse forgetPassword(@ApiParam(value = "User Email", required = true)
                                 @RequestBody ForgetPasswordInput forgetPasswordInput,
                                   HttpServletRequest request, HttpServletResponse  response) throws Exception {
        GeneralResponse generalResponse = this.userService.forgetPassword(forgetPasswordInput);
        checkResourceFound(generalResponse);
        return generalResponse;
    }
   @RequestMapping(value = Constants.UPDATE_PASSWORD,
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "update password for users", notes = "Returns the controller response message.")
    public
    @ResponseBody
    LoginResponse forgetPassword(@ApiParam(value = "User input json", required = true)
                                 @RequestBody UpdatePasswordInput updatePasswordInput,
                                   HttpServletRequest request, HttpServletResponse  response) throws Exception {
       LoginResponse loginResponse = this.userService.updatePassword(updatePasswordInput);
        checkResourceFound(loginResponse);
        return loginResponse;
    }
    @RequestMapping(value = Constants.UPDATE_USER_PROFILE,
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registration for Users.", notes = "Returns the controller response message.")
    public
    @ResponseBody
    LoginResponse updateProfile(@ApiParam(value = "User Input .", required = true)
                                @RequestBody Register register,
                                @ApiParam(value = "UserProfileId is required.", required = true)
                                @PathVariable("userProfileId") Long userProfileId,
                                HttpServletRequest request,
                                HttpServletResponse  response) throws Exception {
        LoginResponse loginResponse = this.userService.updateProfile(register, userProfileId);
        checkResourceFound(loginResponse);
        return loginResponse;
    }
}
