package model;

public class CommentVO {
    
    private int commentNum; 		// 댓글 번호를 저장하는 멤버 변수
    private String comment;  		// 댓글 내용을 저장하는 멤버 변수
    private int boardNum; 			// 댓글이 속한 게시글 번호를 저장하는 멤버 변수
    private String mid;				// 댓글 작성자 아이디를 저장하는 멤버 변수
    private int prohibitCnt;		// 댓글에 대한 신고 횟수를 저장하는 멤버 변수
    // 서치 컨디션 (검색 조건)
    private String select;			// 검색 조건을 저장하는 멤버 변수
    private String nickName;		// 작성자 닉네임을 저장하는 멤버 변수
    
    // 댓글 번호를 반환하는 메서드
    public int getCommentNum() {
        return commentNum;
    }
    
    // 댓글 번호를 설정하는 메서드
    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
    
    // 댓글 내용을 반환하는 메서드
    public String getComment() {
        return comment;
    }
    
    // 댓글 내용을 설정하는 메서드
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    // 댓글이 속한 게시글 번호를 반환하는 메서드
    public int getBoardNum() {
        return boardNum;
    }
    
    // 댓글이 속한 게시글 번호를 설정하는 메서드
    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }
    
    // 댓글 작성자 아이디를 반환하는 메서드
    public String getMid() {
        return mid;
    }
    
    // 댓글 작성자 아이디를 설정하는 메서드
    public void setMid(String mid) {
        this.mid = mid;
    }
    
    // 댓글에 대한 신고 횟수를 반환하는 메서드
    public int getProhibitCnt() {
        return prohibitCnt;
    }
    
    // 댓글에 대한 신고 횟수를 설정하는 메서드
    public void setProhibitCnt(int prohibitCnt) {
        this.prohibitCnt = prohibitCnt;
    }
    
    // 검색 조건을 반환하는 메서드
    public String getSelect() {
        return select;
    }
    
    // 검색 조건을 설정하는 메서드
    public void setSelect(String select) {
        this.select = select;
    }
    
    // 작성자 닉네임을 반환하는 메서드
    public String getNickName() {
        return nickName;
    }
    
    // 작성자 닉네임을 설정하는 메서드
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
