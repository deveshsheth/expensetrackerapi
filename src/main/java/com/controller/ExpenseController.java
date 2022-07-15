package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.entity.CategoryEntity;
import com.entity.ExpenseEntity;
import com.repository.ExpenseRepository;

@RestController
@CrossOrigin
public class ExpenseController {

	@Autowired
	ExpenseRepository expenseRepo;
	
	@PostMapping("saveexpense")
	public ResponseBean<ExpenseEntity> addExpense(@RequestBody ExpenseEntity expense) {
		ResponseBean<ExpenseEntity> response = new ResponseBean<>();

		if (expense != null) {
			
			expenseRepo.save(expense);
			response.setData(expense);
			response.setMessage("Expense Added Successfully ");
			response.setStatus(200);
		} else {
			response.setMessage("Some Data is Missing");
			response.setStatus(201);
		}

		return response;

	}

	
}
