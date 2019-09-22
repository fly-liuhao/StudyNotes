/**
* @项目名称: Javacore
* @文件名称: FileDemo.java
* @Date: 2019年7月10日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava15.file;

import java.io.File;
import java.io.IOException;

/**
 * 创建、删除文件以及文件夹
 * 
 * @author: liuhao
 * @version 1.0
 */
public class GreateFile {
    public static void main(String[] args) {
        /* 创建一个File对象 */
        File file = new File("src/cn/edu/tit/corejava15/file/demo.txt");
        /* 创建一个文件 */
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File creation failed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* 拆个年间一个File对象 */
        File folder = new File("src/cn/edu/tit/corejava15/file/demo");
        /* 创建一个文件夹 */
        if (folder.mkdir()) {
            System.out.println("Folder created successfully.");
        } else {
            System.out.println("Folder creation failed.");
        }

        /* 删除文件 */
        file.delete();
        /* 删除文件夹 */
        folder.delete();
    }

}
