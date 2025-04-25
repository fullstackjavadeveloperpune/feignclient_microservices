package com.fullstack.service;

import com.fullstack.DepartmentServiceApplication;
import com.fullstack.entity.Department;
import com.fullstack.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> findById(long deptId) {
        return departmentRepository.findById(deptId);
    }

    public Department findByName(String deptName) {
        return departmentRepository.findByDeptName(deptName);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteById(long deptId) {
        departmentRepository.deleteById(deptId);
    }
}
