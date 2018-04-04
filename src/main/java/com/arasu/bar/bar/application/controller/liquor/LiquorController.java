package com.arasu.bar.bar.application.controller.liquor;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.entities.Liquor;
import com.arasu.bar.bar.application.model.LiquorCategory;
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
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/liquor")
@Api(tags = {"liquor"})
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
@CrossOrigin(value = "*", maxAge = 3600, allowCredentials = "false")
public class LiquorController  extends AbstractRestHandler {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LiquorService liquorService;
    @RequestMapping(value = Constants.LIQUOR,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get paginated list of all LIQUOR list.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public Page<Liquor> getLiquorList(@ApiParam(value = "The page number (zero-based)", required = true)
                                               @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                @ApiParam(value = "The page Size", required = true)
                                               @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                HttpServletRequest request, HttpServletResponse response) {
        return this.liquorService.getAllLiquor(page, size);
    }
    @RequestMapping(value = Constants.LIQUOR_CATEGORY,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get paginated list of all LIQUOR category list.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public List<LiquorCategory>  getCategoryList() {
        return this.liquorService.getLiquorCategory();
    }
    @RequestMapping(value = Constants.LIQUOR_CATEGORY_NAME,
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get paginated list of all LIQUOR category list.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public Page<Liquor> getLiquorListCategory(@ApiParam(value = "The page number (zero-based)", required = true)
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @ApiParam(value = "The page Size", required = true)
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      @ApiParam(value = "The Category ", required = true)
                                      @PathVariable("category") String category,
                                      HttpServletRequest request, HttpServletResponse response) {
                                        if (category.equals("whisky")) {
                                            category = "Whiskey / Whisky";
                                        }
        return this.liquorService.getAllLiquorByCategory(category,page, size);
    }
}
