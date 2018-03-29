package com.arasu.bar.bar.application.controller.user_liquor_picture;

import com.arasu.bar.bar.application.AbstractRestHandler;
import com.arasu.bar.bar.application.entities.UserLiquor;
import com.arasu.bar.bar.application.entities.UserLiquorPicture;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.UserLiquorPictureResponse;
import com.arasu.bar.bar.utils.Constants;
import io.swagger.annotations.*;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@Api(tags = {"UserLiquorPicture"})
@RequestMapping(value = "picture")
@ApiResponses({
        @ApiResponse(code=200,message="Success. Request completed."),
        @ApiResponse(code=400,message="BAD REQUEST if any validation are failed, like negative company id, invalid metric id."),
        @ApiResponse(code=401,message="Unauthorized Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided."),
        @ApiResponse(code=404,message="Not Found - resource doesn't exist for the specified id."),
        @ApiResponse(code=500,message="Internal Server error."),
})
public class UserLiquorPictureController extends AbstractRestHandler {
    @Autowired
    private UserLiquorPictureService userLiquorPictureService;
    @RequestMapping(method = RequestMethod.GET,value = Constants.PICTURE,
            produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a picture response.", notes = "Picture for User liquor.")
    public @ResponseBody
    ResponseEntity<InputStreamResource> getPictureByPictureId(@ApiParam(value = "Picture Id ",required = true)
            @PathVariable("pictureId")Long pictureId) throws Exception {
        return userLiquorPictureService.getAttachedPictureById(pictureId);
    }
    @RequestMapping(value = Constants.INSERT_PICTURE,
            method = RequestMethod.POST,
            produces = {"application/json", "application/xml"},
            consumes = {"multipart/*"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert a single PICTURE.", notes = "you have to provide picture input.")
    public
    @ResponseBody
    UserLiquorPictureResponse insertUserLiquorPicture(@ApiParam(value = "picture Name  is required.", required = true)
                                              @RequestParam("PictureName") String pictureName,
                                            @ApiParam(value = "UserProfileId is required", required = true)
                                              @RequestParam("UserProfileId") Long userProfileId,
                                            @ApiParam("Data")MultipartFile multipartFile) throws Exception {
        UserLiquorPictureResponse userLiquorPictureResponse = this.userLiquorPictureService.insertPicture(pictureName,userProfileId,multipartFile);
        checkResourceFound(userLiquorPictureResponse);
        return userLiquorPictureResponse;
    }
    @RequestMapping(value = Constants.UPDATE_PICTURE,
            method = RequestMethod.PUT,
            produces = {"application/json", "application/xml"},
            consumes = {"multipart/*"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "update a single PICTURE.", notes = "you have to provide picture multipart input.")
    public
    @ResponseBody
    UserLiquorPictureResponse updateUserLiquorPicture(@ApiParam(value = "picture Name  is required.", required = true)
                                            @RequestParam("PictureName") String pictureName,
                                                      @ApiParam(value = "UserProfileId is required", required = true)
                                            @RequestParam("UserProfileId") Long userProfileId,
                                                      @ApiParam("Data")MultipartFile multipartFile,
                                                      @ApiParam(value = "pictureId is required", required = true)
                                            @PathVariable("pictureId")Long pictureId) throws Exception {
        UserLiquorPictureResponse userLiquorPictureResponse = this.userLiquorPictureService.updatePicture(pictureName,userProfileId,multipartFile,pictureId);
        checkResourceFound(userLiquorPictureResponse);
        return userLiquorPictureResponse;
    }
    @RequestMapping(value = Constants.DELETE_PICTURE,
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete a single picture.", notes = "You have to provide picture id.")
    public
    @ResponseBody
    GeneralResponse deleteBar(@ApiParam(value = "picture id is required.",required = true)
                                     @PathVariable("pictureId")Long pictureId) throws  Exception {
        GeneralResponse generalResponse = this.userLiquorPictureService.deletePicture(pictureId);
        checkResourceFound(generalResponse);
        return generalResponse;
    }


}
