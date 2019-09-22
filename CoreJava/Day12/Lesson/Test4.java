/**
* @项目名称: Javacore
* @文件名称: Test4.java
* @Date: 2019年6月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava12;

import java.util.Scanner;

/**
 * 任务4：输入用户名和密码，密码必须是6位，输出登录是否成功。
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Test4 {
    public String login(String userName, String password) {
        if (password.length() != 6) {
            return "密码必须是6位!";
        }
        if (userName.trim().equalsIgnoreCase("scott")) {
            return "登陆成功！";
        } else {
            return "登陆失败！";
        }
    }

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String userName = scanner.next();
        System.out.print("请输入密码：");
        String password = scanner.next();
        System.out.println(test4.login(userName, password));
    }

}
