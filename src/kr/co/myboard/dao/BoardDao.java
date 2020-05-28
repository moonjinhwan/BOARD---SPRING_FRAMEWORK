package kr.co.myboard.dao;

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
}
