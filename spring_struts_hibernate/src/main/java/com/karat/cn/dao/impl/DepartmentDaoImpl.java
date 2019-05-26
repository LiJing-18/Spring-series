package com.karat.cn.dao.impl;

import java.util.List;

import com.karat.cn.dao.DepartmentDao;
import com.karat.cn.entity.Department;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

/**
 * 部门管理的Dao层实现类
 * @author 开发
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Department";
		@SuppressWarnings("unchecked")
		List<Long> list =(List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		// 查询分页数据
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	/**
	 * Dao中添加部门的实现方法
	 */
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}
	/**
	 * 根据id查询部门的Dao实现
	 */
	@Override
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}
	/**
	 * Dao中更新部门的实现方法
	 */
	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}
	/**
	 * Dao中删除部门的实现方法
	 */
	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
	}
	/**
	 * Dao 查询所有部门
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}
}
