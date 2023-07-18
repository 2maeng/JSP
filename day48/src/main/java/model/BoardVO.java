package model;

import java.util.Date;

public class BoardVO {
//	BID INT PRIMARY KEY AUTO_INCREMENT,
//	MID VARCHAR(10) NOT NULL, -- FK
//	BCONTENT VARCHAR(30) NOT NULL,
//	FAVCNT INT DEFAULT 0,
//	REPLYCNT INT DEFAULT 0,
//	DATE DATETIME NOT NULL
	private int bid;
	private String mid;
	private String bcontent;
	private int favcnt;
	private int replycnt;
	private Date date;
	
	private String condition;

	public BoardVO() {
		this(0, "", "", 0, 0, null);
	}
	
	public BoardVO(int bid, String mid, String bcontent, int favcnt, int replycnt, Date date) {
		this.bid = bid;
		this.mid = mid;
		this.bcontent = bcontent;
		this.favcnt = favcnt;
		this.replycnt = replycnt;
		this.date = date;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getFavcnt() {
		return favcnt;
	}

	public void setFavcnt(int favcnt) {
		this.favcnt = favcnt;
	}

	public int getReplycnt() {
		return replycnt;
	}

	public void setReplycnt(int replycnt) {
		this.replycnt = replycnt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	
	
	
	
}
