/**
* @项目名称: UOL
* @文件名称: User.java
* @Date: 2019年7月17日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.vo;

/**
 * 用于封装user表的类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class User {
    private String userid;
    private String username;
    private String userpwd;
    private String realname;
    private String sex;
    private String job;
    private String remake;
    private String status;

    public User() {
        super();
    }


    public User(String username, String userpwd, String realname, String sex, String job, String remake,
            String status) {
        super();
        this.username = username;
        this.userpwd = userpwd;
        this.realname = realname;
        this.sex = sex;
        this.job = job;
        this.remake = remake;
        this.status = status;
    }


    public String getUserid() {
        return userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
