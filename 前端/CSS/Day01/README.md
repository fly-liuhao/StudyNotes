## CSS样式表和CSS选择器

### 一、CSS与HTML相关联的三种方式
#### 1. 内嵌样式
- 使用style在开始标签内部书写
- style="属性名：属性值；属性名：属性值；……"
    ```html
    <div style="width:100px; height: 100px; background-color: blue">简单爱</div>
    <span style="color:red;">小情歌</span>
    ```
#### 2. 内部样式
- 在head头部写上一对`<style>`标签
    ```html
    <head>
        <meta charset="UTF-8">
        <title>内部样式</title>
        <style type="text/css">
            div{
                width:200px;
                height:200px;
                background-color: red;
            }
        </style>
    </head>
    <body>
        <div>大本钟</div>
    </body>
    ```

#### 3. 外部样式
- 在外部新建一个样式（CSS）文件
- 在需要调用CSS文件的HTML页面中的head头部使用`<link/>`标签链接样式文件
- HTML
    ```html
    <head>
        <meta charset="UTF-8">
        <title>外部样式</title>
        <link href="3.外部样式.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div>123</div>
    </body>
    ```
- CSS
    ```html
    div{
        width:300px;
        height:100px;
        background-color: royalblue;
    }
    ```
#### 4. 样式应用优先级问题
- 采用就近原则
- 内嵌样式优先级最高
- 内部样式和外部样式优先级取决于里元素的距离远近（就近原则）

### 二、CSS选择器
#### 1. 元素选择器
- 通过标签名来找到想要操纵的元素，进而进行样式的修饰
    ```html
    <head>
        <meta charset="UTF-8">
        <title>元素选择器</title>
        <style>
            div{
                color: red;
            }
            span{
                color: green;
            }
            h3{
                color: gold;
            }
        </style>
    </head>
    <body>
        <div>这是一首简单的小情歌</div>
        <span>唱着人们心肠的曲折</span>
        <h3>我想我很快乐 </h3>
    </body>
    ```
#### 2. 属性选择器
- E[attr]对具有sttr属性的E元素起作用
- E[attr="value"]对所有包含attr属性并且该属性值为value的E元素起作用
- E[attr^="value"]对具有attr属性，并且属性值是以指定值开头的E元素起作用
- E[attr$="value"]对具有attr属性，并且属性值是以指定值结尾的E元素起作用
- E[attr*="value"]对具有attr属性，并且属性值包含指定值的E元素起作用
    ```html
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <style>
            /*选择包含 id 属性的所有元素*/
            a[id]{
                background-color: red;
            }
            /*选择包含 class 属性的所有元素*/
            a[class]{
                background-color: green;
            }
            /*选择 class 属性值为 "c" 的所有元素*/
            a[class="c"]{
                background-color: gold;
            }
            /*选择 href 属性值以 "http" 开头的所有元素*/
            a[href^="http"]{
                color: green;
            }
            /*选择 href 属性值以 "css/" 结尾的所有元素*/
            a[href$="css/"]{
                color: white;
            }
            /*选择 href 属性值中包含子串 "apple" 的所有元素*/
            a[href*="apple"]{
                color: red;
            }
        </style>
    </head>
    <body>
        <a href="http://www.w3school.com.cn/" id="1">W3School</a><br/>
        <a href="http://www.w3school.com.cn/css/" class="a">CSS</a><br/>
        <a href="http://www.w3school.com.cn/html/"class="c">HTML</a><br/>

        <hr />

        <a href="http://www.w3c.org/">W3C</a><br/>
        <a href="http://www.microsoft.com" >Microsoft</a><br/>
        <a href="http://www.apple.com.cn">Apple</a><br/>
    </body>
    ```
#### 3. id选择器
- 通过\#加上id值方式来获取相应的元素
    ```html
    <head>
        <meta charset="UTF-8">
        <title>id选择器</title>
        <style>
            #div1{
                color: red;
            }
            #div2{
                color: green;
            }
            #div3{
                color: gold;
            }
        </style>
    </head>
    <body>
        <div id="div1">这是一首简单的小情歌</div>
        <div id="div2">唱着人们心肠的曲折</div>
        <div id="div3">我想我很快乐</div>
    </body>
    ```
