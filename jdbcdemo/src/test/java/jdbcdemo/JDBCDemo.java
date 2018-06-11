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

//      Low level SQL
        String sql = "SELECT * from cursist";

        ResultSet rs = stmt.executeQuery(sql);

        List<Cursist> cursisten = new ArrayList<>();

//      Hier voeren we al een object relational mapping uit
//      ORM mapping verstopt in code = lastig onderhoudbaar
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
