package org.tnsif.accenture.c2tc.college.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.tnsif.accenture.c2tc.college.entity.College;
import org.tnsif.accenture.c2tc.college.entity.Placement;
import org.tnsif.accenture.c2tc.college.service.ICollegeService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/college")
public class CollegeController {

    private final ICollegeService collegeService;

    public CollegeController(ICollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping("/add")
    public ResponseEntity<College> addCollege(@Valid @RequestBody College college) {
        return ResponseEntity.status(HttpStatus.CREATED).body(collegeService.addCollege(college));
    }

    @PutMapping("/update")
    public ResponseEntity<College> updateCollege(@Valid @RequestBody College college) {
        return ResponseEntity.ok(collegeService.updateCollege(college));
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> searchCollege(@PathVariable long id) {
        return ResponseEntity.ok(collegeService.searchCollege(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable long id) {
        collegeService.deleteCollege(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/schedule")
    public ResponseEntity<Placement> schedulePlacement(@Valid @RequestBody Placement placement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(collegeService.schedulePlacement(placement));
    }
}
