package kr.co.myboard.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.myboard.beans.ContentBean;
import kr.co.myboard.dao.BoardDao;

@Service
public class MainService {
	@Autowired
	BoardDao boardDao;
	
	public List<ContentBean> getContentList(int board_info_idx){
		RowBounds rowbounds=new RowBounds(0 ,5);
		return boardDao.getContentList(board_info_idx, rowbounds);
	}
}
