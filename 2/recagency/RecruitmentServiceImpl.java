package com.recruitment.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.recruitment.exception.CandidateAlreadyExistsException;
import com.recruitment.model.Candidate;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class RecruitmentServiceImpl implements IRecruitmentService {

	private static List<Candidate> candidateList=new ArrayList<Candidate>();
	
	
	public RecruitmentServiceImpl() {
		System.out.println("in serviceeeeeeeeeeeeeeeeeeee"+candidateList.size());
		candidateList.add(new Candidate("111", "sudhac", "9876543210", "sudha@gmail.com", "Manager", 10, 500000.0, "not recruited"));
		candidateList.add(new Candidate("222", "sharvin", "9876543211", "sharvin@gmail.com", "HR", 9, 500000.0, "not recruited"));
		candidateList.add(new Candidate("322", "vishahan", "9876593411", "vishahan@gmail.com", "HR", 10, 500000.0, "recruited"));
		candidateList.add(new Candidate("444", "arav", "9876593211", "arav@gmail.com", "Manager", 10, 500000.0, "recruited"));
	}
	
	/*
	 * This method should add the candidate object to the candidateList, before adding it shoulkd check
	 * whether the email id of the candidate is already available, if available throw an exception
	 * else add the candidate object into the list
	 */
	public Candidate registerCandidate(Candidate candidate) throws CandidateAlreadyExistsException {	 	  	    	    		        	 	
		
		for(Candidate c:candidateList) {
			if(c!=null && c.getEmailId().equals(candidate.getEmailId())){
				log.error("Candidate already exists with us");
				throw new CandidateAlreadyExistsException("Candidate already exists with us");
			}
		
		}
		log.info("Candidate with id "+ candidate.getCandidateId()+" registered successfully");
		candidateList.add(candidate);
		return candidate;
		
	}

	/*
	 * This method should return the Map as position applied for as a key and list of candidates who applied for that position as value.
	 */
	public Map<String, List<Candidate>> viewCandidateBasedonPosition() {
		// TODO Auto-generated method stub
Map<String,List<Candidate>> temp=new HashMap<String, List<Candidate>>();
		
		for(Candidate c : candidateList)
		{
			String position=c.getPositionAppliedFor();
			if(!temp.containsKey(position)){
				temp.put(position,new ArrayList());
			}
			List<Candidate> list=temp.get(position);
			list.add(c);
			temp.put(position, list);
		}		
		log.info("View candidate based on position is successful");
		return temp;
		
	}

	/*
	 * This method should accept the years of experience as input and it should  
	 *  iterate the candidateList and return the list of candidates who have that experience.
	 */
	public List<Candidate> filterCandidate(int yearsOfExperience) {	 	  	    	    		        	 	
		System.out.println("sizeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee:"+candidateList.size());
		List<Candidate> cList=new ArrayList<Candidate>();
		for(Candidate c:candidateList) {
			if(c!=null && c.getYearsOfExperience()==yearsOfExperience){
				cList.add(c);
			}
			
		}
		log.info("View candidate based on the experience is successfully done");
		return cList;
	}

	
	/*
	 * This method should remove the candidate based on the status. 
	 * If the status is recruited then remove all those candidates.
	 * This method should return the number of candidates removed.
	 */
	public int removeCandidate() {
		// TODO Auto-generated method stub
		int count=0;
		 Iterator i = candidateList.iterator();
	      Candidate d;
	      while (i.hasNext()) {
	         d = (Candidate) i.next();
	         if (d.getStatus().equals("recruited")) {
	            i.remove();
	           count++;
	         }
	      }
		
	      log.info(count+" candidate recruited via Employ Me");
		return count;
	}

	public static List<Candidate> getCandidateList() {	 	  	    	    		        	 	
		return candidateList;
	}

	public static void setCandidateList(List<Candidate> candidateList) {
		RecruitmentServiceImpl.candidateList = candidateList;
	}

	
	

	
}
