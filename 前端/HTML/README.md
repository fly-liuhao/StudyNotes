# Java
- 老师连系方式：李琦-18435108793  qq:1061388983
- 要求：打字至少100字以上

## 前端
1. HTML(超文本标记语言)
2. CSS（层叠样式表）
3. JS(JavaScript:Web编程脚本语言）
4. JQuery（JS轻量级的框架）:将JS的所有方法封装成简易的东西直接去调用
5. 封装的模板：JQueryUI、EasyUI、LayUI、[Bootstrap](http://www.bootcss.com/)
- 前端框架：https://www.uisdc.com/2019-10-front-frame
- 与前端有关的常见网站、博客、工具：https://zhuanlan.zhihu.com/p/62322155

### 一、HTML常用属性
- HTML5前一个版本是HTML4.01不是HTML4
- ` <meta charset="UTF-8">`声明网页的元数据
- 标签：
- 元素：从开始标签开始到结束标签结束包含中间内容称为元素

#### （一）基本元素
1. `<html>`HTML的根元素，H5允许完全省略这个元素
2. `<head>`H5文档的也买你头部分，也可以完全省略
3. `<title>`定义文档的页面标题
4. `<body>`定义文档的页面主体部分
5. `<h1>`到`<h6>`定义标题1到标题6
6. 注意：几乎所有的HTML元素都可以指定：id、class、style等核心属性
7. `<br/>`插入一个换行
8. `<hr/>`定义一个水平线，也叫分割线
9. `<!---->`定义注释
10. `<p>`定义段落
11. `<div>`定义文档中的节
12. `<span>`与`<div>`基本相似，区别是该标签定义的节默认不会换行。本身不会改变任何东西，只为CSS样式服务
- 单标签：自闭合标签，只为实现自身的功能，而不封装数据，自己在内部开始在内部结束，注意书写格式---斜杠写在后面

####  （二）文本格式化元素
> 按照自定义的格式进行重现
1. `<b>`定义粗体文本
2. `<strong>`定义粗体文本，表水很重要的文本，与`<b>`标签类似,效果相同，强调强度不同
3. `<i>`定义斜体文本
4. `<em>`定义强调文本，实际效果和斜体差不多
5. `<u>`定义下划线
6. `<small>`定义小号字体文本，常用于小号印刷体
7. `<sup>`定义上标文本
8. `<sub>`定义下标文本
9. `<bdo>`定义文本显示方向，dir属性值为ltr或者rtl用来控制文字
    ```html
    <!--rtl: right to left-->
    <bdo dir="rtl">这是一首简单的小情歌</bdo>
    ```

#### （三）语义相关元素
> 需要知道的是`<q>、<del>、<ins>、<pre>`四个，其它了解即可
1. `<address>`用于表示一个地址
2. `<blockquote>`用于定义一段长的引用文本
3. `<q>`用于定义一段短的引用实体，浏览器会自动添加双引号
4. `<cite>`用于表示作品的标题
5. `<code>`用于表示一段计算机的代码
6. `<dfn>`定义一个专业术语
7. `<del>`定义文本中被删除的文本,通常结合插入标签一起使用
8. `<ins>`定义文本中插入的文本
9. `<pre>`预格式化文本,完全安装自己写的格式进行显示
10. `<kdb>`用于定义就按盘文本，该元素用于表示文本是通过键盘输入
11. `<var>`用于表示一个变量
```html
<body>
<!--<q>:用于指定短的应用文本，浏览器自动添加双引号-->
    有句话这么说来着：<q>人这一辈子，有两句肉麻的话是非说不可的。 ――'谢谢你'和'对不起'。</q><br/>
<!--<del>、<ins>-->
    《遇见》被<del>孙燕姿</del><ins>张敬轩</ins>翻唱过……<br/>
<!--pre：预格式化文本-->
    <pre>
    小情歌
    这是一首简单的小情歌
    唱着人们心肠的曲折
    我想我很快乐
    当有你的温热
    脚边的空气转了
    </pre>
</body>
```

#### （四）图像相关元素
1. src：指定图片文件的所在位置，可以是相对路径也可以是绝对路径
2. alt：该属性指定一段文本，作为图片的提示信息
3. height：指定图片的高
4. width：指定图片的宽
    ``` html
    <img src="../img/朱茵.jpg" alt="朱茵-紫霞仙子朱茵3.jpg" height="540px" width="960px"/>
    ```
5. usemap：属性用于链接的map的映射
6. `<map>`：用于定义图片映射，包含一个或多个<area>子元素
- eg：中国地图，点击某个省就对应切换成某个省的地图
7. `<area/>`：用于定义图片映射的内部区域，不用于封装数据
- shape：指定内部区域是那种区域
- coords：指定多个坐标值，用于确定区域位置
    ``` html
    <!--加载图片,使用map映射-->

    <img src="../img/朱茵.jpg" alt="紫霞仙子.jpg" width="960px" height="540px" usemap="#map"/>
    <!--创建一个map标签-->

    <map id="map">
        <area shape="circle" coords="480px, 270px, 300px" href="introduce.html"/>
    </map>
    ```

#### （五）超链接和锚点
1. <a>标签
- href：指定超链接所关联的两一个资源
    ```html
    //href 和 src 的区别
    src是直接引入进行显示
    href则是需要跳转才能显示
    ```
- target：指定使用框架中的哪一个框架来装载另一个资源（本窗口还是新建一个窗口进行显示）
- a元素可以包含文本、图像、各种文本格式化元素和表单元素等内容
    ```html
    <a href="demo1.html">链接到demo1</a>
    <a href="https://www.baidu.com/">百度一下，你就知道！</a>
    <a href="../img/朱茵.jpg">朱茵照片</a>

    <!--target属性，新窗口打开-->
    <a href="https://www.baidu.com/" target="_blank">百度一下，你就知道！</a>
    ```
2. 锚点的演示
    ```html
    <body>
        <a id="top">顶部位置</a>

        <img src="../img/朱茵.jpg" alt="紫霞仙子.jpg"/><br/><br/>
        <img src="../img/朱茵.jpg" alt="紫霞仙子.jpg"/><br/><br/>
        <img src="../img/朱茵.jpg" alt="紫霞仙子.jpg"/><br/><br/>

        <a href="#top">回到顶部</a>
    </body>
    ```


#### （六）列表相关元素
1. `<ol>`定义有序列表，也只能包含`<li>`子元素
- start：指定列表的起始数字，默认是第一个
- type：指定使用哪种类型编号
2. `<ul>`定义无序列表，只能定义`<li>`子元素
3. `<li>`定义列表项
4. `<dl>`也用于定义列表，包含`<dt>`和`<dd>`两种子元素
5. `<dt>`定义标题列表项
6. `<dd>`定义普通列表项
7. 列表的嵌套
```html
<!--有序列表-->
<ol start="3" type="i">
    <li>侯马</li>
    <li>孝义</li>
    <li>运城</li>
    <li>晋中</li>
</ol>

<!--无序列表-->
<ul type="circle"><!--circle:空心圆  square:实心方形-->
    <li>篮球</li>
    <li>足球</li>
    <li>乒乓球</li>
    <li>羽毛球</li>
</ul>
```

#### （七）表格相关元素
1. `<table>` 用于定义表格
2. `<caption>`用于定义表个标题，0或1个
3. `<thead>`定义表格头，0或1个
- `<th>`定义表格的页眉单元格
4. `<tbody>`定义表格体，可以多个
- `<tr>`用来定义行
5. `<tr>`定义行，`<td>`定义列
- colspan:跨列
- rowspan:跨行
- hight:指定单元格的高度
- width：指定单元格的宽度
6. `<table>` 中可以设置的属性
- cellpadding:指定单元格内容和单元格边框之间的间距
- cellspacing:指定单元格之间的距离
- width:指定表格的宽度
```html
<table border="1px" width="400" align="center" cellpadding="20px" cellspacing="0px">
    <caption>值日表</caption>
    <thead>
        <th>周一</th>
        <th>周二</th>
        <th>周三</th>
    </thead>
    <tbody style="text-align: center">
        <tr>
            <td colspan="2">张三</td>
            <td rowspan="2">王五</td>
        </tr>
        <tr>
            <td>赵六</td>
            <td>孙七</td>
        </tr>
    </tbody>
</table>
```

#### （八）框架相关元素
- 因为`<frameset>`和`<body>`不兼容，所以第一步删掉`<body></body>`
- 搭建框架`<frameset>`
1. `<fameset>`---不推荐使用，已被淘汰
- frame
- rows:分割行,cols:分割列
    ```html
    <frameset rows="20%, 80%">
        <frame src="top.html"/>
        <frameset cols="30%, 70%">
            <frame src="left.html">
            <frame src="right.html" name="right">
        </frameset>
    </frameset>
    ```

2. `<iframe>`---经常使用
    ```html
    <body>
        <iframe width="30%" height="700px" src="left.html"></iframe>
        <iframe width="69%" height="700px" src="right.html" name="right"></iframe>
    </body>
    ```
#### （九）常用元素
#### （十）H5新增
1. 使用canvas元素
2. 使用audio和vdeo元素,表示视频资源
- src:配置视频的路径
- controls:显示播放控件
- autoplay:表示当前页面加载完成之后自动加载
- loop:表示视频循环播放
- width:视频的宽度
- height:视频的高度
> 当属性值唯一且与属性名一致，只需要写一个属性名即可
```html
<body>
    <video src="../video/RM动画宣传.mp4" width="640px" height="360" controls autoplay loop></video>
</body
```

### 二、表单控件
#### （一）表单元素
- `<from>`元素用于生成输入表单

#### （二）使用input元素
- 单行文本框：text
- 密码输入框：password
- 单选框：radio
- 复选框：checkbox
- 文件上传域：file
- 提交按钮：submit
- 重置按钮：reset
- 单纯的重置按钮：button
```html
<form>
    <!--表单控件-->
    用户名：<input type="text" name="username" value=""/><br/>
    密码：<input type="password" name="password" value=""/><br/>
    性别：<input type="radio" name="sex" value="boy"/>男
         <input type="radio" name="sex" value="girl"/>女<br/>
    爱好：<input type="checkbox" name="hobby" value="qin"/>琴
         <input type="checkbox" name="hobby" value="qi"/>棋
         <input type="checkbox" name="hobby" value="shu"/>书
         <input type="checkbox" name="hobby" value="hua"/>画<br/>
    上传文件：<input type="file" name="file" value=""/><br/>
    <input type="submit" value="提交按钮"><br/>
    <input type="reset" value="重置按钮"><br/>
    <input type="button" value="单纯按钮"><br/>
</form>
```

#### （三）input中包含的属性
- checked：默认被选中
- disabled：禁用元素/标签
- maxlength：制定文本框中所允许输入的最大字符数
- placeholder：占位符
- readonly：设置只读，不允许修改，只针对文本框
- size：设置元素宽度
```html
<form>
    <!--表单控件-->
    提示：<input value="个人注册信息" readonly size="50" style="text-align: center"/><br/>
    用户名：<input type="text" name="username" value="" placeholder="用户名/邮箱/手机号" /><br/>
    密码：<input type="password" name="password" value="" minlength="6" maxlength="8" placeholder="用户密码"/><br/>
    性别：<input type="radio" name="sex" value="boy" checked/>男
         <input type="radio" name="sex" value="girl"/>女<br/>
    爱好：<input type="checkbox" name="hobby" value="qin"/>琴
         <input type="checkbox" name="hobby" value="qi"/>棋
         <input type="checkbox" name="hobby" value="shu" checked/>书
         <input type="checkbox" name="hobby" value="hua"/>画<br/>
    上传文件：<input type="file" name="file" value=""/><br/>
    <input type="submit" value="提交按钮"><br/>
    <input type="reset" value="重置按钮"><br/>
    <input type="button" value="单纯按钮"><br/>
</form>
```

#### 强调：使用注意
1. `<input>`使用除按钮外，一般都需要添加name、value属性
2. form表单提交有两种提交方式：get和post
    - get：提交时在地址栏显示提交信息（默认使用get方式提交）
    - post：提交时不会在地址栏显示提交信息（一般选用此提交方式）
3. form表单提交后需要进行跳转---action属性
    ```html
    <form method="post" action="address.html">
    <!-- …… -->
    </form>
    ```
#### （四）使用button定义按钮
- 优点：可以嵌套图片
1. disable：指定是否禁用此按钮
2. name：指定按钮的唯一名称
3. type：指定按钮属于那种按钮
    ```
    <button type="submit">提交按钮</button><br/>
    <button type="reset">重置按钮</button><br/>
    <button type="button">单纯按钮</button><br/>
    ```

#### （五）列表和下拉列表
1. `<select>`元素
- size：指定该列表中框中可同时显示多少个列表项
2. `<option>`用于定义列表框选项或菜单项
- selected：默认选中
3. `<optgroup>`用于定义列表项或者菜单项组
- lable：指定该项组的标签，该属性必填
- disable：置于不可选状态
```html
籍贯：<select name="birthplace" size="3">

        <optgroup label="山西" disabled>
            <option value="taiyuan">太原</option>
            <option value="linfen">临汾</option>
            <option value="yuncheng" selected>运城</option>
        </optgroup>

        <optgroup label="山东">
            <option value="qingdao">青岛</option>
            <option value="jinan">济南</option>
            <option value="yantai">烟台</option>
        </optgroup>

     </select><br/>
```

#### （六）使用textaea定义文本域
1. cols指定文本域的宽度
2. rows指定文本域的高度
3. rows指定文本域的高度
4. disabled禁用
5. 禁止拉伸：style="resize:none"
```html
备注：<br/>
<textarea rows="10" cols="50"  style="resize:none">hello world!</textarea><br/>
```

#### （七）H5新增
