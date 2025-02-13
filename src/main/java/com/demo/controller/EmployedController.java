package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.request.EmployerRequest;
import com.demo.dto.response.EmployeeResponse;
import com.demo.entities.Employee;
import com.demo.service.EmployedService;

@RestController
@RequestMapping("/employed")
public class EmployedController {
	
	@Autowired
	private EmployedService service;

	
	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> findALL(){
		List<EmployeeResponse> result = service.findALL();
		return ResponseEntity.ok(result);
	}
	@PostMapping
	public  ResponseEntity<?> post(@RequestBody List<EmployerRequest> body){
		
		List<EmployeeResponse> save = service.addEmplotyed(body);
		return ResponseEntity.ok(save);
		
	}
	@DeleteMapping()
	public  ResponseEntity<?> delete( @RequestParam(name = "id") int id){
		
		service.deleteEmployed(id);
		return ResponseEntity.ok(null);
		
	}
	@PatchMapping()
	public  ResponseEntity<?> patch( @RequestParam(name = "id") int id,@RequestBody EmployerRequest body){
		
	
		return ResponseEntity.ok(service.updateEmployed(body,id));
		
	}
}
