package kr.co.myboard.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.myboard.beans.BoardInfoBean;
import kr.co.myboard.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{
	
	@Autowired
	private TopMenuService topmenuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> topMenuList = topmenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		return true;
	}
}
