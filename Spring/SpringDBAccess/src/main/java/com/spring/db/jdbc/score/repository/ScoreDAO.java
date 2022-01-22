package com.spring.db.jdbc.score.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.jdbc.score.commons.ScoreMapper;
import com.spring.db.jdbc.score.model.ScoreVO;

@Repository
public class ScoreDAO implements IScoreDAO {
	// 내부 클래스 (inner class)
	// 두 클래스가 굉장히 긴밀한 관계가 있을 때 선언 가능
	// 해당 클래스 안에서만 사용할 클래스를 굳이 새 파일을 만들지 않고도 선언 가능
	
	class ScoreMapper implements RowMapper<ScoreVO>{

		@Override
		public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			ScoreVO score = new ScoreVO();
			score.setStuId(rs.getInt("stu_id"));
			score.setStuName(rs.getString("stu_name"));
			score.setKor(rs.getInt("kor"));
			score.setMath(rs.getInt("math"));
			score.setEng(rs.getInt("eng"));
			score.setTotal(rs.getInt("total"));
			score.setAverage(rs.getDouble("average"));
			
			return score;
		}
	}
	
	// 전통적 방식의 jdbc
	/*
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin@localhost:1521:xe";	// 11g 버전
//	private String url = "jdbc:oracle:thin@localhost:1521/XEPDB1";	// 18c 버전
	private String uid = "spring";
	private String upw = "spring";
	
	@Override
	public void insertScore(ScoreVO score) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "insert into scores values(id_seq.nextval, ?,?,?,?,?,?)";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			ps = con.prepareStatement(sql);
			ps.setString(1, score.getStuName());
			ps.setInt(2, score.getKor());
			ps.setInt(3, score.getMath());
			ps.setInt(4, score.getEng());
			ps.setInt(5, score.getTotal());
			ps.setDouble(6, score.getAverage());
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();	con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	// Spring-jdbc 방식의 처리 : JdbcTemplate 사용
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertScore(ScoreVO score) {
		String sql = "insert into scores values(id_seq.nextval,?,?,?,?,?,?)";
		
		template.update(sql, score.getStuName(), score.getKor(), score.getMath(), score.getEng(),
				score.getTotal(), score.getAverage());
	}
	/*
	@Override
	public List<ScoreVO> selectAllScores() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from scores";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uid, upw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setStuId(rs.getInt("stu_id"));
				vo.setStuName(rs.getString("stu_name"));
				vo.setKor(rs.getInt("kor"));
				vo.setMath(rs.getInt("math"));
				vo.setEng(rs.getInt("eng"));
				vo.setTotal(rs.getInt("total"));
				vo.setAverage(rs.getDouble("average"));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();	ps.close();	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}*/
	
	@Override
	public List<ScoreVO> selectAllScores() {
		String sql = "select * from scores order by stu_id asc";
		//return template.query(sql, new ScoreMapper());
		// 람다식
		return template.query(sql, (rs, rowNum) -> {
			ScoreVO score = new ScoreVO();
			score.setStuId(rs.getInt("stu_id"));
			score.setStuName(rs.getString("stu_name"));
			score.setKor(rs.getInt("kor"));
			score.setMath(rs.getInt("math"));
			score.setEng(rs.getInt("eng"));
			score.setTotal(rs.getInt("total"));
			score.setAverage(rs.getDouble("average"));
			
			return score;
		});	// 익명클래스
		// template.quere()는 List형으로 리턴하고 Mapper에서 타입을 지정해주면 됨
	}

	@Override
	public void deleteScores(int stuNum) {
		String sql = "delete from scores where stu_id=?";
		template.update(sql, stuNum);
	}

	@Override
	public ScoreVO selectOne(int stuNum) {
		String sql = "select * from scores where stu_id=?";
		// queryForObject는 single row를 리턴할 때 사용
		// query는 multi row를 리턴할 때 사용
		return template.queryForObject(sql, new ScoreMapper(), stuNum);
	}

}
