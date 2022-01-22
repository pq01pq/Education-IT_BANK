package com.spring.db.jdbc.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.service.IBoardService;

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
	public String write(BoardVO article) {
		System.out.println("/board/write : post");
		service.insertArticle(article);
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
	public void content(int boardNo, Model model) {
		// DB역할을 하는 리스트에서 글 번호에 해당하는 글 객체를 content.jsp로 보냄
		System.out.println("/board/content?boardNo=" + boardNo + ": get");
		model.addAttribute("article", service.getArticle(boardNo));
//		model.addAttribute("boardNo", boardNo);
		// ModelAttribute가 알아서 매개변수로 넣어줌
	}
	
	// 글 수정하기 화면 요청
	@GetMapping("/modify")
	public void modify(int boardNo, Model model) {
		System.out.println("/board/modify?boardNo=" + boardNo + ": get");
		model.addAttribute("article", service.getArticle(boardNo));
	}
	
	// 글 수정 요청
	// 수정 처리 완료 이후에 방금 수정된 글의 상세보기 페이지로 이동
	@PostMapping("/modify")
	public String modify(int boardNo, BoardVO article) {
		System.out.println("/board/modify : post");
		service.updateArticle(article, boardNo);
		
		return "redirect:/board/content?boardNo=" + boardNo;
	}
	
	// 글 삭제 요청
	@GetMapping("/delete")
	public String delete(int boardNo) {
		System.out.println("/board/delete : get");
		service.deleteArticle(boardNo);
		
		return "redirect:/board/list";
	}
	
	//게시글 검색 처리 요청
	/*
	- 글 검색을 처리해서 화면에 응답
	- 해당 키워드가 들어가 있는 글들을 모두 검색해서 가지고 옴
	  ('김' -> 김씨 모두 검색해서 가져오기)
	- 데이터베이스에서 조회한 결과를 list.jsp에 있는 테이블을 재활용하여 뿌림
	 */
	@GetMapping("/searchList")
	public String searchList(String keyword, Model model) {
		model.addAttribute("articleList", service.searchList(keyword));
		return "board/list";
	}
}
