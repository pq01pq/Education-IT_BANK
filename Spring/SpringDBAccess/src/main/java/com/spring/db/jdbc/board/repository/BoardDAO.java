package com.spring.db.jdbc.board.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.jdbc.board.model.BoardVO;
/**
create table jdbc_board (
    board_no number primary key,
    writer varchar2(30) not null,
    title varchar2(100) not null,
    content varchar2(300)
);

CREATE SEQUENCE bid_seq
    START WITH 1 INCREMENT by 1
    MAXVALUE 1000 NOCYCLE NOCACHE;
*/
@Repository
public class BoardDAO implements IBoardDAO {
	
	class BoardMapper implements RowMapper<BoardVO> {
		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO article = new BoardVO();
			article.setBoardNo(rs.getInt("board_no"));
			article.setWriter(rs.getString("writer"));
			article.setTitle(rs.getString("title"));
			article.setContent(rs.getNString("content"));
			return article;
		}
	}
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertArticle(BoardVO article) {
		String sql = "insert into jdbc_board values(bid_seq.nextval,?,?,?)";
		template.update(sql, article.getWriter(), article.getTitle(), article.getContent());
	}
	
	@Override
	public List<BoardVO> getArticleList() {
		String sql = "select * from jdbc_board order by board_no desc";
		return template.query(sql, new BoardMapper());
	}
	
	@Override
	public BoardVO getArticle(int index) {
		String sql = "select * from jdbc_board where board_no=?";
		return template.queryForObject(sql, new BoardMapper(), index);
	}
	
	@Override
	public void deleteArticle(int index) {
		String sql = "delete from jdbc_board where board_no=?";
		template.update(sql, index);
	}
	
	@Override
	public void updateArticle(BoardVO vo, int index) {
		String sql = "update jdbc_board "
				+ "set writer=?,title=?,content=? "
				+ "where board_no=?";
		template.update(sql, vo.getWriter(), vo.getTitle(), vo.getContent(), index);
	}
}
