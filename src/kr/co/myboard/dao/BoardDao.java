package kr.co.myboard.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.myboard.beans.ContentBean;

@Repository
public class BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void addContentInfo(ContentBean writeContentBean) {
		sqlSession.insert("board.addContentInfo", writeContentBean);
	}
	public String getBoardName(int board_info_idx) {
		return sqlSession.selectOne("board.getBoardName", board_info_idx);
	}
	public List<ContentBean> getContentList(int board_info_idx, RowBounds rowbounds){
		return sqlSession.selectList("board.getContentList", board_info_idx, rowbounds);
	}
	public ContentBean getContentInfo(int content_idx) {
		return sqlSession.selectOne("board.getContentInfo", content_idx);
	}
	public void modifyContentInfo(ContentBean modifyContentBean) {
		sqlSession.selectOne("board.modifyContentInfo", modifyContentBean);
	}
	public void deleteContentInfo(int content_idx) {
		sqlSession.delete("board.deleteContentInfo" , content_idx);
	}
	public int getContentCnt(int content_board_idx) {
		return sqlSession.selectOne("board.getContentCnt", content_board_idx);
	}
}
