package com.karat.cn.entity;

import java.util.HashSet;
import java.util.Set;

public class Department implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer did;
	private String dname;
	private String ddesc;
	private Set<Employee> employees = new HashSet<Employee>();

	
	public Department() {
	}

	
	@SuppressWarnings("unchecked")
	public Department(String dname, String ddesc, @SuppressWarnings("rawtypes") Set employees) {
		this.dname = dname;
		this.ddesc = ddesc;
		this.employees = employees;
	}

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdesc() {
		return this.ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
	}

	@SuppressWarnings("rawtypes")
	public Set getEmployees() {
		return this.employees;
	}

	@SuppressWarnings("unchecked")
	public void setEmployees(@SuppressWarnings("rawtypes") Set employees) {
		this.employees = employees;
	}

	

}