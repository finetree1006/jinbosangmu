<%
//****************************************************************************************
//** FILE NAME   : /sampleSub.jsp
//** DESCRIPTION : 
//** DATABASE    :
//** AUTHOR      : ChoMooYeon
//** DATE        : 2024-08-06
//** HISTORY
//****************************************************************************************
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<jsp:include page="../include/incHead.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/assets/incUser.css" rel="stylesheet">

<body>

<script type="text/javascript">
<!--



//-->
</script>
  
<jsp:include page="../include/incTop.jsp"></jsp:include>

	<link href="/S2.User/inc/inc-sub.css" rel="stylesheet">

	<!-- CONTENT --------------------------------------------------------------------------------->

		<section class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70' data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
			<div class='container'>
				<div class='row title'>
					<h2>1:1 문의</h2>
					<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
					<div class='page-breadcrumb'><span>문의하신 질문과 답변을 볼 수 있습니다</span></div>
				</div>
			</div>
		</section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-80">
            <div class="container" id="div_sub">

				<table class="table table-bordered">
					<tr>
						<td>번호</td>
						<td>질문</td>
						<td>질문날짜</td>
						<td>답변유무</td>
					</tr>	
            
               <c:forEach var="CustomerDto" items="${customerList}" varStatus="status">
                  <tr>
                     <td>
                        ${status.count}
                     </td>
                     
                     <td>
                        <a href='./detail?customerNo=${CustomerDto.customerNo}'>
                           ${CustomerDto.customerQue}
                        </a>       
                     </td>
                     
                     <td>
                        ${CustomerDto.customerQdate}
                     </td>
                     
                     <td>
						<c:choose> 
							<c:when test="${CustomerDto.customerAns == null}"> 
								답변준비중
							</c:when> 
							<c:otherwise> 
								답변완료
							</c:otherwise> 
						</c:choose> 

                     </td>
                  </tr>
               </c:forEach>
            </table>

			<div class='text-center mt-5'>
				<button onclick='customerNewFnc();' class='btn btn-brown'>문의하기</button>
			</div>


		</div>
        </section>
        <!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->


<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>