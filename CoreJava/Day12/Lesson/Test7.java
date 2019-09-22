/**
* @项目名称: Javacore
* @文件名称: Test7.java
* @Date: 2019年6月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava12;

import java.lang.Thread.State;
import java.util.Scanner;

/**
 * 任务7：输入教室占用状态，输出第3节是否有课
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Test7 {
    public String getClassroomSattus(String status) {
        String[] stateArray = status.split(",");
        for (String i : stateArray) {
            System.out.print(i + ",");
        }
        if (stateArray[2].endsWith("1")) {
            return "有课！";
        } else {
            return "没课！";
        }
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入教室状态,查看第三节是否有课？（教室状态例如：1，0，1，0，1）");
        String state = scanner.next();
        System.out.println(test7.getClassroomSattus(state));

    }
}
