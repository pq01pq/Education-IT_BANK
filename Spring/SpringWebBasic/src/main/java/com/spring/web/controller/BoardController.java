package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.BoardVO;
import com.spring.web.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;
	
	// 글 작성 화면 요청
	@GetMapping("/write")
	public void write(){
		System.out.println("/board/write : get");
	}
	
	/*
	작성된 글 등록 처리 요청
	메서드 이름 : write()
	작성된 글을 리스트에 등록한 후 /board/list.jsp파일로 응답할 수 있도록 적절하게 처리
	글 목록을 보여달라는 요청이 자동으로 들어와야함(redirect)
	*/
	@PostMapping("/write")
	public String write(BoardVO vo) {
		System.out.println("/board/write : post");
		service.insertArticle(vo);
		return "redirect:/board/list";
	}
	
	/*
	글 목록 화면 요청
	메서드 이름 : list()
	DB 대용 리스트에서 가지고 온 글 목록을 list.jsp파일로 전달해서 브라우저에 글 목록을 띄움
	*/
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/board/list : post");
		model.addAttribute("articleList", service.getArticleList());
	}
	
	// 글 내용 상세보기 요청
	@GetMapping("/content")
	public void content(@ModelAttribute("boardNumber") int boardNumber, Model model) {
		// DB역할을 하는 리스트에서 글 번호에 해당하는 글 객체를 content.jsp로 보냄
		System.out.println("/board/content?boardNumber=" + boardNumber + ": get");
		model.addAttribute("article", service.getArticle(boardNumber));
//		model.addAttribute("boardNumber", boardNumber);
		// ModelAttribute가 알아서 매개변수로 넣어줌
	}
	
	// 글 수정하기 화면 요청
	@GetMapping("/modify")
	public void modify(@ModelAttribute("boardNumber") int boardNumber, Model model) {
		System.out.println("/board/modify?boardNumber=" + boardNumber + ": get");
		model.addAttribute("article", service.getArticle(boardNumber));
	}
	
	// 글 수정 요청
	// 수정 처리 완료 이후에 방금 수정된 글의 상세보기 페이지로 이동
	@PostMapping("/modify")
	public String modify(@RequestParam("boardNumber") int boardNumber, BoardVO article) {
		System.out.println("/board/modify : post");
		service.updateArticle(article, boardNumber);
		
		return "redirect:/board/content?boardNumber=" + boardNumber;
	}
	
	// 글 삭제 요청
	@GetMapping("/delete")
	public String delete(@RequestParam("boardNumber") int boardNumber) {
		System.out.println("/board/delete : get");
		service.deleteArticle(boardNumber);
		
		return "redirect:/board/list";
	}
}
