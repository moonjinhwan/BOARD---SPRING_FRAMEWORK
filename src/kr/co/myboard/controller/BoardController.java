package kr.co.myboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/main")
	public String main(@RequestParam("board_info_idx") String board_info_idx, Model model) {
		model.addAttribute("board_info_idx", board_info_idx);
		return "board/main";
	}
	
	@GetMapping("/read")
	public String read() {
		return "board/read";
	}
	
	@GetMapping("/write")
	public String write() {
		return "board/write";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "board/modify";
	}
	
	@GetMapping("/delete")
	public String delete() {
		return "board/delete";
	}
}
