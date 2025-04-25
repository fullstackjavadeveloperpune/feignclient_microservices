package com.fullstack.service;

import com.fullstack.vo.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DepartmentService", url = "http://localhost:2021/departments")
public interface DepartmentClient {

    @GetMapping("/findbyid/{deptId}")
    public Department findById(@PathVariable long deptId);


}
