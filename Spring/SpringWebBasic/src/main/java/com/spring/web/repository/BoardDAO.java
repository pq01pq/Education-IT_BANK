package com.spring.web.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.web.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {
	
	// 게시글을 저장할 리스트. DB 대용
	private List<BoardVO> articleList = new ArrayList<BoardVO>();
	
	@Override
	public void insertArticle(BoardVO vo) {
		articleList.add(vo);
	}
	
	@Override
	public List<BoardVO> getArticleList() {
		return articleList;
	}
	
	@Override
	public BoardVO getArticle(int index) {
		return articleList.get(index);
	}
	
	@Override
	public void deleteArticle(int index) {
		articleList.remove(index);
	}
	
	@Override
	public void updateArticle(BoardVO vo, int index) {
		articleList.set(index, vo);
	}
}
