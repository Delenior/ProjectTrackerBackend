package com.example.demo.RestController;

import com.example.demo.Model.Project;
import com.example.demo.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/project")
@CrossOrigin
public class ProjectRestController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping(path = "/all")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping(path="/get/{id}")
    public Optional getOneById(@PathVariable String id) {
        return Optional.of(projectRepository.findById(id));
    }

    @PostMapping(path = "/new")
    public Project saveProject(@RequestBody Project project) {
        projectRepository.insert(project);
        return project;
    }

    @PutMapping(path = "/update")
    public Optional updateProject(@RequestBody Project project) {
        projectRepository.save(project);
        return projectRepository.findById(project.getId());
    }

    @DeleteMapping(path = "/delete/{id}")
    public List<Project> delete(@PathVariable String id) {
        projectRepository.deleteById(id);
        return projectRepository.findAll();
    }
}
