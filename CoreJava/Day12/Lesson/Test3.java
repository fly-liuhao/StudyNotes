/**
* @项目名称: Javacore
* @文件名称: Test3.java
* @Date: 2019年6月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava12;

import java.util.Scanner;

/**
 * 任务3：输入身份证号，判断最后一位是不是x
 * 
 * @author: Liuhao
 * @version 1.0
 */
public class Test3 {
    /**
     * 判断身份证号
     * 
     * @return
     */
    public boolean checkIO(String id) {
        return id.endsWith("x");
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.print("请输入身份证号：");
        Scanner scanner = new Scanner(System.in);
        String idString = scanner.next();
        System.out.println("结果：" + test3.checkIO(idString));
    }
}
