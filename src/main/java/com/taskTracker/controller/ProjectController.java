package com.taskTracker.controller;

import com.taskTracker.api.request.RequestProject;
import com.taskTracker.model.Project;
import com.taskTracker.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@Tag(name = "Project controller")
public class ProjectController {

    private final ProjectService projectService;

    @Operation(summary = "create project")
    @PostMapping("/projects")
    public ResponseEntity<Long> create(@RequestBody RequestProject requestProject) {
        return new ResponseEntity<>(projectService.create(requestProject), HttpStatus.OK);
    }

    @Operation(summary = "view project")
    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> view(@PathVariable long id) {
        return new ResponseEntity<>(projectService.view(id), HttpStatus.OK);
    }

    @Operation(summary = "update project")
    @PutMapping("/projects/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody RequestProject requestProject) throws Exception {
        projectService.update(id, requestProject);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Operation(summary = "delete project")
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        projectService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
