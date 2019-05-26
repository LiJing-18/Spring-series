package com.karat.cn.service;

import com.karat.cn.entity.Employee;
import com.karat.cn.entity.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	void update(Employee employee);

	Employee findById(Integer eid);

	void delete(Employee employee);

}
