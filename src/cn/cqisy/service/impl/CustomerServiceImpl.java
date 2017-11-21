package cn.cqisy.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.cqisy.dao.CustomerDao;
import cn.cqisy.dao.impl.CustomerDaoImpl;
import cn.cqisy.domain.Customer;
import cn.cqisy.service.CustomerService;
import cn.cqisy.utils.HibernateUtils;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	public void save(Customer c) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			customerDao.save(c);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}

	public List<Customer> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list = customerDao.getAll();
		tx.commit();
		return list;
	}

	public List<Customer> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> list = customerDao.getAll(dc);
		tx.commit();
		return list;
	}

}