#### 4. class选择器
- 通过一个‘.’加上类名的方式获取对应的元素
    ```html
    <head>
        <meta charset="UTF-8">
        <title>class选择器</title>
        <style>
            div.a{
                color: red;
            }
            span.a{
                color: green;
            }
            .b{
                color: gold;
            }

        </style>
    </head>
    <body>
        <div class="a">这是一首简单的小情歌</div>
        <span class="a">唱着人们心肠的曲折</span>
        <h3 class="b">我想我很快乐 </h3>
        <p class="b">当有你的温热</p>
    </body>
    ```
#### 5. 包含选择器
- 又称后代选择器
- 父元素和子元素之间使用空格分开即可
- 用于指定目标选择器必须处于某个选择器对应的元素内部
    ```html
    <head>
        <meta charset="UTF-8">
        <title>包含选择器</title>
        <style>
            p span{
                color: royalblue;
            }
            #p2 .span2{
                color: green;
            }
        </style>
    </head>
    <body>
        <p>
            这是一首简单的小情歌  <span>唱着人们心肠的曲折</span>
            我想我很快乐  <span>当有你的温热</span>  脚边的空气转了
        </p>

        <p id="p2">
            这是一首简单的小情歌  <span class="span2">唱着我们心头的白鸽</span>
            我想我很适合  <span class="span2">当一个歌颂者</span>  青春在风中飘着
        </p>
    </body>
    ```
#### 6. 子选择器
- 用于指定不妙选择器必须是某个选择器对应的子元素，孙子元素不可使用
- 而包含选择器只要位于外部选择器对应的元素内部即可使用，即使是孙子元素也可以
- 要求目标选择器必须作为外部选择器对应的元素的直接元素才行
    ```html
    <head>
        <meta charset="UTF-8">
        <title>子选择器</title>
        <style>
            p>span{
                color: royalblue;
            }
            p>span>em{
                color: green;
            }
        </style>
    </head>
    <body>
        <p>
            这是一首简单的小情歌  <span>唱着人们心肠的<em>曲折</em></span>
            我想我很快乐  <span>当有你的<em>温热</em></span>  脚边的空气转了
        </p>
    </body>
    ```
#### 7. CSS3新增的兄弟选择器
- Selector1~Selector2{...}
- 用来匹配Selector1对应的元素的后面的能匹配的Selector2兄弟节点
- 对一类标签产生效果
    ```html
    <head>
        <meta charset="UTF-8">
        <title> CSS3新增的兄弟选择器</title>
        <style>
            h1~p{
                color: red;
            }
            #hh~.pp{
                color:blue;
            }
        </style>
    </head>
    <body>
        <p>这是P标签</p>
        <p>这是P标签</p>
        <p>这是P标签</p>
        <h1 id="hh">这是一级标题</h1>
        <P class="pp">这是一级标题后面的P标签</P>
        <P>这是一级标题后面的P标签</P>
        <P>这是一级标题后面的P标签</P>
    </body>
    ```
#### 8. 相邻兄弟选择器
- 只对相邻的一个标签产生效果
    ```html
    <head>
        <meta charset="UTF-8">
        <title>相邻兄弟选择器</title>
        <style>
            h1+p{
                color: red;
            }
            h1+p+p{
                color: blue;
            }
        </style>
    </head>
    <body>
        <p>这是P标签</p>
        <p>这是P标签</p>
        <p>这是P标签</p>
        <h1>这是一级标题</h1>
        <P>这是一级标题后面的P标签</P>
        <P>这是一级标题后面的P标签</P>
        <P>这是一级标题后面的P标签</P>
    </body>
    ```
#### 9. 选择器组合
- HTML
    ```html
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <link href="13.选择器组合.css" type="text/css" rel="stylesheet"/>
    </head>
    <body>
        <div id="div_1" class="a">这是一首简单的小情歌</div>
        <span>唱着人们心肠的曲折</span>
        <h3 id="h3_1">我想我很快乐 </h3>
        <pclass="d">当有你的温热</p>
    </body>
    ```
- CSS
    ```html
    #div_1,span,#h3_1,.d{
        color: green;
    }
    ```
#### 10. 伪元素选择器
- first-letter：指定对象内的第一个字符起作用
- first-line：对指定对象内的第一行内容起作用
- before：指定对象内部的前端插入内容
- after：指定对象内部的尾端添加内容
    ```html
    <head>
        <meta charset="UTF-8">
        <title>伪元素选择器</title>
        <style>
            p:first-letter{
                font-size: 20pt;
                color: red;
            }
            p:first-line{
                color: green;
            }
            p:before{
                content: "小情歌——";
            }
            p:after{
                content: "——吴青峰";
            }
        </style>
    </head>
    <body>
        <P>这是一首简单的小情歌,唱着人们心肠的曲折,
            我想我很快乐,当有你的温热,脚边的空气转了
        </P>
    </body>
    ```
