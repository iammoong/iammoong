package tommy.web.boardone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private static BoardDAO instance = null;

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	} // getInstance()

	public void insertArticle(BoardVO article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = article.getNum();
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
		int number = 0;
		String sql = "";
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select max(num) from board");
			rs = pstmt.executeQuery();
			if (rs.next())
				number = rs.getInt(1) + 1;
			else
				number = 1;
			if (num != 0) { // 답변 글일 경우
				sql = "update board set step = step+1 where ref= ? and step > ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, step);
				pstmt.executeUpdate();
				step = step + 1;
				depth = depth + 1;
			} 
			else { // 새글일 경우
				ref = number;
				step = 0;
				depth = 0;
			}
				sql = "insert into board(num, writer, email, subject, pass, regdate, ref , step, depth, content, ip)"
						+ " values(board_seq.nextval, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, article.getWriter());
				pstmt.setString(2, article.getEmail());
				pstmt.setString(3, article.getSubject());
				pstmt.setString(4, article.getPass());
				pstmt.setTimestamp(5, article.getRegdate());
				pstmt.setInt(6, ref);
				pstmt.setInt(7, step);
				pstmt.setInt(8, depth);
				pstmt.setString(9, article.getContent());
				pstmt.setString(10, article.getIp());
				pstmt.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
	} // insertArticle()

	public int getArticleCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x = 0;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select count(*) from board");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}

		return x;
	} // getArticleCount()

	public List<BoardVO> getArticles(int start, int end){  //테이블에서 데이터를 가져올 메서드
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      List<BoardVO> articleList = null;
	      try {
	         conn=ConnUtil.getConnection();
	         pstmt= conn.prepareStatement("select * from (select rownum rnum, num, writer, email, subject, pass, regdate, readcount, ref, step, depth, content, ip from (select * from board order by ref desc, step asc)) where rnum >= ? and rnum <= ?");
	         pstmt.setInt(1, start);
	         pstmt.setInt(2, end);
	         rs=pstmt.executeQuery();
	         if(rs.next()) {
	            articleList = new ArrayList<BoardVO>(end-start+1); //수정<4>
	            do {
	               BoardVO article = new BoardVO();
	               article.setNum(rs.getInt("num"));
	               article.setWriter(rs.getString("writer"));
	               article.setEmail(rs.getString("email"));
	               article.setSubject(rs.getString("subject"));
	               article.setPass(rs.getString("pass"));
	               article.setRegdate(rs.getTimestamp("regdate"));
	               article.setReadcount(rs.getInt("readcount"));
	               article.setRef(rs.getInt("ref"));
	               article.setStep(rs.getInt("step"));
	               article.setDepth(rs.getInt("depth"));
	               article.setContent(rs.getString("content"));
	               article.setIp(rs.getString("ip"));
	               articleList.add(article);
	            }while(rs.next());
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null)pstmt.close();
	            if(conn != null)conn.close();
	         }catch(SQLException e) {
	         }

	      }
	      return articleList;
	   }

	public BoardVO getArticle(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("update board set readcount = readcount + 1 where num = ?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("select * from board where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPass(rs.getString("pass"));
				article.setRegdate(rs.getTimestamp("regdate"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setStep(rs.getInt("step"));
				article.setDepth(rs.getInt("depth"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		return article;
	} // getArticle

//	public BoardVO viewArticle(int num) {
//		
//		getArticle(num);
//		
//		BoardVO vo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = ConnUtil.getConnection();
//			pstmt = conn.prepareStatement("select * from board where num = ?");
//			pstmt.setInt(1, num);
//			rs = pstmt.executeQuery();
//
//			if (rs.next()) {
//				vo = new BoardVO();
//				vo.setNum(rs.getInt("num"));
//				vo.setWriter(rs.getString("writer"));
//				vo.setEmail(rs.getString("email"));
//				vo.setSubject(rs.getString("subject"));
//				vo.setPass(rs.getString("pass"));
//				vo.setRegdate(rs.getTimestamp("regdate"));
//				vo.setReadcount(rs.getInt("readcount"));
//				vo.setRef(rs.getInt("ref"));
//				vo.setStep(rs.getInt("step"));
//				vo.setDepth(rs.getInt("depth"));
//				vo.setContent(rs.getString("content"));
//				vo.setIp(rs.getString("ip"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs);
//			JDBCUtil.close(pstmt);
//			JDBCUtil.close(conn);
//		}
//		return vo;
//	} // viewArticle()
//
//	public void replyForm(BoardVO reply) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		int ref = reply.getRef();
//		int step = reply.getStep();
//		int depth = reply.getDepth();
//		try {
//			conn = ConnUtil.getConnection();
//			pstmt = conn.prepareStatement("update board set step+1 where ref= ? and step > ?");
//			pstmt.setInt(1, ref);
//			pstmt.setInt(2, step);
//			pstmt.executeUpdate();
//			step = step + 1;
//			depth = depth + 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(pstmt);
//			JDBCUtil.close(conn);
//		}
//	} // reply
//
//	public void insertContent(BoardVO Content) {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int ref = Content.getRef();
//		int step = Content.getStep();
//		int depth = Content.getDepth();
//		int number = 0;
//		String sql = "";
//		try {
//			conn = ConnUtil.getConnection();
//			ref = number;
//			step = 0;
//			depth = 0;
//			sql = "insert into board(num, writer, email, subject, pass, regdate, ref , step, depth, content, ip)"
//					+ " values(board_seq.nextval, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, Content.getWriter());
//			pstmt.setString(2, Content.getEmail());
//			pstmt.setString(3, Content.getSubject());
//			pstmt.setString(4, Content.getPass());
//			pstmt.setTimestamp(5, Content.getRegdate());
//			pstmt.setInt(6, ref);
//			pstmt.setInt(7, step);
//			pstmt.setInt(8, depth);
//			pstmt.setString(9, Content.getContent());
//			pstmt.setString(10, Content.getIp());
//			pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			JDBCUtil.close(rs);
//			JDBCUtil.close(pstmt);
//			JDBCUtil.close(conn);
//		}
//	} // insertContent()
	
	public BoardVO updateGetArticle(int num) {
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select * from board where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setWriter(rs.getString("writer"));
				vo.setEmail(rs.getString("email"));
				vo.setSubject(rs.getString("subject"));
				vo.setPass(rs.getString("pass"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setRef(rs.getInt("ref"));
				vo.setStep(rs.getInt("step"));
				vo.setDepth(rs.getInt("depth"));
				vo.setContent(rs.getString("content"));
				vo.setIp(rs.getString("ip"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		return vo;
		
	} // updateGetArticle()
	
	public int updateArticle(BoardVO article) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		String sql="";
		int result = -1;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select pass from board where num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbpasswd = rs.getString("pass");
				if(dbpasswd.equals(article.getPass())) {
					sql = "update board set writer = ?, email = ?, subject = ?, content = ? where num = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getEmail());
					pstmt.setString(3, article.getSubject());
					pstmt.setString(4, article.getContent());
					pstmt.setInt(5, article.getNum());
					pstmt.executeUpdate();
					result = 1; // 수정 성공
				}
			} else {
				result = 0; // 수정 실패
			} // if else
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		return result;
	} // updateArticle()
	
	public int deleteArticle(int num, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String dbpasswd = "";
		int result = -1;
		try {
			conn = ConnUtil.getConnection();
			pstmt = conn.prepareStatement("select pass from board where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("pass");
				if(dbpasswd.equals(pass)) {
					 pstmt = conn.prepareStatement("delete from board where num = ?");
					 pstmt.setInt(1, num);
					 pstmt.executeUpdate();
					 result = 1; // 글삭제 성공
				} else {
					result = 0;
				} // if~else
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
			JDBCUtil.close(conn);
		}
		return result;
	}
}
