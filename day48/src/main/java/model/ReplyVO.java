package model;

import java.util.Date;

public class ReplyVO {
   private int rid;
   private int bid;
   private String mid;
   private Date date;
   private String rcontent;
   
   public ReplyVO() {
	   this(0, 0, "", null, "");
   }
   
   public ReplyVO(int rid, int bid, String mid, Date date, String rcontent) {
	   this.rid = rid;
	   this.bid = bid;
	   this.mid = mid; 
	   this.date = date;
	   this.rcontent = rcontent;
   }
   
   public int getRid() {
      return rid;
   }
   
   public void setRid(int rid) {
      this.rid = rid;
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
   
   public Date getDate() {
      return date;
   }
   
   public void setDate(Date date) {
      this.date = date;
   }
   
   public String getRcontent() {
      return rcontent;
   }
   
   public void setRcontent(String rcontent) {
      this.rcontent = rcontent;
   }
   
}