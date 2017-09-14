package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entity.Nav;
import com.sql.SqlHelper;
import com.tools.MyFuns;

public class InsertNav extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertNav() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        String nav_name=request.getParameter("nav_name");
		String nav_feight_str=request.getParameter("nav_feight");
		System.out.println(nav_name+"=========="+nav_feight_str);
		if(nav_name==null||nav_feight_str==null){
			System.out.println("1==========");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE></TITLE></HEAD>");
			out.println("  <BODY>");
			out.print(" 请把信息输入完整。<a href=\"addNav.jsp\">返回重新输入。</a> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
			return;
		}
		int nav_feight=0;
		try{
			System.out.println("2==========");
		nav_feight=Integer.parseInt(nav_feight_str);
		}catch(Exception e){
			System.out.println("3==========");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE></TITLE></HEAD>");
			out.println("  <BODY>");
			out.print(" 输入的信息有误。<a href=\"addNav.jsp\">返回重新输入。</a> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
		
		String nav_id=UUID.randomUUID().toString();
		
		Nav nav=new Nav();
		System.out.println("8=========");
		nav.setNav_id(nav_id);
		System.out.println("9=========");
		nav.setNav_feight(nav_feight);
		nav.setNav_name(MyFuns.convert2utf8(nav_name));
		SqlHelper sqlHelper=new SqlHelper();
		boolean a=sqlHelper.insertNav(nav);
		System.out.println(a+"a=========");
		sqlHelper.desttroy();
		if(!a){
			System.out.println("4==========");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE></TITLE></HEAD>");
			out.println("  <BODY>");
			out.print(" 增加类别错误。<a href=\"addNav.jsp\">返回重新输入。</a> ");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}else{
			System.out.println("5==========");
			response.sendRedirect("navList.jsp");
		}
		
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
