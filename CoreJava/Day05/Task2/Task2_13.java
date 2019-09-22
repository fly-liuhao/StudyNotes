/**
* @项目名称: Javacore
* @文件名称: Task2_13.java
* @Date: 2019年5月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava05.task2;

import java.util.Scanner;

/**
 * 张三为他的手机设定了自动拨号 按1：拨爸爸的号 按2：拨妈妈的号 按3：拨爷爷的号 按4：拨奶奶的号
 *
 * @author: liuhao
 * @version 1.0
 */
public class Task2_13 {

    /**
     * 快速拨号
     * @param key 快速拨号号码
     */
    public void call(int key) {
        switch (key) {
        case 1:
            System.out.println("正在呼叫爸爸……");
            break;
        case 2:
            System.out.println("正在呼叫妈妈……");
            break;
        case 3:
            System.out.println("正在呼叫爷爷……");
            break;
        case 4:
            System.out.println("正在呼叫奶奶……");
            break;

        default:
            System.out.println("error：输入错误！");
            break;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task2_13 test = new Task2_13();
        Scanner sc = new Scanner(System.in);

        System.out.println("按1：拨爸爸的号 按2：拨妈妈的号 按3：拨爷爷的号 按4：拨奶奶的号 ");
        System.out.println("请按号：");
        test.call(sc.nextInt());
    }

}
