## 异常处理
#### 1. 问题引入：除法计算
- 不使用异常捕获
直接报错，程序终止
- 使用异常捕获（try-catch）
提示友好，程序还可继续执行（跳过try异常后代码）
#### 2. 异常处理机制如何？
首先：执行到异常时，JVM自动创建一个异常类对象，后面的代码不在执行。然后，catch捕获异常，执行catch中的代码。如果catch无法捕获异常，程序退出。
> Exception 有很多一场子类

#### 3. 异常处理语法如何？
  - try catch finally
    ```Java
    /**
     * 除法计算（添加异常捕获)
     * @param num1 被除数
     * @param num2 除数
     * @return 相除结果
     */
    public double div2(int num1, int num2) {
        double result = 0;
        try {
            //一旦出现异常，JVM直接创建ArithmeticException对象
            result = num1 / num2;
        } catch (Exception e) {
            System.out.println("数据不合法！");
            //e.printStackTrace();
        } finally {// 不管有无异常必定要执行，可选则添加，一般用于释放资源
            System.out.println("finally");
        }
        return result;
    }
    ```
- finally
  + 不管有无异常必定要执行
  + 可选则添加
  + 一般用于释放资源

#### 4. 手动抛出异常
  - 什么时候用？根据编程者的需要，使用`throw`抛出异常
    ```Java
    /**
     * 除法计算（手动添加异常捕获)
     *
     * @param num1 被除数
     * @param num2 除数
     * @return 相除结果
     */
    public double div3(int num1, int num2) {
        double result = 0;
        if (num2 == 0) {
            System.out.println("数据不合法！");
            // 手动抛出异常
            throw new AcceptPendingException();
        } else {
            result = num1 / num2;
        }
        return result;
    }
    ```

#### 5. 调用者处理异常
- 在方法声明处添加异常，使用`throws`
    ```Java
    public void read() throws FileNotFoundException,ArithmeticException {
        FileInputStream fs = new FileInputStream("a.txt");
    }
    ```
- throw和throws的区别？
  > throws是用来声明一个方法可能抛出的所有异常信息，throws是将异常声明但是不处理，而是将异常往上传，谁调用我就交给谁处理。
  > 而throw则是指抛出的一个具体的异常类型。
#### 6. 自定义异常类
- 例如：用户取款时，金额不够。
- 书写规则
  + 继承Exception
  + 两个构造（一个无参，一个带参）
  ```Java
  /**
   * 模拟取款余额不足时的异常
   * 自定义异常类
   * @author: liuhao
   * @version 1.0
   */
  public class AccountException extends Exception {

      /**
       * 无参构造
       */
      public AccountException() {
          super();
      }

      /**
       * 带参构造
       * @param message
       */
      public AccountException(String message) {
          super(message);
      }

      /**
       * 重写同String
       */
      public String toString() {
          return "AccountException提示：余额不足";
      }

  }

  //用户账户
  class BankAccound {
      public void withDraw() throws AccountException {
          int balance = 200;// 余额
          int withDraw = 500;// 待取金额
          if (withDraw > balance) {
              throw new AccountException("余额不足");
          }
      }

      /**
       * 主方法测试
       * @param args
       */
      public static void main(String[] args) {
          BankAccound bankAccound = new BankAccound();
          try {
              bankAccound.withDraw();
          } catch (AccountException e) {
              e.printStackTrace();
              System.out.println(e);
              System.out.println(e.getMessage());
          }
      }
  }
  ```
