package kr.co.myboard.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.myboard.beans.UserBean;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public String checkUserIdExist(String user_id) {
		return sqlSessionTemplate.selectOne("user.checkUserIdExist", user_id);
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		sqlSessionTemplate.insert("user.addUserInfo", joinUserBean);
	}
	
	public UserBean getLoginUserInfo(UserBean loginBean) {
		return sqlSessionTemplate.selectOne("user.getLoginUserInfo" ,loginBean);
	}
	
	public UserBean getModifyInfo(int user_idx) {
		return sqlSessionTemplate.selectOne("user.getModifyInfo", user_idx);
	}
	
	public void updateUserInfo(UserBean modifyUserBean) {
		sqlSessionTemplate.update("user.updateUserInfo", modifyUserBean);
	}
}