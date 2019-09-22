### Java I/O
#### 一、存放数据的几个地方
- 内存--Redis***【标记】
- 磁盘---文件
- 数据库
#### 二、什么是I/O
- input：读文件
- output：写文件
#### 三、java.io.File
1. 查看文档
2. 常用函数
- File(String pathname) //构造函数
- boolean exists()  //判断文件是否存在
- long length()  //文件所占字节长度/大小
- boolean createNewFile()   //新建文件
- boolean mkdir()  //新建文件夹
- boolean delete()  //删除文件/文件夹
> 参考：GreateFile.java


#### 四、文件读写问题
1. 按字节读写（二进制文件、文本文件）
读：输入流（FileInputStream）
写：输出流（FileOutputStream）
2. 按字符读写（文本文件）
读：输入流（FileReader）
写：输出流（FileWrite）
有格式文件：POI组件
3. 按行读取
Java.io.buffer
4. JDK8中文件读取方式
> 参考：FileOperation.java

#### 五、对象序列化 和 反序列化
JavaBean EJB--企业级对象
- 序列化目的：将内存对象包含的属性值保存到硬盘上，长期保存对象数据
- 反序列化：将硬盘中存放的数据载入到内存对象中
- 使用场景：两台电脑传输类对象
- 问题：那种类的对象可以序列化？
  如果一个类的对象要被序列化，这个类要实现一个接口：java.io.Serializable---标志接口
  > 标志接口，作用：让一个类的对象可以序列化 eg:Remo
  > 暂态关键字：transient，让不想让序列化的属性不参加序列化，eg:网络上传的敏感信息：密码
