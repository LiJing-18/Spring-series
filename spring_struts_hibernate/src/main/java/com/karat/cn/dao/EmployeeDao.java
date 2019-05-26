package com.karat.cn.dao;

import java.util.List;

import com.karat.cn.entity.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	void update(Employee employee);

	Employee findById(Integer eid);

	void delete(Employee employee);

}
