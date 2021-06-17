package persistance;

import domain.Portfolio;
import domain.PortfolioBoard;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class PortfolioRepository {

    private static PortfolioRepository instance;
    private static DataSource ds;

    private PortfolioRepository() { }

    public static PortfolioRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/mariadb");
                return instance = new PortfolioRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }

    public ArrayList<Portfolio> findByEmail(String email){

        ArrayList<Portfolio> result = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM PORTFOLIO WHERE email = ?";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                int postingId = rs.getInt("portfolio_id");
                String title = rs.getString("title");
                String link = rs.getString("link");
                Timestamp creationDate = rs.getTimestamp("creation_date");

                Portfolio board = new Portfolio(postingId, email, title, link, null, creationDate);
                result.add(board);

            }


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


    public boolean delete(int id) {


        boolean result = false;

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "DELETE FROM PORTFOLIO WHERE (portfolio_id=?)";

        try {

            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, id);

            if(pstmt.executeUpdate() == 1)
                result = true;

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


        return result;
    }


    public void write(String email, String title, String link) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO PORTFOLIO(email, title, link) values(?,?,?)";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, title);
            pstmt.setString(3, link);

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



    public int getTotalMyPortfolioCount(String email) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        int total = 0;

        String sql = "SELECT count(*) FROM PORTFOLIO WHERE email = ?";


        try {

            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                total = rs.getInt(1);
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
        return total;
    }

    public ArrayList<Portfolio> getChunkList(int start, int end, String email) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        String sql = "SELECT * FROM PORTFOLIO WHERE email = ? ORDER BY portfolio_id DESC LIMIT " + start + "," + end;

        ArrayList<Portfolio> myPortfolio = new ArrayList<>();

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int portfolioId = rs.getInt("portfolio_id");
                String title = rs.getString("title");
                String link = rs.getString("link");
                Timestamp creationDate = rs.getTimestamp("creation_date");


                Portfolio portfolio = new Portfolio(portfolioId, email, title, link, null, creationDate);

                myPortfolio.add(portfolio);
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
        return myPortfolio;
    }




}
