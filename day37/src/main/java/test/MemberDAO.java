package test;

import java.util.ArrayList;

public class MemberDAO {
	ArrayList<MemberVO> datas;
	
	public MemberDAO() {
		datas = new ArrayList<MemberVO>();
		datas.add(new MemberVO("admin", "1234"));
		datas.add(new MemberVO("timo", "1234"));
		datas.add(new MemberVO("kim", "1234"));
	}
	
	public boolean insert(MemberVO mVO) {
		boolean flag = false; // id가 중복검사를 위해 flag 알고리즘 사용
		for(MemberVO data : datas) { 
			if(data.equals(mVO)) { // 사용자가 입력한 id가 기존이 배열리스트에 존재한다면
				flag = true; // 해당 id 중복됨
				break;
			}
		}
		if(flag) { // id 중복이므로
			return false; // false 반환
		} 
		datas.add(mVO); // 중복되지 않은 id라면 배열리스트에 저장
		return true;
	}
	
	public boolean update(MemberVO mVO) {
		return false;
	}
	
	public boolean delete(MemberVO mVO) {
		return false;
	}
	
	public ArrayList<MemberVO> selectAll(MemberVO mVO){
		return datas;
	}
	
	public MemberVO selectOne(MemberVO mVO) {
		for(MemberVO data : datas) {
			if(mVO.getMid().equals(data.getMid())) { // 사용자가 입력한 id가 v의 id와 같다면
				if(mVO.getMpw().equals(data.getMpw())) { // 사용자가 입력한 password가 v의 password와 같다면
					return data; // v 반환
				}
			}
		}
		return null;
	}
	
}
