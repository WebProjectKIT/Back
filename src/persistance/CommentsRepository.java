package persistance;

import domain.Comments;
import domain.PortfolioBoard;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class CommentsRepository {

    private static CommentsRepository instance;
    private static DataSource ds;

    private CommentsRepository() { }

    public static CommentsRepository getInstacne() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/mariadb");
                return instance = new CommentsRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void save(Comments comments) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO COMMENTS(email, posting_id, contents) values(?, ?, ?)";
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, comments.getEmail());
            pstmt.setString(2, String.valueOf(comments.getPostingId()));
            pstmt.setString(3, comments.getContents());

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

    public ArrayList<Comments> findAllCommentOfPost(long id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM COMMENTS WHERE (posting_id = ?)";
        ArrayList<Comments> commentList = new ArrayList<Comments>();
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int commentId = rs.getInt("comment_id");
                String email = rs.getString("email");
                int postingId = rs.getInt("posting_id");
                Timestamp creationDate = rs.getTimestamp("creation_date");
                String contents = rs.getString("contents");

                Comments comment = new Comments(commentId, email, postingId, creationDate, contents);
                commentList.add(comment);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
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
        return commentList;
    }
}
