package spring.struts.hibernate.service;

import java.util.List;

import spring.struts.hibernate.entity.Department;
import spring.struts.hibernate.entity.PageBean;
/**
 *  部门管理的业务层接口实现类
 * @author 开发
 *
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	void update(Department department);

	Department findById(Integer did);

	void delete(Department department);

	List<Department> findAll();


}
