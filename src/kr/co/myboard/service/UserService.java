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
	public void getModifyInfo(UserBean modifyUserBean) {//주소값을 전달한다
		UserBean tempBean = userDao.getModifyInfo(loginUserBean.getUser_idx());
		modifyUserBean.setUser_id(tempBean.getUser_id());
		modifyUserBean.setUser_name(tempBean.getUser_name());
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
	}
	
	public void updateUserInfo(UserBean modifyUserBean) {
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		userDao.updateUserInfo(modifyUserBean);
	}
}
