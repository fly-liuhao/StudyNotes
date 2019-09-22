### Git提交作业
1. 安装Git软件
2. 在码云平台注册账号
3. SSH公钥配置：
- 克隆项目方便
- 以后使用省去一个登陆和写密码的步骤
    ```git
    // 打开Git Bash,粘贴如下创建命令，连续敲回车，中间键入'y'
    ssh-keygen -t rsa -C "15364925795@163.com"
    // 打开C:\Users\刘浩\.ssh，找到id_rsa.pub文件
    // 记事本打开，复制内容到码云平台的SSH公钥页面的中，默认以邮箱命名进行创建
    ```
4. Git配置：配置用户名和邮箱
    ```git
    // 命令：
        git config --global user.name"name"
        git config --global user.email"your_email@yourmail.com"

    // eg:
        git config --global user.name "fly-liuhao"
        git config --global user.email "15364925795@163.com"

    // 查看配置
        git config --list
    ```
5. 在码云上创建一个项目/仓库
6. atom的安装以及配置（环境变量）
7. 项目资料提交常用git命令：
- 初始化一个本地仓库
    ```git
    // 初始化一个本地仓库
    // 注意路径中为确保创建成功，使用双反斜杠，或者单斜杠
        git init D:\\文档\\Git\\PROJECT_GIT
        git init D:/Git/PROJECT_GIT
    ```
- 克隆项目
    ```git
    git clone 远程网址
    ```
- 查看本地分支
    ```gitgit
    git branch
    ```
- 查看远程分支
    ```git
    git branch -r
    ```
- 创建分支
    ```git
    git branch 分支名称
    ```
- 将新建分支推送到远程
    ```git
    git push --set-upstream origin 分支名称
    ```
- 克隆指定分支
    ```git
    git clone -b 分支名 复制的项目路径
    ```
- 切换分支
    ```git
    git checkout 分支名称
    ```
- 查看当前目录所在路径
    ```git
    pwd
    ```
- 切换目录
    ```git
    cd 盘符
    cd .. 切换到上一层目录
    cd 文件夹 （切换到文件夹下）
    ```
- 查看当前目录及文件
    ```git
    ls //查看文件夹及文件
    dir //Windows下面可以使用
    ```
- 创建文件夹
    ```git
    mkdir 文件夹名
    ```
- 创建文件
    ```git
    touch 文件名
    ```
- 添加到暂存区
    ```git
    git add 文件名

    //查看暂存区待提交文件的状态
    git status
    ```
- 提交到本地仓库中
    ```git
    git commit -m'提交描述'

    //eg:
    git commit -m'提交HTML第一天学习笔记'
    ```
- 推送到远程仓库
    ```git
    git push origin 分支名
    ```
- 查看历史
    ```git
    git log
    ```
- 更新项目
    ```git
     git pull https:github/ITdian/misass
    ```
