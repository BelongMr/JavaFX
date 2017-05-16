package sample.db;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接测试库
 * Created by belong on 2017/4/12.
 */
public class OracleConn {
    private static Connection conn;
    private static InputStream is;
    private static DataSource ds;
    private static Properties pro;
    static {
        String path = OracleConn.class.getClassLoader().getResource("sample/resources/db/dbcpT.ini").getPath();
        pro = new Properties();
        try {
            is = new FileInputStream(path);
            pro.load(is);
            ds = BasicDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }
    public static Connection getConnection(){
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
