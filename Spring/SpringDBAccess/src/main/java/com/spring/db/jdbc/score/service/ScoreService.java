package com.spring.db.jdbc.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.jdbc.score.model.ScoreVO;
import com.spring.db.jdbc.score.repository.IScoreDAO;

@Service
public class ScoreService implements IScoreService {
	@Autowired
	private IScoreDAO dao;
	
	@Override
	public void insertScore(ScoreVO score) {
		score.calcData();
		dao.insertScore(score);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return dao.selectAllScores();
	}

	@Override
	public void deleteScores(int stuNum) {
		dao.deleteScores(stuNum);
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		return dao.selectOne(stuNum);
	}

}
