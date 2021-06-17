package persistance;

import domain.Member;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class BookmarkRepository {

    private static BookmarkRepository instance;
    private static DataSource ds;

    private BookmarkRepository() { }

    public static BookmarkRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/mariadb");
                return instance = new BookmarkRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }

    public int[] getListByEmail(String email){  // email을 입력받아 해당 유저가 북마크 해 둔 게시글들의 id를 int배열 형태로 반환

        int [] list = null;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM BOOKMARK WHERE email = ?";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            rs = pstmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            list = new int[columnCount];
            int idx = 0;

            if(rs.next()) { list[idx] = rs.getInt(2); }


        } catch(SQLException e) {
            e.printStackTrace();

        } finally {

            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }


        return list;
    }


    public boolean isBookmarked(String email, int postingID){

        boolean result = false;


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM BOOKMARK WHERE email = ? AND posting_id = ?";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setInt(2, postingID);

            rs = pstmt.executeQuery();

            if(rs.next()) result = true;


        } catch(SQLException e) {
            e.printStackTrace();

        } finally {

            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

        }


        return result;
    }

    public void insertBookmark(String email, int postingID){

        Connection conn = null;
        PreparedStatement pstmt = null;

        System.out.println("repo");
        System.out.println(postingID);

        String sql = "INSERT INTO BOOKMARK(email, posting_id) values(?,?)";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setInt(2, postingID);

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


    public void deleteBookmark(String email, int postingID){

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM BOOKMARK WHERE (email=?) AND (posting_id=?)";

        try {

            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, email);
            pstmt.setInt(2, postingID);

            pstmt.executeUpdate();

        }catch(SQLException e) {
            e.printStackTrace();

        } finally {
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
