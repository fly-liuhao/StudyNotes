/**
* @项目名称: Javacore
* @文件名称: Animal.java
* @Date: 2019年6月2日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava10;

/**
 * 测试静态块、主方法、还有游离块的执行顺序
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Animal {
    static {
        System.out.println("111111");
    }
    static {
        System.out.println("222222");
    }
    // 只创建对象的时候调用
    {
        System.out.println("333333");
    }

    public static void main(String[] args) {
        System.out.println("444444");
        Animal dog = new Animal();
        Animal cat = new Animal();
    }
}
