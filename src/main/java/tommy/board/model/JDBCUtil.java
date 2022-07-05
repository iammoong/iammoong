package tommy.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	
	public static void close(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // close(conn)
	
	public static void close(PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // close(conn)
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	} // close(conn)

}
