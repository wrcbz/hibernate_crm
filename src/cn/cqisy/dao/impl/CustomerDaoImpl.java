package cn.cqisy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import cn.cqisy.dao.CustomerDao;
import cn.cqisy.domain.Customer;
import cn.cqisy.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	public void save(Customer c) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(c);
	}

	public List<Customer> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = session.createCriteria(Customer.class);
		return c.list();
	}

	public Customer getById(Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Customer c = session.get(Customer.class, cust_id);
		return c;
	}

	public List<Customer> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = dc.getExecutableCriteria(session);
		return c.list();
	}

	
}
