package com.arasu.bar.bar.application.controller.email_management;

import com.arasu.bar.bar.application.entities.Email;
import com.arasu.bar.bar.application.entities.Section;
import com.arasu.bar.bar.application.model.EmailInput;
import com.arasu.bar.bar.application.repository.EmailManagementRepository;
import com.arasu.bar.bar.exception.ResourceNotFoundException;
import com.arasu.bar.bar.responses.EmailResponse;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.responses.SectionResponse;
import com.arasu.bar.bar.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmailManagementRepository emailManagementRepository;
    public Page<Email> getEmailsByUserProfileId(Integer page, Integer size, Long userProfileId) {
        Page pageOfEmail =  emailManagementRepository.findEmailsByUserProfileId(userProfileId, PageRequest.of(page, size));
        return pageOfEmail;
    }
    public EmailResponse getEmailById(Long emailId) {
        Email email = emailManagementRepository.findById(emailId).orElseThrow(()-> new ResourceNotFoundException("EmailId : "+emailId));
        return new EmailResponse(true, "success", email);
    }
    public EmailResponse insertEmail(EmailInput emailInput) {
        Email email = emailManagementRepository.save(new Email(emailInput.getUserEmail(), emailInput.getUserProfileId(), Utils.getCurrentDate()));
        if ( email == null ) {
            return new EmailResponse(false, "email is not inserted!", null);
        }
        return new EmailResponse(true, "success", email);
    }
    public EmailResponse updateEmail(EmailInput emailInput, Long emailId) {
        Email email = emailManagementRepository.findById(emailId).orElseThrow(() -> new ResourceNotFoundException("EmailId : "+ emailId));
        email.setUserProfileId(emailInput.getUserProfileId());
        email.setModifiedOn(Utils.getCurrentDate());
        email.setUserEmail(emailInput.getUserEmail());
        Email emailUpdated = emailManagementRepository.save(email);
        return new EmailResponse(true,"success", emailUpdated);
    }
    public GeneralResponse deleteEmail(Long emailId) {
        Email email = emailManagementRepository.findById(emailId).orElseThrow(() -> new ResourceNotFoundException("EmailId: "+ emailId));
        emailManagementRepository.delete(email);
        return new GeneralResponse(true, "deleted Successfully!");
    }
}
