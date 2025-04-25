package com.fullstack.controller;

import com.fullstack.entity.Department;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.service.DepartmentService;
import jakarta.ws.rs.DELETE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<Department> save(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.save(department));
    }

    @GetMapping("/findbyid/{deptId}")
    public ResponseEntity<Optional<Department>> findById(@PathVariable long deptId) {
        return ResponseEntity.ok(departmentService.findById(deptId));
    }

    @GetMapping("/findbyname")
    public ResponseEntity<Department> findByName(@RequestParam(defaultValue = "HR", required = false) String deptName) {
        return ResponseEntity.ok(departmentService.findByName(deptName));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Department>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @PutMapping("/update/{deptId}")
    public ResponseEntity<Department> update(@PathVariable long deptId, @RequestBody Department department) {
        Department department1 = departmentService.findById(deptId).orElseThrow(() -> new RecordNotFoundException("Department ID Does Not Exist"));

        department1.setDeptName(department.getDeptName());
        department1.setDeptCode(department.getDeptCode());
        department1.setDeptStartDate(department.getDeptStartDate());

        return ResponseEntity.ok(departmentService.update(department1));
    }

    @DeleteMapping("/deletebyid/{deptId}")
    public ResponseEntity<String> deleteById(@PathVariable long deptId) {
        departmentService.deleteById(deptId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
