package com.devmarcotulio.api.controllers;

import com.devmarcotulio.api.entities.Department;
import com.devmarcotulio.api.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Department findById(@PathVariable Long id) {
        return departmentRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Department department) {
        Department departmentExists = departmentRepository.findByName(department.getName());

        if (departmentExists != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Department already exists!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(departmentRepository.save(department));
    }
}
