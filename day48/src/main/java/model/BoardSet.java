package model;

import java.util.ArrayList;

import model.BoardVO;
import model.ReplyVO;

public class BoardSet {
	private BoardVO board; // 1 
	private ArrayList<ReplyVO> rdatas; // M

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	public ArrayList<ReplyVO> getRdatas() {
		return rdatas;
	}

	public void setRdatas(ArrayList<ReplyVO> rdatas) {
		this.rdatas = rdatas;
	}
	
	
}
