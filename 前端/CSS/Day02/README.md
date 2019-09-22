## CSS第二天
#### 一、字体相关属性
#### 1. color
```html
<!--color-->
<span style="color: red">1.测试文字---color</span><br/>
```
#### 2. font
- font-style
    - normal
    - italic斜体
    - oblique倾斜体
- font-weight
    - ligher更细
    - normal正常
    - bold加粗
    - bolder更粗
    - 还可以使用具体的数值100到900
- font-size
    - 使用
- font-family
```html
<!--font-style-->
<span style="font-style: italic">2.测试文字---font-style</span><br/>

<!--font-weight-->
<span style="font-weight: 900">3.测试文字---font-weight</span><br/>

<!--font-size-->
<span style="font-size:20pt">4.测试文字---font-size</span><br/>

<!--font-family-->
<span style="font-family: '华文行楷';">5.测试文字---font-family</span><br/>
```
#### 3. text-decoration(设置下划线)
- none无修饰
- underline下滑线
- line-through中划线
- over-line上划线
```html
<!--text-decoration-->
<span style="text-decoration: underline;">3.测试文字---text-decoration</span><br/>

<span style="text-decoration: line-through">3.测试文字---text-decoration</span><br/>

<span style="text-decoration: overline">3.测试文字---text-decoration</span><br/>
```
#### 4.  text-transform(设置大小写)
- none不转换
- capitalize首字母大写
- uppercase全部大写
- lowercase全部小写
```html
<!--text-transform-->
<span style="text-transform: capitalize;">4.abcdefghijklmnopqrstuvwxyz</span><br/>

<span style="text-transform: uppercase;">4.abcdefghijklmnopqrstuvwxyz</span><br/>

<span style="text-transform: lowercase;">4.ABCDEFGHIJKLMNOPQRSTUVWXYZ</span><br/>
```
#### 5. line-height(设置行高)
```html
<!--line-height-->
<p style="line-height: 50px">5.骚灵情歌》是张敬轩的一首粤语歌曲，由周耀辉填词，林健华作曲，张敬轩演唱的流行音乐，被收录于专辑《笑忘书》，发行于2006年10月20日，2007年2月1日，《骚灵情歌》在香港电台中文歌曲龙虎榜周榜单排名第二。</p>
```
#### 6. letter-spacing(设置字间距)
- normal
- 数值+长度单位
```html
<!--letter-spacing-->
<span style="letter-spacing: 10px">6.测试文字---letter-spacing</span><br/>
```
#### 7. word-spacing(规定段落中的词间距)
- normal
- 数值+长度单位
```html
<!--word-spacing-->
<span style="word-spacing: 100px">7.这是 一段 测试 文字 --- word-spacing</span><br/>
```
#### 8. text-indent(设置段落文本的缩进)
- 数值+长度单位（em）
- 对p标签、div标签起作用，对span标签不起作用
```html
<!--text-indent-->
<p style="text-indent: 2em">8.《骚灵情歌》是张敬轩的一首粤语歌曲，由周耀辉填词，林健华作曲。</p><br/>
```
#### 9. text-align(设置居中)
- 对p标签、div标签起作用，对span标签不起作用
- left
- right
- center
```html
<!--text-align-->
<p style="text-align: center">9.测试文字---text-align</p><br/>
```
#### 10. text-shadow(设置阴影)
- 一共四个属性值`style="text-shadow: red 5px 5px 2px"`
- color：指定该阴影的颜色
- xoffset：指定阴影在横向上的偏移
- yoffset：指定阴影在纵向上的偏移
- radius：指定阴影的模糊半径，越大越模糊
- 可以同时添加多个阴影
```html
<!--text-shadow-->
<p style="text-shadow: blue 5px 5px 1px">10.《骚灵情歌》是张敬轩的一首粤语歌曲，由周耀辉填词，林健华作曲。</p>
<p style="text-shadow: red -5px -5px 2px, blue 5px 5px 1px">10.《骚灵情歌》是张敬轩的一首粤语歌曲，由周耀辉填词，林健华作曲。</p>
```
### 二、背景相关属性
#### 1. background(设置背景样式)
#### 2. background-color(设置背景颜色)
#### 3. background-image(设置背景图片)
#### 4. background-size(设置图片的大小尺寸)
#### 5. background-position(设置背景图片位置，前提是必须有background-image属性)
#### 6. background-repeat(设置对象的背景图片是否平铺)
- repeat
- no-repeat
- repeat-x
- repeat-y
```html
<head>
    <meta charset="UTF-8">
    <title>背景相关属性</title>
    <style>
        div{
            width: 400px;
            height: 400px;
            background-color: rosybrown;
            background-image: url("../../Html/img/朱茵.jpg");
            background-size:300px 200px;
            background-position: 50px 100px;
            background-repeat:no-repeat;
        }
    </style>
</head>
<body>
    <div></div>
</body>
```
### 三、边框相关属性
#### 1. border
- none-无边框
- hidden-隐藏边框
- dotted-点线边框
- dashed-虚线边框
- solid-实线边框
- double-双线边框
#### 2. border-style
- 一个值：1-上下左右，作用于四边
- 两个值：1-上下，2-左右
- 三个值：1-上，2-左右，3-下
- 四个值：1-上，2-右，3-下，4-左
#### 3. border-color
- 同上
#### 4. border-width
- 同上
#### 5. border-top
- border-top-color
- border-top-style
- border-top-width
#### 6. border-right
- 同上
#### 7. border-bottom
- 同上
#### 8. border-left
- 同上
#### 9. 圆角边框
- border-radius
- border-top-left-radius
- border-top-right-radius
- border-bottom-left-radius
- border-bottom-left-radius
```html
<head>
    <meta charset="UTF-8">
    <title>边框属性</title>
    <style>
        #input_1{
            border: double;
            border-style: solid double dotted hidden;
            border-color: red green blue gold;
            border-width: 10px;
        }
        #input_2{
            border-top: 10px solid red;
            border-right: 10px double green;
            border-bottom: 10px dotted blue;
            border-left: 3px dashed gold;
        }
        #input_3{
            border-radius: 5px;
        }
        #input_4{
            border-top-left-radius: 1px;
            border-top-right-radius: 5px;
            border-bottom-left-radius: 5px;
            border-bottom-right-radius: 1px;
        }
    </style>
</head>
<body>
    用户名：<input id="input_1" type="text"/><br/><br/>
    密码：<input id="input_2" type="password"/><br/><br/>
    手机号：<input id="input_3" type="text"/><br/><br/>
    家庭住址：<input id="input_4" type="text"/><br/><br/>
</body>
```

