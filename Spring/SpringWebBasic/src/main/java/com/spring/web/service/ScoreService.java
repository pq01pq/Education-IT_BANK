package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.model.ScoreVO;
import com.spring.web.repository.IScoreDAO;

@Service
public class ScoreService implements IScoreService {
	@Autowired
	private IScoreDAO dao;
	
	@Override
	public void insertScore(ScoreVO services) {
		services.calcData();
		dao.insertScore(services);
	}

	@Override
	public List<ScoreVO> selectAllScores() {
		return dao.selectAllScores();
	}

	@Override
	public void deleteScores(int stuNum) {
		dao.deleteScores(stuNum - 1);
		// 서비스에서 데이터베이스에 넘겨주기 전에 미리 처리를 해서 전달함
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		return dao.selectOne(stuNum - 1);
	}

}
