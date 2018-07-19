package MySQL;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by DELL on 2018/7/17.
 */
public class JdbcWORK {
    //连接数据库方法
    private Connection getconnection(){
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
    private void Close( Connection connection, Statement statement,ResultSet resultSet ){


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

    //添加数据
    private void   Insert(int i, String name, String publish, String author) {
        Connection connection=getconnection();
        Statement statement=null;

        try {

            String sql = "insert into book(book_name,book_publishers,book_author)" + " VALUES ('" +name+"','" +publish + "','" + author+ "')";
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            //int rows = statement.executeUpdate(sql);
            // System.out.print("ok" + rows);
        } catch (SQLException E) {
            E.printStackTrace();
        }
        finally {
            Close(connection,statement,null);
        }

    }
    //修改数据
    private void Update(int id,String name,String publish,String author){
        Connection connection=getconnection();
        Statement statement=null;

        try {
            String sql = "update account set book_name='"+name+"',book_publishers='"+publish+"',book_author='"+author+"'where id="+id;
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close(connection,statement,null);
        }

    }
    //查询

    private  void  Select(){
        Connection connection=getconnection();
        Statement statement=null;
        ResultSet resultSet=null;
        String sql="select  id ,book_name,book_publishers,book_author from book";
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            StringBuffer buffer=new StringBuffer();
            buffer.append("******************************"+System.lineSeparator());
            buffer.append("***********查询结果***********"+System.lineSeparator());
            buffer.append("*****************************"+System.lineSeparator());
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("book_name");
                String publish= resultSet.getString("book_publishers");
                String author=resultSet.getString("book_author");
                buffer.append(id + "\t|" + name+ "|\t" + publish +"\t|"+author+ "|" + System.lineSeparator());
                System.out.print(buffer);
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close(connection,statement,resultSet);
        }
    }
    //删除数据
    private void Delete(int id){
        Connection connection=getconnection();
        Statement statement=null;
        try {
            String sql = "delete from account where id="+id;
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();

        }
        finally {
            Close(connection,statement,null);
        }

    }

    //模糊查询
    private void  LikeSelect(String name,String author){
        Connection connection=getconnection();
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            String sql="select  id ,book_name,book_publishers,book_author from book where book_name like '%"+name+"' or like '%"+author+"'";
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            StringBuffer buffer=new StringBuffer();
            buffer.append("******************************"+System.lineSeparator());
            buffer.append("***********查询结果***********"+System.lineSeparator());
            buffer.append("*****************************"+System.lineSeparator());
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("book_name");
                String publish1 = resultSet.getString("book_publishers");
                String author1 = resultSet.getString("book_author");
                buffer.append(id + "\t|" + name1 + "|\t" + publish1 + "\t|" + author1 + "|" + System.lineSeparator());
                System.out.print(buffer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            Close(connection,statement,resultSet);
        }
    }
    //主函数
    public static void main(String[] args){
        String value = null;
        JdbcWORK jdbcwork = new JdbcWORK();

        while(true) {
            System.out.println("==============================");
            System.out.println("|    欢迎使用baba的人工智能    |");
            System.out.println("==============================");
            System.out.println("|*******1、添加数据***********|");
            System.out.println("|*******2、修改数据***********|");
            System.out.println("|*******3、查询数据***********|");
            System.out.println("|*******4、删除数据***********|");
            System.out.println("|*******5、模糊查询***********|");
            System.out.println("|*******6、退出系统***********|");
            System.out.println("请选择：");
            Scanner input = new Scanner(System.in);
            int select = input.nextInt();
            while (select < 1 || select > 6) {
                System.out.println("请重新选择");
                select = input.nextInt();
            }
            if (select == 1) {
                System.out.println("请输入添加的书名、出版社、作者，例如：祝福，人民，鲁迅");
                value = input.next();
                String[] values = value.split(",");
                jdbcwork.Insert((int)System.currentTimeMillis(),values[0],values[1],values[2]);
            } else if (select == 2) {
                System.out.println("请输入修改的书名、出版社、作者、id，例如：5、祝福，人民，鲁迅、");
                value=input.next();
                String[] values=value.split(",");
                jdbcwork.Update(Integer.parseInt(values[0]),values[1],values[2],values[3]);

            } else if (select == 3) {
                jdbcwork.Select();

            } else if (select == 4) {
                System.out.println("请输入要删除的id");
                value=input.next();
                String[] values=value.split(",");
                jdbcwork.Delete(Integer.parseInt(values[0]));

            } else if (select == 5) {
                System.out.println("请输入查询的关键字");
                value=input.next();
                String[] values=value.split(",");
                jdbcwork.LikeSelect(values[0],values[1]);

            } else if (select == 6) {
                System.exit(-2);

            }
        }
    }
}
