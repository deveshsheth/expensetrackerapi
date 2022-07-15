package com.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity()
@Table(name = "expense")
public class ExpenseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	Long expenseid;
	
//	Long userid;
	String expensename;
	Long amount;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	LocalDate expensedate;
	
	String expensecategory;
	String paymenttype;
	String comment;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "userid")
    UserEntity users;
	
}
