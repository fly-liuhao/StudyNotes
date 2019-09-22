/**
* @项目名称: UOL
* @文件名称: DBUtil.java
* @Date: 2019年7月17日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ietf.jgss.Oid;

/**
 * 数据库链接实用类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class DBUtil {
    /**
     * 获取Oracle数据库链接
     * 
     * @return 数据库的链接对象
     */
    public static Connection getConnection() {
        /** 定义一个链接对象，Connection是一个接口 */
        Connection conn = null;//
        try {
            /** 注册Oracle驱动，参数是Oracle数据库驱动的名称 */
            Class.forName("oracle.jdbc.OracleDriver");
            /** 链接字符串（主协议、子协议、链接方式） */
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            /** 链接字符串（主协议、子协议、链接方式） */
            conn = DriverManager.getConnection(url, "scott", "scott");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库链接
     * 
     * @param conn 数据库的链接对象
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭结果集对象
     * 
     * @param rs 结果集
     */
    public static void closeRs(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭预编译对象
     * 
     * @param pstmt 预编译对象
     */
    public static void closePstmt(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
