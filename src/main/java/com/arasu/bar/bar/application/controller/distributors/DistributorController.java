package com.arasu.bar.bar.application.controller.distributors;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.entities.Bar;
import com.arasu.bar.bar.application.entities.Distributor;
import com.arasu.bar.bar.application.model.BarInput;
import com.arasu.bar.bar.application.model.BarUpdate;
import com.arasu.bar.bar.application.model.DistributorInput;
import com.arasu.bar.bar.responses.BarResponse;
import com.arasu.bar.bar.responses.DistributorResponse;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.utils.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Api(tags = {"Distributor"})
@RequestMapping(value = "distributor")
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "false")
public class DistributorController extends AbstractRestHandler {
    @Autowired
    private DistributorService distributorService;

    @RequestMapping(value = Constants.DISTRIBUTOR,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all distributors list.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Distributor> getAllDistributors(@ApiParam(value = "The page number (zero-based)", required = true)
                         @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                 @ApiParam(value = "The page Size", required = true)
                         @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                 @ApiParam(value = "UserProfileId", required = true)
                         @PathVariable("userProfileId") Long userProfileId,
                                 HttpServletRequest request, HttpServletResponse response) {
        return  this.distributorService.getAllDistributorByUserProfileId(page, size,userProfileId);
    }
    @RequestMapping(value = Constants.DISTRIBUTOR_BY_ID,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single Distributor.", notes = "You have to provide valid Distributor Id.")
    public
    @ResponseBody
    DistributorResponse getDistributorById(@ApiParam(value = "The id of the Distributor.", required = true)
                              @PathVariable("distributorId") Long distributorId) throws Exception {
        DistributorResponse distributorResponse = this.distributorService.getDistributorById(distributorId);
        checkResourceFound(distributorResponse);
        return distributorResponse;
    }

    @RequestMapping(value = Constants.INSERT_DISTRIBUTOR,
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert a single Distributor.", notes = "you have to provide bar input.")
    public
    @ResponseBody
    DistributorResponse insertDistributor(@ApiParam(value = "Distributor input json is required.", required = true)
                          @Valid @RequestBody DistributorInput distributorInput) throws Exception {
        DistributorResponse  distributorResponse = this.distributorService.insertDistributor(distributorInput);
        checkResourceFound(distributorResponse);
        return distributorResponse;
    }
    @RequestMapping(value = Constants.UPDATE_DISTRIBUTOR,
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a single Distributor.", notes = "You have to provide bar input.")
    public
    @ResponseBody
    DistributorResponse updateDistributor(@ApiParam(value = "Distributor input json is required.", required = true)
                          @RequestBody DistributorInput distributorInput,
                          @ApiParam(value = "Distributor Id is required.", required = true)
                          @PathVariable("distributorId") Long distributorId) throws Exception {
        DistributorResponse distributorResponse = this.distributorService.updateDistributor(distributorInput, distributorId);
        checkResourceFound(distributorResponse);
        return distributorResponse;
    }
    @RequestMapping(value = Constants.DELETE_DISTRIBUTOR,
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a single Distributor.", notes = "You have to provide Distributor id.")
    public GeneralResponse deleteBar(@ApiParam(value = "Distributor id is required.",required = true)
                                     @PathVariable("distributorId")Long distributorId) throws  Exception {
        GeneralResponse generalResponse = this.distributorService.deleteDistributor(distributorId);
        checkResourceFound(generalResponse);
        return generalResponse;
    }

}
