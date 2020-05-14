package kr.co.myboard.beans;

public class BoardInfoBean {
	private int board_info_idx; //게시판 유영별 번호
	private String board_info_name;//게시판 이름 - 유머, 자유 등등
	
	public int getBoard_info_idx() {
		return board_info_idx;
	}
	public void setBoard_info_idx(int board_info_idx) {
		this.board_info_idx = board_info_idx;
	}
	public String getBoard_info_name() {
		return board_info_name;
	}
	public void setBoard_info_name(String board_info_name) {
		this.board_info_name = board_info_name;
	}
	
	
}