package cn.cqisy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.cqisy.domain.LinkMan;
import cn.cqisy.service.LinkManService;
import cn.cqisy.service.impl.LinkManServiceImpl;

public class ListLinkManServlet extends HttpServlet {
	LinkManService lms = new LinkManServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获得查询条件是否存在
		String lkm_name = request.getParameter("lkm_name");
		//2.判断查询条件是否不为空
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if(lkm_name!=null && !lkm_name.trim().equals("")) {
			dc.add(Restrictions.like("lkm_name", "%" + lkm_name + "%"));
		}
		List<LinkMan> list = lms.getAll(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
