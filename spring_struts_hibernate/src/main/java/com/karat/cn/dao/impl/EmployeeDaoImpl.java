package com.karat.cn.dao.impl;

import java.util.List;

import com.karat.cn.entity.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.karat.cn.dao.EmployeeDao;

/**
 * 员工实现的Dao类
 * @author 开发
 *
 */

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	/**
	 * Dao中根据用户名和密码查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where username=? and password=?";
		List<Employee> employeeList = (List<Employee>) this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(employeeList.size()>0){
			// 查到数据返回第一个
			System.out.println(employeeList.get(0).getEname()+"查找成功");
			return employeeList.get(0);
		}
		return null;
	}
	/**
	 * Dao层查询总员工数的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	/**
	 * Dao中查询指定页的方法
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}
	/**
	 * Dao 层添加员工的保存方法
	 */
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
	}
	/**
	 * Dao中根据id查询员工
	 */
	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Employee em =this.getHibernateTemplate().get(Employee.class, eid);
		System.out.println("特定员工："+em);
		return em;
	}
	/**
	 * Dao层编辑员工
	 */
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("name: "+employee.getEname());
		System.out.println("sex: "+employee.getSex());
		this.getHibernateTemplate().update(employee);
	}
	/**
	 * Dao层删除方法
	 */
	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}
}
