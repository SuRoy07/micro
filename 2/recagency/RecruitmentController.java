package com.recruitment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.exception.CandidateAlreadyExistsException;
import com.recruitment.model.Candidate;
import com.recruitment.service.IRecruitmentService;


@RestController
public class RecruitmentController {
	
	@Autowired
	private IRecruitmentService service;
	
	@PostMapping(value = "/register",produces = "application/json")
	public Candidate registerCandidate(@RequestBody @Validated Candidate candidate) throws CandidateAlreadyExistsException {	 	  	    	    		        	 	
		System.out.println("registerrrrrrrrrrrrrrrrrrrrrrrr");
		return service.registerCandidate(candidate);
	}
	
	@GetMapping(value="/view",produces = "application/json")
	public Map<String,List<Candidate>> viewCandidateBasedonPosition(){
		System.out.println("viewwwwwwwwww");
		return service.viewCandidateBasedonPosition();
		
	}
	
	@GetMapping(value="/filter/{yearsOfExperience}",produces = "application/json")
	public List<Candidate> filterCandidate(@PathVariable int yearsOfExperience){
		System.out.println("filterrrrrrrrrrrrrrrrr");
		return service.filterCandidate(yearsOfExperience);
		
	}
	
	@DeleteMapping(value="/remove")
	public int removeCandidate() {
		System.out.println("removeeeeeeeeeeeeeeeeeeee");
		return service.removeCandidate();
	}

}
	 	  	    	    		        	 	
