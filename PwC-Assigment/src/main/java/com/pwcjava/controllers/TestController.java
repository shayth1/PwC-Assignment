package com.pwcjava.controllers;

import com.pwcjava.models.Departments;
import com.pwcjava.models.Project;
import com.pwcjava.models.User;

import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pwcjava.repository.DepartmentsRepository;
import com.pwcjava.repository.UserRepository;
import com.pwcjava.repository.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Pageable;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {


	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DepartmentsRepository departmentsRepository;

	@Autowired
	private ProjectRepository projectRepository;


	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}


	@GetMapping("/users")
//	@PreAuthorize("hasRole('ADMIN')")
	public List<User> getAllEmployees() {
		return userRepository.findAll();
	}


	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
		userRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);

	} catch (Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	}


	@PutMapping("/editUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> tutorialData = userRepository.findById(id);

		if (tutorialData.isPresent()) {
			User _user = tutorialData.get();
			_user.setEmail(user.getEmail());
			_user.setDepartment(user.getDepartrment());
			_user.setUsername(user.getUsername());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getDepartments")
//	@PreAuthorize("hasRole('ADMIN')")
	public List<Departments> getAllDepartments() {
		return departmentsRepository.findAll();
	}


	@PutMapping("/editDepartment/{id}")
	public ResponseEntity<Departments> updateDep(@PathVariable("id") long id, @RequestBody Departments departments) {
		Optional<Departments> tutorialData = departmentsRepository.findById(id);

		if (tutorialData.isPresent()) {
			Departments _dep = tutorialData.get();
			_dep.setDep_email(departments.getDep_email());
			_dep.setDep_name(departments.getDepname());
			_dep.setManager(departments.getManager());
			return new ResponseEntity<>(departmentsRepository.save(_dep), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteDep/{id}")
	public ResponseEntity<HttpStatus> deleteDep(@PathVariable("id") long id) {
		try {
			departmentsRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/getProjects")
//	@PreAuthorize("hasRole('ADMIN')")
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@PutMapping("/editProject/{id}")
	public ResponseEntity<Project> updateDep(@PathVariable("id") long id, @RequestBody Project project) {
		Optional<Project> tutorialData = projectRepository.findById(id);

		if (tutorialData.isPresent()) {
			Project _pro = tutorialData.get();
			_pro.setProM(project.getProM());
			_pro.setProS(project.getProS());
			_pro.setProN(project.getProN());
			return new ResponseEntity<>(projectRepository.save(_pro), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteProject/{id}")
	public ResponseEntity<HttpStatus> deletePro(@PathVariable("id") long id) {
		try {
			projectRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Autowired
	private UserRepository employeeData;

	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<User> employeesPageable(Pageable pageable) {
		return employeeData.findAll(pageable);

	}







//	@GetMapping("/depUsers/{id}")





}


