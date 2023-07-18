
/* b_main.jsp */

function check(){
	var ans=prompt('비밀번호를 입력하세요.');
	location.href='controller.jsp?action=mypage&mpw='+ans;
}



/* d_board.jsp */

function delBoard(num){
	var ans=confirm('정말 삭제할까요?');
	if(ans==true){
		/*document.form.action.value='deleteBoard';
		document.form.submit();	*/
		location.href = "deleteBoard.do?num=" + num;
	}
}



/* f_mypage.jsp */

function remove(){
	var ans=confirm("정말로 탈퇴하시겠습니까???");
	if(ans==true){
		/*
		document.form.action.value='deleteMember.do';
		document.form.submit();
		*/
		location.href = "deleteMember.do"
	}
}
