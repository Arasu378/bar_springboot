package com.arasu.bar.bar.application.controller.user_liquor_picture;

import com.arasu.bar.bar.application.entities.User;
import com.arasu.bar.bar.application.entities.UserLiquorPicture;
import com.arasu.bar.bar.application.repository.UserLiquorPictureRepository;
import com.arasu.bar.bar.exception.ResourceNotFoundException;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.UserLiquorPictureResponse;
import com.arasu.bar.bar.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class UserLiquorPictureService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserLiquorPictureRepository pictureRepository;
    public Page<UserLiquorPicture> getPicturesByUserProfileId(Integer page, Integer size, Long userProfileId) {
        Page pageOfUserLiquorPicture = pictureRepository.findUserLiquorPicturesByUserProfileId(userProfileId, PageRequest.of(page,size));
        return pageOfUserLiquorPicture;
    }
    public UserLiquorPicture getPictureById(Long userLiquorPictureId) {
        return pictureRepository.findById(userLiquorPictureId).orElseThrow(() -> new ResourceNotFoundException("User LiquorPictureId : " +userLiquorPictureId));
    }
    public ResponseEntity<InputStreamResource> getAttachedPictureById(Long pictureId) throws Exception {
        UserLiquorPicture userLiquorPicture = pictureRepository.findById(pictureId).orElseThrow(() -> new ResourceNotFoundException("PictureId : "+pictureId));
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userLiquorPicture.getData());
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(byteArrayInputStream));

    }
    public UserLiquorPictureResponse insertPicture(String pictureName, Long userProfileId, MultipartFile multipartFile) throws IOException {
        UserLiquorPicture input = new UserLiquorPicture();
        input.setPictureName(pictureName);
        input.setCreatedOn(Utils.getCurrentDate());
        input.setUserProfileId(userProfileId);
        input.setData(multipartFile.getBytes());
        UserLiquorPicture userLiquorPicture = pictureRepository.save(input);
        if (userLiquorPicture == null) {
            return new UserLiquorPictureResponse(false,"picture is not inserted",0L);
        }
        return new UserLiquorPictureResponse(true, "picture is inserted",input.getId());
    }
    public UserLiquorPictureResponse updatePicture(String pictureName, Long userProfileId, MultipartFile multipartFile, Long pictureId) throws IOException {
        UserLiquorPicture userLiquorPicture = pictureRepository.findById(pictureId).orElseThrow(() -> new ResourceNotFoundException("PictureId : "+ pictureId));
        userLiquorPicture.setData(multipartFile.getBytes());
        userLiquorPicture.setPictureName(pictureName);
        userLiquorPicture.setUserProfileId(userProfileId);
        userLiquorPicture.setModifiedOn(Utils.getCurrentDate());
        UserLiquorPicture updatedPicture = pictureRepository.save(userLiquorPicture);
        if (updatedPicture == null) {
            return new UserLiquorPictureResponse(false, "Picture is not updated!", 0L);
        }
        return new UserLiquorPictureResponse(true, "Picture is updated",userLiquorPicture.getId());
    }
    public GeneralResponse deletePicture(Long pictureId) {
        UserLiquorPicture userLiquorPicture = pictureRepository.findById(pictureId).orElseThrow(() -> new ResourceNotFoundException("PictureId : "+ pictureId));
        pictureRepository.delete(userLiquorPicture);
        return new GeneralResponse(true,"successfully Deleted!");
    }
}
