package io.oicp.yorick61c.druidUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * druid工具类：
 * 1.提供静态代码块，加载配置文件，初始化连接池对象
 * 2.提供方法
 *     1.获取连接：通过数据库连接池获取链接
 *     2.释放资源
 *     3.获取连接池的方法
 * */
public class druidUtils {
    //    1.定义成员变量 DataSource
    private static DataSource dataSource;

    static {
//        1.加载配置文件
        Properties properties = new Properties();
        try {
            properties.load(druidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //    方法：获取连接
    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }

    //    方法：释放资源
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if(resultSet != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        ***归还连接***
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement statement, Connection connection) {
        druidUtils.close(null,statement,connection);
    }
    //    获取连接池
    public static DataSource getDataSource() {
        return dataSource;
    }
}