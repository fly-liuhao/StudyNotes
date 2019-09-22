/**
* @项目名称: Javacore
* @文件名称: TestSwitch.java
* @Date: 2019年5月10日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

/**
 * switch测试
 * 
 * @author: liuhao
 * @version 1.0
 */
public class TestSwitch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String addr = "titabc";
        switch (addr) {
        case "china":
            System.out.println("china");
            break;
        case "tit":
            System.out.println("tit");
            break;
        default:
            System.out.println("other");
            break;
        }
    }

}
