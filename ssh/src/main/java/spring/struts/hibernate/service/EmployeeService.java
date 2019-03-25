package spring.struts.hibernate.service;

import spring.struts.hibernate.entity.Employee;
import spring.struts.hibernate.entity.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	void update(Employee employee);

	Employee findById(Integer eid);

	void delete(Employee employee);

}
