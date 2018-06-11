package jdbcdemo;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    @Test
    public void openEenConnectieNaarMysql() throws SQLException {

        String url = "jdbc:mysql://localhost/cursisten";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement stmt = connection.createStatement();

        String sql = "SELECT * from cursist";

        ResultSet rs = stmt.executeQuery(sql);

        List<Cursist> cursisten = new ArrayList<>();
        while (rs.next()){
            int id = rs.getInt("id");
            String naam = rs.getString("naam");
            String organisatie = rs.getString("organisatie");
            Cursist cursist = new Cursist(id, naam, organisatie);
            cursisten.add(cursist);
        }

        for (Cursist cursist : cursisten){
            System.out.println(cursist.getNaam());
        }

        connection.close();

    }

}
