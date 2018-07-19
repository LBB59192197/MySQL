package DAO;

import java.sql.*;

/**
 * Created by DELL on 2018/7/18.
 */
public class JDBCDemoUitl {
    public static Connection getconnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost/baba";
            try {
                Connection connection= DriverManager.getConnection(dbURL,"root","lld591921917");
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    //释放数据库连接
    public static void close(Connection connection, Statement statement, ResultSet resultSet ){


        try {

            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
                ;
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
