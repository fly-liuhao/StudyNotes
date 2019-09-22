/**
* @项目名称: Javacore
* @文件名称: Test6.java
* @Date: 2019年6月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava12;

import java.util.Scanner;

/**
 * 任务6：输入学号，输出该生入学年份
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Test6 {

    public int getYear(String sid) {
        String str = sid.substring(0, 2);
        return Integer.parseInt("20" + str);
    }

    public static void main(String[] args) {
        Test6 test6 = new Test6();
        Scanner scanner = new Scanner(System.in);
        System.out.println(test6.getYear(scanner.next()));
    }
}
