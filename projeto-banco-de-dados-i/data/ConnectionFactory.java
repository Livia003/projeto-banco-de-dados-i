package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  //Usuario do Banco de dados
    private static final String USERNAME = "postgres";

     //Usuario do Banco de dados
    private static final String PASSWORD = "1608";

     //Usuario do Banco de dados
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/app";


    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        return conexao;
    }
}

