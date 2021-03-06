package mj.ita.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mj.ita.dao.ProjectRepository;
import mj.ita.entities.Project;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiControllers {


	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping
	public Iterable<Project> getProjects() {
		return proRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable("id") Long id) {
		return proRepo.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Project create(@RequestBody Project project) {
		return proRepo.save(project);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Project update(@RequestBody Project project) {
		return proRepo.save(project);
	}
	
	@PatchMapping(path="/{id}", consumes = "application/json")
	public Project partialUpdate(@PathVariable("id") Long id, @RequestBody Project patchProject) {
		Project proj = proRepo.findById(id).get();
		
		if(patchProject.getName() != null) {
			proj.setName(patchProject.getName());
		}
		
		if(patchProject.getStage() != null) {
			proj.setStage(patchProject.getStage());
		}
		
		if(patchProject.getDescription() != null) {
			proj.setDescription(patchProject.getDescription());
		}
		
		return proRepo.save(proj);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
			proRepo.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}	
}
