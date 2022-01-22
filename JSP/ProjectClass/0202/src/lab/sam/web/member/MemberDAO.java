package lab.sam.web.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public MemberDAO() {
		try {
			String str = "oracle.jdbc.OracleDriver";
			Class.forName(str);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DriverManager");
		}
	}
	
	private void getConnection() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";	// localhost, port=1521
			String user = "KKS";
			String password = "kks";
			con = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Connection");
		}
	}
	
	public boolean join(MemberBean bean) {
		boolean check = false;
		String sql = "insert into members values(?,?,?,?,?,sysdate)";
		try {
			getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getId());
			ps.setString(2, bean.getPassword());
			ps.setString(3, bean.getName());
			ps.setString(4, bean.getEmail());
			ps.setString(5, bean.getPhone());
			
			if(ps.executeUpdate() != 0) {check = true;}
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Join");
		} finally {
			try {
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch(SQLException e) {
				System.out.println("Join");
			}
		}
		
		return check;
	}
	
	public MemberBean memberCheck(MemberBean bean) {
		String password = "";
		String sql = "select password from members where id=?";
		try {
			getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bean.getId());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				password = rs.getString(1);
			}
			
			bean.setPassword(password);
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Join");
		} finally {
			try {
				if(ps != null) {ps.close();}
				if(con != null) {con.close();}
			} catch(SQLException e) {
				System.out.println("MemberCheck");
			}
		}
		
		return bean;
	}
}
