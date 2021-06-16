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
}
