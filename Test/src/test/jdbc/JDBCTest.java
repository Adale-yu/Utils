package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {

	public static void main(String[] args) {
		testJDBC();
	}
	
	public static void testJDBC() {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String pid = "391";
			String cname = "开朗的封印师";
			int zid = 2;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/platform391?characterEncoding=utf-8", "root", "123456");
			String sql = "select * from login_server where cname = ? and sid = ? and pid in ("+pid+")";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cname);
			pstm.setInt(2, zid);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				
				
				System.out.println(id + "--");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(rs != null) {
					rs.close();
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
}
