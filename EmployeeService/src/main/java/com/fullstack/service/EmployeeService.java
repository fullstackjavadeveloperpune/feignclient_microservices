package com.fullstack.service;

import com.fullstack.entity.Employee;
import com.fullstack.repository.EmployeeRepository;
import com.fullstack.vo.Department;
import com.fullstack.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentClient departmentClient;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {
        Employee employee = employeeRepository.findByEmpEmailIdAndEmpPassword(empEmailId, empPassword);

        boolean flag = false;

        if (employee != null) {
            flag = true;
        }

        return flag;
    }

    public ResponseVO findById(long empId) {
        ResponseVO responseVO = new ResponseVO();

        Employee employee = employeeRepository.findByEmpId(empId);

        responseVO.setEmployee(employee);

        Department department = departmentClient.findById(employee.getDeptId());

        responseVO.setDepartment(department);

        return responseVO;
    }
}
