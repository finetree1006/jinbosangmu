/**
 * 
 */
/*헤더 함수*/
function top_user_login(){
	location.href = "../member/login";
}

/*로그인이 필요한 경우 로그인 창으로 이동*/
function sendLoginFnc() {
	alert("로그인이 필요합니다");
	location.href = "../member/login";
}

/*로그인 체크*/
function loginCheckFnc() {
	var loginCheck = document.getElementById("loginCheck").value;
	let memberEmail = document.getElementById('memberEmail').value;
	let memberPw = document.getElementById('memberPw').value;
	
	let securePw = null;
	securePw = CryptoJS.SHA256(memberPw);
	document.getElementById('securePw').value = securePw;
	
	if(memberEmail.length < 1){
		alert("이메일을 입력하세요");
		return false;
	}
	
	if(memberPw.length < 1){
		alert("비밀번호를 입력하세요");
		return false;
	}

}

/*로그인 실패*/
function loginFnc() {		
	location.href = '<%=request.getContextPath()%>/member/LoginForm.jsp';
}

/*로그아웃*/
function top_user_logout() {
	location.href = "../member/logout";
}

/*회원 정보수정 이동*/
function top_user_modify(no) {
	location.href = "../member/modify?memberNo="+no;
}

/*회원가입 체크*/
function memberNewCheckFnc(){
	let memberEmail = document.getElementById('memberEmail').value;
	let memberName = document.getElementById('memberName').value;
	let memberPw = document.getElementById('memberPw').value;
	let memberPwc = document.getElementById('memberPwc').value;
	let phoneNum2 = document.getElementById('phoneNum2').value;
	let phoneNum3 = document.getElementById('phoneNum3').value;
	
	let securePw = null;
	securePw = CryptoJS.SHA256(memberPw);
	document.getElementById('securePw').value = securePw;
	
	if(memberEmail.length < 1){
		alert("이메일을 입력하세요");
		return false;
	}
	
	if(memberName.length < 1){
		alert("이름 입력하세요");
		return false;
	}
	
	if(memberPw.length < 1){
		alert("비밀번호를 입력하세요");
		return false;
	}
	
	if(memberPwc.length < 1){
		alert("비밀번호 확인을 입력하세요");
		return false;
	}
	
	if(phoneNum2.length <= 3 || phoneNum3.length <= 3){
		alert("전화번호를 입력하세요");
		return false;
	}
	
	if(memberPw != memberPwc){
		alert("비밀번호가 서로 일치하지 않습니다");
		return false;
	}
	
	return;
}

/*공지사항 목록으로 이동*/
function noticeListFnc() {		
	location.href = '../notice/list';
}

/*공지사항 페이지 이동 함수*/
function noticeSearch() {

   let searchField = document.getElementById('searchField').value;
   let searchText = document.getElementById('searchText').value;
   
   location.href = '../notice/list?searchField='+searchField+'&searchText='+searchText;

}

/*회원가입 페이지 이동 함수*/
function memberAddFnc() {
	location.href = "./new";
}

function pageMoveListFnc() {
	location.href="../main";
}

/*문의 하기 이동*/
function customerNewFnc() {
   location.href = "./new";
}

/*이벤트 추가*/
function eventAddFnc() {
   location.href = "./new";
}


function eventListFnc() {
   location.href = "./list";
}
