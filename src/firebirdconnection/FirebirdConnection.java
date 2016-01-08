package firebirdconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirebirdConnection {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:firebirdsql:localhost/3050:E:/rab_kopiy.fdb",
                    "SYSDBA", "masterkey");

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from NSTR");
        while (rs.next()) {
            System.out.println(rs.getString(1) + "   |||   " + rs.getString(2)  );
//                    + "   |||   " + rs.getString(3) + "   |||   " + rs.getString(4) 
//                    + "   |||   " + rs.getString(5) + "   |||   " + rs.getString(6));
        }
        connection.close();
    }
}
