import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
* @项目名称: Log4j2_Demo
* @文件名称: Calc.java
* @Date: 2019年7月10日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/

/**
 * 测试log4j2
 * @author: liuhao
 * @version 1.0
 */
public class Calc2 {

    /**
     * 
     * @param num1 被除数
     * @param num2 除数
     * @return 两数相除结果
     * @throws Exception
     */
    public static double div(double num1, double num2) throws Exception {
        if (num2 == 0) {
            /*手动抛出异常*/
            throw new Exception();
        }
        return num1 / num2;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请输入被除数和除数：");
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        double result = 0;

        Logger logger = LogManager.getLogger(Calc2.class); 
        try {
            result = div(num1, num2);
        } catch (Exception e) {
            /*生成日志信息*/
            logger.error(e);
            logger.info(e);
            logger.warn(e);
        }
        System.out.println("结果为2：" + result);
    }
}
