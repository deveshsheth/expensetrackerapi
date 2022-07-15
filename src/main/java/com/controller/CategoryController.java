package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bean.ResponseBean;
import com.entity.CategoryEntity;
import com.repository.CategoryRepository;

@RestController
@CrossOrigin
public class CategoryController {
	
	@Autowired
	CategoryRepository categoryRepo;

	@PostMapping("savecategory")
	public ResponseBean<CategoryEntity> addCategory(@RequestBody CategoryEntity category) {
		ResponseBean<CategoryEntity> response = new ResponseBean<>();
		CategoryEntity cate = null;
		cate=categoryRepo.findByCategoryname(category.getCategoryname());

		if(cate == null) {
			categoryRepo.save(category);
			response.setData(category);
			response.setMessage("Category Added Successfully ");
			response.setStatus(200);
			}else {
				response.setMessage("Category Already Exist..");
				response.setStatus(400);
			}

		return response;

	}
	
	@GetMapping("/listcategory")
    public ResponseBean<java.util.List<CategoryEntity>> listCategory() {
        ResponseBean<java.util.List<CategoryEntity>> response = new ResponseBean<>();

        java.util.List<CategoryEntity> cateBean = categoryRepo.findAll();
        if(cateBean != null) {
        response.setData(cateBean);
        response.setMessage("List of Category..!!");
        response.setStatus(201);
        }else {
        	 response.setMessage("Something went wrong..!!");
             response.setStatus(400);
        }
        return response;
    }

	
}
