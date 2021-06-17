package persistance;

import domain.PortfolioBoard;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PortfolioBoardRepository {
    private static PortfolioBoardRepository instance;
    private static DataSource ds;
    private PortfolioBoardRepository() {

    }
    public static PortfolioBoardRepository getInstacne() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/mariadb");
                System.out.println("hello");
                return instance = new PortfolioBoardRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("hi");
        return instance;
    }


    public static ArrayList<PortfolioBoard> findAll() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM PORTFOLIO_BOARD";
        ArrayList<PortfolioBoard> boards = new ArrayList<PortfolioBoard>();

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
                int postingId = rs.getInt("posting_id");
                String email = rs.getString("email");
                int portfolioId = rs.getInt("portfolio_id");
                String title = rs.getString("title");
                String contents = rs.getString("contents");
                Timestamp creationDate = rs.getTimestamp("creation_date");
                int view = rs.getInt("view");
                PortfolioBoard board = new PortfolioBoard(postingId, email, portfolioId, title, contents, creationDate, view);
                boards.add(board);
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

    public PortfolioBoard findById(long id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PortfolioBoard post = null;

        String sql = "SELECT * FROM PORTFOLIO_BOARD WHERE (posting_id=?)";

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
                Long postingId = rs.getLong("posting_id");
                String email = rs.getString("email");
                Long portfolioId = rs.getLong("portfolio_id");
                String title = rs.getString("title");
                String contents = rs.getString("contents");
                Timestamp creationDate = rs.getTimestamp("creation_date");
                Long view = rs.getLong("view");

                post = new PortfolioBoard(postingId,email,portfolioId,title,contents,creationDate,view);
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

    public void save(PortfolioBoard board) {
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
//            pstmt.setString(2, board.getWriter());
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

    public void deleteById(long id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "DELETE FROM PORTFOLIO_BOARD WHERE (posting_id=?)";

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
}
