package lab.sam.web.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public BoardDAO() {
		try {
			String str = "oracle.jdbc.OracleDriver";
			Class.forName(str);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DriverManager");
		}
	}
	
	private void getConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	// localhost, port=1521
		String user = "KKS";
		String password = "kks";
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Connection");
		}
	}
	
	// 새로운 글 번호
	public int nextLineNo() {
		String sql = "select lineNo from board order by lineNo desc";
		try {
			getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1; //처음 글
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Join");
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch(SQLException e) {
				System.out.println("MemberCheck");
			}
		}
		
		return 0;
	}
	
	public boolean write(BoardBean bean) {
		boolean check = false;
		
		int lineNo = nextLineNo();
		if(lineNo <= 0) {
			return check;
		}
		
		String sql = "insert into board values(?,?,?,sysdate,0,?)";
		try {
			getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, lineNo);
			ps.setString(2, bean.getTitle());
			ps.setString(3, bean.getId());
			ps.setString(4, bean.getContent());
			rs = ps.executeQuery();
			
			if(ps.executeUpdate() != 0) {
				check = true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("nextLineNo");
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch(SQLException e) {
				e.printStackTrace();
				System.out.println("nextLineNo");
			}
		}
		
		return check;
	}
	
	public List<BoardBean> getBoardList(int pageNum){
		ArrayList<BoardBean> list = new ArrayList<BoardBean>();
		int start = nextLineNo() - (pageNum - 1) * 10;
		int end = start - 10;
		String sql = "select * from board where lineNo < ? and lineNo >= ? order by lineNo desc";
		
		try {
			getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int lineNo = rs.getInt("lineNo");
				String title = rs.getString("title");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				int readCount = rs.getInt("readCount");
				String content = rs.getString("content");
				
				BoardBean bean = new BoardBean();
				bean.setLineNo(lineNo);
				bean.setTitle(title);
				bean.setId(id);
				bean.setWriteDate(writeDate);
				bean.setReadCount(readCount);
				bean.setContent(content);
				
				list.add(bean);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Join");
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch(SQLException e) {
				System.out.println("MemberCheck");
			}
		}
		
		return list;
	}
	
	public BoardBean getContent(int lineNo) {
		BoardBean bean = new BoardBean();
		String sql = "select * from board where lineNo=?";
		
		try {
			getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, lineNo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				lineNo = rs.getInt("lineNo");
				String title = rs.getString("title");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				int readCount = rs.getInt("readCount");
				String content = rs.getString("content");
				
				bean.setLineNo(lineNo);
				bean.setTitle(title);
				bean.setId(id);
				bean.setWriteDate(writeDate);
				bean.setReadCount(readCount);
				bean.setContent(content);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("nextLineNo");
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch(SQLException e) {
				System.out.println("nextLineNo");
			}
		}
		return bean;
	}
}
