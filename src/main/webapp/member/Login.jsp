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
					<h2>로그인</h2>
					<span class='sd-1 sd-sm sd-thick-3px sd-center'></span>
					<div class='page-breadcrumb'><span>진보상무에 어서오세요!</span></div>
				</div>
			</div>
		</section>

        <!-- Content Section -->
        <section class="ptb ptb-sm-80">
            <div class="container" id="div_sub" style='height: 400px'>

				<%
				String loginCheck = request.getParameter("loginCheck");
				%>
			 	
				<div class='loginDiv'>
					<h2>사용자 로그인</h2>
					<form action="./login" method="post" onsubmit="return loginCheckFnc()">
						<div class="mb-3 mt-3">
				      		<label for="email">Email</label>
					      	<input type="email" class="form-control" id="memberEmail" placeholder="ex:hong@test.com" name="memberEmail">
					    </div>
					    <div class="mb-3">
					      	<label for="pwd">Password</label>
					      	<input type="password" class="form-control" id="memberPw" placeholder="Enter password" name="memberPw">
							<input type='hidden' name='securePw' id='securePw' value=''>
					    </div>
						<br>
						<input type="submit" value="로그인" class="btn btn-brown">
					</form>
					<button onclick="memberAddFnc()" value="회원가입" class="btn btn-brown">
						회원가입
					</button>
					<form>
						<input type='hidden' id='loginCheck' value='<%=loginCheck %>'>
					</form>
				</div>

            </div>
        </section>
        <!-- End Content Section -->

	<!-- END CONTENT ---------------------------------------------------------------------------->

  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/core.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/sha256.js"></script>

<jsp:include page="../include/incFooter.jsp"></jsp:include>
		
<jsp:include page="../include/incClose.jsp"></jsp:include>