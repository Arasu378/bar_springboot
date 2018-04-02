package com.arasu.bar.bar.application.controller.section;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.entities.Section;
import com.arasu.bar.bar.application.model.BarInput;
import com.arasu.bar.bar.application.model.SectionInput;
import com.arasu.bar.bar.responses.BarResponse;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.SectionResponse;
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
@RequestMapping(value = "/section")
@Api(tags = {"Section"})
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "false")
public class SectionController extends AbstractRestHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SectionService sectionService;

    @RequestMapping(value = Constants.SECTIONS_USERPROFILEID,
    method = RequestMethod.GET,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get paginated list of all sections list.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public Page<Section> getSectionsByUserProfileId(@ApiParam(value = "The page number (zero-based)", required = true)
                                                        @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                    @ApiParam(value = "The page Size", required = true)
                                                        @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                    @ApiParam(value = "UserProfileId", required = true)
                                                        @PathVariable("userProfileId") Long userProfileId,
                                                    HttpServletRequest request, HttpServletResponse response) {
        return this.sectionService.getAllSectionByUserProfileId(page, size, userProfileId);
    }
    @RequestMapping(value = Constants.SECTIONS_BARID,
    method = RequestMethod.GET,
    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get paginated list of all sections list.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public Page<Section> getSectionsByBarId(@ApiParam(value = "The page number (zero-based)", required = true)
                                                        @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                    @ApiParam(value = "The page Size", required = true)
                                                        @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                    @ApiParam(value = "BarId", required = true)
                                                        @PathVariable("barId") Long barId,
                                                    HttpServletRequest request, HttpServletResponse response) {
        return this.sectionService.getAllSectionByBarId(page, size, barId);
    }
    @RequestMapping(value = Constants.SECTION,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single Section.", notes = "You have to provide valid SectionId.")
    public
    SectionResponse getSectionBySectionId(@ApiParam(value = "The SectionId of the Bar.", required = true)
                              @PathVariable("sectionId") Long sectionId) throws Exception {
        SectionResponse sectionResponse = this.sectionService.getSectionBySectionId(sectionId);
        checkResourceFound(sectionResponse);
        return sectionResponse;
    }
    @RequestMapping(value = Constants.INSERT_SECTION,
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert a single section.", notes = "you have to provide bar input.")
    public
    SectionResponse insertSection(@ApiParam(value = "section input json is required.", required = true)
                          @Valid @RequestBody SectionInput sectionInput) throws Exception {
        SectionResponse sectionResponse = this.sectionService.insertSection(sectionInput);
        checkResourceFound(sectionResponse);
        return sectionResponse;
    }
    @RequestMapping(value = Constants.UPDATE_SECTION,
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update a single bar.", notes = "You have to provide bar input.")
    public
    @ResponseBody
    SectionResponse updateSection(@ApiParam(value = "section input json is required.", required = true)
                          @RequestBody SectionInput sectionInput,
                          @ApiParam(value = "Section Id is required.", required = true)
                          @PathVariable("sectionId") Long sectionId) throws Exception {
        SectionResponse sectionResponse = this.sectionService.updateSection(sectionInput, sectionId);
        checkResourceFound(sectionResponse);
        return sectionResponse;
    }
    @RequestMapping(value = Constants.DELETE_SECTION,
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a single section.", notes = "You have to provide bar id.")
    public GeneralResponse deleteSection(@ApiParam(value = "section id is required.",required = true)
                                     @PathVariable("sectionId")Long sectionId) throws  Exception {
        GeneralResponse generalResponse = this.sectionService.deleteSection(sectionId);
        checkResourceFound(generalResponse);
        return generalResponse;
    }
}
