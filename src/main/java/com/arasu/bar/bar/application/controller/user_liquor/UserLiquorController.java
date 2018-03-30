package com.arasu.bar.bar.application.controller.user_liquor;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.entities.UserLiquor;
import com.arasu.bar.bar.application.model.UserLiquorInput;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.UserLiquorResponse;
import com.arasu.bar.bar.utils.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Set;

@RestController
@Api(tags = {"UserLiquor"})
@RequestMapping(value = "userLiquor")
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
public class UserLiquorController extends AbstractRestHandler {
    @Autowired
    private UserLiquorService userLiquorService;

    @RequestMapping(value = Constants.USER_LIQUOR_BY_USER_PROFILEID,
    method = RequestMethod.GET,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all user liquor.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<UserLiquor> getUserLiquorByUserProfileId(@ApiParam(value = "The page number (zero-based)", required = true)
                                                  @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                  @ApiParam(value = "The page size" , required = true)
                                                  @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                  HttpServletRequest request, HttpServletResponse response,
                                                  @ApiParam(value = "The UserProfileId of the User.", required = true)
                                                  @PathVariable("userProfileId") Long id) throws Exception {
        return this.userLiquorService.getLiquorsByUserProfileId(page, size, id);
    }
    @RequestMapping(value = Constants.USER_LIQUOR_BY_BAR_ID,
    method = RequestMethod.GET,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all user liquor.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<UserLiquor> getUserLiquorByBarId(@ApiParam(value = "The page number (zero-based)", required = true)
                                                  @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                  @ApiParam(value = "The page size" , required = true)
                                                  @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                  HttpServletRequest request, HttpServletResponse response,
                                                  @ApiParam(value = "The UserProfileId of the User.", required = true)
                                                  @PathVariable("barId") Long id) throws Exception {
        return this.userLiquorService.getLiquorByBarId(page, size, id);
    }
    @RequestMapping(value = Constants.USER_LIQUOR_BY_SECTION_ID,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all user liquor.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<UserLiquor> getUserLiquorBySectionId(@ApiParam(value = "The page number (zero-based)", required = true)
                                          @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                          @ApiParam(value = "The page size" , required = true)
                                          @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                          HttpServletRequest request, HttpServletResponse response,
                                          @ApiParam(value = "The UserProfileId of the User.", required = true)
                                          @PathVariable("sectionId") Long id) throws Exception {
        return this.userLiquorService.getLiquorBySectionId(page, size, id);
    }
    @RequestMapping(value = Constants.USER_LIQUOR_BY_ID,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all user liquor.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    UserLiquorResponse getUserLiquorById(@ApiParam(value = "The page number (zero-based)", required = true)
                                              @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                @ApiParam(value = "The page size" , required = true)
                                              @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                HttpServletRequest request, HttpServletResponse response,
                                                @ApiParam(value = "The UserProfileId of the User.", required = true)
                                              @PathVariable("liquorId") Long id) throws Exception {
        return this.userLiquorService.getUserLiquorById(id);
    }
    @RequestMapping(value = Constants.INSERT_USER_LIQUOR,
    method = RequestMethod.POST,
    produces = {"application/json", "application/xml"},
    consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Insert User liquor", notes = "Inserting user Liquor.")
    public
    @ResponseBody
    UserLiquorResponse insertUserLiquor(@ApiParam(value = "The userLiquor  input json is required.", required = true)
                                        @RequestBody UserLiquorInput userLiquorInput) throws Exception {
        UserLiquorResponse userLiquorResponse = userLiquorService.insertUserLiquor(userLiquorInput);
        checkResourceFound(userLiquorResponse);
        return userLiquorResponse;
    }
    @RequestMapping(value = Constants.UPDATE_USER_LIQUOR,
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update User liquor", notes = "Updating user Liquor.")
    public
    @ResponseBody
    UserLiquorResponse updateUserLiquor(@ApiParam(value = "The userLiquor  input json is required.", required = true)
                                        @RequestBody UserLiquorInput userLiquorInput,
                                        @ApiParam(value = "The User liquor id is required.", required = true)
                                        @PathVariable("liquorId") Long liquorId) throws Exception {
        UserLiquorResponse userLiquorResponse = userLiquorService.updateUserLiquor(userLiquorInput,liquorId);
        checkResourceFound(userLiquorResponse);
        return userLiquorResponse;
    }
    @RequestMapping(value = Constants.DELETE_USER_LIQUOR,
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update User liquor", notes = "Updating user Liquor.")
    public
    @ResponseBody
    GeneralResponse deleteUserLiquor( @ApiParam(value = "The User liquor id is required.", required = true)
                                         @PathVariable("liquorId") Long liquorId) throws Exception {
        GeneralResponse generalResponse = userLiquorService.deleteUserLiquor(liquorId);
        checkResourceFound(generalResponse);
        return generalResponse;
    }

    @RequestMapping(value = Constants.DISTRIBUTORS,
    method = RequestMethod.GET,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get distributors.", notes = "Geting distributors list by passing userprofileId")
    public
    @ResponseBody
    Set<UserLiquor> getDistributors (@ApiParam(value = "UserProfileId is required.", required = true)
                                     @PathVariable("userProfileId")Long userProfileId) {
        return userLiquorService.getDistributors(userProfileId);
    }
 @RequestMapping(value = Constants.PAR_LIST,
    method = RequestMethod.GET,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get ParList.", notes = "Geting distributors list by passing userprofileId")
    public
    @ResponseBody
 List<UserLiquor> getParList (@ApiParam(value = "UserProfileId is required.", required = true)
                                     @PathVariable("userProfileId")Long userProfileId) {
        return userLiquorService.getParList(userProfileId);
    }

}
