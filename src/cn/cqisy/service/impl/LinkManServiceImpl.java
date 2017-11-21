package cn.cqisy.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.cqisy.dao.CustomerDao;
import cn.cqisy.dao.LinkManDao;
import cn.cqisy.dao.impl.CustomerDaoImpl;
import cn.cqisy.dao.impl.LinkManDaoImpl;
import cn.cqisy.domain.Customer;
import cn.cqisy.domain.LinkMan;
import cn.cqisy.service.LinkManService;
import cn.cqisy.utils.HibernateUtils;

public class LinkManServiceImpl implements LinkManService {

	private CustomerDao cd = new CustomerDaoImpl();
	private LinkManDao lmd = new LinkManDaoImpl();
	public void save(LinkMan lm) {
		//打开事务
		Session session = HibernateUtils.getCurrentSession();
		Transaction t = session.beginTransaction();
		try {
			//根据客户id获得客户对象
			Long cust_id = lm.getCust_id();
			Customer c = cd.getById(cust_id);
			//将客户放到LinkMan中表达关系
			lm.setCustomer(c);
			//保存LinkMan
			lmd.save(lm);
		} catch (Exception e) {
			e.printStackTrace();
			//回滚事务
			t.rollback();
		}
		//提交事务
		t.commit();
	}
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction t = session.beginTransaction();
		List<LinkMan> list = lmd.getAll(dc);
		t.commit();
		return list;
	}

}
