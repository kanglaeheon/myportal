package com.bitacademy.myportal.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.myportal.repository.BoardVo;
import com.bitacademy.myportal.repository.UserVo;
import com.bitacademy.myportal.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {
	@Autowired
	private BoardService boardServiceImpl;
	@RequestMapping(value={"", "/", "/list"})
	public String list(Model model) {
		List<BoardVo> list = boardServiceImpl.getList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	//	게시물 작성 폼
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String writeForm(HttpSession session) {
		//	로그인 된 사용자인지 확인 -> 인터셉터에 처리 위임
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//		if (authUser == null) {
//			System.err.println("로그인 사용자가 아닙니다");
//			return "redirect:/";
//		}
		
		return "board/write";
	}
	
	//	게시물 작성 액션
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute BoardVo boardVo, HttpSession session) {
		//	로그인 사용자 확인 -> 인터셉터에 처리 위임
		UserVo authUser = (UserVo)session.getAttribute("authUser");
//		if (authUser == null) {
//			return "redirect:/";
//		}
		//	작성자 정보 추가
		boardVo.setUserNo(authUser.getNo());
		//	삽입
		boardServiceImpl.write(boardVo);
		
		return "redirect:/board/list";
	}
	
	// 게시물 조회
	@RequestMapping(value="/view/*", method=RequestMethod.GET)
	public String view(@ModelAttribute BoardVo boardVo) {
		return "redirect:/board/view/" + boardVo.getNo();
	}
}