#### 11. 伪类选择器
- 子元素选择器
	- first-child
	- last-child
- nth-child选择器
    - nth-child(n)
	- nth-last-child(n)
	- nth-child(odd)设置奇数行
	- nth-child(even)设置偶数行
    ```html
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <style>
            /*设置第一行（父元素的第一个孩子）*/
            li:first-child{
                color: red;
            }
            /*设置最后一行*/
            li:last-child{
                color: blue;
            }
            /*设置指定行（从前数）*/
            li:nth-child(2){
                color: gold;
            }
            /*设置指定行（从后数）*/
            li:nth-last-child(2){
                color: green;
            }
            /*设置奇数行*/
            tr:nth-child(odd){
                background-color: white;
            }
            /*设置偶数行*/
            tr:nth-child(even){
                background-color: gray;
            }
        </style>
    </head>
    <body>
        <ol>
            <li>列表项</li>
            <li>列表项</li>
            <li>列表项</li>
            <li>列表项</li>
            <li>列表项</li>
        </ol>
        <ul>
            <li>列表项</li>
            <li>列表项</li>
            <li>列表项</li>
            <li>列表项</li>
            <li>列表项</li>
        </ul>

        <table border="1px" width="300px" cellspacing="0px" style="text-align: center">
            <tr>
                <td>1-1</td>
                <td>1-2</td>
                <td>1-3</td>
            </tr>
            <tr>
                <td>2-1</td>
                <td>2-2</td>
                <td>2-3</td>
            </tr>
            <tr>
                <td>3-1</td>
                <td>3-2</td>
                <td>3-3</td>
            </tr>
            <tr>
                <td>4-1</td>
                <td>4-2</td>
                <td>4-3</td>
            </tr>
            <tr>
                <td>5-1</td>
                <td>5-2</td>
                <td>5-3</td>
            </tr>
        </table>
    </body>
    ```
#### 12. 动态伪类选择器
- link：超链接被访问前的状态
- visited：超链接被访问后的状态
    > visited伪类可能会暴露用户浏览的信息记录，攻击者可能会根据此来判断用户曾经访问过的网站，造成不必要的损失，因此浏览器决定限制伪类的功能，所以不是代码的问题二十浏览器方面的限制
- hover：设置鼠标滑过的状态
- active：设置正在被点击时的状态
    ```html
    <head>
        <meta charset="UTF-8">
        <title>动态伪类选择器</title>
        <style>
            /*超链接被访问前的状态*/
            a:link{
                /*去掉下划线*/
                text-decoration: none;
                color: black;
            }
            /*超链接被访问后的状态*/
            a:visited{
                text-decoration: none;
                color: gray;
            }
            /*设置鼠标滑过的状态*/
            a:hover{
                text-decoration: underline;
                color: blue;
            }
            /*设置正在被点击时的状态*/
            a:active{
                color: red;
            }
            /*hover应用在<div>上*/
            div{
                width: 100px;
                height:100px;
                background-color:rosybrown;
            }
            div:hover{
                width: 200px;
                height:200px;
                background-color:red;
            }
            /*hover应用在图片上*/
            img{
                width: 200px;
                height: 150px;
            }
            img:hover{
                 width: 400px;
                 height: 300px;
             }
        </style>
    </head>

    <body>
        <a href="http://www.baidu.com" target="_blank">百度一下，你就知道</a><br/>
        <div></div><br/>
        <img src="../../Html/img/朱茵.jpg" alt="朱茵.jpg"><br/>
    </body>
    ```

### 三、颜色和单位的使用
1. 颜色
- 以颜色的名字表示颜色
- 以16进制表示颜色
- rgb()表示颜色
    ```html
    <head>
        <meta charset="UTF-8">
        <title>颜色和单位的使用</title>
        <style>
            div{
                width: 200px;
                height:200px;
                background-color: red;
                background-color: #008F00;
                background-color: rgb(0,0,255);
            }
        </style>
    </head>
    <body>
        <div></div>
    </body>
    ```
2. 单位
- px：宽高尺寸
- %：适应网页大小
- pt：字体大小
- em：相对长度单位

### 作业
1. 整理笔记上上传平台
2. 所有选择器敲三遍
3. 将W3cschool上挂关于css选择器的所有内容看一遍
4. 将字体与文本、字体、背景相关属性做预习
5. 坚持金山打字