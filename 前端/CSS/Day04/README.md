## 案列

### 一、网站骨架搭建
1. 网页导航栏图标添加
    ```html
    <!--语句一-->
    <link rel="shortcut icon" href="baidu.png" type="image/x-icon">
    <!--语句二-->
    <link rel="icon" href="baidu.png" type="image/x-icon">
    ```
- 图片也行，icon图标文件也可以，甚至是gif也支持
- 两个语句，只有第一行是必须的，因为“shortcut icon”字符串将被多数遵守标准的浏览器识别为列出可能的关键词（“shortcut”将被忽略，而仅适用“icon”）；而Internet Explorer将会把它作为一个单独的名称（“shortcut icon”）。这样做的结果是所有浏览器都可以理解此代码。只有当希望为新浏览器提供另一种备用图像（例如动画GIF）时，才有必要添加第二行。
2. 搭建时注意
- 把网站层次理清楚
- 使用div进行骨架搭建
> 参考：0.baidu框架搭建.html

### 二、导航栏的制作
- 使用无序列表（ul）
> 参考：1.导航栏的制作.html

### 三、列表块的制作
- eg：天猫的每个商品块
- figure
    + img
    + figcaption（文字信息）
    ```html
    <figure class="father">
        <img src="img/block_1.png">
        <figcaption class="son">
            <p class="p_title">大数据</p>
            <p class="p_content">中质信联以电梯安全监管为切入点，以电梯云大数据为支撑，为各单位、社会大众提供大数据服务，实现数据共享。</p>
        </figcaption>
    </figure>
    ```

### 四、最小尺寸，最大尺寸
- min-width
- max-width
> 参考：3.最大最小尺寸.html

### 五、图像遮罩层的制作
- 用div包裹图片
- 图片同级建立一个div当作遮罩层
- 移动同级的div到图片上
- 设置div透明度
> 参考：6.遮罩层的制作