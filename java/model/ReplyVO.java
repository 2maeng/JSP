package model;

public class ReplyVO {
    
    private int replyNum;			// 댓글 번호
    private String reply;			// 댓글 내용
    private int commentNum;			// 댓글이 속한 댓글 그룹(댓글의 원글)의 번호
    private String mid;				// 댓글 작성자 아이디
    private int prohibitCnt;		// 댓글의 신고 횟수
    // 댓글에 대한 작업 선택 조건 (서치 컨디션)
    private String select;
    private String nickName;		// 댓글 작성자 닉네임
    
    // 댓글 번호를 반환하는 메서드
    public int getReplyNum() {
        return replyNum;
    }
    
    // 댓글 번호를 설정하는 메서드
    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }
    
    // 댓글 내용을 반환하는 메서드
    public String getReply() {
        return reply;
    }
    
    // 댓글 내용을 설정하는 메서드
    public void setReply(String reply) {
        this.reply = reply;
    }
    
    // 댓글이 속한 댓글 그룹(댓글의 원글)의 번호를 반환하는 메서드
    public int getCommentNum() {
        return commentNum;
    }
    
    // 댓글이 속한 댓글 그룹(댓글의 원글)의 번호를 설정하는 메서드
    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }
    
    // 댓글 작성자 아이디를 반환하는 메서드
    public String getMid() {
        return mid;
    }
    
    // 댓글 작성자 아이디를 설정하는 메서드
    public void setMid(String mid) {
        this.mid = mid;
    }
    
    // 댓글의 신고 횟수를 반환하는 메서드
    public int getProhibitCnt() {
        return prohibitCnt;
    }
    
    // 댓글의 신고 횟수를 설정하는 메서드
    public void setProhibitCnt(int prohibitCnt) {
        this.prohibitCnt = prohibitCnt;
    }
    
    // 댓글에 대한 작업 선택 조건(서치 컨디션)을 반환하는 메서드
    public String getSelect() {
        return select;
    }
    
    // 댓글에 대한 작업 선택 조건(서치 컨디션)을 설정하는 메서드
    public void setSelect(String select) {
        this.select = select;
    }
    
    // 댓글 작성자 닉네임을 반환하는 메서드
    public String getNickName() {
        return nickName;
    }
    
    // 댓글 작성자 닉네임을 설정하는 메서드
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

