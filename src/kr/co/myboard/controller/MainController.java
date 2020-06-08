package kr.co.myboard.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.myboard.beans.BoardInfoBean;
import kr.co.myboard.beans.ContentBean;
import kr.co.myboard.service.MainService;
import kr.co.myboard.service.TopMenuService;

@Controller
public class MainController {
	@Autowired
	MainService mainService;
	@Autowired
	TopMenuService topMenuService;
	
	@GetMapping("/main")
	public String main(Model model) {
		
		ArrayList<List<ContentBean>> list=new ArrayList<List<ContentBean>>();
		
		for(int i=1;i<=4;i++) {
			list.add(mainService.getContentList(i));
		}
		model.addAttribute("list", list);
		
		List<BoardInfoBean> board_list=topMenuService.getTopMenuList();
		model.addAttribute("board_list", board_list);
		return "main";
	}
}
