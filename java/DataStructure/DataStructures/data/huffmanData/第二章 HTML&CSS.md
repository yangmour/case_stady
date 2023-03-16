# 第二章 HTML\&CSS

## 1 HTML概念

HTML是Hyper Text Markup Language的缩写。意思是『超文本标记语言』。它的作用是搭建网页结构，在网页上展示内容！

HTML5 是 **HyperText Markup Language 5 的缩写，HTML5** 技术结合了 HTML4.01 的[相关标准](https://baike.baidu.com/item/相关标准/5199682?fromModule=lemma_inlink "相关标准")并革新，符合现代网络发展要求，在 2008 年正式发布。HTML5 由不同的技术构成，其在互联网中得到了非常广泛的应用，提供更多增强[网络应用](https://baike.baidu.com/item/网络应用/2196523?fromModule=lemma_inlink "网络应用")的标准机。与传统的技术相比，HTML5 的语法特征更加明显，并且结合了 [SVG](https://baike.baidu.com/item/SVG/63178?fromModule=lemma_inlink "SVG") 的内容。这些内容在网页中使用可以更加便捷地处理多媒体内容，而且 HTML5中还结合了其他元素，对原有的功能进行调整和修改，进行[标准化工作](https://baike.baidu.com/item/标准化工作/9777788?fromModule=lemma_inlink "标准化工作")。HTML5 在 2012 年已形成了稳定的版本。2014年10月28日，W3C发布了HTML5的最终版。

### 1.1 超文本

HTML文件本质上是文本文件，而普通的文本文件只能显示字符。但是HTML技术则通过HTML标签把其他网页、图片、音频、视频等各种多媒体资源引入到当前网页中，让网页有了非常丰富的呈现方式，这就是超文本的含义——本身是文本，但是呈现出来的最终效果超越了文本。

### 1.2 标记语言

说HTML是一种『标记语言』是因为它不是向Java这样的『编程语言』，因为它是由一系列『标签』组成的，没有常量、变量、流程控制、异常处理、IO等等这些功能。HTML很简单，每个标签都有它固定的含义和确定的页面显示效果。

-   『双标签』

标签是通过一组尖括号+标签名的方式来定义的：

```html
<p>HTML is a very popular fore-end technology.</p>
```

这个例子中使用了一个p标签来定义一个段落，\<p>叫**开始标签**，\</p>叫**结束标签**。开始标签和结束标签一起构成了一个完整的标签。开始标签和结束标签之间的部分叫**文本标签体**，也简称：**标签体**。

-   『属性』

```html
<a href="http://www.xxx.com">show detail</a>
```

href="网址" 就是属性，href是属性名，"网址"是属性值

-   『单标签』

```html
<input type="text" name="username" />
```

## 2 HTML的入门程序

![](image/img029_D60bYNcRqG.png)

### 2.1 HTML的结构

1.  **文档声明:** HTML文件中第一行的内容，用来告诉浏览器当前HTML文档的基本信息，其中最重要的就是当前HTML文档遵循的语法标准。这里我们只需要知道HTML有4和5这两个大的版本，HTML4版本的文档类型声明是：
    ```html
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    ```
    HTML5版本的文档类型声明是：
    ```html
    <!DOCTYPE html>
    ```
    现在主流的技术选型都是使用HTML5，之前的版本基本不用了。
2.  **根标签:** html标签是整个文档的根标签，所有其他标签都必须放在html标签里面。
3.  **头部:** head标签用于定义文档的头部，其他头部元素都放在head标签里。头部元素包括title标签、script标签、style标签、link标签、meta标签等等。
4.  **主体:** body标签定义网页的主体内容，在浏览器窗口内显示的内容都定义到body标签内。
5.  **注释:** HTML注释的写法是：
    ```html
    <!-- 注释内容 -->
    ```
    注释的内容不会显示到浏览器窗口内，是开发人员用来对代码内容进行解释说明。

### 2.2 HTML语法规则

-   根标签有且只能有一个
-   无论是双标签还是单标签都需要正确关闭
-   标签可以嵌套但不能交叉嵌套
-   注释不能嵌套
-   属性必须有值，值必须加引号，单引号或双引号均可
    -   H5新规中有的属性可以没有属性值(后面会遇到，在介绍)
-   标签名不区分大小写但建议使用小写

### 2.3 使用idea创建StaticWeb工程

![](image/image_ASUu7Wc4mY.png)

## 3 HTML的基础标签

### 3.1 标题标签

**代码**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>这是一级标题</h1>
    <h2>这是二级标题</h2>
    <h3>这是三级标题</h3>
    <h4>这是四级标题</h4>
    <h5>这是五级标题</h5>
    <h6>这是六级标题</h6>

</body>
</html>
```

**页面效果**

![](image/img031_CXNDopMpzQ.png)

### 3.2 段落标签

**代码**

```html
<p>
    There is clearly a need for CSS to be taken seriously by graphic artists. 
    The Zen Garden aims to excite, inspire, and encourage participation. 
    To begin, view some of the existing designs in the list. 
    Clicking on any one will load the style sheet into this very page. 
    The code remains the same, the only thing that has changed is 
    the external .css file. Yes, really.
</p>
```

**页面效果**

![](image/img032_JRP3jOmdzQ.png)

### 3.3 换行标签

**代码**

```html
We would like to see as much CSS1 as possible. CSS2 should be limited to 
widely-supported elements only. The css Zen Garden is about functional, 
practical CSS and not the latest bleeding-edge tricks viewable by 2% of 
the browsing public. <br/>The only real requirement we have is that your
 CSS validates.
```

![](image/img034_9WXRjXC-HI.png)

### 3.4 无序列表标签

**代码**

```html
<!--4.无序列表标签 ul-li
        type: disc 黑色圆圈
              circle 空心圆圈
              square 黑心方块
    -->
<ul>
    <li>Apple</li>
    <li>Banana</li>
    <li>Grape</li>
</ul>
```

**页面效果**

![](image/img035_dwuiw5mQ45.png)

### 3.5 超链接标签(重要)

**代码**

```html
<body>
    <!--
        超链接标签a的作用: 进行资源跳转
            href: 你要跳转到的资源的路径
            target: 新页面的打开方式
    -->
    <!--
        1. 跳转到本项目的资源: 使用相对路径
            相对路径: 以当前路径作为基准，如果资源跟我说同一个目录下的则直接写资源名就行了
                    如果在不同目录下，要找上一级目录，则使用../

                    . 当前目录
                    .. 上一级目录
        2. 跳转到其它服务器的资源: 此时就要使用完整的url访问路径
    -->
    <a href="../01_html的入门/start.html">跳转到start.html页面</a><br/>

    <!--
        target属性表示新页面的打开方式，我们目前只需要掌握两种取值:
            _self 表示新页面在当前页面打开
            _blank 表示新页面会新打开一个标签页
    -->
    <a href="https://www.baidu.com" target="_blank">跳转到百度</a>
</body>
```

点击后跳转到href属性指定的页面

### 3.6 图片标签(重点)

**准备图片文件**

**代码**

```html
<!--
img标签是用于显示图片的，它有如下属性
1. src: 用于指定要显示的图片的路径，建议使用相对路径
        图片除了可以引用本地相对路径，也可以引用网络地址图片！
        除了可以显示静态图片也可以显示gif格式的动态图片！
项目中的图片一般存放在一个img的文件夹中
2. width: 图片的宽度
3. height: 图片的高度
-->
<img src="../img/mm.jpg" width="409" height="292"/>
```

**页面效果**

![](image/img037_9tTtLtpS7u.png)

### 3.7 块标签(重点)

『块』

并不是为了显示文章内容的，而是为了方便结合CSS对页面进行布局。块有两种，div是前后有换行的块，span是前后没有换行的块。

把下面代码粘贴到HTML文件中查看他们的区别：

```html
<div style="border: 1px solid black;width: 100px;height: 100px;">This is a div block</div>
<div style="border: 1px solid black;width: 100px;height: 100px;">This is a div block</div>

<span style="border: 1px solid black;width: 100px;height: 100px;">This is a span block</span>
<span style="border: 1px solid black;width: 100px;height: 100px;">This is a span block</span>
```

![](image/img038_T35GyIKUMn.png)

### 3.8 HTML实体(了解)

在HTML文件中，<、>等等这样的符号已经被赋予了特定含义，不会作为符号本身显示到页面上，此时如果我们想使用符号本身怎么办呢？那就是使用HTML实体来转义。

![](image/img050_GoJvQhWN6J.png)

## 4 使用表格标签展示数据(重要)

### 4.1 目标页面效果

![](image/img051_RBgzwNa_b3.png)

### 4.2 第一版代码

```html
<!-- 使用table标签定义表格 -->
<table>
    <!-- 使用tr标签定义表格的行 -->
    <tr>
        <!-- 使用th标签定义表头，表头有字体加粗效果 -->
        <th>姓名</th>
        <th>属性</th>
        <th>级别</th>
        <th>忍村</th>
    </tr>
    <tr>
        <!-- 使用td标签定义单元格 -->
        <td>漩涡鸣人</td>
        <td>风</td>
        <td>下忍</td>
        <td>木叶</td>
    </tr>
    <tr>
        <td>宇智波佐助</td>
        <td>雷&火</td>
        <td>下忍</td>
        <td>木叶</td>
    </tr>
    <tr>
        <td>我爱罗</td>
        <td>沙</td>
        <td>影</td>
        <td>砂隐村</td>
    </tr>
</table>
```

如果只有上面的代码，页面显示效果是：

![](image/img052_2ASqapYaNO.png)

没有表格边框。想要显示好看的表格边框可以把下面属性：

```html
<!-- 使用table标签定义表格 -->
<table bordercolor="black" border="1px" cellspacing="0px" >
    <!-- 使用tr标签定义表格的行 -->
    <tr>
        <!-- 使用th标签定义表头，表头有字体加粗效果 -->
        <th>姓名</th>
        <th>属性</th>
        <th>级别</th>
        <th>忍村</th>
    </tr>
    <tr>
        <!-- 使用td标签定义单元格 -->
        <td>漩涡鸣人</td>
        <td>风</td>
        <td>下忍</td>
        <td>木叶</td>
    </tr>
    <tr>
        <td>宇智波佐助</td>
        <td>雷&火</td>
        <td>下忍</td>
        <td>木叶</td>
    </tr>
    <tr>
        <td>我爱罗</td>
        <td>沙</td>
        <td>影</td>
        <td>砂隐村</td>
    </tr>
</table>
```

![](image/img053_JcytgSziZm.png)

我们发现，相较于目标效果而言，还未实现横纵向合并单元格

### 4.3 合并单元格

#### 4.3.1 横向合并单元格(列合并)

使用colspan属性将两个横向相邻的单元格跨列合并：

```html
<tr>
    <td>宇智波佐助</td>
    <td>雷&火</td>
    <td colspan="2">下忍</td>
</tr>
```

![](image/img054_McCIQIakj9.png)

注意: 『被合并』的单元格要删掉。

#### 4.3.2 纵向合并单元格(行合并)

使用rowspan属性将两个纵向相邻的单元格跨行合并：

```html
<tr>
    <td>宇智波佐助</td>
    <td rowspan="2">雷&火</td>
    <td colspan="2">下忍</td>
</tr>
<tr>
    <td>我爱罗</td>
    <td>影</td>
    <td>砂隐村</td>
</tr>
```

![](image/img055_j1DN-Y0Xp2.png)

注意: 『被合并』的单元格要删掉。

### 4.4 扩展表格内含标签

thead、tfoot 以及 [tbody](https://baike.baidu.com/item/tbody?fromModule=lemma_inlink "tbody") 元素使您有能力对[表格](https://baike.baidu.com/item/表格?fromModule=lemma_inlink "表格")中的行进行分组。当您创建某个表格时，您也许希望拥有一个标题行，一些带有数据的行，以及位于底部的一个总计行。这种划分使浏览器有能力支持独立于表格标题和页脚的表格正文滚动。当长的表格被打印时，表格的表头和页脚可被打印在包含表格数据的每张页面上。

```html
<table border="1">
    <thead>
      <tr>
        <th>人物</th>
        <th>背景</th>
        <th>成就</th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td>张三</td>
        <td>清末</td>
        <td>当了洋人的内奸</td>
      </tr>
    </tbody>
  </table>

```

## 5 表单标签(重要)

### 5.1 表单标签的作用

在项目开发过程中，凡是需要用户填写的信息都需要用到表单。它的作用是接收用户的输入信息，并且将用户输入的信息提交给服务器

### 5.2 form标签的介绍

在HTML中我们使用form标签来定义一个表单。而对于form标签来说有两个最重要的属性：action和method。

```html
<form action="/aaa/pro01-HTML/page05-form-target.html" method="post">
    
</form>
```

#### 5.2.1 action属性

用户在表单里填写的信息需要发送到服务器端，对于Java项目来说就是交给Java代码来处理。那么在页面上我们就必须正确填写服务器端的能够接收表单数据的地址。

这个地址要写在form标签的action属性中。但是现在暂时我们还没有服务器端环境，所以先借用一个HTML页面来当作服务器端地址使用。

#### 5.2.2 method属性

这个单词的意思是『方式、方法』，在form标签中method属性用来定义提交表单的『请求方式』。method属性只有两个可选值：get或post，没有极特殊情况的话使用post即可。

### 5.3 表单项标签

表单中的每一项，包括: 文本框、密码框、单选框、多选框等等，都称之为表单项，一个表单中可以包含多个表单项

#### 5.3.1 name和value属性

在用户使用一个软件系统时，需要一次性提交很多数据是非常正常的现象。我们肯定不能要求用户一个数据一个数据的提交，而肯定是所有数据填好后一起提交。那就带来一个问题，服务器怎么从众多数据中识别出来收货人、所在地区、详细地址、手机号码……？

很简单，给每个数据都起一个『名字』，发送数据时用『名字』携带对应的数据，接收数据时通过『名字』获取对应的数据。在各个具体的表单标签中，我们通过『name属性』来给数据起『名字』，通过『value属性』来保存要发送给服务器的『值』。

但是名字和值之间既有可能是『一个名字对应一个值』，也有可能是『一个名字对应多个值』。

这么看来这样的关系很像我们Java中的Map，而事实上在服务器端就是使用Map类型来接收请求参数的。具体的是类型是：Map\<String,String\[]>。

name属性就是Map的键，value属性就是Map的值。

有了上面介绍的基础知识，下面我们就可以来看具体的表单项标签了。

#### 5.3.2 单行文本框

**代码**

```html
个性签名：<input type="text" name="signal"/><br/>
```

**显示效果**

![](image/img056_UTAfwj8_OF.png)

#### 5.3.3 密码框

**代码**

```html
密码：<input type="password" name="secret"/><br/>
```

**显示效果**

![](image/img057_SbxPP1mQsm.png)

#### 5.3.4 单选框

**代码**

```html
你的性别是：
<input type="radio" name="sex" value="spring" />男
<input type="radio" name="sex" value="summer" checked="checked" />女

```

**显示效果**

![](image/image_eHuu03UO_e.png)

**说明:**

-   name属性相同的radio为一组，组内互斥
-   当用户选择了一个radio并提交表单，这个radio的name属性和value属性组成一个键值对发送给服务器
-   设置checked="checked"属性设置默认被选中的radio
    -   如果属性名和属性值一样的话，可以省略属性值，只写checked即可

#### 5.3.5 多选框

**代码**

```html
你最喜欢的球队是：
<input type="checkbox" name="team" value="Brazil"/>巴西
<input type="checkbox" name="team" value="German" checked/>德国
<input type="checkbox" name="team" value="France"/>法国
<input type="checkbox" name="team" value="China" checked="checked"/>中国
<input type="checkbox" name="team" value="Italian"/>意大利
```

**显示效果**

![](image/img059_m_GZJ1PCzW.png)

**说明:**

-   设置checked="checked"属性设置默认被选中的checkbox
    -   如果属性名和属性值一样的话，可以省略属性值，只写checked即可

#### 5.3.6 下拉框

**代码**

```html
你喜欢的运动是：
<select name="interesting">
    <option value="swimming">游泳</option>
    <option value="running">跑步</option>
    <option value="shooting" selected="selected">射击</option>
    <option value="skating">溜冰</option>
</select>
```

**显示效果**

![](image/img060_TyWVPscK3Z.png)

**说明:**

-   下拉列表用到了两种标签，其中select标签用来定义下拉列表，而option标签设置列表项。
-   name属性在select标签中设置。
-   value属性在option标签中设置。
-   option标签的标签体是显示出来给用户看的，提交到服务器的是value属性的值。
-   通过在option标签中设置selected="selected"属性实现默认选中的效果。
    -   只写selected即可

#### 5.3.7 按钮

**代码**

```html
<button type="button">普通按钮</button>或<input type="button" value="普通按钮"/>
<button type="reset">重置按钮</button>或<input type="reset" value="重置按钮"/>
<button type="submit">提交按钮</button>或<input type="submit" value="提交按钮"/>
```

**显示效果**

![](image/img061_3p4HFezjgl.png)

**说明:**

-   普通按钮: 点击后无效果，需要通过JavaScript绑定单击响应函数
-   重置按钮: 点击后将表单内的所有表单项都恢复为默认值  提交按钮
-   提交按钮: 点击后提交表单

#### 5.3.8 隐藏域

**代码**

```html
<input type="hidden" name="userId" value="2233"/>
```

**说明:**

通过表单隐藏域设置的表单项不会显示到页面上，用户看不到。但是提交表单时会一起被提交。用来设置一些需要和表单一起提交但是不希望用户看到的数据，例如：用户id等等。

#### 5.3.9 多行文本框

**代码**

```html
自我介绍：<textarea name="desc"></textarea>
```

**显示效果**

![](image/img062_UCquH_xtcj.png)

**说明:**

textarea没有value属性，如果要设置默认值需要写在开始和结束标签之间。

#### 5.3.10 文件表单

**代码**

```html
头像:<input type="file" name="file"/>
```

**显示效果**

**说明:**

不同浏览器显示的样式有微小差异

## 6 CSS

CSS是用于设置HTML页面标签的样式，用于美化HTML页面

CSS3是[CSS](https://baike.baidu.com/item/CSS/5457?fromModule=lemma_inlink "CSS")（层叠样式表）技术的升级版本，于1999年开始制订，2001年5月23日W3C完成了CSS3的工作草案，主要包括盒子模型、列表模块、[超链接](https://baike.baidu.com/item/超链接/97857?fromModule=lemma_inlink "超链接")方式、语言模块、背景和边框、文字特效、多栏布局等模块

### 6.1 CSS的引入方式

#### 6.1.1 行内样式

也就是在要设置样式的标签中添加style属性，编写css样式; 行内样式仅对当前标签生效

```html
<!--给div设置边框-->
<div style="border: 1px solid black;width: 100px; height: 100px;">&nbsp;</div>
```

#### 6.1.2 内部样式

一般是在当前页面的head标签中添加style标签，在style标签中编写css样式代码; 内部样式仅对当前页面生效

```html
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        .one {
            border: 1px solid black;
            width: 100px;
            height: 100px;
            background-color: lightgreen;
            margin-top: 5px;
        }
    </style>
</head>
<body>

    <div style="border: 1px solid black;width: 100px; height: 100px;">&nbsp;</div>

    <div class="one">&nbsp;</div>
    <div class="one">&nbsp;</div>
    <div class="one">&nbsp;</div>

</body>
```

![](image/img063_O9xbTuJDnd.png)

#### 6.1.3 外部样式

1.  创建CSS文件

    ![](image/img064_WKn1Hzohcu.png)
2.  编辑CSS文件
    ```css
    .two {
        border: 1px solid black;
        width: 100px;
        height: 100px;
        background-color: yellow;
        margin-top: 5px;
    }
    ```
3.  引入外部CSS文件
    在需要使用这个CSS文件的HTML页面的head标签内加入：
    ```html
    <link rel="stylesheet" type="text/css" href="/aaa/pro01-HTML/style/example.css" />
    ```
    于是下面HTML代码的显示效果是:
    ```html
    <div class="two">&nbsp;</div>
    <div class="two">&nbsp;</div>
    <div class="two">&nbsp;</div>
    ```
    ![](image/img065__Hoh0AwYtO.png)

### 6.2 CSS代码语法

-   CSS样式由选择器和声明组成，而声明又由属性和值组成。
-   属性和值之间用冒号隔开。
-   多条声明之间用分号隔开。
-   使用/\* ... \*/声明注释

![](image/img066_mVsjvJfhij.png)

### 6.3 CSS选择器

#### 6.3.1 标签选择器

HTML代码

```html
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
<p>Hello, this is a p tag.</p>
```

CSS代码

```css
p {
    color: blue;
    font-weight: bold;
}
```

页面效果

![](image/img067_E0Pb3KrXyB.png)

#### 6.3.2 id选择器

HTML代码：

```html
    <p>Hello, this is a p tag.</p>
    <p>Hello, this is a p tag.</p>
    <p id="special">Hello, this is a p tag.</p>
    <p>Hello, this is a p tag.</p>
    <p>Hello, this is a p tag.</p>
```

CSS代码：

```css
        #special {
            font-size: 20px;
            background-color: aqua;
        }
```

显示效果

![](image/img068_Jw0A_H8r5j.png)

#### 6.3.3 类选择器

HTML代码：

```html
    <div class="one">&nbsp;</div>
    <div class="one">&nbsp;</div>
    <div class="one">&nbsp;</div>
```

CSS代码：

```css
        .one {
            border: 1px solid black;
            width: 100px;
            height: 100px;
            background-color: lightgreen;
            margin-top: 5px;
        }
```

显示效果

![](image/img069_mG-NH1DRdm.png)

[\[ 上一章 \]](https://www.wolai.com/gAShd8SJ6s2M6iMsm7YtJ7 "\[ 上一章 ]")    [\[ 回目录 \]](https://www.wolai.com/uqHQ7tKYz6d6dAg5Gbva4T "\[ 回目录 ]")    [\[ 下一章 \]](https://www.wolai.com/8ZyB2YLQLLJumFUP4xGVHg "\[ 下一章 ]")
