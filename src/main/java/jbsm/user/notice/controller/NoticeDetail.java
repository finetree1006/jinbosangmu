package jbsm.user.notice.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jbsm.user.notice.dao.NoticeDao;
import jbsm.user.notice.dto.NoticeDto;

@WebServlet(urlPatterns = {"/notice/detail"})
public class NoticeDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			
			ServletContext sc = this.getServletContext();

			conn = (Connection)sc.getAttribute("conn");			
			
			NoticeDao noticeDao = new NoticeDao();
			noticeDao.setConnection(conn);
			
			NoticeDto noticeDto = noticeDao.noticeSelectOne(noticeNo);
			
			request.setAttribute("noticeDto", noticeDto);
			RequestDispatcher rd = 
					request.getRequestDispatcher("./NoticeDetail.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/common/Error.jsp");
			
			dispatcher.forward(request, response);
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				
	}
	
}
