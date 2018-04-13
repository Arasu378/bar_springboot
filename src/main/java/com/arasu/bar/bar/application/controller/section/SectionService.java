package com.arasu.bar.bar.application.controller.section;

import com.arasu.bar.bar.application.entities.Section;
import com.arasu.bar.bar.application.entities.UserLiquor;
import com.arasu.bar.bar.application.model.SectionInput;
import com.arasu.bar.bar.application.repository.SectionRepository;
import com.arasu.bar.bar.application.exception.ResourceNotFoundException;
import com.arasu.bar.bar.application.repository.UserLiquorRepository;
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
public class SectionService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private UserLiquorRepository userLiquorRepository;

    public Page<Section> getAllSectionByUserProfileId(Integer page, Integer size, Long userProfileId) {
        Page pageOfSection = sectionRepository.findSectionsByUserProfileId(userProfileId, PageRequest.of(page, size));
        return pageOfSection;
    }
    public Page<Section> getAllSectionByBarId(Integer page, Integer size, Long barId) {
        Page pageOfSection = sectionRepository.findSectionsByBarId(barId, PageRequest.of(page, size));
        return pageOfSection;
    }
    public SectionResponse getSectionBySectionId(Long sectionId) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(()-> new ResourceNotFoundException("SectionId : "+sectionId));
        return new SectionResponse(true, "success", section);
    }
    public SectionResponse insertSection(SectionInput sectionInput) {
        Section section = sectionRepository.save(new Section(sectionInput.getUserProfileId(), sectionInput.getBarId(), Utils.getCurrentDate(), sectionInput.getSectionName()));
        if ( section == null ) {
            return new SectionResponse(false, "section is not inserted!", null);
        }
        return new SectionResponse(true, "Added Successfully", section);
    }
    public SectionResponse updateSection(SectionInput sectionInput, Long sectionId) {
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("SectionId : "+ sectionId));
        section.setBarId(sectionInput.getBarId());
        section.setUserProfileId(sectionInput.getUserProfileId());
        section.setModifiedOn(Utils.getCurrentDate());
        section.setSectionName(sectionInput.getSectionName());
        Section sectionUpdated = sectionRepository.save(section);
        return new SectionResponse(true,"Updated Successfully", sectionUpdated);
    }
    public GeneralResponse deleteSection(Long sectionId) {
        deleteUserLiquorBySectionId(sectionId);
        Section section = sectionRepository.findById(sectionId).orElseThrow(() -> new ResourceNotFoundException("Section Id: "+ sectionId));
        sectionRepository.delete(section);
        return new GeneralResponse(true, "Deleted Successfully");
    }

    public void deleteUserLiquorBySectionId(Long sectionId) {
        userLiquorRepository.deleteUserLiquorsBySectionId(sectionId);
    }
}
