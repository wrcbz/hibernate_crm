package cn.cqisy.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.cqisy.domain.Customer;
import cn.cqisy.domain.LinkMan;

public interface LinkManDao {

	void save(LinkMan lm);

	List<LinkMan> getAll(DetachedCriteria dc);


}
