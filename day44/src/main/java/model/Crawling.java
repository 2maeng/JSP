package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	// 1. static 쓰는 이유
	// 크롤링 클래스의 객체가 불필요한 상황 (멤버변수가 없는 클래스)
	public static ArrayList<BoardVO> sample() {
//		public static void main(String[] args) {

		final String url="https://www.melon.com/chart/";

		Connection conn = Jsoup.connect(url);

		Document doc=null;
		try {
			doc=conn.get(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements elements = doc.select("div.ellipsis.rank01 > span > a");
		Elements elements2 = doc.select("div.ellipsis.rank02 > span");
//		Elements elements2 = doc.select("div.ellipsis.rank02 > span > a");
//		System.out.println(elements2);

		Iterator<Element> itr = elements.iterator();
		Iterator<Element> itr2 = elements2.iterator();

		ArrayList<BoardVO> mdatas= new ArrayList<BoardVO>();
		int PK=1;
		
		while(itr.hasNext() && itr2.hasNext()) {
			// for 문으로 변경해서 정해진 갯수만!
			String title = itr.next().text();
			String artist = itr2.next().text();
			
			// text(); 메서드는 Jsoup의 메서드로
			// 선택된 모든 HTML 요소의 텍스트 컨텐츠를 하나의 문자열로 반환합니다.
			// <a>텍스트</a> -----> 텍스트

//			System.out.println(artist+" / "+title);
			mdatas.add(new BoardVO(artist,title));
		}
		return mdatas;

	}

}
