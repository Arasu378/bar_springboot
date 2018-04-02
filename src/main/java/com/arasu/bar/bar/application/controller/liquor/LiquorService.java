package com.arasu.bar.bar.application.controller.liquor;

import com.arasu.bar.bar.application.entities.Liquor;
import com.arasu.bar.bar.application.model.LiquorCategory;
import com.arasu.bar.bar.application.repository.LiquorCategoryRepository;
import com.arasu.bar.bar.application.repository.LiquorRepository;
import com.arasu.bar.bar.utils.Constants;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<LiquorCategory> getLiquorCategory() {
        List<Object[]> objects = liquorRepository.findAllByCategory();
        List<LiquorCategory>categoryList = new ArrayList<>();
        for (Object[] obj: objects) {
        LiquorCategory liquorCategory = new LiquorCategory();
            liquorCategory.setCategoryName(obj[0].toString());
        liquorCategory.setPictureId(Long.parseLong(obj[1].toString()));
        liquorCategory.setPictureURL(Constants.PICTURE_URL+Long.parseLong(obj[1].toString()));
        categoryList.add(liquorCategory);
        }

        return categoryList;
    }
    public Page<Liquor> getAllLiquorByCategory(String category,Integer page, Integer size) {
        Page pageOfLiquor =  liquorRepository.findAllByAlcohol_type(category,PageRequest.of(page,size));
        return pageOfLiquor;
    }


}
