package kr.co.myboard.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.myboard.beans.UserBean;
import kr.co.myboard.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	public boolean checkUserIdExist(String user_id) {
		String user_name = userDao.checkUserIdExist(user_id);
		if(user_name == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}
	
	public void getLoginUserInfo(UserBean loginBean) {
		UserBean tempBean = userDao.getLoginUserInfo(loginBean);
		if(tempBean != null) {
			loginUserBean.setUser_idx(tempBean.getUser_idx());
			loginUserBean.setUser_name(tempBean.getUser_name());
			loginUserBean.setLoginFlag(true);
		}
	}
}
