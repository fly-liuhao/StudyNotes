/**
* @项目名称: Javacore
* @文件名称: Test5.java
* @Date: 2019年6月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava12;

import java.util.Scanner;

/**
 * 任务5：输入一个小数，判断该小数是否合法。
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Test5 {
    public boolean check(String number) {
        if (number.indexOf(".") == number.lastIndexOf(".")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("输入小数：");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        Test5 test5 = new Test5();
        System.out.println(test5.check(number));
    }
}
