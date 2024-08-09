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

<%-- <jsp:useBean id="noticeDto"
   	scope="request"
  	class="jbsm.user.notice.dto.NoticeDto"/> --%>

<body>

<script type="text/javascript">
<!--



//-->
</script>
  
<jsp:include page="../include/incTop.jsp"></jsp:include>


	<!-- CONTENT --------------------------------------------------------------------------------->

		<section class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70' data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
			<div class='container'>
				<div class='row title'>
					<h2>공지사항</h2>
					<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
					<div class='page-breadcrumb'><span>진보상무의 공지사항을 확인하세요!</span></div>
				</div>
			</div>
		</section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-80">
            <div class="container" id="div_sub" style='height: 400px'>

				<div class="card">
					<div class="card-header" style='font-weight: bold;'>
						${noticeDto.noticeTitle}
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">${noticeDto.noticeCdate}</li>
						<li class="list-group-item">${noticeDto.noticeContent}</li>
					</ul>
				</div>
				
				<div class='text-center mt-5'>
		        	<button onclick='noticeListFnc()' class='btn btn-brown'>목록</button>
				</div>
				
            </div>
        </section>
        
        <!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->


<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>