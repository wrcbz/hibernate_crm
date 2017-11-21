package cn.cqisy.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.cqisy.domain.LinkMan;
import cn.cqisy.service.LinkManService;
import cn.cqisy.service.impl.LinkManServiceImpl;

public class AddLinkManServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LinkManService lms = new LinkManServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LinkMan lm = new LinkMan();
		try {
			BeanUtils.populate(lm, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		lms.save(lm);
		response.sendRedirect(request.getContextPath() + "/servlet/ListLinkManServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
