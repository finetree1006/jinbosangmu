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

	<!-- CONTENT --------------------------------------------------------------------------------->

<jsp:useBean id="memberDto"
   scope="request"
   class="jbsm.user.member.dto.MemberDto"/>

		<section class='inner-intro dark-bg bg-image overlay-dark parallax parallax-background1 overlay-dark70' data-background-img='http://sjd03.godohosting.com/S2.User/img/sub-introduce.jpg'>
			<div class='container'>
				<div class='row title'>
					<h2>정보 변경</h2>
					<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
					<div class='page-breadcrumb'><span>정보변경 임다</span></div>
				</div>
			</div>
		</section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-80">
            <div class="container" id="div_sub">

				<h1>회원정보</h1>
			<form action='./modify' method='post'>
				<input type='hidden' name='memberNo' class='form-control'
					value='${memberDto.memberNo}'> 
					
				<label>이름</label> 
				<input type='text' name='memberName' class='form-control'
					value='${memberDto.memberName}'> 
					
				<label>전화번호</label>
				<select name='phoneNum1' id='phoneNum1'
					class='form-select text-center' style="width: 100px">
					<option value='010'>010</option>
					<option value='011'>011</option>					
				</select> 
				<input type='text' name='phoneNum2' id='phoneNum2' value=''
					style='width: 150px;' maxlength="4" class='form-control'> 	
				<input type='text' name='phoneNum3' id='phoneNum3' value=''
					style='width: 150px;' maxlength="4" class='form-control'> 
					
				<label>우편번호</label>
				<input type='text' name='memberZip' class='form-control'
					value='${memberDto.memberZip}'> 
					
				<label>주소</label>
				<input type='text' name='memberAddr1' class='form-control'
					value='${memberDto.memberAddr1}'>
					
				<label>상세주소</label>
				<input type='text' name='memberAddr2' class='form-control'
					value='${memberDto.memberAddr2}'>
					
				<input type='submit' value='정보 수정' class='btn btn-brown'> 
				<input type='button' value='취소' onclick='pageMoveListFnc();' class='btn btn-brown'>
			</form>

		</div>
        </section>
        <!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->


<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>