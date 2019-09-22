/**
* @项目名称: UOL
* @文件名称: IUserDao.java
* @Date: 2019年7月17日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import com.ychs.uol.vo.User;

/**
 * 用户管理模块DAO接口
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface IUserDao {

    /**
     * 根据用户名及密码判断用户是否登陆成功
     * 
     * @param nameName 用户名
     * @param userPwd  用户密码
     * @return 登陆成功返回 true， 登陆失败返回 false
     */
    public boolean checkUser(String nameName, String userPwd);
    
    /**
     * 添加用户
     * @param user 封装用户数据的对象
     * @return 添加成功返回1，添加失败返回0
     */
    public int insertUser(User user);
    
    /**
     * 修改用户
     * @param user 分装的用户对象
     * @return 修改成功返回1，失败返回0
     */
    public int updateUser(String userid, User user);
    
    /**
     * 删除用户
     * @param userid 用户id
     * @return 删除成功返回1，失败返回0
     */
    public int deleteUser(String userid);
    
    /**
     * 禁止用户功能
     * @param userid 用户id
     * @return 禁用成功返回1，失败返回0
     */
    public int banUser(String userid);

}
