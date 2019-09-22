/**
* @项目名称: Javacore
* @文件名称: Odd.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

import java.util.Scanner;

/**
 * 奇数类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Odd {

    /**
     * 判断输入数是否为奇数
     * 
     * @param number 输入的整数
     * @return true 是奇数， false 不是奇数
     */
    public boolean isOdd(int number) {
        if (number % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

}
