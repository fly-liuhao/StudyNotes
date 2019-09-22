/**
* @项目名称: UOL
* @文件名称: UserDaoImpl.java
* @Date: 2019年7月17日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ychs.uol.dao.IUserDao;
import com.ychs.uol.util.DBUtil;
import com.ychs.uol.vo.User;

/**
 * 用户管理模块实现
 * 
 * @author: liuhao
 * @version 1.0
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public boolean checkUser(String userName, String userPwd) {
        /** 登陆状态：true--成功，false--失败 */
        boolean flag = false;

        /** 连接数据库 */
        Connection conn = null;
        /** 预编译对象 */
        PreparedStatement pstmt = null;
        /** 结果集 */
        ResultSet rs = null;

        /** 获取连接 */
        conn = DBUtil.getConnection();//
        /** 定义SQL语句 */
        String checkUserSQL = "SELECT * FROM users WHERE username = ? AND userpwd = ?";

        try {
            /** 准备SQL语句/创建一个执行SQL语句的对象 */
            pstmt = conn.prepareStatement(checkUserSQL);
            /** 给第参数?赋值 */
            pstmt.setString(1, userName);// 给第一个参数?赋值
            pstmt.setString(2, userPwd);// 给第二个参数?赋值
            /** 执行SQL语句 */
            rs = pstmt.executeQuery();// 执行查询

            /** 处理执行结果 */
            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeRs(rs);
            DBUtil.closePstmt(pstmt);
            DBUtil.closeConnection(conn);
        }
        return flag;
    }

    @Override
    public int insertUser(User user) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = DBUtil.getConnection();
        String insertUserSQL = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(insertUserSQL);
            pstmt.setString(1, (int) (Math.random() * 10000) + "");
            pstmt.setString(2, user.getUsername());
            pstmt.setString(3, user.getUserpwd());
            pstmt.setString(4, user.getRealname());
            pstmt.setString(5, user.getSex());
            pstmt.setString(6, user.getJob());
            pstmt.setString(7, user.getRemake());
            pstmt.setString(8, user.getStatus());
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePstmt(pstmt);
            DBUtil.closeConnection(conn);
        }
        return flag;
    }

    @Override
    public int updateUser(String userid, User user) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = DBUtil.getConnection();
        /** 定义SQL语句 */
        String updateUserSQL = "UPDATE users SET username=?, userpwd=?, realname=?, sex=?, job=?, remake=?, status=? WHERE userid = ?";
        try {
            pstmt = conn.prepareStatement(updateUserSQL);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getUserpwd());
            pstmt.setString(3, user.getRealname());
            pstmt.setString(4, user.getSex());
            pstmt.setString(5, user.getJob());
            pstmt.setString(6, user.getRemake());
            pstmt.setString(7, user.getStatus());
            pstmt.setString(8, userid);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePstmt(pstmt);
            DBUtil.closeConnection(conn);
        }

        return flag;
    }

    @Override
    public int deleteUser(String userid) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = DBUtil.getConnection();
        String deleteUserSQL = "DELETE users WHERE userid=?";

        try {
            pstmt = conn.prepareStatement(deleteUserSQL);
            pstmt.setString(1, userid);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePstmt(pstmt);
            DBUtil.closeConnection(conn);
        }
        return 0;
    }

    @Override
    public int banUser(String userid) {
        int flag = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;

        conn = DBUtil.getConnection();
        String banUserSQL = "UPDATE users SET status=0 WHERE userid = ?";

        try {
            pstmt = conn.prepareStatement(banUserSQL);
            pstmt.setString(1, userid);
            flag = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closePstmt(pstmt);
            DBUtil.closeConnection(conn);
        }
        return flag;
    }

}
