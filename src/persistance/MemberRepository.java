package persistance;

import domain.Member;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRepository {

    private static MemberRepository instance;
    private static DataSource ds;

    private MemberRepository() { }

    public static MemberRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/mariadb");
                return instance = new MemberRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }


    public Member login(String email, String password) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Member member = null;
        String sql = "SELECT * FROM MEMBER WHERE email = ? AND password = ?";

        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if(rs.next()) {

                email = rs.getString(1);
                String name = rs.getString(3);
                String phoneNum = rs.getString(4);

                member = new Member(email, null, name, phoneNum);
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

        return member;
    }
}
