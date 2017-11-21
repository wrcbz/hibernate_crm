package cn.cqisy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import cn.cqisy.dao.LinkManDao;
import cn.cqisy.domain.LinkMan;
import cn.cqisy.utils.HibernateUtils;

public class LinkManDaoImpl implements LinkManDao {

	public void save(LinkMan lm) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(lm);
	}

	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria c = dc.getExecutableCriteria(session);
		return c.list();
	}

}
