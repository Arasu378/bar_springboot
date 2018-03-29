package com.arasu.bar.bar.application.controller.email_management;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.entities.Email;
import com.arasu.bar.bar.application.entities.Section;
import com.arasu.bar.bar.application.model.EmailInput;
import com.arasu.bar.bar.responses.EmailResponse;
import com.arasu.bar.bar.responses.GeneralResponse;
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
import javax.validation.Valid;


@RestController
@RequestMapping(value = "/email")
@Api(tags = {"email"})
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
public class EmailController extends AbstractRestHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = Constants.EMAILS,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get paginated list of all EMAILS list.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public Page<Email> getEmailByUserProfileId(@ApiParam(value = "The page number (zero-based)", required = true)
                                                    @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                  @ApiParam(value = "The page Size", required = true)
                                                    @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                  @ApiParam(value = "UserProfileId", required = true)
                                                    @PathVariable("userProfileId") Long userProfileId,
                                                  HttpServletRequest request, HttpServletResponse response) {
        return this.emailService.getEmailsByUserProfileId(page, size, userProfileId);
    }
    @RequestMapping(value = Constants.EMAIL,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single Email.", notes = "You have to provide valid SectionId.")
    public EmailResponse getEmailById(@ApiParam(value = "The emailId of the Email.", required = true)
                                          @PathVariable("emailId") Long emailId) throws Exception {
        EmailResponse emailResponse = this.emailService.getEmailById(emailId);
        checkResourceFound(emailResponse);
        return emailResponse;
    }
    @RequestMapping(value = Constants.INSERT_EMAIL,
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert a single email.", notes = "you have to provide email input json.")
    public
    EmailResponse insertEmail(@ApiParam(value = "email input json is required.", required = true)
                                @Valid @RequestBody EmailInput emailInput) throws Exception {
        EmailResponse emailResponse = this.emailService.insertEmail(emailInput);
        checkResourceFound(emailResponse);
        return emailResponse;
    }
    @RequestMapping(value = Constants.UPDATE_EMAIL,
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a single Email.", notes = "You have to provide Email input.")
    public
    @ResponseBody
    EmailResponse updateEmail(@ApiParam(value = "Email input json is required.", required = true)
                                  @RequestBody EmailInput emailInput,
                                  @ApiParam(value = "Section Id is required.", required = true)
                                  @PathVariable("emailId") Long emailId) throws Exception {
        EmailResponse emailResponse = this.emailService.updateEmail(emailInput, emailId);
        checkResourceFound(emailResponse);
        return emailResponse;
    }
    @RequestMapping(value = Constants.DELETE_EMAIL,
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a single email.", notes = "You have to provide email id.")
    public GeneralResponse deleteEmail(@ApiParam(value = "email id is required.",required = true)
                                         @PathVariable("emailId")Long emailId) throws  Exception {
        GeneralResponse generalResponse = this.emailService.deleteEmail(emailId);
        checkResourceFound(generalResponse);
        return generalResponse;
    }
}

