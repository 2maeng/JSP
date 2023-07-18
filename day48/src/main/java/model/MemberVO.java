package model;

public class MemberVO {
   private String mid;
   private String mpw;
   private String name;
   
   public MemberVO() {
	   this("", "", "");
   }
   
   public MemberVO(String mid, String mpw, String name) {
	   this.mid = mid;
	   this.mpw = mpw;
	   this.name = name;
   }
   
   public String getMid() {
      return mid;
   }
   
   public void setMid(String mid) {
      this.mid = mid;
   }
   
   public String getMpw() {
      return mpw;
   }
   
   public void setMpw(String mpw) {
      this.mpw = mpw;
   }
   
   public String getName() {
      return name;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   
   
}