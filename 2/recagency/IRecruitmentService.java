package com.recruitment.service;

import java.util.List;
import java.util.Map;

import com.recruitment.exception.CandidateAlreadyExistsException;
import com.recruitment.model.Candidate;

public interface IRecruitmentService {
	
	public Candidate registerCandidate(Candidate candidate) throws CandidateAlreadyExistsException;
	
	public Map<String,List<Candidate>> viewCandidateBasedonPosition();
	
	public List<Candidate> filterCandidate(int yearsOfExperience);
	public int removeCandidate() ;

}
