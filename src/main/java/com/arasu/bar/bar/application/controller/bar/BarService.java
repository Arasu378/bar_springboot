package com.arasu.bar.bar.application.controller.bar;

import com.arasu.bar.bar.application.entities.Bar;
import com.arasu.bar.bar.application.entities.UserLiquor;
import com.arasu.bar.bar.application.model.BarInput;
import com.arasu.bar.bar.application.model.BarUpdate;
import com.arasu.bar.bar.application.repository.BarRepository;
import com.arasu.bar.bar.application.exception.ResourceNotFoundException;
import com.arasu.bar.bar.application.repository.SectionRepository;
import com.arasu.bar.bar.application.repository.UserLiquorRepository;
import com.arasu.bar.bar.responses.BarResponse;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class BarService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BarRepository barRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private UserLiquorRepository userLiquorRepository;


    public Page<Bar> getAllBars(Integer page, Integer size, Long userProfileId) {
        Page pageOfBar = barRepository.findBarsByUserProfileId(userProfileId, PageRequest.of(page,size));
        return pageOfBar;
    }
    public BarResponse getBarByBarId(Long barId) {
        Bar bar = barRepository.findById(barId).orElseThrow(()-> new ResourceNotFoundException("Bar Id: "+barId));
        return new BarResponse(true, "success", bar);
    }
    public BarResponse insertBar(BarInput barInput) {
        Bar bar = barRepository.save(new Bar(barInput.getUserProfileId(), barInput.getBarName(), Utils.getCurrentDate(),null));
        if (bar == null) {
            return  new BarResponse(false, "bar not inserted!", null);
        }
        return new BarResponse(true, "Added Successfully", bar);
    }
    public BarResponse updateBar(BarUpdate barInput, Long barId) {
        Bar barUpdate = barRepository.findById(barId).orElseThrow(() -> new ResourceNotFoundException("BarId : "+ barId));
            barUpdate.setBarName(barInput.getBarName());
            barUpdate.setUserProfileId(barInput.getUserProfileId());
            barUpdate.setModifiedOn(Utils.getCurrentDate());

        Bar bar = barRepository.save(barUpdate);
        return new BarResponse(true, "Updated Successfully", bar);
    }
    public GeneralResponse deleteBar(Long barId) {
        deleteUserLiquorByBarId(barId);
        deleteSectionByBarId(barId);
        Bar bar = barRepository.findById(barId).orElseThrow(() -> new ResourceNotFoundException("BarId : "+ barId));
         barRepository.delete(bar);
         return new GeneralResponse(true, "Deleted Successfully!");
    }
    public void deleteUserLiquorByBarId(Long barId) {
        userLiquorRepository.deleteUserLiquorsByBarId(barId);
    }
    public void deleteSectionByBarId(Long barId) {
        sectionRepository.deleteSectionsByBarId(barId);
    }


}