### 四、其它样式
#### 1. 表格
- 设置相邻单元格的边框处理样式：border-collapse
    - separate边框分开
    - collapse边框合并
- 设置相邻单元格边框的间距：border-spacing
- 设置表格标题的位置：mcaption-side
- 设置空单元格是否显示边框：empty-cells
    - hide
    ```html
    <head>
        <meta charset="UTF-8">
        <title>表格相关属性</title>
    </head>
    <body>
        <table border="1px" style="border-collapse:separate; border-spacing: 20px; caption-side: bottom; empty-cells: hide">
            <caption>标题</caption>
            <tr>
                <td>1-1</td>
                <td>1-2</td>
                <td>1-3</td>
            </tr>
            <tr>
                <td>2-1</td>
                <td></td>
                <td>2-3</td>
            </tr>
            <tr>
                <td>3-1</td>
                <td>3-2</td>
                <td>3-3</td>
            </tr>
        </table>
    </body>
    ```
#### 2. 列表
- 设置列表标记：list-style-type
- 设置图像列表标记：list-style-image
- list-style-position：设置标记的位置
    - inside(通常情况下，写这个)
    - outside
- 去掉列表前的标记（序号/实心圆点）
    ` list-style: none;`
    ```html
    <head>
        <meta charset="UTF-8">
        <title>列表相关属性</title>
        <style>
            ol>li{
                list-style-type: circle;
                list-style-image: url("1.png");
                list-style-position: inherit;
            }
            ul>li{
                /*去掉列表的标记点*/
                list-style: none;
            }
            div{
                width: 200px;
                height: 200px;
                background-color: blue;
                cursor: help;
            }
        </style>
    </head>
    <body>
        <ol>
            <li>列表项</li>
            <li>列表项</li>
            <li>列表项</li>
        </ol>

        <l>
            <li>列表项</li>
            <li>列表项</li>
            <li>列表项</li>
        </l>
        <div></div>
    </body>
    ```
#### 3. 光标形状：cursor
- pointer（手形）
- help（问号）
- text（输入符号）
    ```html
    <head>
        <meta charset="UTF-8">
        <title>列表相关属性</title>
        <style>
            div{
                width: 200px;
                height: 200px;
                background-color: blue;
                cursor: help;
            }
        </style>
    </head>
    <body>
        <div></div>
    </body>
    ```

### 五、过渡
#### 1. 什么是过渡
#### 2. 过渡涉及到的属性
- 设置过度开始的延时：transition-delay
- 设置过度持续的时间：transition-duration
- 设置过度的参与属性：transition-property
- 设置过度的速率：transition-timing-function
- 简写属性：transition
#### 3. 创建反向过度
- 直接复制hover设置的内容，到原样式中
```html
<head>
    <meta charset="UTF-8">
    <title>过渡</title>
    <style>
        div{
            width: 100px;
            height: 100px;
            background-color: red;

            /*设置延时显示时间*/
            transition-delay: 500ms;
            /*设置过渡持续时间*/
            transition-duration: 3000ms;
            /*设置过渡参与的属性*/
            transition-property: width, height, border-radius, background-color;
            /*设置过渡速率*/
            transition-timing-function: linear;
        }
        div:hover{
            width: 100px;
            height: 100px;
            border-radius: 50px;
            background-color: blue;

            /*设置延时显示时间*/
            transition-delay: 500ms;
            /*设置过渡持续时间*/
            transition-duration: 3000ms;
            /*设置过渡参与的属性*/
            transition-property: width, height, border-radius, background-color;
            /*设置过渡速率*/
            transition-timing-function: linear;
        }
    </style>
</head>
<body>
    <div></div>
</body>
```

