/**
* @项目名称: Javacore
* @文件名称: Task1_14.java
* @Date: 2019年4月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 把用户输入的秒数折算成 X小时X分X秒
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Task1_14 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个秒数：");
        int number = sc.nextInt();

        int hour = number / 3600;
        int minute = (number % 3600) / 60;
        int second = (number % 3600) % 60;
        System.out.println("转换结果为：" + hour + "h-" + minute + "m-" + second + "s");

    }

}
