package cn.cqisy.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.cqisy.domain.LinkMan;

public interface LinkManService {

	void save(LinkMan lm);

	List<LinkMan> getAll(DetachedCriteria dc);

}