### 六、盒子模型
#### 1. 设置尺寸
- width：设置元素宽度
- height：设置元素高度
#### 2. 设置内边距:内容与边框之间的距离
- padding-top
- padding-right
- padding-bottom
- padding-left
- padding：简写形式
#### 3. 设置外边距:盒子盒子之间的距离
> margin存在塌陷问题，选取两者中大的哪一个
- margin-top
- margin-right
- margin-bottom
- margin-left
- margin：简写形式
> 注：盒子居中`margin: 0 auto;`

    ```html
    <head>
        <meta charset="UTF-8">
        <title>盒子模型</title>
        <style>
            div{
                width: 200px;
                height: 200px;
                background-color: blue;
                padding: 20px;
                margin: 50px;
                /*第一种方式*/
                padding-top: 10px;
                padding-right: 20px;
                padding-bottom: 30px;
                padding-left: 40px;
    
                margin-top: 10px;
                margin-right: 20px;
                margin-bottom: 30px;
                margin-left: 40px;
    
                /*第二种方式*/
                padding: 10px 20px 30px 40px;
                margin: 10px 20px 30px 40px;
            }
        </style>
    </head>
    <body>
        <div></div>
        <div></div>
    </body>
    ```
#### 4. 处理元素内容溢出
- overflow-x
- overflow-y
- overflow：简写形式
	- scroll：滑动条
	- hidden：隐藏
    ```html
    <head>
        <meta charset="UTF-8">
        <title>处理元素内容的溢出</title>
        <style>
            div{
                width: 100px;
                height: 100px;
                background-color: bisque;
                margin: 50px;
            }
            #div_1{
                /*使用滑动条方式一*/
                overflow: scroll;
                /*使用滑动条方式二*/
                overflow-x: scroll;
             }
            #div_2{
                /*使用滑动条方式一*/
                overflow: scroll;
                /*使用滑动条方式二*/
                overflow-y: scroll;
            }
            #div_3{
                /*隐藏*/
                overflow: hidden;
            }
        </style>
    </head>
    <body>
        <div id="div_1">11111111111111111111111</div>
        <div id="div_2">1111<br/>1111<br/>1111<br/>1111<br/>1111<br/>1111<br/>1111<br/></div>
        <div id="div_3">123456789123456789123456789</div>
    </body>
    ```

#### 5. 改变元素类型
- 元素类型
    - inline：行内元素`<span>`
    > 不能设置宽高尺寸
    > 不能独占一行
    - inline-block：行内块级元素`<img>`
    > 可以设置宽高尺寸
    > 不能独占一行
    - block：块级元素`<div>`、`<p>`
    > 可以设置宽高尺寸
    > 独占一行
    ```html
    <head>
        <meta charset="UTF-8">
        <title>元素类型</title>
        <style>
            span{
                width: 100px;
                height: 100px;
                background-color: gold;
            }
            img{
                width: 100px;
                height: 100px;
                background-color: gold;
            }
            div{
                width: 100px;
                height: 100px;
                background-color: gold;
            }
            p{
                width: 100px;
                height: 100px;
                background-color: gold;
            }
        </style>
    </head>
    <body>
        <!--inline：行内元素-->
        <span>span标签</span>
        <span>span标签</span>

        <!--inline-block：行内块级元素-->
        <img src="1.png"/>

        <!--block：块级元素-->
        <div>div标签</div>
        <p>p标签</p>
        <p>p标签</p>
    </body>
    ```

- display：可以转换元素之间的类型
    ```html
        <head>
            <meta charset="UTF-8">
            <title>元素类型</title>
            <style>
                span{
                    width: 100px;
                    height: 100px;
                    background-color: gold;
                    display: block;
                    margin: 10px;
                }
                div{
                    width: 100px;
                    height: 100px;
                    background-color: gold;
                    display: inline-block;
                    margin: 10px;
                }
            </style>
        </head>
        <body>
            <span>span标签1</span>
            <span>span标签2</span>
            <span>span标签3</span>

            <div>div标签1</div>
            <div>div标签2</div>
            <div>div标签3</div>
        </body>
    ```

- 隐藏元素：display：none；

- 设置元素是否可见：visbility
    + visible：可见
    + hidden：隐藏

#### 6. 浮动
- float

#### 7. 阻止元素浮动
- clear
