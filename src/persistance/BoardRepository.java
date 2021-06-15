package persistance;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Board;
import domain.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.sql.Connection;

public class BoardRepository {
	private static BoardRepository instance;
	private static DataSource ds;
	private BoardRepository() {
		
	}
	public static BoardRepository getInstance() {
		if(instance==null) {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
				return instance = new BoardRepository();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;		
	}
	public void save(Board board){
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO BOARD(title, writer, contents) values(?,?,?)";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContents());

			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Board findById(Long id){

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board post = null;

		String sql = "SELECT * FROM BOARD WHERE (ID=?)";

		try {
			conn = ds.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Long iD = rs.getLong("id");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String contents = rs.getString("contents");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				String hit = rs.getString("hit");
				post = new Board(iD,title,writer,contents,regdate,hit);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return post;
	}

	public void update(Board board){
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "UPDATE BOARD set title=?, writer=?, contents=? where id=?";
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContents());
			pstmt.setString(4, board.getId().toString());

			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void deleteById(Long id){

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board post = null;

		String sql = "DELETE FROM BOARD WHERE (ID=?)";

		try {
			conn = ds.getConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public ArrayList<Board> findAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOARD";
		ArrayList<Board> boards = new ArrayList<Board>();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Long id = rs.getLong("id");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String contents = rs.getString("contents");
				LocalDateTime regdate = rs.getTimestamp("regdate").toLocalDateTime();
				String hit = rs.getString("hit");
				Board posts = new Board(id,title,writer,contents,regdate,hit);
				boards.add(posts);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}		
		return boards;
	}
}
