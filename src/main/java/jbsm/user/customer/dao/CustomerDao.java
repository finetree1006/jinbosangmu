package jbsm.user.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jbsm.user.customer.dto.CustomerDto;
import jbsm.user.event.dto.EventDto;
import jbsm.user.member.dto.MemberDto;

public class CustomerDao {

   private Connection connection;

   public void setConnection(Connection conn) {
      this.connection = conn;
   }

   public List<CustomerDto> customerList(int memberNo) throws Exception {

      PreparedStatement pstmt = null;// 상태
      ResultSet rs = null;// 요청

      try {
         String sql = "";

         sql += "SELECT CUSTOMER_NO, CUSTOMER_MNO, CUSTOMER_QUE, CUSTOMER_ANS, CUSTOMER_QDATE, CUSTOMER_ADATE";
         sql += " FROM CUSTOMER";
         sql += " WHERE CUSTOMER_MNO = ?";     
      
         pstmt = connection.prepareStatement(sql);

         pstmt.setInt(1, memberNo);
         
         rs = pstmt.executeQuery();

         int customerNo = 0;
         int customerMno = 0;
         String customerQue = "";
         String customerAns = "";
         Date customerQdate = null;
         Date customerAdate = null;

         ArrayList<CustomerDto> customerList = new ArrayList<CustomerDto>();

         CustomerDto customerDto = null;

         while (rs.next()) {
        	customerNo = rs.getInt("CUSTOMER_NO");
        	customerNo = rs.getInt("CUSTOMER_MNO");
            customerQue = rs.getString("CUSTOMER_QUE");
            customerAns = rs.getString("CUSTOMER_ANS");
            customerQdate = rs.getDate("CUSTOMER_QDATE");
            customerAdate = rs.getDate("CUSTOMER_ADATE");

            customerDto = new CustomerDto(customerNo, customerMno, customerQue, customerAns, customerQdate, customerAdate);

            customerList.add(customerDto);
         }

         return customerList;
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
         throw e;
      } finally {
//         db 객체 메모리 해제
         try {
            if (rs != null) {
               rs.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         try {
            if (pstmt != null) {
               pstmt.close();
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      } // finally 종료

   }
   
// 고객센터 조회
	public CustomerDto customerSelectOne(int customerNo) throws Exception {
		CustomerDto customerDto = new CustomerDto();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "";

		sql += "SELECT CUSTOMER_NO, CUSTOMER_QUE, CUSTOMER_ANS, CUSTOMER_QDATE, CUSTOMER_ADATE";
		sql += " FROM CUSTOMER";
		sql += " WHERE CUSTOMER_NO = ?";

		try {
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, customerNo);

			rs = pstmt.executeQuery();

			String customerQue = "";
			String customerAns = "";
			Date customerQdate = null;
			Date customerAdate = null;


			if (rs.next()) {
				customerNo = rs.getInt("CUSTOMER_NO");
				customerQue = rs.getString("CUSTOMER_QUE");
				customerAns = rs.getString("CUSTOMER_ANS");
				customerQdate = rs.getDate("CUSTOMER_QDATE");
				customerAdate = rs.getDate("CUSTOMER_ADATE");

				customerDto = new CustomerDto(customerNo, customerQue, customerAns, customerQdate, customerAdate);
			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally 종료

		return customerDto;
	}



	// 고객센터 질문 변경
	public int customerUpdate(CustomerDto customerDto) {
		int result = 0;

		PreparedStatement pstmt = null;// 상태

		try {
			String sql = "";

			sql += "UPDATE CUSTOMER";
			sql += " SET CUSTOMER_QUE = ?, CUSTOMER_ANS = ?";
			sql += " WHERE CUSTOMER_NO = ?";

			pstmt = connection.prepareStatement(sql);

			System.out.println(customerDto.getCustomerNo());
			
			pstmt.setString(1, customerDto.getCustomerQue());
			pstmt.setString(2, customerDto.getCustomerAns());
			pstmt.setInt(3, customerDto.getCustomerNo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} // finally 종료

		return result;
	}
	

		public int customerInsert(CustomerDto customerDto) throws Exception {
			int result = 0;
			PreparedStatement pstmt = null;

			try {
				int customerMno = customerDto.getCustomerMno();
				String customerQue = customerDto.getCustomerQue();

				System.out.println(customerMno);
				
				String sql = "";

				sql = "INSERT INTO CUSTOMER (CUSTOMER_NO, CUSTOMER_MNO, CUSTOMER_QUE, CUSTOMER_QDATE) " +
	                     "VALUES (CUSTOMER_NO_SEQ.NEXTVAL, ?, ?, SYSDATE)";

				pstmt = connection.prepareStatement(sql);

				pstmt.setInt(1, customerMno);
				pstmt.setString(2, customerQue);

				result = pstmt.executeUpdate();			
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("customerDao customerInsert() 예외 발생");
			} finally {
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			return result;
		}

}