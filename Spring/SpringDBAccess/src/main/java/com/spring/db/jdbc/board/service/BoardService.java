package com.spring.db.jdbc.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.jdbc.board.model.BoardVO;
import com.spring.db.jdbc.board.repository.IBoardDAO;
import com.spring.db.jdbc.board.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {
	
	// jdbc template 사용
//	@Autowired
//	private IBoardDAO dao;
	
	// mybatis를 이용한 sql문 처리
	@Autowired
	private IBoardMapper mapper;
	
	@Override
	public void insertArticle(BoardVO vo) {
		mapper.insertArticle(vo);
	}

	@Override
	public List<BoardVO> getArticleList() {
		return mapper.getArticleList();
	}

	@Override
	public BoardVO getArticle(int index) {
		return mapper.getArticle(index);
	}

	@Override
	public void deleteArticle(int index) {
		mapper.deleteArticle(index);
	}

	@Override
	public void updateArticle(BoardVO vo, int index) {
		mapper.updateArticle(vo, index);
	}
	
	@Override
	public List<BoardVO> searchList(String keyword) {
		keyword = "%" + keyword + "%";
		return mapper.searchList(keyword);
	}
}
