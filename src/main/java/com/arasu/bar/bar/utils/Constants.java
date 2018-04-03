package com.arasu.bar.bar.utils;

public class Constants {
    public static final String LOGIN = "/login";
    public static final String USERS = "/users";
    public static final String USER_MANAGEMENT = "/userManagements/{userProfileId}";
    public static final String USER_MANAGEMENT_BY_ID = "/{userManagementId}";
    public static final String INSERT_USER_MANAGEMENT = "/{userManagementId}";
    public static final String UPDATE_USER_MANAGEMENT = "";
    public static final String USER = "/{userProfileId}";
    public static final String REGISTER = "/register";
    public static final String UPDATE_USER_PROFILE = "/updateProfile/{userProfileId}";
    public static final String FORGET_PASSWORD = "/forgetPassword";
    public static final String UPDATE_PASSWORD = "/updatePassword";
    public static final String BARS = "/bars/{userProfileId}";
    public static final String BAR = "/{barId}";
    public static final String INSERT_BAR = "";
    public static final String UPDATE_BAR = "/{barId}";
    public static final String DELETE_BAR = "/{barId}";
    public static final String SECTIONS_USERPROFILEID = "/sectionsByUserProfileId/{userProfileId}";
    public static final String SECTIONS_BARID = "/sectionsByBarId/{barId}";
    public static final String SECTION = "/{sectionId}";
    public static final String INSERT_SECTION = "";
    public static final String UPDATE_SECTION = "/{sectionId}";
    public static final String DELETE_SECTION = "/{sectionId}";
    public static final String EMAILS = "/emails/{userProfileId}";
    public static final String EMAIL = "/{emailId}";
    public static final String INSERT_EMAIL = "";
    public static final String UPDATE_EMAIL = "/{emailId}";
    public static final String DELETE_EMAIL = "/{emailId}";
    public static final String PICTURE = "/{pictureId}";
    public static final String CATEGORY_PICTURE = "category/{pictureId}";
    public static final String INSERT_PICTURE = "";
    public static final String UPDATE_PICTURE = "/{pictureId}";
    public static final String DELETE_PICTURE = "/{pictureId}";
    public static final String USER_LIQUOR_BY_USER_PROFILEID = "userProfile/{userProfileId}";
    public static final String USER_LIQUOR_BY_BAR_ID = "bar/{barId}";
    public static final String USER_LIQUOR_BY_SECTION_ID = "section/{sectionId}";
    public static final String USER_LIQUOR_BY_ID = "/liquor/{liquorId}";
    public static final String INSERT_USER_LIQUOR = "";
    public static final String UPDATE_USER_LIQUOR = "/{liquorId}";
    public static final String DELETE_USER_LIQUOR = "/{liquorId}";
    public static final String LIQUOR = "/liquors";
    public static final String LIQUOR_CATEGORY = "/category";
    public static final String GENERATE_TOKEN = "/generate-token";
    public static final String LIQUOR_CATEGORY_NAME = "/categoryName/{category}";
    public static final String DISTRIBUTORS = "/distributors/{userProfileId}";
    public static final String PAR_LIST = "/parList/{userProfileId}";


    public static final String PICTURE_URL = "http://192.168.1.16:8091/bar/v1/picture/category/";

}
