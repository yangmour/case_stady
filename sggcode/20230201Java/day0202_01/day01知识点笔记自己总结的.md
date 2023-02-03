# day01知识点的总结

## 1.多种注释方法

- //:单行注释

- /* */:多行注释

- /** */:文档注释

  - 文档注释的作用有两个：一个是辅助阅读源码的人员（包括代码的设计者、使用代码的开发人员、后期代码的维护人员等）快速地理解代码，另一个是使用javadoc工具生成API文档，这就使得开发人员在不打开源代码的情况下也能快速地了解源码。为了javadoc工具能正确解析文档注释，更好地生成API文档，文档注释必须按照规范的格式进行编写，通常还会借助一些特殊的标记来进行说明。例如：

    - @author 标明开发该类模块的作者，多个作者之间使用,分割

    * @version 标明该类模块的版本

    * @see 参考转向，也就是相关主题

    * @since 从哪个版本开始增加的

    * @param  只能用于方法，对方法的形参进行说明，如果方法没有参数就不能写，有几个参数写几个@param，每个参数注释格式要求：@param 形参名 形参类型  形参说明

    * @return 只能用于方法，对方法的返回值进行说明，每个方法最多只能有一个@return说明，如果方法的返回值类型是void就不能写@return，如果方法的返回值类型不是void就必须写@return，格式要求：@return 返回值类型 返回值说明

    * @throws/@exception 只能用于方法，对方法可能抛出的异常进行说明 ，如果方法没有用throws显式抛出的异常就不能写@throws，如果方法可能发生异常就要进行说明，每一个可能发生的异常说明格式要求：@exception 异常类型 异常说明

    例如：

    ```java
    /**
    文档注释演示
    @author chai
    */
    public class Comments{
        
    	/**
    	Java程序的入口
    	@param String[] args main方法的命令参数
    	*/
        public static void main(String[] args){
            System.out.println("hello");
        }
    }
    ```

    javadoc工具的使用格式：

    ```cmd
    javadoc [options] [packagenames] [sourcefiles] [@files]
    ```

    例如：

    ```java
    javadoc -author -d doc Comments.java
    ```

    ![image-20211226163731907](https://image.3001.net/images/20230202/1675334266776.png)

    ![image-20211226163802649](https://image.3001.net/images/20230202/16753342664439.png)

    ![image-20211226163949641](https://image.3001.net/images/20230202/16753342663159.png)

## 2.开发java程序的3个步骤

1. 编辑java文件，以java为结尾
2. 编译源文件将java的文件编译为.class文件，命令为：javac 文件名.java
3. 在命令行运行class文件，命令：java 类名（注意大小写敏感）

### 3.初学常见的错误

#### 1、单词拼写问题

* 	* 正确：class		错误：Class
   * 正确：String              错误：string
   * 正确：System            错误：system
   * 正确：main		错误：mian
* 	Java语言是一门严格区分大小写的语言

例如：



![image-20220908154610246](https://image.3001.net/images/20230202/16753340123429.png)

#### ![image-20220908154759027](https://image.3001.net/images/20230202/16753340127952.png)



#### 2.标点符号使用问题

* 不能用中文标点符号，要使用英文半角的标点符号
* 括号和引号等成对出现

例如：

![image-20220908154853639](https://image.3001.net/images/20230202/16753340256183.png)

![image-20220908154925963](https://image.3001.net/images/20230202/16753340252401.png)

![image-20220908154950155](https://image.3001.net/images/20230202/1675334025309.png)



## 4.源文件名、类名、字节码文件名的区别和联系？

（1）源文件名、类名、字节码文件名的认识

![image-20230202183556243](https://image.3001.net/images/20230202/16753341586004.png)



（2）源文件名是否必须与类名一致？

```java
如果这个类不是public，那么源文件名可以和类名不一致。但是不便于代码维护。不推荐这么干。
我们建议大家，不管是否是public，都与源文件名保持一致，而且一个源文件尽量只写一个类，目的是为了好维护。
```

（3）类名和字节码文件名一致？

```java
字节码文件名就是类名
```

（4）一个源文件中是否可以有多个类？

```java
一个源文件中可以有多个类，编译后会生成多个.class字节码文件。
```

## 5、public的类

（1）class前面可以加public

```java
如果这个类是public，那么要求源文件名必须与类名一致。否则编译报错。
    
因此一个源文件只能有一个public的类。
```

（2）main方法必须在public的类中吗？

```java
不是。

但是后面写代码时，基本上main方法（主方法）习惯上都在public类中。
```

#### 6、文件名大小写问题

（1）程序代码中代码、类名等

	严格区分大小写

（2）字节码文件名

	因为字节码文件名就是类名，所以严格区分大小写
	
	java命令 主类名/字节码文件名

（3）源文件名

	在Windows操作系统中.java的源文件名不区分大小写，但是考虑到需要培养程序员严谨的工作态度，我们建议大家养成区分大小写的习惯。
	
	javac命令 源文件名.java

#### 7、字符编码问题

当cmd命令行窗口的字符编码与.java源文件的字符编码不一致，如何解决？

![1557881223916](https://image.3001.net/images/20230202/16753342228051.png)

解决方案一：

	在Notepad++等编辑器中，修改源文件的字符编码

![1557881271819](https://image.3001.net/images/20230202/16753342225543.png)

解决方案二：

	在使用javac命令式，可以指定源文件的字符编码

```cmd
javac -encoding utf-8 Review01.java
```

#### 8、Java程序的结构与格式

```java
类{
    方法{
        语句;
    }
}
```

格式：

（1）每一级{}缩进一个Tab键

（2）习惯{}的左半部分在行尾，右半部分单独一行，与和它成对的"{"的行首对齐



## 9、 关键字（*keyword*）（掌握）

**关键字**：是指在程序中，Java已经定义好的单词，具有特殊含义。

关键字的特点：全部都是小写字母。

```java
HelloWorld案例中，出现的关键字有 public、class、static、void等，这些单词已经被Java定义好。
关键字比较多，不需要今天一口气全记住，学到哪里记到哪里即可。
```

```java
Java8关键字一共50个，其中const和goto是保留字。
true,false,null看起来像关键字，但从技术角度，它们是特殊的布尔值和空值。
```

![1555209180504](https://image.3001.net/images/20230202/16753343119420.png)

```java
Java17关键字有51个，其中const和goto、_是保留字。
strictfp是已经废弃的关键字。
true,false,null是字面常量值。
另外有16个上下文关键字，它们只在特定的位置才是关键字，否则它们就是标识符。例如：
    exports，opens，requires，uses
    module，permits，sealed，var
    non-sealed，provides，to，with
    open，record，transitive，yield
```

![image-20221111133342187](https://image.3001.net/images/20230202/16753343118125.png)



## 10、 标识符( identifier)（掌握）

简单的说，凡是程序员自己命名的部分都可以称为标识符。

即给类、变量、方法、包等命名的字符序列，称为标识符。

更多细节详见《代码整洁之道.pdf》《阿里的Java开发手册》

### 10.1.1 标识符的命名规则

标识符的命名规则：必须遵守的硬性规则

（1）Java的标识符只能使用26个英文字母大小写，0-9的数字，下划线_，美元符号$

（2）不能使用Java的关键字（包含保留字）和特殊值

（3）数字不能开头

（4）不能包含空格

（5）严格区分大小写

### 10.1.2 标识符的命名规范

 标识符的命名规范：建议遵守的软性规则，否则容易被鄙视和淘汰

（1）见名知意

（2）类名、接口名等：每个单词的首字母都大写，形式：XxxYyyZzz，

例如：HelloWorld，String，System等

（3）变量、方法名等：从第二个单词开始首字母大写，其余字母小写，形式：xxxYyyZzz，

例如：age,name,bookName,main

（4）包名等：每一个单词都小写，单词之间使用点.分割，形式：xxx.yyy.zzz，

例如：java.lang;

自己命名的包不能以java开头，习惯上以公司域名倒置的写法，例如：com.atguigu.bean;

（5）常量名等：每一个单词都大写，单词之间使用下划线_分割，形式：XXX_YYY_ZZZ，

例如：MAX_VALUE,PI

## 10.2 初识数据类型(data type)（掌握）

Java的数据类型分为两大类：

- **基本数据类型**：包括 `整数`、`浮点数`、`字符`、`布尔`。 
- **引用数据类型**：包括`数组`、 `类`、`接口`、`枚举`、`注解`、`记录`。 



## 10.3 常量值（*literal value*）（掌握）

**常量值：用于表示在编译时就可以确定的数据值，并且在程序执行的过程中其值不可以发生改变**

```java
例如：整数最大值：9223372036854775807，
     圆周率pi的值：3.14159265358979323846，
     自然底数e的值：2.7182818284590452354，
     《三国演义》的作者：罗贯中
    李清照的性别：女
```

常量值的分类和表示：

|          类型          |          举例           |
| :--------------------: | :---------------------: |
|       整数常量值       | 12，-23, 1567844444557L |
|       浮点常量值       |   12.34F，12.34，12D    |
|       字符常量值       |     ‘a’，'0'，‘尚’      |
|       布尔常量值       |       true，false       |
|      字符串常量值      |    "HelloWorld"、""     |
| 引用数据类型空值常量值 |          null           |


- 整数常量值，超过int范围的必须加L或l（小写L）
- 小数常量值，无论多少，不加F，就是double类型，也可以在数字后面加D或d表示double类型。要表示float类型，必须加F或f
- char常量值，必须使用单引号
- String字符串常量值，必须使用双引号

```java
public class ConstantDemo {
	public static void main(String[] args) {		
		//输出整数常量值
		System.out.println(12);
		System.out.println(-23);
        System.out.println(235265954566L);
		
		//输出小数常量值
        System.out.println(12.34F);
		System.out.println(12.34);
        System.out.println(12D);
		
		//输出字符常量值
		System.out.println('a');
		System.out.println('0');
        System.out.println('尚');
		
		//输出布尔常量值
		System.out.println(true);
		System.out.println(false);
        
        //输出字符串常量值
		System.out.println("HelloWorld");
        System.out.println("");
        
        //输出空值常量值
		System.out.println(null);
	}
}
```

## 10.4 变量（*variable*）（掌握）

### 10.4.1 变量的概念

**变量：用来表示可以在程序执行的过程中才能确定的数据值，或者在程序执行期间可以修改的数据值**

变量的作用：用来存储数据，代表内存的一块存储区域，这块内存中的值是可以改变的。

![image-20230202164552516](https://image.3001.net/images/20230202/16753343766137.png)

### 10.4.2 变量的声明

```java
数据类型  变量名;
例如：
//存储一个整数类型的年龄
int age; 

//存储一个小数类型的体重
double weight;

//存储一个单字符类型的性别 
char gender;

//存储一个布尔类型的婚姻状态
boolean marry;

//存储一个字符串类型的姓名
String name;

//声明多个同类型的变量
int a,b,c; //表示a,b,c三个变量都是int类型。
```

> 注意：变量的数据类型可以是基本数据类型，也可以是引用数据类型。

### 10.4.3 变量的赋值

给变量赋值，就是把“值”存到该变量代表的内存空间中。

1、变量赋值的语法格式

```java
变量名 = 值;
```

- 给变量赋值，变量名必须在=左边，值必须在=右边
- 给变量赋的值类型必须与变量声明的类型一致或兼容（<=）

2、可以使用合适类型的常量值给变量赋值

```java
int age = 18;
double weight = 44.4;
char gender = '女';
boolean marry = true;
String name = "柴林燕";
```

**long类型：如果赋值的常量整数超过int范围，那么需要在数字后面加L。**

**float类型：如果赋值为常量小数，那么需要在小数后面加F。**

**char类型：使用单引号''**

**String类型：使用双引号""**

3、可以使用其他变量或者表达式给变量赋值

```java
int m = 1;
int n = m;
        
int x = 1;
int y = 2;
int z = 2 * x + y;
```

### 10.4.4 变量值的输出

```java
//输出变量的值
System.out.println(age);

//输出变量的值
System.out.println("年龄：" + age);
System.out.println("age：" + age);
System.out.println("name" + name + ",age = " + age + "，gender = " + gender + ",weight = " + weight + ",marry = " + marry);
```

> ()中填写的是要输出的某个值。
>
> 如果某些内容想要原样输出，就用""引起来，而要输出变量中的内容，则不要把变量名用""引起来
>
> +的左右两边有""表示的字符串的话，意义是拼接多项内容为一个值。

### 10.4.5 变量可以反复赋值

- 变量的第一次赋值称为初始化；
- 变量的再赋值称为修改变量的值；
- 上一行变量值的修改对下一行的计算会产生影响；

```java
//先声明，后初始化
char gender;
gender = '女';

//声明的同时初始化
int age = 18;
System.out.println("age = " + age);///age = 18

//给变量重新赋值，修改age变量的值
age = 19;
System.out.println("age = " + age);//age = 19
```

### 10.4.6 变量的三要素

1、数据类型

- 变量的数据类型决定了在内存中开辟多大空间
- 变量的数据类型也决定了该变量可以存什么值

2、变量名

- 见名知意非常重要

3、值

- 基本数据类型的变量：存储数据值

- 引用数据类型的变量：存储地址值，即对象的首地址。例如：String类型的变量存储的是字符串对象的首地址（关于对象后面章节再详细讲解）

### 10.4.7 变量的使用应该注意什么？

1、先声明后使用

> 如果没有声明，会报“找不到符号”错误

2、在使用之前必须初始化

> 如果没有初始化，会报“未初始化”错误

3、变量有作用域

> 如果超过作用域，也会报“找不到符号”错误

4、在同一个作用域中不能重名

5、变量值的类型必须与变量声明的类型一致或兼容（<=）

```java
一致：一样
int age = 18;  18是int类型的常量值，age也是int类型

    
兼容：可以装的下，=右边的值要 小于等于 =左边的变量类型
long bigNum =18; 18是int类型的常量值，bigNum是long类型
int < long

int age = 18L; 错误  18L是long类型的常量值，age是int类型
long > int
```

### 10.4.8 变量的使用案例

案例需求：随机产生一个[0,1)的小数，用它表示某个圆的半径，然后输出圆的面积和周长的值。

开发提示：

- 通过Math.random()可以随机产生一个[0,1)的小数。
- 圆周率用3.14159265358979323846表示。
- Java中用*表示乘法。

```java
class TestCircle {
    public static void main(String[] args) {
        double radius = Math.random();
        double area = 3.14159265358979323846 * radius * radius;
        double perimeter = 2 * 3.14159265358979323846 * radius;
        System.out.println("本次圆半径值是：" + radius);
        System.out.println("面积是：" + area);
        System.out.println("周长是：" + perimeter);
    }
}
```



## 11、 最终变量/常量（final）

最终变量习惯上也称为常量，因为它是通过在声明变量的数据类型前面加final的方式实现的，所以叫最终变量。加final修饰后，这个变量的值就不能修改了，一开始赋值多少，就是多少，所以此时的变量名通常称为常量名。常量名通常所有字母都大写，每一个单词之间使用下划线分割，从命名上和变量名区分开来。

这样做的好处：

- 可读性更好
- 便于维护

案例需求：随机产生两个[0,1)的小数，分别用它表示两个圆的半径，然后输出对应圆的面积和周长的值。

开发提示：

- 通过Math.random()可以随机产生一个[0,1)的小数。
- 圆周率用3.14159265358979323846表示。
- Java中用*表示乘法。

```java
class TestNoFinal {
    public static void main(String[] args) {
        double radius1 = Math.random();
        double area1 = 3.14159265358979323846 * radius1 * radius1;
        double perimeter1 = 2 * 3.14159265358979323846 * radius1;
        System.out.println("第1个圆半径值是：" + radius1);
        System.out.println("第1个圆面积是：" + area1);
        System.out.println("第1个圆周长是：" + perimeter1);

        double radius2 = Math.random();
        double area2 = 3.14159265358979323846 * radius2 * radius2;
        double perimeter2 = 2 * 3.14159265358979323846 * radius2;
        System.out.println("第2个圆半径值是：" + radius2);
        System.out.println("第2个圆面积是：" + area2);
        System.out.println("第2个圆周长是：" + perimeter2);
    }
}
```

```java
public class TestUseFinal {
    public static void main(String[] args) {
//        final double PI = 3.14159265358979323846;
        final double PI = 3.14;
        double radius1 = Math.random();
        double area1 =  PI * radius1 * radius1;
        double perimeter1 = 2 * PI * radius1;
        System.out.println("第1个圆半径值是：" + radius1);
        System.out.println("第1个圆面积是：" + area1);
        System.out.println("第1个圆周长是：" + perimeter1);

        double radius2 = Math.random();
        double area2 = PI * radius2 * radius2;
        double perimeter2 = 2 * PI * radius2;
        System.out.println("第2个圆半径值是：" + radius2);
        System.out.println("第2个圆面积是：" + area2);
        System.out.println("第2个圆周长是：" + perimeter2);
    }
}
```



