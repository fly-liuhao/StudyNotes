## Git使用
目的：通过 git 管理 github 托管项目代码

#### 一、下载安装Git
1. 官网下载：https://git-scm.com/download/win
2. 双击安装：https://blog.csdn.net/Fly_1213/article/details/88769482

#### 二、Git的工作流程
1. Git工作区域
  - 工作区：添加、编辑、修改文件等动作
  - 暂存区：暂存已经修改的文件，最后统一提交到Git仓库中
  - Git Repository(Git仓库)：最终确定的文件到仓库，成为一个新版本，并对他人可见
2. 具体添加文件流程
```
工作区---暂存区
  git status
  git add hello.py
  git add test.py
暂存区---仓库
  git status
  git commit -m '提交描述'
```
#### 三、Git初始化及仓库创建操作和操作
```
常用操作：
  ls //当前路径下的文件
  pwd //输出当前路径
  cd+路径/文件 //进入到指定的文件/路径下
  touch+文件名.后缀名 //创建文件
  git status //查看状态
  git中config配置的增删改查操作：https://blog.csdn.net/itdian666/article/details/79665530
```
1. 基本信息设置
  - 设置用户名
    `git config --global user.name 'fly-liuhao'`
  - 设置用户名邮箱
    `git config --global user.email '15364925795@163.com'`
  - 查看设置
    `git config --list`
2. 初始化一个新的Git仓库
- 新建一个文件夹
  ```c++
  mkdir test //创建一个文件夹
  ```
- 在文件内初始化git仓库（创建git仓库）
  ```
  cd test
  git init
  ```
3. 向仓库添加文件（三步）
    ```
    git status

    git add test.py
    git status

    git commit -m 'first add test.py'
    git status
    ```
4. 修改仓库文件
    ```
    vi test.py /进入编辑
    Esc--Shift+ZZ //退出并保存
    git status
    git commit -m 'Modify  test.py'
    git status
    ```
4. 删除仓库文件
    ```
    rm -f test.py
    git rm -f test.py
    git commit -m 'Delete test.py'
    git status
    ```
#### 四、Git 管理远程仓库
使用远程仓库目的
作用：备份、实 现代码共享集中化管理

1. Git克隆操作
- 目的：将远程仓库（github对应的项目）复制到本地
- 代码：`git clone 仓库地址` //仓库地址：复制仓库连接

2. 添加/删除/修改文件---添加到暂存区---添加到本地仓库
    ```
    touch test2.py //新建文件
    git add test.py //添加到暂存区
    git commit -m '添加文件test.py文件' //添加到仓库
    ```
3. 将本地仓库同步到远程仓库中
    ```
    git push
    ```
4. 注意
此时应该无法同步
原因：私有项目、没有权限、输入用户名密码，或者采用远程地址采用这种类型
解决：打开.git目录，找到config文件做以下修改，或者下载github客户端进行登陆
    ```
    将：
    [remote "origin"]
      url = https://github.com/用户名/仓库名.git
    修改为：
    [remote "origin"]
      url = https://用户名：密码@github.com/用户名/仓库名.git
    ```
