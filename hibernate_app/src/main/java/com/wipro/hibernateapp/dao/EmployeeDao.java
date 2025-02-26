package com.wipro.hibernateapp.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.wipro.hibernateapp.entity.Employee;
import com.wipro.hibernateapp.entity.Student;
import com.wipro.hibernateapp.util.HibernateUtil;


public class EmployeeDao {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	public EmployeeDao() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public Employee addEmployee(Employee employee) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
		return employee;
	}
	public List<Employee> getEmployees(){
		session = sessionFactory.openSession();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> list = query.list();
		return list;
	}
	
	public List<Employee> getEmployeeByDepartment(String dept){
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("department", dept));
		criteria.addOrder(Order.desc("empName"));
		criteria.setMaxResults(3);
		return criteria.list();
	}

	public void addStudent(Student std) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(std);
		transaction.commit();
		session.close();
	}

	public List<Student> getStudents() {
		return sessionFactory.openSession().createQuery("from Student").list();
	}
}
