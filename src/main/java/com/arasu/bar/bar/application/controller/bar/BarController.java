package com.arasu.bar.bar.application.controller.bar;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.entities.Bar;
import com.arasu.bar.bar.application.model.BarInput;
import com.arasu.bar.bar.application.model.BarUpdate;
import com.arasu.bar.bar.responses.BarResponse;
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
@Api(tags = {"Bar"})
@RequestMapping(value = "bar")
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
public class BarController  extends AbstractRestHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BarService barService;
    @RequestMapping(value = Constants.BARS,
    method = RequestMethod.GET,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all bar list.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Bar> getAllBars(@ApiParam(value = "The page number (zero-based)", required = true)
                         @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                         @ApiParam(value = "The page Size", required = true)
                         @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                         @ApiParam(value = "UserProfileId", required = true)
                         @PathVariable("userProfileId") Long userProfileId,
                         HttpServletRequest request, HttpServletResponse response) {
        return  this.barService.getAllBars(page, size,userProfileId);
    }
    @RequestMapping(value = Constants.BAR,
    method = RequestMethod.GET,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single Bar.", notes = "You have to provide valid BarId.")
    public
    @ResponseBody
    BarResponse getBarByBarId(@ApiParam(value = "The BarId of the Bar.", required = true)
                      @PathVariable("barId") Long barId) throws Exception {
        BarResponse barResponse = this.barService.getBarByBarId(barId);
        checkResourceFound(barResponse);
        return barResponse;
    }
    @RequestMapping(value = Constants.INSERT_BAR,
    method = RequestMethod.POST,
    produces = {"application/json", "application/xml"},
    consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert a single bar.", notes = "you have to provide bar input.")
    public
    @ResponseBody
    BarResponse insertBar(@ApiParam(value = "bar input json is required.", required = true)
                          @Valid @RequestBody BarInput barInput) throws Exception {
        BarResponse barResponse = this.barService.insertBar(barInput);
        checkResourceFound(barResponse);
        return barResponse;
    }

    @RequestMapping(value = Constants.UPDATE_BAR,
    method = RequestMethod.PUT,
    produces = {"application/json", "application/xml"},
    consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a single bar.", notes = "You have to provide bar input.")
    public
    @ResponseBody
    BarResponse updateBar(@ApiParam(value = "bar input json is required.", required = true)
                          @RequestBody BarUpdate barInput,
                          @ApiParam(value = "Bar Id is required.", required = true)
                          @PathVariable("barId") Long barId) throws Exception {
        BarResponse barResponse = this.barService.updateBar(barInput, barId);
        checkResourceFound(barResponse);
        return barResponse;
    }
    @RequestMapping(value = Constants.DELETE_BAR,
    method = RequestMethod.DELETE,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a single bar.", notes = "You have to provide bar id.")
    public GeneralResponse deleteBar(@ApiParam(value = "bar id is required.",required = true)
                                     @PathVariable("barId")Long barId) throws  Exception {
        GeneralResponse generalResponse = this.barService.deleteBar(barId);
        checkResourceFound(generalResponse);
        return generalResponse;
    }

}
