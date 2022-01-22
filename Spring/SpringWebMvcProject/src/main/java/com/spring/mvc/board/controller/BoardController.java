package com.spring.mvc.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.commons.PageCreator;
import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	// 검색 처리 이후 게시글 목록 불러오기 요청
	@GetMapping("/list")
	public String list(SearchVO search, Model model) {
		System.out.println("페이지 번호 : " + search.getPage());
		System.out.println("검색 조건 : " + search.getCondition());
		System.out.println("검색어 : " + search.getKeyword());

		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		
		List<BoardVO> list = service.getArticleList(search);
		pc.setArticleTotalCount(service.countArticles(search));
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		return "board/list";
	}
	
	// 검색 처리 이후 게시글 목록 불러오기 요청 (너무 비효율적이다)
	/*
	@GetMapping("/list")
	public String list(SearchVO search, Model model) {
		System.out.println("페이지 번호 : " + search.getPage());
		System.out.println("검색 조건 : " + search.getCondition());
		System.out.println("검색어 : " + search.getKeyword());

		PageCreator pc = new PageCreator();
		pc.setPaging(search);

		List<BoardVO> list = null;

		if(search.getCondition().equals("title")) {
			System.out.println("제목 검색 요청이 들어옴");
			list = service.getArticleListByTitle(search);
			System.out.println("mapper result : " + search);
			pc.setArticleTotalCount(service.countArticlesByTitle(search));
		} else if(search.getCondition().equals("content")) {
			
		} else if(search.getCondition().equals("writer")) {
			
		} else {
			list = service.getArticleList(search);
			pc.setArticleTotalCount(service.countArticles());
		}
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);

		return "board/list";
	}*/
	
	/*
	// 페이징 처리 이후 게시글 목록 불러오기 요청
	@GetMapping("list")
	public String list(PageVO paging, Model model) {
		List<BoardVO> list = service.getArticleList(paging);
		System.out.println("url : /board/list - get, result : " + list.size());
		System.out.println("페이지 번호 : " + paging.getPage());
		
		PageCreator pc = new PageCreator();
		pc.setPaging(paging);
		pc.setArticleTotalCount(service.countArticles());
		
		model.addAttribute("articles", list);
		model.addAttribute("pc", pc);
		
		return "board/list";
	}
	*/

	//게시글 목록 불러오기
	/*
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardVO> list = service.getArticleList();

		System.out.println("URL: /board/list GET -> result: " + list.size());
		model.addAttribute("articles", list);

		return "board/list";
	}*/

	//글 작성 페이지 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("URL: /board/write -> GET");
	}

	// 게시글 DB 등록 요청
	// 글 등록 이후에 목록 요청이 자동으로 들어갈 수 있게끔 처리
	// '글 등록이 완료되었습니다' 경고창
	// ("msg", "regSuccess")
	@PostMapping("/write")
	public String write(BoardVO article, RedirectAttributes ra) {
		System.out.println("url : /board/write -> post");
		service.insert(article);;
		ra.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/list";

	}

	// 게시물 상세 조회 요청
	@GetMapping("/content/{boardNo}")
	// @PathVariable은 url 경로에 변수를 포함시켜주는 방식
	// null이나 공백이 들어갈 수 있는 파라미터값이면 사용하지 않는것이 좋음
	// 파라미터값에 .이 포함되어있다면 .뒤의 값은 잘림
	public String content(@PathVariable/*("boardNo")*/ int boardNo, Model model,
			@ModelAttribute("p") SearchVO search) {
		System.out.println("url : /board/content -> get");
		System.out.println("parameter(글 번호) : " + boardNo);
		BoardVO article = service.getArticle(boardNo);
		System.out.println("result data : " + article);
		model.addAttribute("article", article);

		return "board/content";
	}

	// 게시글 수정 페이지 이동 요청
	@GetMapping("/modify")
	public void modify(int boardNo, Model model, @ModelAttribute("p") PageVO paging) {
		System.out.println("url : /board/modify - get");
		System.out.println("parameter(글번호) : " + boardNo);
		model.addAttribute("article", service.getArticle(boardNo));
	}

	// 게시물 수정 요청
	// 수정 처리하고 나서 수정된 글의 상세보기 페이지로 이동
	// ra 활용해서 '게시글 수정이 완료되었습니다' 경고창 띄움("msg", "modSuccess")
	@PostMapping("/modify")
	public String modify(BoardVO article, RedirectAttributes ra) {
		System.out.println("url : /board/modify - post");
		service.update(article);

		ra.addFlashAttribute("msg", "modSuccess");

		return "redirect:/board/content/" + article.getBoardNo();
	}

	// 게시물 삭제 요청
	@PostMapping("/delete")
	public String delete(int boardNo, RedirectAttributes ra) {
		System.out.println("url : /board/delete - get");
		System.out.println("parameter(글번호) : " + boardNo);
		service.delete(boardNo);
		ra.addFlashAttribute("msg", "delSuccess");

		return "redirect:/board/list";
	}
}
