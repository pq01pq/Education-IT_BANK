package com.spring.db.mybatis.score.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.db.mybatis.score.model.ScoreVO;
import com.spring.db.mybatis.score.service.IScoreService;

@Controller("scoreController2")
@RequestMapping("/mybatis/score")
public class ScoreController {
	// 컨트롤러와 서비스 계층 사이의 의존성 자동 주입을 위해 변수 선언
	@Autowired	@Qualifier("scoreService2")
	private IScoreService service;
	
	// 점수 등록 화면을 열어주는 처리를 하는 요청 메서드
	@GetMapping("/register")
	public String register() {
		System.out.println("/score/register : get");
		return "/score2/write-form";
	}
	
	// 점수 등록을 처리하는 요청 메서드
	@PostMapping("/register")
	public String register(ScoreVO scores) {
		System.out.println("/score/register : post");
		System.out.println("param : " + scores);
		service.insertScore(scores);
		return "/score2/write-result";
	}
	
	// 점수 전체 조회를 처리하는 메서드
	@GetMapping("/list")
	public void list(Model model) {
		System.out.println("/score/list : get");
//		List<ScoreVO> list = service.selectAllScores();
//		model.addAttribute("slist", list);
		model.addAttribute("sList", service.selectAllScores());
	}
	
	// 점수 삭제 요청 처리 메서드
	@GetMapping("/delete")
	public String delete(int stuNum, RedirectAttributes ra) {
		System.out.println("삭제할 번호 : " + stuNum);
		// 삭제 처리를 완료한 후 list 요청이 다시 컨트롤러로 들어갈 수 있도록 처리
		// list 요청이 다시 들어가서 list.jsp로 갔을 때 삭제 이후 간 것이 판단되면
		// alert()을 통해 '삭제가 완료되었습니다.' 경고창을 띄우기
		service.deleteScores(stuNum);
		ra.addFlashAttribute("msg", "delSuccess");
		return "redirect:/mybatis/score/list";
	}
	
	// 점수 개별조회 화면 열람 요청 메서드
	@GetMapping("/search")
	public String search() {
		System.out.println("/score/search : get");
		return "score2/search-result";
	}
	
	// 점수 개별 조회 처리 요청 메서드
	@GetMapping("/selectOne")
	public String selectOne(int stuNum, RedirectAttributes ra, Model model) {
		// stuNum은 jsp에서 텍스트로 받았는데 RequestParam이 int로 바꿔준다?
		System.out.println("/score/selectOne : get");
		ScoreVO vo = service.selectOne(stuNum);
		System.out.println("selectOne result : " + vo);
		model.addAttribute("stu", vo);
		return "score2/search-result";
	}
}
