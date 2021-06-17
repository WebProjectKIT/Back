package persistance;

import domain.Portfolio;
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

    public static PortfolioBoardRepository getInstance() {
        if (instance == null) {
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
        } finally {
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

    public ArrayList<PortfolioBoard> getBookmarkedPortfoliosByIDList(ArrayList<Integer> idList) {

        ArrayList<PortfolioBoard> result = new ArrayList<>();

        ArrayList<PortfolioBoard> postingList = findAll();

        for (int idx : idList) {
            System.out.println("idx : " + idx);
            System.out.println();
            for (PortfolioBoard posting : postingList) {  // 모든 포스팅에 대해서
                System.out.println("posting : " + posting.getPostingId());
                if (posting.getPostingId() == idx) {    // id 리스트에 존재하는 포스팅일 경우 결과 리스트에 추가
                    result.add(posting);

                }
            }
            System.out.println();

        }

        return result;

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

                post = new PortfolioBoard(postingId, email, portfolioId, title, contents, creationDate, view);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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


        String sql = "INSERT INTO PORTFOLIO_BOARD(email, portfolio_id, title, contents, view) values(?,?,?,?,?)";
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, board.getEmail());
            pstmt.setLong(2, board.getPortfolioId());
            pstmt.setString(3, board.getTitle());
            pstmt.setString(4, board.getContents());
            pstmt.setLong(5, board.getView());

            pstmt.executeUpdate();
        } catch (SQLException e) {
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

        } catch (SQLException e) {
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

    public int getTotalBoardCount() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        int total = 0;

        String sql = "SELECT count(*) FROM PORTFOLIO_BOARD";

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
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return total;
    }

    public ArrayList<PortfolioBoard> getChunkList(int start, int end) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM PORTFOLIO_BOARD ORDER BY posting_id DESC LIMIT " + start + "," + end;

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
        } finally {
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


    public ArrayList<PortfolioBoard> getMyPortfolio(String memberId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM PORTFOLIO_BOARD WHERE (email=?) ORDER BY portfolio_id DESC LIMIT " + 0 + "," + 3;

        ArrayList<PortfolioBoard> myPortfolioBoard = new ArrayList<PortfolioBoard>();

        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int postingId = rs.getInt("posting_id");
                String email = rs.getString("email");
                int portfolioId = rs.getInt("portfolio_id");
                String title = rs.getString("title");
                String contents = rs.getString("contents");
                Timestamp creationDate = rs.getTimestamp("creation_date");
                int view = rs.getInt("view");
                PortfolioBoard board = new PortfolioBoard(postingId, email, portfolioId, title, contents, creationDate, view);
                myPortfolioBoard.add(board);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return myPortfolioBoard;
    }
}
