package cn.cqisy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.cqisy.domain.Customer;
import cn.cqisy.service.CustomerService;
import cn.cqisy.service.impl.CustomerServiceImpl;

public class ListCustomerServlet extends HttpServlet {
	private CustomerService cs = new CustomerServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.获得查询条件
		String cust_name = request.getParameter("cust_name");
		//2.判断查询条件是否不为空
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if(cust_name!=null && !cust_name.trim().equals("")) {
			dc.add(Restrictions.like("cust_name", "%" + cust_name + "%"));
			 
		} 
		List<Customer> list = cs.getAll(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
