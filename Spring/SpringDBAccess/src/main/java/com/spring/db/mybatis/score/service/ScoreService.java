package com.spring.db.mybatis.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.db.mybatis.score.model.ScoreVO;
import com.spring.db.mybatis.score.repository.IScoreMapper;

@Service("scoreService2")
public class ScoreService implements IScoreService {
	@Autowired
	private IScoreMapper mapper;
	
	@Override
	public void insertScore(ScoreVO score) {
		score.calcData();
		mapper.insertScore(score);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return mapper.selectAllScores();
	}

	@Override
	public void deleteScores(int stuNum) {
		mapper.deleteScores(stuNum);
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		return mapper.selectOne(stuNum);
	}

}
