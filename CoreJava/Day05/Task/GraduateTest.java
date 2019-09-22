/**
* @项目名称: Javacore
* @文件名称: GraduateTest.java
* @Date: 2019年4月27日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava06;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class GraduateTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Graduate stu1 = new Graduate("张三", 75, 45, 56);
        Graduate stu2 = new Graduate("李四", 95, 25, 47);
        System.out.println(stu1.getName() + "考研结果：" + stu1.judgeResult());
        System.out.println(stu2.getName() + "考研结果：" + stu2.judgeResult());

        /**********************************************************************************/
        // 面试题：
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        int e = 50;

        // 短路与：如果前面的表达式已经能够确定最终结果了，后面的式子就不执行了
        if ((a > b) && (++c < d)) {
            System.out.println("right1");
        }
        System.out.println("c = " + c);// 30

        // 一般的与&：所有式子都要被执行
        if ((a > b) & (++c < d)) {
            System.out.println("right2");
        }
        System.out.println("c = " + c);// 31

        // 短路或：前面的式子能确定最终结果了，后面不计算了。
        if ((a < b) || (++c < d)) {
            System.out.println("right3");
        }
        System.out.println("c = " + c);// 31

        // 一般的或|：所有式子都要被执行
        if ((a < b) | (++c < d)) {
            System.out.println("right4");
        }
        System.out.println("c = " + c);// 32

    }

}
