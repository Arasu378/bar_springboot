package com.arasu.bar.bar.application.controller.distributors;

import com.arasu.bar.bar.application.entities.Distributor;
import com.arasu.bar.bar.application.exception.ResourceNotFoundException;
import com.arasu.bar.bar.application.model.DistributorInput;
import com.arasu.bar.bar.application.repository.DistributorRepository;
import com.arasu.bar.bar.responses.DistributorResponse;
import com.arasu.bar.bar.responses.GeneralResponse;
import com.arasu.bar.bar.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DistributorService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DistributorRepository distributorRepository;

    public Page<Distributor> getAllDistributorByUserProfileId(Integer page, Integer size, Long userProfileId) {
        return distributorRepository.findAllDistributors(userProfileId, PageRequest.of(page,size));
    }
    public DistributorResponse getDistributorById(Long distributorId) {
        Distributor distributor = distributorRepository.findById(distributorId).orElseThrow(() -> new ResourceNotFoundException("Distributor Id  : "+ distributorId));
        return new DistributorResponse(true, "success", distributor);
    }
    public DistributorResponse insertDistributor(DistributorInput distributorInput ) {
        Distributor distributor = distributorRepository.save(new Distributor(distributorInput.getDistributorName(), distributorInput.getUserProfileId(), distributorInput.getEmail(), distributorInput.getMobile(), distributorInput.getAddress(), Utils.getCurrentDate()));
        if (distributor == null) {
            return new DistributorResponse(false, "distributor is not inserted!", null);
        }
        return new DistributorResponse(true, "success", distributor);
    }
    public DistributorResponse updateDistributor(DistributorInput distributorInput, Long distributorId) {
        Distributor distributor = distributorRepository.findById(distributorId).orElseThrow(() -> new ResourceNotFoundException("Distributor Id : : "+ distributorId));
        distributor.setDistributorName(distributorInput.getDistributorName());
        distributor.setUserProfileId(distributorInput.getUserProfileId());
        distributor.setEmail(distributorInput.getEmail());
        distributor.setMobile(distributorInput.getMobile());
        distributor.setAddress(distributorInput.getAddress());
        distributor.setModifiedOn(Utils.getCurrentDate());
        Distributor distributorUpdate = distributorRepository.save(distributor);
        return new DistributorResponse(true, "success", distributorUpdate);
    }
    public GeneralResponse deleteDistributor(Long distributorId) {
        Distributor distributor = distributorRepository.findById(distributorId).orElseThrow(() -> new ResourceNotFoundException("Distributor ID : "+ distributorId));
        distributorRepository.delete(distributor);
        return new GeneralResponse(true,"successfully deleted!");
    }

}
