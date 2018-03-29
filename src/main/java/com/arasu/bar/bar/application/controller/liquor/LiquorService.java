package com.arasu.bar.bar.application.controller.liquor;

import com.arasu.bar.bar.application.entities.Liquor;
import com.arasu.bar.bar.application.repository.LiquorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LiquorService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LiquorRepository liquorRepository;
    public Page<Liquor> getAllLiquor(Integer page, Integer size) {
        Page pageOfLiquor = liquorRepository.findAllBy(PageRequest.of(page, size));
        return pageOfLiquor;
    }
    public Set<String> getLiquorCategory() {
        List pageOfLiquor = liquorRepository.findAllByCategory();
        Set set = new HashSet(pageOfLiquor);
        return set;
    }
    public Page<Liquor> getAllLiquorByCategory(String category,Integer page, Integer size) {
        Page pageOfLiquor =  liquorRepository.findAllByAlcohol_type(category,PageRequest.of(page,size));
        return pageOfLiquor;
    }


}
