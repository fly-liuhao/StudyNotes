/**
* @项目名称: Javacore
* @文件名称: ReadFile.java
* @Date: 2019年6月8日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 函数抛出异常，调用者处理异常
 * 
 * @author: liuhao
 * @version 1.0
 */
public class ReadFile {
    public void read() throws FileNotFoundException, ArithmeticException {
        FileInputStream fs = new FileInputStream("a.txt");
    }

    /**
     * @param args
     * @throws ArithmeticException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, ArithmeticException {
        ReadFile readFile = new ReadFile();
        readFile.read();

    }

}
