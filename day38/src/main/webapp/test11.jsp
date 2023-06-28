<%@page import="test.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>


<script>

<% 
// ★★★★★★★★★★★★★★★★
// 장바구니, 로그인 유지 여부, 광고 띄우지 않기 설정 등
// 서버가 변경되어도 '브라우저가 유지되고 있었다면 설정이 유지되어야하는 상태'에 있는 데이터들을
// "세션(session)"으로 관리! ex) 바나프레소 어플 세션이 만료 되었습니다.
// 일정 시간이 흐르면 연결이 해제됨
// ★★★★★★★★★★★★★★★★

// 현재 한글 데이터 전송중 -> 인코딩 필수
request.setCharacterEncoding("UTF-8");

ArrayList<ProductVO> datas = (ArrayList<ProductVO>)session.getAttribute("datas"); // 인자를 객체로 받기에 다운캐스팅 강제형변환 (ArrayList<String>)session

ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();
pdatas.add(new ProductVO(1, "티셔츠", 2000));
pdatas.add(new ProductVO(2, "목도리", 3000));
pdatas.add(new ProductVO(3, "청바지", 4000));
pdatas.add(new ProductVO(4, "운동화", 5000));
pdatas.add(new ProductVO(5, "가방", 6000));

// 사용자가 product라는 이름의 파라미터를 전송할 예정
// 전달받은 상품을 "장바구니"에 추가

int product = Integer.parseInt(request.getParameter("product"));

if(datas == null){ // datas가 없니?
	// 즉 첫번째 상품이니?
	datas = new ArrayList<ProductVO>();
	session.setAttribute("datas", datas);
} 

	ProductVO pVO = null;
	
	for(int i = 0; i < pdatas.size(); i++){
		if(pdatas.get(i).getPk() == product){
			pVO = pdatas.get(i);				
		}
	}
	
	boolean flag = false;
	if(datas.isEmpty()){
		datas.add(pVO);
		
		%>	
		alert('<%= product %>이(가) 장바구니에 추가 되었습니다! :D');
		history.go(-1);
		<%
	}
	
	else{
		for(int i = 0; i < datas.size(); i++){
			if(pVO.getPk() == datas.get(i).getPk()){
				flag = true;
				break;
			}
		}
		if(!flag){
			datas.add(pVO);
			%>	
			alert('<%= product %>이(가) 장바구니에 추가 되었습니다! :D');
			history.go(-1);
			<%
		}
		else {
			%>	
			alert('<%= product %>이(가) 중복 상품입니다....');
			history.go(-1);
			<%
		}
	}
		%>
					
// 장바구니를 맨 처음 만드는 경우에는 새로 new
// 기존 장바구니가 있는 경우에는 .add()

// 추가완료되면 다시 test10.jsp로 이동

</script>