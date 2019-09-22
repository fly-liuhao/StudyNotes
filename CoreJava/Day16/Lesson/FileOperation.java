/**
* @项目名称: Javacore
* @文件名称: FileOperation.java
* @Date: 2019年7月10日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava15.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 文件相关的读写操作：按字节读写、按字符读写、按行读取、Java8新特性读取
 * 
 * @author: liuhao
 * @version 1.0
 */
public class FileOperation {

    /**
     * 按字节读取数据
     */
    public void readFileByStream() {
        /* 创建文件对象 */
        File file = new File("src/cn/edu/tit/corejava15/file/test_demo.txt");
        /* 创建文件读取流 */
        FileInputStream fis = null;
        try {
            /* 创建文件读取流对象 */
            fis = new FileInputStream(file);
            /* 定义一次读取的字节数 */
            byte[] buffer = new byte[1024];
            /* 读取操作 */
            while (fis.read(buffer) != -1) {
                /* 以String的形式打印到控制台，查看读取结果 */
                System.out.print(new String(buffer));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    /* 使用结束关闭读取流 */
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 按字节写入数据
     */
    private void writeFileByStream() {
        /* 创建文件对象 */
        File file = new File("src/cn/edu/tit/corejava15/file/test_demo.txt");
        /* 创建输出流 */
        FileOutputStream fos = null;

        try {
            /* 创建输出流对象 */
            fos = new FileOutputStream(file, true);// true表示原有内容追加写入，false表示覆盖原有内容
            /* 定义写入的内容 */
            String str = "这是一首简单的小情歌  唱着我们心头的白鸽\n\n";
            /* 写入操作 */
            fos.write(str.getBytes());
            /* 打印提示 */
            System.out.println("写入成功！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    /* 使用结束关闭输出流 */
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 按字符读取数据
     */
    public void readFileByChar() {
        /* 定义文件对象 */
        File file = new File("src/cn/edu/tit/corejava15/file/test_demo.txt");
        /* 创建Reader变量 */
        Reader reader = null;

        try {
            /* 实例化Reader对象 */
            reader = new FileReader(file);
            /* 定义一次读取的字符数 */
            char[] content = new char[1];
            /* 读取操作 */
            while (reader.read(content) != -1) {
                /* 打印查看读取结果 */
                System.out.print(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    /* 关闭 */
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 按字符写入数据
     */
    public void writeFileByChar() {
        /* 定义文件对象 */
        File file = new File("src/cn/edu/tit/corejava15/file/test_demo.txt");
        /* 创建Writer变量 */
        Writer writer = null;
        try {
            /* 实例化Writer对象 */
            writer = new FileWriter(file, true);
            /* 定义写入的内容 */
            String str = "这是一首简单的小情歌  唱着我们心头的白鸽\n\n";
            /* 写入操作 */
            writer.write(str);
            /* 打印提示 */
            System.out.println("写文件成功，请查看文件！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    /* 关闭 */
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 通过BufferedReader按行读取
     */
    public void readFileByLine() {
        /* 定义文件对象 */
        File file = new File("src/cn/edu/tit/corejava15/file/test_demo.txt");
        /* 声明BufferedReader类型变量 */
        BufferedReader bufferedReader = null;
        /* 保存读取结果 */
        String str = null;

        try {
            /* 实例化BufferedReader对象 */
            bufferedReader = new BufferedReader(new FileReader(file));
            // 每次读1行，直到读完为止
            while ((str = bufferedReader.readLine()) != null) {
                /* 打印读取结果 */
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    /* 关闭流 */
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Java8新特性，读取文件
     */
    public void readFileByLine_Java8() {
        List<String> lines;
        try {
            /* 将读取的结果全部放入List中 */
            lines = Files.readAllLines(Paths.get("src/cn/edu/tit/corejava15/file/test_demo.txt"),
                    StandardCharsets.UTF_8);
            /* 保存读取的每行内容，用于显示 */
            StringBuilder sb = new StringBuilder();
            for (String line : lines) {
                sb.append(line + "\n");
            }
            String fromFile = sb.toString();
            System.out.println(fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args 主函数参数
     */
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        /* 按字节读取数据 */
//        fileOperation.readFileByStream();
        /* 按字节写入数据 */
//        fileOperation.writeFileByStream();
        /* 按字符读取数据 */
//        fileOperation.readFileByChar();
        /* 按字符写入数据 */
//        fileOperation.writeFileByChar();
        /* 按行读取 */
//        fileOperation.readFileByLine();
        /* 按行读取-使用Java8新特性 */
        fileOperation.readFileByLine_Java8();
    }

}
