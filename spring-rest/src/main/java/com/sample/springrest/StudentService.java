package com.sample.springrest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private Map<String,Student> studMap = new HashMap<String,Student>(); ;
	
	@PostConstruct
	private void init() {
		Student s1 = new Student("ravi","25","M");
		Student s2 = new Student("naveen","24","M");
		Student s3 = new Student("manu","24","F");
		studMap.put("ravi",s1);
		studMap.put("naveen",s2);
		studMap.put("manu",s3);
	}

	public Student getStudentDetails(String sname) {
		 return studMap.get(sname);
	}
	
	
}
