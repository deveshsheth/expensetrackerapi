package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CategoryEntity;


@Repository
public interface CategoryRepository extends  JpaRepository<CategoryEntity, Long> {
	
	CategoryEntity findByCategoryname(String categoryname);
	
	List<CategoryEntity> findByCategoryid(Long categoryid);
	
	
}
