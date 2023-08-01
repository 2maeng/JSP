package model;

import java.util.ArrayList;

public class CommentSet {
	
	// 댓글(1개) 정보를 저장하는 객체
	private CommentVO comment;
	// 대댓글들(N개)을 저장하는 ArrayList
	private ArrayList<ReplyVO> rdatas;
	
	// 댓글(1개) 정보를 반환하는 메서드
    public CommentVO getComment() {
        return comment;
    }
    
    // 댓글(1개) 정보를 설정하는 메서드
    public void setComment(CommentVO comment) {
        this.comment = comment;
    }
    
    // 대댓글들(N개)을 반환하는 메서드
    public ArrayList<ReplyVO> getRdatas() {
        return rdatas;
    }
    
    // 대댓글들(N개)을 설정하는 메서드
    public void setRdatas(ArrayList<ReplyVO> rdatas) {
        this.rdatas = rdatas;
    }
	
}
