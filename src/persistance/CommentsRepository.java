package persistance;

import domain.Comments;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        String sql = "INSERT INTO COMMENTS(contents) values(?)";
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, comments.getContents());

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
}
