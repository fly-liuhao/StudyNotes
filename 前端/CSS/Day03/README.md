### 布局样式
#### 一、 什么是布局？
#### 二、 定位布局
1. 第一步：设置元素在容器块中的定位方式—position
- position：
- static：流定位/默认的定位
- relative：相对定位—相对于自己的定位，设置完成后原来的位置进行保留
- fixed：相对于浏览器窗体进行定位，应用于广告
- absolute：绝对定位，最常用
    + 在参照物里设置position,除了static其他的都可以，建议使用relative
    + 如果参照物不唯一，采用就近原则
    ```html
    <head>
        <meta charset="UTF-8">
        <title>absolute——绝对定位</title>son
        <style>
            #grandfather{
                width: 500px;
                height: 500px;
                background-color: yellow;
                position: relative;
            }
            #father{
                width: 300px;
                height: 300px;
                background-color: blue;
                position: relative;
            }
            #son{
                width: 100px;
                height: 100px;
                background-color: red;
                position: absolute;
                right: 20px;
            }
        </style>
    </head>
    <body>
        <div id="grandfather">
            <div id="father">
                <div id="son"></div>
            </div>
        </div>
    </body>
    ```

2. 第二步：设置定位元素对容器边界的偏移量
- top
- bottom
- left
- right
3. z-index（可写可不写）
- 使用index前提必须有position
- z-index值越大越靠上，越小越靠下
- z-index默认值为0
    ```html
    <head>
        <meta charset="UTF-8">
        <title>z_index</title>
        <style>
            #one{
                width: 100px;
                height: 100px;
                background-color: yellow;
            }
            #two{
                width: 100px;
                height: 100px;
                background-color: red;
                position: relative;
                top: -90px;
                /*设置z-index，值越小越靠下*/
                z-index: -1;
            }
        </style>
    </head>
    <body>
        <div id="one"></div>
        <div id="two"></div>
    </body>
    ```