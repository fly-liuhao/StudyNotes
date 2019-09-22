/**
* @项目名称: Javacore
* @文件名称: ChangeMobile.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava13;

import java.util.Scanner;

/**
* 任务：更改手机号：188****5486
* @author: liuhao
* @version 1.0
*/
public class ChangeMobile {
    /**
     * 
     * @param oldMobile 旧手机号
     * @return 替换后新的手机号
     */
    public String change(String oldMobile) {
        StringBuilder stringBuilder = new StringBuilder(oldMobile);
        stringBuilder.replace(3, 7, "****");
        return stringBuilder.toString();       
    }
    
    /**
     * 通过拆分后拼接得到新新隐藏的手机号
     * @param oldMobile 旧手机号
     * @return 替换后新的手机号
     */
    public String change2(String oldMobile) {
      
        String firstString = oldMobile.substring(0, 3);
        String endString = oldMobile.substring(7);
        return firstString+"****"+endString;
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入手机号:");
        String phoneNumber = scanner.next();
        
        ChangeMobile test = new ChangeMobile();
        System.out.println(test.change(phoneNumber));
        System.out.println(test.change2(phoneNumber));
    }

}
