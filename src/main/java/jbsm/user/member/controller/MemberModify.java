package jbsm.user.member.controller;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jbsm.user.member.dao.MemberDao;
import jbsm.user.member.dto.MemberDto;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/member/modify"})
public class MemberModify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;//연결
		
		try {
			int memberNo = Integer.parseInt(request.getParameter("memberNo"));
			
			ServletContext sc = this.getServletContext();

			conn = (Connection)sc.getAttribute("conn");			
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			MemberDto memberDto = memberDao.memberSelectOne(memberNo);
			
			request.setAttribute("memberDto", memberDto);
			RequestDispatcher rd = 
					request.getRequestDispatcher("./MemberModify.jsp");
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
		
		Connection conn = null;//연결
		
		MemberDto memberDto = null;
		
		try {
			ServletContext sc = this.getServletContext();
			
			int memberNo = Integer.parseInt(request.getParameter("memberNo"));
			String memberName = request.getParameter("memberName");
			String phoneNum1 = request.getParameter("phoneNum1");
	        String phoneNum2 = request.getParameter("phoneNum2");
	        String phoneNum3 = request.getParameter("phoneNum3");
			String memberZip = request.getParameter("memberZip");
			String memberAddr1 = request.getParameter("memberAddr1");
			String memberAddr2 = request.getParameter("memberAddr2");
			
			String memberPhone = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
			
			
			memberDto = new MemberDto();
			
			memberDto.setMemberNo(memberNo);
			memberDto.setMemberName(memberName);
			memberDto.setMemberPhone(memberPhone);
			memberDto.setMemberZip(memberZip);
			memberDto.setMemberAddr1(memberAddr1);
			memberDto.setMemberAddr2(memberAddr2);
			
			conn = (Connection)sc.getAttribute("conn");
			
			MemberDao memberDao = new MemberDao();
			memberDao.setConnection(conn);
			
			int result = memberDao.memberUpdate(memberDto);
			
			if(result == 0) {
				System.out.println("회원 정보 조회가 실패하였습니다.");
			}
			
			response.sendRedirect("./logout");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/common/Error.jsp");
			
			dispatcher.forward(request, response);
		} 
				
	}
	
}
