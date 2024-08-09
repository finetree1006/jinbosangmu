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

@WebServlet(value = "/member/delete")
public class MemberDelete extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      Connection conn = null;
      
      try {
    	 ServletContext sc = this.getServletContext();
          
         int memberNo = Integer.parseInt(request.getParameter("memberNo"));
         
         conn = (Connection)sc.getAttribute("conn");
         
         MemberDao memberDao = new MemberDao();
         memberDao.setConnection(conn);
         
         int result = memberDao.memberDelete(memberNo);
         
         if(result == 0) {
        	 System.out.println("회원 삭제가 정상처리 되지 않았습니다.");
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
   
   @Override
   protected void doPost(HttpServletRequest requset, HttpServletResponse response) 
      throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      
      
   }
   
}
