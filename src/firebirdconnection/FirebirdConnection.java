package firebirdconnection;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirebirdConnection {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("org.firebirdsql.jdbc.FBDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:firebirdsql:localhost/3050:E:/rab_kopiy.fdb",
                "SYSDBA", "masterkey");

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from NSTR");

        while (rs.next()) {
            System.out.println(rs.getString(1) + "   |||   " + rs.getString(2));    // + "   |||   " + rs.getString(3) + "   |||   " + rs.getString(4)
                                                                                    // + "   |||   " + rs.getString(5) + "   |||   " + rs.getString(6)
            if (rs.getString(1).equals("1")) {
                byte[] bdata = rs.getBlob(3).getBytes(1, (int) rs.getBlob(3).length());
                String data1 = new String(bdata);
                System.out.println("data: " + data1);
            }
        }
        connection.close();
    }
}
