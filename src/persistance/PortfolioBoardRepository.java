package persistance;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PortfolioBoardRepository {

    private static PortfolioBoardRepository instance;
    private static DataSource ds;

    private PortfolioBoardRepository() { }

    public static PortfolioBoardRepository getInstance() {
        if(instance==null) {
            try {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/mariaDB");
                return instance = new PortfolioBoardRepository();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return instance;
    }



}
