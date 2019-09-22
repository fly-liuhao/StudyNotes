### liuhao-HDML第3讲 听课笔记

#### 什么是CSS?
CSS叫做样式表，简称CSS样式，主要作用：美化网页，对网页的显示效果进行修饰
全称是：层叠式样式表（Cascading Style Sheets）
CSS也是W3C组织指定的国际标准。最新版本为CSS3。不同的浏览器对标准的支持不尽相同，因此
可能CSS存在浏览器兼容性问题，所以写完后要多浏览器测试。
#### CSS的语法？
```
    div {
        color:red;
        font-size:14px;
        text-align:center;
    }
```
注释方式：`/*XXXX*/`
#### CSS代码放到什么位置？
1. 放到网页中，使用style标记，这个标记放到head之间（头部样式）-----内部样式表
2. 在标记的属性中（行内样式）-----内联样式
3. 放到独立的CSS文件中，该文件的扩展名是.css -----外部样式 【*****】
#### CSS中的选择器有哪些？
1. class选择器（常选用）
2. id选择器
3. 标记（元素）选择器
#### 开发常用的CSS样式？
##### 1.背景样式（如何使用CSS改变背景）
- 背景颜色：background-color
- 背景图片：background-image
> 开发中常用于文本框等合法性验证、提示
##### 2.文本样式
> 开发中常用于更改文字的颜色、大小、**去超链接下划线**
- color 用于文字颜色
- text-align 对齐方式
- text-decoration 文字下划线
- text-indent 文字缩进
- text-height 指定行间距(行高)
##### 3.字体样式
- font-family:"微软雅黑"; 指定字体
- font-style 斜体、正常
- font-size  字体大小
- font-weight 字体加粗
##### 4.CSS连接
> 去掉超链接的下划线、鼠标滑到超链接上有所变化
##### 5.列表样式
- list-style-type
- list-style-image
##### 6.表格样式
- border
- border-collapse
- width
- height
- text-align
- vertical-align:bottom;/*向下停靠*/
> 宽度和高度设定：可以是固定值和百分比
##### 7.边框样式
> 开发中常用于文本框边框、表格边框、图片边框、DIV边框
- border
- border-left
- border-top
- border-right
- border-bottom
- border-radius 文本框弧度
##### 8.显示样式
- display（后面的字体会跟进）
- visibility（后面的字体会跟进）



#### Tip
- 在浏览器中默认的文字大小是16px
- 学知识方式：What Why When Where Who How
[5W1H分析法](https://baike.baidu.com/item/5W1H%E5%88%86%E6%9E%90%E6%B3%95/10091536?fr=aladdin&fromid=6062002&fromtitle=5W1H)
- 两本书{HTML权威指南，CSS3权威指南，HDML5 and CSS3}
- 1em = 16px
- <盒子模型>
