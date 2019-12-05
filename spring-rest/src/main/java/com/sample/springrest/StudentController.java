package com.sample.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	private StudentService studService;
	
	@GetMapping("/getStud/{sname}")
	public ResponseEntity<Student> getStudent(@PathVariable final String sname) throws Exception {
		
		if(sname == null || (sname != null && sname.trim().equals(""))){
			throw new CustException("invalid student search, Student Name = "+sname);
		}
		Student std = studService.getStudentDetails(sname);
		
		if(std == null){
			throw new Exception("Internal Server Issue");
		}
		ResponseEntity<Student> resEntity = new ResponseEntity<Student>(std, HttpStatus.OK);
		return resEntity;
	}

	@GetMapping("/")
	public void getRoot() throws Exception {
		throw new Exception("Resource is not avaliable");
	}	
}
