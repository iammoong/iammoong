package tommy.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TempMemberDAO {

//	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
//	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
//	private final String USER = "mytest";
//	private final String PASS = "mytest";
	// private ConnectionPool pool = null;

	public TempMemberDAO() {
//		try {
//			//Class.forName(JDBC_DRIVER);
//			pool = ConnectionPool.getInstance();
//		} catch (Exception e) {
//			System.out.println("드라이버 로딩 실패");
//		}
	}

	private Connection getConnection() {
		Connection conn = null;
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/myOracle");
			conn = ds.getConnection();

		} catch (NamingException ne) {
			ne.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return conn;
	} //getConnection()

	public Vector<TempMemberVO> getMemberList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Vector<TempMemberVO> vecList = new Vector<TempMemberVO>();
		try {
			conn = getConnection();
			// pool.getConnection();
			// DriverManager.getConnection(JDBC_URL, USER, PASS);
			stmt = conn.createStatement();
			String query = "select * from tempmember";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				TempMemberVO vo = new TempMemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setMem_num1(rs.getString("mem_num1"));
				vo.setMem_num2(rs.getString("mem_num2"));
				vo.setEmail(rs.getString("e_mail"));
				vo.setPhone(rs.getString("phone"));
				vo.setZipcode(rs.getString("zipcode"));
				vo.setAddress(rs.getString("address"));
				vo.setJob(rs.getString("job"));
				vecList.add(vo);
			}
		} catch (Exception e) {
			System.out.println("Exception" + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					// pool.releaseConnection(conn);
					conn.close();
				} catch (SQLException e) {
				}
		} // finally
		return vecList;

	} // getMemberList()
}
