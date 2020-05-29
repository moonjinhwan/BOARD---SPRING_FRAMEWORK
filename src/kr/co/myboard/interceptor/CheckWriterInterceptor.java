package kr.co.myboard.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.myboard.beans.ContentBean;
import kr.co.myboard.beans.UserBean;
import kr.co.myboard.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	@Autowired
	private BoardService boardService;
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String temp=request.getParameter("content_idx");
		int content_idx=Integer.parseInt(temp);
		
		ContentBean currentContentBean = boardService.getContentInfo(content_idx);
		
		if(loginUserBean.getUser_idx() != currentContentBean.getContent_writer_idx()) {
			String contextPath=request.getContextPath();
			response.sendRedirect(contextPath+"/board/not_writer");
			return false;
		}
		return true;
	}
}
