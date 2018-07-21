package DAO;

import java.sql.  *;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2018/7/19.
 */
public class SuperDAO {
    public int extendDML(String sql){
        Connection connection=JDBCDemoUitl.getconnection();

        return  0;
    }
    public List query(String sql) {
        Connection connection = JDBCDemoUitl.getconnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List datas = new ArrayList();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();//拿到结果集元数据对象
            int column = metaData.getColumnCount();//获取当前sql返回的列数量
            while (resultSet.next()) {
                Object[] columDatas = new Object[column];
                for (int i = 0; i < columDatas.length; i++) {
                    columDatas[i] = resultSet.getObject(i + 1);
                }
                datas.add(columDatas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCDemoUitl.close(connection, statement, resultSet);
        }
            return datas;
    }
}
