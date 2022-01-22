package com.spring.mvc.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BoardMapperTest {
	@Autowired
	private IBoardMapper mapper;
	
	// 게시글 등록 단위 테스트
	@Test
	public void insertTest(){
		for(int i = 1; i <= 324; i++) {
			BoardVO article = new BoardVO();
			article.setTitle("테스트 제목" + i);
			article.setWriter("김테스트" + i);
			article.setContent("테스트중" + i);
			mapper.insert(article);
		}
	}
	/*
	// 게시글 목록 조회 테스트
	@Test
	public void getListTest() {
//		List<BoardVO> list = mapper.getArticleList();
//		for(BoardVO vo : list) {
//			System.out.println(vo);
//		}
		// 람다식
		mapper.getArticleList().forEach(vo -> System.out.println(vo));
	}
	*/
	
	// 게시글 단일 조회 테스트
	// 44번 글을 조회해서 글 상세내용을 출력
	@Test
	public void getArticleTest() {
		BoardVO article = mapper.getArticle(44);
		System.out.println(article);
	}
	
	// 게시글 수정 테스트
	// BoardVO 객체를 하나 생성하고, VO의 setter를 사용하여
	// 수정내용(글 제목, 글 내용)을 입력하고 수정을 진행(1번글의 제목, 내용 수정)
	@Test
	public void updateTest() {
		BoardVO article = new BoardVO();
		article.setBoardNo(1);
		article.setTitle("수정된 제목");
		article.setContent("수정된 내용");
		mapper.update(article);
		System.out.println("수정 후 정보 : " + mapper.getArticle(1));
	}
	
	// 게시글 삭제 테스트 : 게시글 번호를 통해 삭제 확인
	// 3번글을 삭제 후 상세보기를 통해 3번글을 가져왔을 때 null이 리턴되는지 확인
	@Test
	public void deleteTest() {
		mapper.delete(3);
		BoardVO article = mapper.getArticle(3);
		if(article == null) {
			System.out.println("게시물 없음");
		} else {
			System.out.println("삭제 실패");
		}
	}
}
