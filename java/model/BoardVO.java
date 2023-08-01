package model;

import java.util.Date;

public class BoardVO {
    
    private int boardNum;			// 게시글 번호
    private String title; 			// 게시글 제목
    private String content; 		// 게시글 내용
    private String mid; 			// 작성자 아이디
    private int prohibitCnt; 		// 게시글의 금지 횟수
    private int category; 			// 게시글의 카테고리
    private Date date; 				// 게시글 작성일
    // 서치 컨디션 (검색 조건)
    private String select;
    private String nickName; 		// 작성자 닉네임
    private int recommendCnt; 		// 게시글의 추천 횟수
    private int page; 				// 게시판 페이지 번호 (페이징 처리를 위한 변수)
    
    // 게시판 페이지 번호를 반환하는 메서드
    public int getPage() {
        return page;
    }
    
    // 게시판 페이지 번호를 설정하는 메서드
    public void setPage(int page) {
        this.page = page;
    }
    
    // 게시글 번호를 반환하는 메서드
    public int getBoardNum() {
        return boardNum;
    }
    
    // 게시글 번호를 설정하는 메서드
    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }
    
    // 게시글 제목을 반환하는 메서드
    public String getTitle() {
        return title;
    }
    
    // 게시글 제목을 설정하는 메서드
    public void setTitle(String title) {
        this.title = title;
    }
    
    // 게시글 내용을 반환하는 메서드
    public String getContent() {
        return content;
    }
    
    // 게시글 내용을 설정하는 메서드
    public void setContent(String content) {
        this.content = content;
    }
    
    // 작성자 아이디를 반환하는 메서드
    public String getMid() {
        return mid;
    }
    
    // 작성자 아이디를 설정하는 메서드
    public void setMid(String mid) {
        this.mid = mid;
    }
    
    // 게시글의 추천 횟수를 반환하는 메서드
    public int getRecommendCnt() {
        return recommendCnt;
    }
    
    // 게시글의 추천 횟수를 설정하는 메서드
    public void setRecommendCnt(int recommendCnt) {
        this.recommendCnt = recommendCnt;
    }
    
    // 게시글의 금지 횟수를 반환하는 메서드
    public int getProhibitCnt() {
        return prohibitCnt;
    }
    
    // 게시글의 금지 횟수를 설정하는 메서드
    public void setProhibitCnt(int prohibitCnt) {
        this.prohibitCnt = prohibitCnt;
    }
    
    // 게시글의 카테고리를 반환하는 메서드
    public int getCategory() {
        return category;
    }
    
    // 게시글의 카테고리를 설정하는 메서드
    public void setCategory(int category) {
        this.category = category;
    }
    
    // 게시글 작성일을 반환하는 메서드
    public Date getDate() {
        return date;
    }
    
    // 게시글 작성일을 설정하는 메서드
    public void setDate(Date date) {
        this.date = date;
    }
    
    // 서치 컨디션(검색 조건)을 반환하는 메서드
    public String getSelect() {
        return select;
    }
    
    // 서치 컨디션(검색 조건)을 설정하는 메서드
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
