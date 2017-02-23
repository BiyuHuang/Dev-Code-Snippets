# ___Coding Notes___

---
# ___前端/服务端 技能专题___

> TCP/IP  XML  HTML  CSS  JavaScript Spray

## 1.1 __Tcp/IP协议模块__
### 1.1.1 Tcp/IP介绍

* 概念  

      计算机通信协议(Computer Communication Protocol)

      Tcp/IP是供已连接因特网的计算机进行通信的通信协议 (Transmission Control Protocol / Internet Protocol)   

* 通信协议

      TCP (传输控制协议) - 应用程序之间通信

      UDP (用户数据包协议) - 应用程序之间的简单通信

      IP (网际协议) - 计算机之间的通信

      ICMP (因特网消息控制协议) - 针对错误和状态

      DHCP (动态主机配置协议) - 针对动态寻址

* 具体功能

      Tcp/IP 意味着TCP 与 IP 一起协同工作

      TCP 负责应用软件(Broswer)和网络软件之间的通信

      IP 负责计算机之间的通信

      TCP 负责将数据分割并装入IP包，然后在它们到达的时候重新组合它们

      IP负责将包发送至接受者

### 1.1.2 Tcp/IP寻址

> TCP/IP使用32个比特或者4组0到255之间的数字来为计算机编址

* IP地址

      TCP/IP 使用4组数字来为计算机编址：192.168.0.1
      实质是使用32bits进行编址，1Byte = 8 bits，所以TCP/IP使用4字节.

* 域名

### 1.1.3 Tcp/IP协议(协议族)

* TCP - 传输控制协议: 从应用程序到网络的数据传输控制
* IP - 网际协议(Internet Protocol)
* HTTP - 超文本传输协议(Hyper Text Transfer Protocol): 负责web服务器与web浏览器之间的通信
* HTTPS - 安全的HTTP(Secure HTTP)：负现web服务器与web浏览器之间的安全通信
* SSL - 安全套接字层(Secure Sockets Layer): 为安全数据传输加密数据
* SMTP - 简易邮件传输协议(Simple Mail Transfer Protocol): 电子邮件的传输
* MIME - 多用途因特网邮件扩展(Multi-purpose Internet Mail Extensions): 使SMTP有能力通TCP/IP网络传输多媒体文本，包括声音、视频和二进制数据
* IMAP - 因特网消息访问协议(Internet Message Access Protocol): 存储和取回电子邮件
* POP - 邮局协议(Post Office Protocol): 用于从电子邮件服务器向个人电脑下载电子邮件
* FTP - 文件传输协议(File Transfer Protocol): 计算机之间的文件传输
* NTP - 网络时间协议(Network Time Protocol): 计算机之间同步时间
* DHCP - 动态主机配置协议(Dynamic Host Configuration Protocol): 向网络中的计算机分配动态IP地址
* SNMP - 简单网络管理协议(Simple Network Management Protocol): 计算机网络的管理
* LDAP - 轻量级的目录访问协议(Lightweight Directory Access Protocol):用于从因特网搜集关于用户和电子邮件地址的信息
* ICMP - 因特网消息控制协议(Internet Control Message Protocol): 负责网络中的错误处理
* ARP - 地址解析协议(Address Resolution Protocol): 用于通过 IP 来查找基于 IP 地址的计算机网卡的硬件地址
* RARP - 反向地址转换协议(Reverse Address Resolution Protocol): 用于通过 IP 查找基于硬件地址的计算机网卡的 IP 地址
* BOOTP - 自举协议(Boot Protocol): 用于从网络启动计算机
* PPTP - 点对点隧道协议(Point to Point Tunneling Protocol): 用于私人网络之间的连接(隧道)

### 1.1.4 Tcp/IP邮件

    邮件收发使用不同的TCP/IP协议: SMTP发送邮件,IMAP连接邮件服务器,POP从邮件服务器下载邮件

### 1.1.5 SNMP协议详解
* SNMP协议(简单网络管理协议),是TCP/IP协议簇的一个应用层协议.
* SNMP系统主要包括管理信息库(MIB)、管理信息结构(SMI)及SNMP报文协议.
* MIB: 定义被管理对象的一系列属性(对象的名称、对象的访问权限和对象的数据类型等)
  每个SNMP设备(Agent)都有自已的MIB. MIB是NMS(网管系统)和Agent之间的沟通桥梁.
<div align="center">![NMS Agent和MIB的关系](resources\SNMP_MIB.jpg)</div>
* MIB文件中的变量使用的名字取自ISO和ITU管理的对象标识符（object identifier）名字空间。它是一种分级树的结构
<div align="center">![MIB树结构](resources\MIB_TREE.png)</div>
* SMI: 定义了SNMP框架所用信息的组织、组成和标识
* SNMP报文(5种报文)
  报文结构： 版本号
  团体号
  协议数据单元PDU(0: get-request; 1: get-next-request; 2: get-response; 3: set-request; 4: trap.)
  get-request操作：从代理进程处提取一个或多个参数值;
  get-next-request操作：从代理进程处提取紧跟当前参数值的下一个参数值;
  set-request操作：设置代理进程的一个或多个参数值;
  get-response操作：返回的一个或多个参数值。这个操作是由代理进程发出的，它是前面三种操作的响应操作;
  trap操作：代理进程主动发出的报文，通知管理进程有某些事情发生.

<div align="center">![SNMP的5种报文操作](resources\pdu.png)</div><br>
<div align="center">![报文的组成](resources\pdu_detail.png)</div>

* SNMP协议 PDU报文格式分析（BER编码）



## 1.2 __XML模块__

## 1.3 __Spary Rest API 服务__
### 1.3.1 概念
    spray 是基于akka的轻量级 scala 库，可用于编写 REST API 服务

### 1.3.2 Directive(指令)
    def routes = {
      path("") {
        get {
          respondWithMediaType(`text/html`) {
            complete {
              DefaultValues.defaultAPI
            }
          }
        }
      }
    }

    path,get,respondWithMediaType,complete嵌套在一起形成一个 Route 的语义

    Directive有四个功能:
    1. 复制 RequestContext 到下一层 Directive，RequestContext 在传输的过程中是 immutable 的。
    2. 可以获取 requester 附带的参数，比如 parameters, formData, jsonData 等，还能完成 marshall， unmarshall 操作。
    3. 可以用返回结果到 requester，可以定义结果的类型和值.

### 1.3.3 Json Support
    从 parameter 到 case class 也有映射，

    case class Color(keyword: String, sort_order: Int, sort_key: String)

    val testRoute = path("test") {
        parameters('keyword.as[String], 'sort_order.as[Int], 'sort_key.as[String]).as(Color) { color =>
          //handleTestRoute(color) // route working with the Color instance
            complete {
              <h1>test route</h1>
            }
          }
        }         

### 1.3.4 Spary test-kit
    test-kit 能够实现本地测试 Route，配合 spec2 可以取代 soapUI等自动化测试工具。

    "main entrance (/) working" in {
      Get("/") ~> routes ~> check {
        status === OK
          response.entity.asString === DefaultValues.defaultAPI

        }
      }

    step {
      server.start()
        server.createAndWaitForIndex("persons")
      }

    "Elasticsearch person dao" should {
      "return None for a non-existing person" in new Context {
          val person: Option[Person] = dao.get(UUID.randomUUID)
          person must beNone
        }

      "create and then return a person" in new Context {
          val id: UUID = dao.add(name = "John")
          val person = dao.get(id)
          person must beSome[Person]
          person must haveName("John")
        }
      }

    step {
      server.stop()
    }

## 1.4 __JavaScript 模块__
### 1.4.1 ECharts Doc

> Echarts: Enterprise Charts,商业级数据图表库

* 名词解析

      chart: 完整图表
      axis: 直角坐标系的一个坐标轴，分为类目型、数值型、时间型
      xAxis: 横轴，默认为类目型
      yAxis: 纵轴，默为为数值型
      grid: 直解坐标系中除坐标轴外的绘图网络，定义整体布局
      legend：图例，表述数据与图形的关联
      dataRange: 值域选择
      dataZoom: 数据区域缩放，用于展现大量数据时选择可视范围
      roamController: 缩放漫游组件，与地图搭配使用
      toolbox：辅助工具箱
      tooltip: 气泡提示框，常用于展现更详细的数据
      timeline: 时间轴
      series: 数据系列

      line: 折线图，堆积折线图，区域图，堆积区域图
      bar: 柱形图，堆积柱形图，条形图，堆积条形图
      scatter: 散点图，气泡图
      k: K线图
      pie: 饼图，圆环图
      radar： 雷达图，填充雷达图
      chord: 和弦图
      force: 力导布局图
      map: 地图
      heatamp: 热力图
      gauge: 仪表盘
      funnel: 漏斗图.用于展现数据经过筛选、过滤等流程处理后发生的数据变化，常见于BI类系统.
      eventRiver: 事件河流图
      treemap: 矩形式树状结构图
      venn: 韦恩图
      tree: 树图
      wordCloud: 词云

* 引入ECharts
  1. 模块化包引入
  2. 标签式单文件引入
  3. 模块化单文件引入(推荐)

* 初始化

      require获得echarts接口(或者命名空间)后可实例化图表，echarts接口仅有一个方法init,执行init时传入一个具备大小的dom节点
      //作为入口
      require(
        [
          'echarts',
          'echarts/chart/pie'
        ],
        function(ec){
          var myChart = ec.init(document.getElementById('main'));
          myChart.setOption({...});
        })

### 1.4.2 RDK Doc

### 1.4.3 React Doc

> React是一个用于构建用户界面的JavaScript库，主要用于构建UI，是MVC中的V
> MVC全名是Model View Controller，是模型(model)－视图(view)－控制器(controller)的缩写

* React 特点
  1. 声明式设计
  2. 高效
  3. 灵活
  4. JSX -- 支持JavaScript语法
  5. 组件
  6. 单向响应的数据流

## 1.5 __HTML模块__

### 1.5.1 HTML基础
* 基本标签、元素、属性  
      HTML 基本文档
            <!DOCTYPE html>
            <html>
              <head>
                <title>文档标题</title>
              </head>
              <body>
                可见文本...
              </body>
            </html>

      基本标签（Basic Tags）
      <h1>最大的标题</h1>
      <h2> . . . </h2>
      <h3> . . . </h3>
      <h4> . . . </h4>
      <h5> . . . </h5>
      <h6>最小的标题</h6>

      <p>这是一个段落。</p>
      <br> （换行）
      <hr> （水平线）
      <!-- 这是注释 -->

      文本格式化（Formatting）
      <b>粗体文本</b>
      <code>计算机代码</code>
      <em>强调文本</em>
      <i>斜体文本</i>
      <kbd>键盘输入</kbd>
      <pre>预格式化文本</pre>
      <small>更小的文本</small>
      <strong>重要的文本</strong>

      <abbr> （缩写）
      <address> （联系信息）
      <bdo> （文字方向）
      <blockquote> （从另一个源引用的部分）
      <cite> （工作的名称）
      <del> （删除的文本）
      <ins> （插入的文本）
      <sub> （下标文本）
      <sup> （上标文本）

      链接（Links）
      普通的链接： <a href="http://www.example.com/">链接文本</a>
      图像链接： <a href="http://www.example.com/"><img src="URL" alt="替换文本"></a>
      邮件链接： <a href="mailto:webmaster@example.com">发送e-mail</a>

      书签：<a id="tips">提示部分</a>
      <a href="#tips">跳到提示部分</a>

      图片（Images）
      <img src="URL" alt="替换文本" height="42" width="42">

      样式/区块（Styles/Sections）
      <style type="text/css">
      h1 {color:red;}
      p {color:blue;}
      </style>

      <div>文档中的块级元素</div>
      <span>文档中的内联元素</span>

      无序列表
      <ul>
      <li>项目</li>
      <li>项目</li>
      </ul>

      有序列表
      <ol>
      <li>第一项</li>
      <li>第二项</li>
      </ol>

      定义列表
      <dl>
      <dt>项目 1</dt>
      <dd>描述项目 1</dd>
      <dt>项目 2</dt>
      <dd>描述项目 2</dd>
      </dl>

      表格（Tables）
      <table border="1">
      <tr>
      <th>表格标题</th>
      <th>表格标题</th>
      </tr>
      <tr>
      <td>表格数据</td>
      <td>表格数据</td>
      </tr>
      </table>
      框架（Iframe）
      <iframe src="demo_iframe.htm"></iframe>
      表单（Forms）
      <form action="demo_form.php" method="post/get">

      <input type="text" name="email" size="40" maxlength="50">
      <input type="password">
      <input type="checkbox" checked="checked">
      <input type="radio" checked="checked">
      <input type="submit" value="Send">
      <input type="reset">
      <input type="hidden">
      <select>
      <option>苹果</option>
      <option selected="selected">香蕉</option>
      <option>樱桃</option>
      </select>

      <textarea name="comment" rows="60" cols="20"></textarea>

      </form>
      实体（Entities）
      &lt; 等同于 <
      &gt; 等同于 >
      &#169; 等同于 ©

      class: 为HTML元素定义一个或多个类名
      id: 定义元素的唯一id
      style: 规定元素的行内样式
      title: 描述了元素的额外信息

      <canvas> 标签定义图形,比如图表和其他图像

* HTML表单和输入
      <form>
      .
      input 元素
      .
      </form>

      示例1:
      <form action="">
      Username: <input type="text" name="user"><br>
      Password: <input type="password" name="password">
      </form>
      示例2:


### 1.5.2 HTML页面布局
* div页面布局
<div id="container" style="width:500px">
<div id="header" style="background-color:#FFA500;">
<h1 style="margin-bottom:0;">Main Title of Web Page</h1></div>
<div id="menu" style="background-color:#FFD700;height:200px;width:100px;float:left;">
<b>Menu</b><br>
HTML<br>
CSS<br>
JavaScript</div>
<div id="content" style="background-color:#EEEEEE;height:200px;width:400px;float:left;">
Content goes here</div>
<div id="footer" style="background-color:#FFA500;clear:both;text-align:center;">
Copyright © W3Schools.com</div>
</div>

* table页面布局
<table width="500" border="0">
<tr>
  <td colspan="2" style="background-color:#FFA500;">
    <h1>Main Title of Web Page</h1>
  </td>
</tr>
<tr>
  <td style="background-color:#FFD700;width:100px;">
    <b>Menu</b><br>
    HTML<br>
    CSS<br>
    JavaScript
  </td>
  <td style="background-color:#EEEEEE;height:200px;width:400px;">Content goes here</td>
</tr>
<tr>
  <td colspan="2" style="background-color:#FFA500;text-align:center;">Copyright © W3Schools.com</td>
</tr>
</table>

### 1.5.3 HTML统一资源定位器(URL)
---

# ___开发语言专题___
> scala  SQL  Python  java  shell

## 2.1 scala模块
### 2.1.1 scala 与 java集合互相调用  
    import scala.collection.JavaConversions._
### 2.1.1 zip操作

* 示例1
      scala> val k = List("aaaa","bbbb","cccc")
      k: List[String] = List(aaaa, bbbb, cccc)

      scala> val v = List("#1","#2","#3")
      v: List[String] = List(#1, #2, #3)

      scala> k.zip(v).toMap
      res1: scala.collection.immutable.Map[String,String] = Map(aaaa -> #1, bbbb -> #2, cccc -> #3)

* 示例2
      scala> val keys = List("a","b","c")
      keys: List[String] = List(a, b, c)

      scala> val values = List(List("#1111","#2222","#3333"),List("#4444","#5555","#6666"),List("#7777","#8888","#9999"))
      values: List[List[String]] = List(List(#1111, #2222, #3333), List(#4444, #5555, #6666), List(#7777, #8888, #9999))

      scala> values.map(row => keys.zip(row).toMap)
      res0: List[scala.collection.immutable.Map[String,String]] = List(Map(a -> #1111, b -> #2222, c -> #3333), Map(a -> #4444, b -> #5555, c -> #6666), Map(a -> #7777, b -> #8888, c -> #9999))

### 2.1.2 包和引用

* Package

### 2.1.3  函数

    def createCommand(srcPath:String) {
      (0 to 23).foreach { x =>
        val t = x match {
          case v if v < 10 => s"0$x"
          case _ => x
        }
      val mkDirCommand = s"""hadoop fs -mkdir -p $srcPath/p_provincecode=440000/p_date=2016-11-09/p_hour=$x/\n"""

      val putCommand = s"""hadoop fs -put ./2016-11-09_$t-*/*.csv  $srcPath/p_provincecode=440000/p_date=2016-11-09/p_hour=$x/\n"""
      println(mkDirCommand + "\n" +str)
      }
    }

## 2.2 SQL模块
### 2.2.1 SparkSQL字符串处理
* regexp_replace(src_str, pattern, replace_str) 正则匹配,替换相关内容
      0: jdbc:hive2://SPARK2:18000/> select regexp_replace('2015/6/3 11:59','/','-');
      Result: 2015-6-3 11:59
* concat_ws(separator,str1,str2,...)  字符串拼接         
      0: jdbc:hive2://SPARK2:18000/> select concat_ws(':',regexp_replace('2015/6/3 11:59','/','-'),'00');        
      Result: 2015-6-3 11:59:00
* trim(str) 去除无效空格
      0: jdbc:hive2://SPARK2:18000/> select length(trim('  wallace   '));
      Result: 7

      1 row selected (0.045 seconds)
      0: jdbc:hive2://SPARK2:18000/> select length('  wallace   ');      
      Result: 12   
* regexp_extract 字符串正则表达式解析函数
      0: jdbc:hive2://localhost:18000/> select regexp_extract('ip1234567890@itv','[0-9]+',0);
      Reulst: 1234567890

* 复制表 CREATE TABLE XXXX AS SELECT
      CREATE TABLE XXXX_temp AS SELECT * FROM XXXX;

      - 相同名称，相同数据类型定义
      - 选择特定的列，select子句需要列出列

* 内存表 CACHE TABLE
      cache table xxxx_cache as select * from table_a;
      uncache table xxxx_cache;(该操作仅仅将内存释放，并没有将cache操作的转换过程删除掉，因而uncache之后可以再次查询到结果;可以使用drop table xxxx_cache操作替代。参考RDD的 transform 与 action 的工作原理.)

## 2.3 Python模块

## 2.4 java模块

## 2.5 shell模块
### 2.5.1 获取进程号
    #!/bin/bash
    echo "PID OF THIS SCRIPT: $$"
    echo "PPID OF THIS SCRIPT: $PPID"
    echo "UID OF THIS SCRIPT: $UID"

### 2.5.2 通配符
    * 匹配0或多个字符 	 a*b  a与b之间可以有任意长度的任意字符, 也可以一个也没有, 如aabcb, a01b, ab等
    ? 匹配任意一个字符 	 a?b  a与b之间有且只有一个字符, 可以是任意字符, 如aab, adb, a0b等
    [list] 	 匹配list中的任意单一字符 	 a[xyz]b  a与b之间有且只有一个字符, 且只能是x或y或z, 如: axb, ayb, azb。
    [!list] 	 匹配除list中的任意单一字符 	 a[!0-9]b  a与b之间有且只有一个字符, 但不能是数字, 如axb, aab, a-b等
    [c1-c2] 	 匹配c1-c2中的任意单一字符 	 a[0-9]b  a与b之间有且只有一个字符，该字符是0-9之间的数字，如a0b, a1b，... ，a9b。
    {string1,string2,...} 	 匹配 sring1 或 string2 (或更多)其一字符串 	 a{abc,xyz,123}b    a与b之间只能是abc或xyz或123这三个字符串之一。

### 2.5.1 文件操作

* :> test.txt (清空文件内容)
* 文件合并操作
      for i in *.csv ; do cat "$i" >> res.csv  ;done (合并所有csv文件 到 res.csv)
      cat test1.csv test2.csv > test.csv (合并test1.csv 与 test2.csv)
      find . -name "*.csv" -type f -exec cat {} + > result
* 替换文件中的字符
      ll ./*/*.zip |awk '{print $10}' >> FileList.csv |sed -i 's/*//g' FileList.csv

* 解压ZIP文件到相同目录
      ls -d ./* | xargs -I {} unzip -P SOPinU {}/*.zip -d {}/

## 2.6 C/C++语言
### 2.6.1 移位操作

    逻辑左移=算术左移，右边统一添0
    逻辑右移，左边统一添0
    算术右移，左边添加的数和符号有关

    e.g: 1010101010，其中[]是添加的位
    逻辑左移一位：010101010[0]
    算术左移一位：010101010[0]
    逻辑右移一位：[0]101010101
    算术右移一位：[1]101010101


---

# ___大数据模块___

> Spark  Sybase  GBase  HBase

## 3.1 Spark模块
### 3.1.1 Spark计算模型
#### 3.1.1.1 Spark算子

> RDD(弹性分布式数据集)是Spark中的抽象数据结构类型，任何数据在Spark中都被表示为RDD.
从编程角度来看，RDD可以简单看成一个数组；
与普通数组的区别是，RDD中的数据是分区存储的，能够并行处理RDD.
RDD计算操作算子：Transformation(变换) 与 Action(行动)

> RDD对象实质上是一个元数据结构，存储着Block、Node等的映射关系，以及其他的元数据信息。
一个RDD就是一组分区，在物理数据存储上，RDD的每个分区对应的就是一个Block，Block可以存储在内存，当内存不够时可以存储到磁盘上
<div align="center">![算子与数据空间](resources\rdd.png) <br><br> ![RDD数据管理模型](resources\rdd_data_manage_model.png)</div>

    每一个运行在cluster上的spark应用程序，是由一个运行main函数的driver program和运行多种并行操作的executes组成

    其中spark的核心是弹性分布式数据集（Resilient Distributed Dataset—RDD）

    Resilient（弹性）：易变化、易计算

    Distributed（分布式）：可横跨多台机器，集群分布

    Dataset（数据集）：大批量数据的集合

    RDD基本概念

    RDD是逻辑集中的实体，代表一个分区的只读数据集，不可发生改变

    【RDD的重要内部属性】

    分区列表(partitions)
    对于一个RDD而言，分区的多少涉及对这个RDD并行计算的粒度，每一个RDD分区的计算都会在一个单独的任务中执行，每一个分区对应一个Task，分区后的数据存放在内存当中

    计算每个分区的函数(compute)
    对于Spark中每个RDD都是以分区进行计算的，并且每个分区的compute函数是在对迭代器进行复合操作，不需要每次计算，直到提交动作触发才会将之前所有的迭代操作进行计算，lineage在容错中有重要作用

    对父级RDD的依赖(dependencies)
    由于RDD存在转换关系，所以新生成的RDD对上一个RDD有依赖关系，RDD之间通过lineage产生依赖关系

    【窄依赖】
    每一个父RDD的分区最多只被子RDD的一个分区所使用，可以类似于流水线一样，计算所有父RDD的分区；在节点计算失败的恢复上也更有效，可以直接计算其父RDD的分区，还可以进行并行计算

    子RDD的每个分区依赖于常数个父分区（即与数据规模无关）
    输入输出一对一的算子，且结果RDD的分区结构不变，主要是map、flatmap
    输入输出一对一，但结果RDD的分区结构发生了变化，如union、coalesce
    从输入中选择部分元素的算子，如filter、distinct、subtract、sample

    【宽依赖】
    多个子RDD的分区会依赖于同一个父RDD的分区，需要取得其父RDD的所有分区数据进行计算，而一个节点的计算失败，将会导致其父RDD上多个分区重新计算

    子RDD的每个分区依赖于所有父RDD分区
    对单个RDD基于key进行重组和reduce，如groupByKey、reduceByKey
    对两个RDD基于key进行jion和重组，如jion

    对key-value数据类型RDD的分区器，控制分区策略和分区数(partitioner)
    partitioner就是RDD的分区函数，即HashPartitioner（哈希分区）和RangePartitioner（区域分区），分区函数决定了每个RDD的分区策略和分区数，并且这个函数只在(k-v)类型的RDD中存在，在非(k-v)结构的RDD中是None

    每个数据分区的地址列表(preferredLocations)
    与Spark中的调度相关，返回的是此RDD的每个partition所出储存的位置，按照“移动数据不如移动计算”的理念，在spark进行任务调度的时候，尽可能将任务分配到数据块所存储的位置

    控制操作（control operation）
    spark中对RDD的持久化操作是很重要的，可以将RDD存放在不同的存储介质中，方便后续的操作可以重复使用。

    主要有cache、persist、checkpoint，checkpoint接口是将RDD持久化到HDFS中，与persist的区别是checkpoint会切断此RDD之前的依赖关系，而persist会保留依赖关系。checkpoint的两大作用：一是spark程序长期驻留，过长的依赖会占用很多的系统资源，定期checkpoint可以有效的节省资源；二是维护过长的依赖关系可能会出现问题，一旦spark程序运行失败，RDD的容错成本会很高

> 算子分类. 大致可以分为三大类算子:
1. Value数据类型的Transformation算子，这种变换并不触发提交作业，针对处理的数据项是Value型的数据。
2. Key-Value数据类型的Transfromation算子，这种变换并不触发提交作业，针对处理的数据项是Key-Value型的数据对。
3. Action算子，这类算子会触发SparkContext提交Job作业。

* map
      scala> val c = sc.textFile("READMD.md") //从文件读取数据，创建RDD
      res0: Array[String] = Array("HUANG ", ZHANG, WALLACE, HUANG, HUANG, BELL, Eily, BELL)
      scala> c.map(word => (word,1)).collect
      res1: Array[(String, Int)] = Array(("HUANG ",1), (ZHANG,1), (WALLACE,1), (HUANG,1), (HUANG,1), (BELL,1), (Eily,1), (BELL,1))
      scala> c.map(word => (word,1)).reduceByKey((a,b)=> a+b).collect
      res3: Array[(String, Int)] = Array((ZHANG,1), (WALLACE,1), (HUANG,2), (BELL,2), ("HUANG ",1), (Eily,1))

* mapPartitions (map的一个变种，将每个partition中的内容作为整体进行处理)
      scala> val a1= sc.parallelize(1 to 9,3) //创建RDD，3个分区
      a1: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[30] at parallelize at <console>:21
      scala> a1.collect
      res0: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
      scala> def myfunc[T](iter: Iterator[T]) : Iterator[(T, T)] = {
      var res = List[(T, T)]()
      var pre = iter.next
      while (iter.hasNext) {
      val cur = iter.next
      res .::= (pre, cur)
      pre = cur
      }
      res.iterator
      }
      myfunc: [T](iter: Iterator[T])Iterator[(T, T)]
      scala> a1.mapPartitions(myfunc).collect
      res1: Array[(Int, Int)] = Array((2,3), (1,2), (5,6), (4,5), (8,9), (7,8))

* mapValues

      scala> val v = sc.parallelize(List("dog", "tiger", "lion", "cat", "panther", " eagle"), 2) //创建RDD
      v: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[33] at parallelize at <console>:21
      scala> v.collect
      res0: Array[String] = Array(dog, tiger, lion, cat, panther, " eagle")
      scala> val vv = v.map(x => (x.length,x))   //RDD：(K , V)
      vv: org.apache.spark.rdd.RDD[(Int, String)] = MapPartitionsRDD[34] at map at <console>:23
      scala> vv.collect
      res1: Array[(Int, String)] = Array((3,dog), (5,tiger), (4,lion), (3,cat), (7,panther), (6," eagle"))
      scala> vv.mapValues("x" + _ + "x").collect
      res42: Array[(Int, String)] = Array((3,xdogx), (5,xtigerx), (4,xlionx), (3,xcatx), (7,xpantherx), (6,x eaglex))

* mapWith

      def mapWith[A: ClassTag, U: ](constructA: Int => A, preservesPartitioning: Boolean = false)(f: (T, A) => U): RDD[U]
      第一个函数constructA是把RDD的partition index(index >= 0)作为输入,输出为新类型A;
      第二个函数f是把二元组(T,A)作为输入(其中T为原RDD中的元素,A是第一个函数的输出),输出类型为U。

      scala> val x = sc.parallelize(List(1,2,3,4,5,6,7,8,9,10),3)
      res0: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      scala> x.mapWith(a => a * 10)((a,b)=> (b + 2 ) ).collect
      res1: Array[Int] = Array(2, 2, 2, 12, 12, 12, 22, 22, 22, 22)

      获取RDD中各元素的partition index，输出(k,v)对
      scala> x.mapWith(a => a)((t,a)=> (t,a) ).collect
      res2: Array[(Int, Int)] = Array((1,0), (2,0), (3,0), (4,1), (5,1), (6,1), (7,2), (8,2), (9,2), (10,2))


* flatMap

      与map类似,区别是原RDD中的元素经map处理之后只能生成一个元素,经flatMap处理之后可生成多个元素来构建新RDD.

      scala> val a =sc.parallelize(1 to 4 ,2)
      a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[46] at parallelize at <console>:21
      scala> val b = a.flatMap(x => 1 to x)
      b: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[47] at flatMap at <console>:25
      scala> b.collect
      res0: Array[Int] = Array(1, 1, 2, 1, 2, 3, 1, 2, 3, 4)

      //scala flatMap
      val a = Array(Array("a", "1$2$3"), Array("b", "4$5$6"), Array("c", "6$7$8"))
      a.flatMap {
      x =>
      val normalPart = x(0)
      val atemp: Array[String] = x.last.split("\\$").map {
      y =>
      s"$normalPart,$y"
      }
      atemp
      }


* flatMapWith

      def flatMapWith[A: ClassTag, U: ClassTag](constructA: Int => A, preservesPartitioning: Boolean = false)(f: (T, A) => Seq[U]): RDD[U]
      与mapWith类似.

      scala> val a = sc.parallelize(List(1,2,3,4,5,6,7,8,9),3)
      a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[48] at parallelize at <console>:21
      scala> a.flatMapWith(x => x,true)((x,y) => List(y,x)).collect
      res0: Array[Int] = Array(0, 1, 0, 2, 0, 3, 1, 4, 1, 5, 1, 6, 2, 7, 2, 8, 2, 9)

* flatMapValues

      flatMapValues类似于mapValues，不同的在于flatMapValues应用于元素为KV对的RDD中Value.

      scala> val a= sc.parallelize(List((1,2),(3,4),(5,6)))
      a: org.apache.spark.rdd.RDD[(Int, Int)] = ParallelCollectionRDD[58] at parallelize at <console>:21
      scala> a.collect
      res0: Array[(Int, Int)] = Array((1,2), (3,4), (5,6))
      scala> val b = a.flatMapValues(x => x.to(5)).collect
      b: Array[(Int, Int)] = Array((1,2), (1,3), (1,4), (1,5), (3,4), (3,5))

* reduce

      reduce将RDD中元素两两传递给输入函数,同时产生一个新值,新值与RDD中下一个元素再被传递给输入函数直到最后只有一个值为止.

      scala> val c = sc.parallelize(1 to 10)
      c: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[60] at parallelize at <console>:21
      scala> c.collect
      res0: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      scala> c.reduce((x,y) => x + y)
      res1: Int = 55
      scala> c.reduce(_ + _)
      res2: Int = 55

* reduceByKey

      reduceByKey就是对元素为KV对的RDD中Key相同的元素的Value进行reduce
      因此，Key相同的多个元素的值被reduce为一个值，然后与原RDD中的Key组成一个新的KV对.

      scala> val a = sc.parallelize(List(("A",2),("B",1),("C",3),("A",4)))
      a: org.apache.spark.rdd.RDD[(String, Int)] = ParallelCollectionRDD[62] at parallelize at <console>:21
      scala> a.collect
      res0: Array[(String, Int)] = Array((A,2), (B,1), (C,3), (A,4))
      scala> a.reduceByKey((x,y) => x + y).collect
      res1: Array[(String, Int)] = Array((B,1), (C,3), (A,6))
      scala> a.reduceByKey(_ + _).collect
      res2: Array[(String, Int)] = Array((B,1), (C,3), (A,6))

* combineByKey

* glom

      scala> val a =sc.parallelize(1 to 4 ,2)
      a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[56] at parallelize at <console>:21
      scala> a.glom.collect
      res0: Array[Array[Int]] = Array(Array(1, 2), Array(3, 4))

* union

      使用union函数时需要保证两个RDD元素的数据类型相同，并且保存所有元素.

      scala> val a = sc.parallelize(1 to 4,2)
      a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[72] at parallelize at <console>:21
      scala> val b = sc.parallelize(5 to 10,2)
      b: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[73] at parallelize at <console>:21
      res0: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

* filter

      scala> val b = sc.parallelize(List("wallace","Huang","Alisa","James"),2)
      b: org.apache.spark.rdd.RDD[String] = ParallelCollectionRDD[17] at parallelize at <console>:21
      scala> b.collect
      res0: Array[String] = Array(wallace, Huang, Alisa, James)
      scala> b.filter( _.contains("wallace")).collect
      res1: Array[String] = Array(wallace)
      scala> b.filter( line => line.contains("ace")).collect
      res2: Array[String] = Array(wallace)

* cartesian

      cartesian算子：对两个RDD内的所有元素进行笛卡尔积操作

      scala> val x = sc.parallelize(1 to 3, 2)
      x: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[40] at parallelize at <console>:22\
      scala> x.mapWith(a => a)((t,a)=> (t,a) ).collect
      res0: Array[(Int, Int)] = Array((1,0), (2,1), (3,1)) //获取partition index
      scala> val y = sc.parallelize(5 to 7,2)
      y: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[41] at parallelize at <console>:22
      scala> y.mapWith(a => a)((t,a)=> (t,a) ).collect
      res1: Array[(Int, Int)] = Array((5,0), (6,1), (7,1)) //获取partition index
      scala> x.cartesian(y).collect
      res3: Array[(Int, Int)] = Array((1,5), (1,6), (1,7), (2,5), (3,5), (2,6), (2,7), (3,6), (3,7))
      scala> x.cartesian(y).mapWith(a => a)((t,a)=> (t,a) ).collect
      res4: Array[((Int, Int), Int)] = Array(((1,5),0), ((1,6),1), ((1,7),1), ((2,5),2), ((3,5),2), ((2,6),3), ((2,7),3), ((3,6),3), ((3,7),3))  //获取partition index

* groupByKey

      groupBy:将元素通过函数生成相应的Key,数据就转化为Key-Value格式,之后将Key相同的元素分为一组.

      scala> val pets = sc.parallelize(List(("cat",2),("dog",3),("cat",1)))
      res0: Array[(String, Int)] = Array((cat,2), (dog,3), (cat,1))
      scala> pets.groupByKey()
      res1: org.apache.spark.rdd.RDD[(String, Iterable[Int])] = ShuffledRDD[88] at groupByKey at <console>:25
      scala> pets.groupByKey().collect
      res2: Array[(String, Iterable[Int])] = Array((cat,CompactBuffer(2, 1)), (dog,CompactBuffer(3)))

      DataFrame中 groupBy操作
      scala> val df = sqlContext.jsonFile("/user/mr/test.json")  //本地新建一个json文件，推送到HDFS
      df: org.apache.spark.sql.DataFrame = [age: bigint, name: string]
      scala> df.printSchema()   //输出表结构
      root
      |-- age: long (nullable = true)
      |-- name: string (nullable = true)
      scala> df.filter(df("age")> 21 ).select("name").show()        
      +-------+
      |   name|
      +-------+
      |   Andy|
      |Wallace|
      |  Huang|
      +-------+
      scala> df.groupBy("age").count().show()    
      +----+-----+
      | age|count|
      +----+-----+
      |null|    1|
      |  19|    1|
      |  24|    1|
      |  25|    1|
      |  30|    1|
      +----+-----+
      //将DataFrame对象注册为一个临时表，然后用sql语句查询。
      scala> df.registerTempTable("people")
      scala> sqlContext.sql("select age,count(*) from people group by age").show()

* distinct

      distinct将RDD中的元素进行去重操作.

      scala> val a = sc.parallelize(List(1,1,1,2,3,4,5,6,6))
      a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[111] at parallelize at <console>:22
      scala> a.distinct
      res0: org.apache.spark.rdd.RDD[Int] = MapPartitionsRDD[114] at distinct at <console>:25
      scala> a.distinct.collect
      res1: Array[Int] = Array(6, 1, 2, 3, 4, 5)

* subtract

      subtract相当于进行集合的差操作,RDD1去除RDD1和RDD2交集中的所有元素.

* sample

      sample将RDD集合内的元素进行采样，获取所有元素的子集.用户可以选择采样方式:抽样、百分比、随机种子.

* taskSample

      与sample是相同原理，区别在于采样方式是按设定的采样个数进行采样，输出结果不再是RDD,而是对采样后的数据进行collect().

* cache

      cache将RDD元素从磁盘缓存到内存.

      scala> val a =sc.parallelize(1 to 4,2)
      a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[124] at parallelize at <console>:22
      scala> a.cache
      res0: a.type = ParallelCollectionRDD[124] at parallelize at <console>:22

* persist

      persist函数对RDD进行缓存操作.

      scala> val a =sc.parallelize(1 to 4,2)
      a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[124] at parallelize at <console>:22
      scala> a.persist
      res0: a.type = ParallelCollectionRDD[124] at parallelize at <console>:22

* partitionBy

      partitionBy函数对RDD进行分区操作

      scala> var rdd1 = sc.makeRDD(Array((1,"A"),(2,"B"),(3,"C"),(4,"D")),2)
      rdd1: org.apache.spark.rdd.RDD[(Int, String)] = ParallelCollectionRDD[7] at makeRDD at <console>:21
      scala> var rdd2 = rdd1.partitionBy(new org.apache.spark.HashPartitioner(2))
      rdd2: org.apache.spark.rdd.RDD[(Int, String)] = ShuffledRDD[8] at partitionBy at <console>:23
      scala> rdd2.collectAsMap()
      res3: scala.collection.Map[Int,String] = Map(2 -> B, 4 -> D, 1 -> A, 3 -> C)

* join(????)、leftOutJoin、rightOutJoin

      join 对两个RDD中拥有相同Key的元素,进行连接操作

      scala> val pets = sc.parallelize(List(("cat",2),("dog",3),("cat",1)))
      scala> val pets1 = sc.parallelize(List(("cat",2),("flower",3),("snake",1)))
      scala> pets.join(pets1)
      res0: Array[(String, (Int, Int))] = Array((cat,(1,2)), (cat,(2,2)))

* foreach

      RDD中每个函数都应f函数操作，返回Unit

* saveAsTextFile

      存储到HDFS指定目录
      scala> val a = sc.parallelize(0 to 10,3)
      scala> a.saveAsTextFile("/walllace")

* saveAsObjectFile

      scala> val a = sc.parallelize(0 to 100, 5)
      scala> a.saveAsObjectFile("/wallace")    //写入HDFS为sequenceFile的格式

* collect

      scala> val a = sc.parallelize(0 to 100, 5)
      a: org.apache.spark.rdd.RDD[Int] = ParallelCollectionRDD[5] at parallelize at <console>:21
      scala> a.collect
      res0: Array[Int] = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
      20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
      43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65,
      66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88,
      89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100)      

* collectAsMap

      对(k,v)型的RDD数据返回一个单机hashMap.
      scala> var rdd1 = sc.makeRDD(Array((1,"A"),(2,"B"),(3,"C"),(4,"D")),2)
      rdd0: org.apache.spark.rdd.RDD[(Int, String)] = ParallelCollectionRDD[6] at makeRDD at <console>:21
      scala> rdd1.collectAsMap()
      res1: scala.collection.Map[Int,String] = Map(2 -> B, 4 -> D, 1 -> A, 3 -> C)    

* reduceByKeyLocally

      实现功能: 先reduceByKey,再进行 collectAsMap 操作

      scala> var rdd1 = sc.makeRDD(Array(("A",1),("B",2),("C",3),("D",4),("A",10)),2)
      rdd1: org.apache.spark.rdd.RDD[(String, Int)] = ParallelCollectionRDD[7] at makeRDD at <console>:21
      scala> rdd1.reduceByKeyLocally(_+_)
      res0: scala.collection.Map[String,Int] = Map(D -> 4, A -> 11, B -> 2, C -> 3)

* lookup(??????)



* count

      scala> var rdd1 = sc.makeRDD(Array(("A",1),("B",2),("C",3),("D",4),2))
      rdd1: org.apache.spark.rdd.RDD[Any] = ParallelCollectionRDD[9] at makeRDD at <console>:21
      scala> rdd1.count()
      res0: Long = 4
* top

      top 可返回最大的K个元素
      scala> var rdd1 = sc.makeRDD(Array((1,"A"),(2,"B"),(3,"C"),(4,"D")),2)
      rdd1: org.apache.spark.rdd.RDD[Any] = ParallelCollectionRDD[9] at makeRDD at <console>:21
      scala> rdd1.top(1)
      res0: Array[(Int, String)] = Array((4,D))
      scala> rdd1.take(2)
      res5: Array[(Int, String)] = Array((1,A), (2,B))
      scala> rdd1.takeOrdered(2)
      res6: Array[(Int, String)] = Array((1,A), (2,B))

* reduce (????)

      scala> var rdd1 = sc.makeRDD(Array(("A",1),("B",2),("C",3),("D",4),2))
      rdd1: org.apache.spark.rdd.RDD[Any] = ParallelCollectionRDD[9] at makeRDD at <console>:21


* fold

* aggregate


#### 3.1.1.2 Scala on Spark

* 获取主题表所有 column 字段
      scala> val table = sqlContext.sql("desc Legend").collect
      table: Array[org.apache.spark.sql.Row] = Array([day,timestamp,null], [id,int,null], [name,string,null], [age,int,null], [phone,double,null], [others,string,null], [p_info,string,null],
      [p_date,int,null], [# Partition Information,,], [# col_name,data_type,comment], [p_info,string,null], [p_date,int,null])
      sscala> val columns = table.filter(x => {
      | val y = x.mkString
      | y.endsWith("null") && !y.startsWith("p_")})
      columns: Array[org.apache.spark.sql.Row] = Array([day,timestamp,null], [id,int,null], [name,string,null], [age,int,null], [phone,double,null], [others,string,null])
      scala> columns.map(x=>x(0).toString).toList
      res0: List[String] = List(day, id, name, age, phone, others)

      scala> val a = sqlContext.sql("desc Legend").collect.toList //描述主题表的结构信息
      scala> val b = sc.parallelize(a.map(x => x(0).toString).toList, 1).saveAsTextFile("/chuanqi_tmp/Legend")  //保存主题表的结构信息

      hadoop fs -getmerge /chuanqi_tmp/Legend/test/* /home/mr/chuanqi/Legend.txt  //从HDFS上下载文件到本地路径/home/mr/chuanqi

      def extractFieldNameFrom(hc: HiveContext, tableName: String, log:Logger): List[String] = {
      val sqlText = s"desc $tableName"
      val fieldNames: Try[List[String]] = Try {
      val fieldInfo = hc.sql(sqlText).collect.filter(x => {
      val fieldNameRow = x.mkString
      fieldNameRow.endsWith("null") && !fieldNameRow.startsWith("p_")
      }
      )
      fieldInfo.map(x => x(0).toString).toList
      }

      fieldNames match {
      case Success(result) =>
      result
      case Failure(e) =>
      log.info(s"Extract field name from table $tableName throw exception: " + e.getMessage)
      List()
      }
      }


### 3.1.2 Spark组件

#### 3.1.2.1 Spark Streaming  + Kafka

>集群资源信息: CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181

* 创建Topic
      /home/mr/kafka/bin/kafka-topics.sh --create --topic broker1_rep1_parti20 --zookeeper CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --replication-factor 1 --partitions 20

* 列出所有Topic
      /home/mr/kafka/bin/kafka-topics.sh --list --zookeeper  CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181

* 查看Topic详情
      /home/mr/kafka/bin/kafka-topics.sh --describe --zookeeper CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --topic broker1_rep1_parti20

* kafka生产命令行
      /home/mr/kafka/bin/kafka-console-producer.sh --broker-list CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --topic broker1_rep1_parti20

* kafka消费命令行
      /home/mr/kafka/bin/kafka-console-consumer.sh --zookeeper  CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --topic broker1_rep1_parti20

* kafka删除Topic
      /home/mr/kafka/bin/kafka-topics.sh --delete --zookeeper CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --topic broker1_rep1_parti20

* 启动kafka服务
      /home/mr/kafka/bin/kafka-server-start.sh config/server.properties

#### 3.1.2.2 Spark Steaming 窗口操作
<table align="center" class="table table-bordered table-condensed">
<tr>
<th align="center" colspan="1">Transformation</th>
<td>Meaning</td>
</tr>
<tr>
<td>window(windowLength, slideInterval)</td>
<td>Return a new DStream which is computed based on windowed batches of the source DStream.</td>
</tr>
<tr>
<td>countByWindow(windowLength,slideInterval)</td>
<td>Return a sliding window count of elements in the stream.</td>
</tr>
<tr>
<td>reduceByWindow(func, windowLength,slideInterval)</td>
<td>Return a new single-element stream, created by aggregating elements in the stream over a sliding interval using func.
The function should be associative so that it can be computed correctly in parallel.</td>
</tr>
<tr>
<td>reduceByKeyAndWindow(func,windowLength, slideInterval, [numTasks])</td>
<td>When called on a DStream of (K, V) pairs, returns a new DStream of  (K, V) pairs where the values for each key are aggregated using the  given reduce function func over batches in a sliding window.
Note: By default, this uses Spark's default number of parallel tasks (2 for local machine, 8 for a cluster) to do the grouping. You can pass an optional numTasks argument to set a different number of tasks.</td>
</tr>
<tr>
<td>reduceByKeyAndWindow(func, invFunc,windowLength, slideInterval, [numTasks])</td>
<td>A more efficient version of the above reduceByKeyAndWindow() where the reduce value of each window is calculated incrementally using the reduce values of the previous window.
This is done by reducing the new data that enter the sliding window, and "inverse reducing" the old data that leave the window. An example would be that of "adding" and "subtracting" counts of keys as the window slides.
However, it is applicable to only "invertible reduce functions", that is, those reduce functions which have a corresponding "inverse reduce" function (taken as parameterinvFunc. Like in reduceByKeyAndWindow, the number of reduce tasks is configurable through an optional argument.</td>
</tr>
<tr>
<td>countByValueAndWindow(windowLength,slideInterval, [numTasks])</td>	<td>When called on a DStream of (K, V) pairs, returns a new DStream of (K, Long) pairs where the value of each key is its frequency within a sliding window. Like in reduceByKeyAndWindow, the number of reduce tasks is configurable through an optional argument.</td>
</tr>
<tr>
<th align="center" colspan="1">Output Operation</th>
<td>Meaning</td>
</tr>
<tr>
<td>print()</td>
<td>Prints first ten elements of every batch of data in a DStream on the driver.</td>
</tr>
<tr>
<td>foreachRDD(func)</td>
<td>The fundamental output operator. Applies a function, func, to each RDD generated from the stream. This function should have side effects, such as printing output, saving the RDD to external files, or writing it over the network to an external system.</td>
</tr>
<tr>
<td>saveAsObjectFiles(prefix, [suffix])</td>
<td>Save this DStream's contents as a SequenceFile of serialized objects. The file name at each batch interval is generated based on prefix and suffix: "prefix-TIME_IN_MS[.suffix]".</td>
</tr>
<tr>
<td>saveAsTextFiles(prefix, [suffix])</td>
<td>Save this DStream's contents as a text files. The file name at each batch interval is generated based on prefix and suffix: "prefix-TIME_IN_MS[.suffix]".</td>
</tr>
<tr>
<td>saveAsHadoopFiles(prefix, [suffix])</td>
<td>Save this DStream's contents as a Hadoop file. The file name at each batch interval is generated based on prefix and suffix: "prefix-TIME_IN_MS[.suffix]".</td>
</tr>
</table>

### 3.1.3 Spark性能调优
#### 3.1.3.1 Spark参数配置
    keyParameters = [
    //"spark.serializer,org.apache.spark.serializer.KryoSerializer",
    "spark.executor.cores,12",
    "spark.kryoserializer.buffer,512",
    "spark.driver.extraJavaOptions,-Xss32m",
    "spark.driver.maxResultSize,3g",
    "spark.eventLog.enabled,false",
    "spark.shuffle.consolidateFiles,true",
    "spark.rdd.compress,true",
    "spark.io.compression.codec,lzf",
    "spark.ui.port,0",
    "spark.cores.max,36",
    "spark.executor.memory,12g",
    "spark.sql.shuffle.partitions,24",
    "spark.locality.wait,100",
    "spark.default.parallelism,90",
    //    "spark.streaming.receiver.maxRate,6000",
    "spark.streaming.kafka.maxRatePerPartition,3000",
    "spark.shuffle.spill,false"
    ]

* spark.num.executors
      参数说明：该参数用于设置Spark作业总共要用多少个Executor进程来执行。Driver在向YARN集群管理器申请资源时，YARN集群管理器会尽可能按照你的设置来在集群的各个工作节点上，启动相应数量的Executor进程。这个参数非常之重要，如果不设置的话，默认只会给你启动少量的Executor进程，此时你的Spark作业的运行速度是非常慢的

* spark.executor.cores
      参数说明：该参数用于设置每个Executor进程的CPUcore数量。这个参数决定了每个Executor进程并行执行task线程的能力。因为每个CPUcore同一时间只能执行一个task线程，因此每个Executor进程的CPUcore数量越多，越能够快速地执行完分配给自己的所有task线程
      spark.cores.max(36) = spark.executor.cores(12) * spark.num.executors(自动默认分配 3)

* spark.driver.maxResultSize
      参数说明：该参数用于设置Driver进程的内存。参数调优建议：Driver的内存通常来说不设置，或者设置1G左右应该就够了。唯一需要注意的一点是，如果需要使用collect算子将RDD的数据全部拉取到Driver上进行处理，那么必须确保Driver的内存足够大，否则会出现OOM内存溢出的问题。
      eg:九江定位和道路修正读入大量参数，尝试增大driver 内存

* spark.default.parallelism
      参数说明：该参数用于设置每个stage的默认task数量。这个参数极为重要，如果不设置可能会直接影响你的Spark作业性能。
      Spark作业的默认task数量为500~1000个较为合适。很多同学常犯的一个错误就是不去设置这个参数，那么此时就会导致Spark自己根据底层HDFS的block数量来设置task的数量，默认是一个HDFS block对应一个task。

* spark.streaming.concurrentJobs
      参数说明：jobExecutor 的线程池大小，是由 spark.streaming.concurrentJobs 参数来控制的，当没有显式设置时，其取值为 1

#### 3.1.3.2 GC调优
* GC算法原理
      传统JVM内存管理中，将HEAP空间分为Young/Old两个分区,Young分区所括一个Eden和两个Survivor分区，如图所示;
      新产生的对象首先会被存在Eden分区,而每次minor GC发生，JVM一方面将Eden分区内存活的对象拷贝到一个空的Survivor分区，另一方面将另一个正在被使用的Survivor分区中的存活对象也拷贝到空的Survivor分区内;
      在此过程中，JVM始终保持一个Survivor分区处于全空的状态。一个对象在两个Survivor之间的拷贝到一定次数后，如果还是存活的，就将其拷入Old分区。当Old分区没有足够空间时，GC会停下所有程序线程，进行Full GC，即对Old区中的对象进行整理。
      这个所有线程都暂停的阶段被称为Stop-The-World(STW)，也是大多数GC算法中对性能影响最大的部分。
<div align="center">![分年代的Heap结构](resources\heap_struct.jpg)</div>

### 3.1.4 Spark工作机制
#### 3.1.4.1 Spark 执行机制
* TaskSetManager 的有效 Locality Levels: PROCESS_LOCAL、NODE_LOCAL、NO_PREF、RACK_LOCAL、ANY.
这几个值代表 task 的计算节点和 task 的输入数据的节点位置关系:
  1. PROCESS_LOCAL: 数据在同一个 JVM 中，即同一个 executor 上。这是最佳数据 locality。
  2. NODE_LOCAL: 数据在同一个节点上。比如数据在同一个节点的另一个 executor上；或在 HDFS 上，恰好有 block 在同一个节点上。速度比 PROCESS_LOCAL 稍慢，因为数据需要在不同进程之间传递
  3. NO_PREF: 数据从哪里访问都一样快，不需要位置优先
  4. RACK_LOCAL: 数据在同一机架的不同节点上。需要通过网络传输数据，比 NODE_LOCAL 慢
  5. ANY: 数据在非同一机架的网络上，速度最慢

## 3.2 Sybase模块

## 3.3 GBase模块

## 3.4 HBase模块

---
# ___无线产品业务专题___

> LTE  CDMA  UMTS  Pre5G

# 4.1 LTE业务模块

# 4.2 CDMA业务模块

---
# ___系统环境专题___

> Linux

## 5.1 Linux系统模块
### 5.1.1 系统相关操作
* 查看系统信息
  - cat /etc/fstab
  - df -T -h |  df  -T
  - parted   ，然后执行p（即print）
  - cat /proc/cpuinfo (打印CPU信息)
  - cat /proc/cpuinfo |grep "cores"|uniq (查看CPU是几核)
  - cat /proc/cpuinfo |grep "processor"|wc -l (查看逻辑CPU的个数)
  - cat /proc/cpuinfo |grep "physical id"|sort |uniq|wc -l  (查看物理CPU的个数)
  - lscpu (列出CPU信息)

* 进程操作
      ps -ef| grep xxx
      ps -a
      ps -e
      ps -A -o stat,ppid,pid,cmd | grep -e '^[Zz]' | awk '{print $2}' | xargs kill -9  (查找僵死进程,并杀死父进程)
      ps -ef | grep "nslookup" | awk '{print $2}' | xargs -t -i kill -9 {}  (kill全部检索出来的所有进程)
* 内存相关操作
      cat /proc/sys/vm/drop_caches
      手动执行sync命令(描述:sync 命令运行 sync 子例程。如果必须停止系统，则运行 sync 命令以确保文件系统的完整性。sync 命令将所有未写的系统缓冲区写到磁盘中，包含已修改的 i-node、已延迟的块 I/O 和读写映射文件)
* 系统监控
      vmstat -S M
      top #查看cpu利用率
      iostat -c -t 5
      iostat -x 1 10
      dstat
* IO实时监控
      iostat -d -k 2 #参数 -d 表示，显示设备（磁盘）使用状态；-k某些使用           block为单位的列强制使用Kilobytes为单位；2表示，数据显示每隔2秒刷新一次;
      iostat -x 2 #每隔2秒刷新一下磁盘使用状态
      iostat -d -k 1 10  #查看TPS和吞吐量信息(磁盘读写速度单位为KB)
      iostat -d -m 2     #查看TPS和吞吐量信息(磁盘读写速度单位为MB)
      iostat -d -x -k 1 10 #查看设备使用率（%util）、响应时间（await） iostat -c 1 10 #查看cpu状态

      dd生成指定大小的文件
      dd if=/home/10192057/temp_data/emsSimulator.zip of=/home/10192057/temp_data/temp.zip bs=1M count=1024 //测试磁盘读写速度
      dd if=/dev/zero of=/home/10192057/temp_data/temp_data bs=1M count=1024

* jstat命令详解(GC信息)
      jstat -gc pid 可以显示gc的信息，查看gc的次数，及时间
      jstat -gccapacity pid 可以显示，VM内存中三代（young,old,perm）对象的使用和占用大小
      jstat -gcutil pid  统计gc信息统计
      jstat -gcnew pid 年轻代对象的信息
      jstat -gcnewcapacity pid 年轻代对象的信息及其占用量
      jstat -gcold pid  old代对象的信息
      jstat -gcoldcapacity pid  old代对象的信息及其占用量
      jstat -gcpermcapacity pid perm对象的信息及其占用量
      jstat -class pid 显示加载class的数量，及所占空间等信息
      jstat -compiler pid 显示VM实时编译的数量等信息
      jstat -printcompilation pid 当前VM执行的信息

      一些术语的中文解释：
      S0C：年轻代中第一个survivor（幸存区）的容量 (字节)
      S1C：年轻代中第二个survivor（幸存区）的容量 (字节)
      S0U：年轻代中第一个survivor（幸存区）目前已使用空间 (字节)
      S1U：年轻代中第二个survivor（幸存区）目前已使用空间 (字节)
      EC：年轻代中Eden（伊甸园）的容量 (字节)
      EU：年轻代中Eden（伊甸园）目前已使用空间 (字节)
      OC：Old代的容量 (字节)
      OU：Old代目前已使用空间 (字节)
      PC：Perm(持久代)的容量 (字节)
      PU：Perm(持久代)目前已使用空间 (字节)
      YGC：从应用程序启动到采样时年轻代中gc次数
      YGCT：从应用程序启动到采样时年轻代中gc所用时间(s)
      FGC：从应用程序启动到采样时old代(全gc)gc次数
      FGCT：从应用程序启动到采样时old代(全gc)gc所用时间(s)
      GCT：从应用程序启动到采样时gc用的总时间(s)
      NGCMN：年轻代(young)中初始化(最小)的大小 (字节)
      NGCMX：年轻代(young)的最大容量 (字节)
      NGC：年轻代(young)中当前的容量 (字节)
      OGCMN：old代中初始化(最小)的大小 (字节)
      OGCMX：old代的最大容量 (字节)
      OGC：old代当前新生成的容量 (字节)
      PGCMN：perm代中初始化(最小)的大小 (字节)
      PGCMX：perm代的最大容量 (字节)   
      PGC：perm代当前新生成的容量 (字节)
      S0：年轻代中第一个survivor（幸存区）已使用的占当前容量百分比
      S1：年轻代中第二个survivor（幸存区）已使用的占当前容量百分比
      E：年轻代中Eden（伊甸园）已使用的占当前容量百分比
      O：old代已使用的占当前容量百分比
      P：perm代已使用的占当前容量百分比
      S0CMX：年轻代中第一个survivor（幸存区）的最大容量 (字节)
      S1CMX ：年轻代中第二个survivor（幸存区）的最大容量 (字节)
      ECMX：年轻代中Eden（伊甸园）的最大容量 (字节)
      DSS：当前需要survivor（幸存区）的容量 (字节)（Eden区已满）
      TT： 持有次数限制
      MTT ： 最大持有次数限制

* 系统定时任务管理
  - 查看定时任务
        crontab -l
  - 编辑定时任务
        crontab -e

* 命令行输入历史记录
      history
      history -c

* 系统时间与时区
      $ date +%F' '%T
      2016-07-05 09:59:32
      $ date -R
      Wed, 08 Feb 2017 10:26:24 +0800
      $ cat /etc/sysconfig/clock
      # The time zone of the system is defined by the contents of /etc/localtime.
      # This file is only for evaluation by system-config-date, do not rely on its
      # contents elsewhere.
      ZONE="Asia/Shanghai"
* 强制踢人命令格式
      pkill -kill -t tty
* 踢掉用终端登陆的用户
      ps -ef |grep pts/0
      kill -9 pid

### 5.1.2 文件操作命令
* 新建文件
      touch 文件名
* 修改文件名
      修改后缀名
      rename .txt .csv *
* scp文件传输命令
      scp -r LocalHostName:sourcePath remoteHostName:/targetPath
<table class="table table-bordered table-condensed">
<tr>
<td>参数</td>
<td>详细描述</td>
</tr>
<tr>
<td>-a</td>
<td>尽可能将档案状态、权限等资料都照原状予以复制</td>
</tr>
<tr>
<td>-r</td>
<td>若 source 中含有目录名，则将目录下之档案亦皆依序拷贝至目的地</td>
</tr>
<tr>
<td>-f</td>
<td>若目的地已经有相同档名的档案存在，则在复制前先予以删除再行复制</td>
</tr>
</table>
* cp文件拷贝命令
      cp -u sourcePath targetPath #只复制更新的文件
* sz / rz 上传下载文件命令(SecureCRT)
      下载文件：sz finename1 filename2
      上传文件：rz
* 常见解压命令
<table class="table table-bordered table-condensed">
<tr>
<td>格式</td>
<td>解压命令</td>
</tr>
<tr>
<td>.tar格式</td>
<td>tar -xvf xx.tar</td>
</tr>
<tr>
<td>.zip 格式</td>
<td>unzip xx.zip</td>
</tr>
<tr>
<td>.gz格式</td>
<td>gunzip xx.gz</td>
</tr>
<tr>
<td>.Z 格式</td>
<td>zcat  xx.Z  |  tar -xf</td>
</tr>
<tr>
<td>7z 格式</td>
<td> 7za x temp.7z -r -o./</td>
</tr>
</table>
<table class="table table-bordered table-condensed">
<tr>
<td>格式</td>
<td>压缩命令</td>
</tr>
<tr>
<td>.zip 格式</td>
<td>zip -r xx.zip targetPath/*<br/>zip -qj test.zip targetPath/* (-j参数: 不处理压缩文件中原有的目录路径)</td>
</tr>
<tr>
<td>.gz格式</td>
<td>gzip files</td>
</tr>
</table>

* 文件格式转换
      iconv -f GBK -t UTF-8 test.txt -o test.txt
      iconv -f UTF-8 -t GBK test.txt -o test.txt

      Input/Output format specification:
      -f, --from-code=NAME       encoding of original text
      -t, --to-code=NAME         encoding for output

      Information:
      -l, --list                 list all known coded character sets

      Output control:
      -c                         omit invalid characters from output
      -o, --output=FILE          output file
      -s, --silent               suppress warnings
      --verbose              print progress information

* wc(Word Count)命令
  - 命令参数：
        -c 统计字节数.
        -l 统计行数.
        -m 统计字符数,这个标志不能与 -c 标志一起使用.
        -w 统计字数,一个字被定义为由空白、跳格或换行字符分隔的字符串.
        -L 打印最长行的长度.
        -help 显示帮助信息.
        –version 显示版本信息.

* ls 命令
        只显示文件夹 ls -l | grep ^d
        只显示文件 ls -l | grep ^-
        查看文件夹个数 ls -l | grep ^d
        查看文件个数 ls -l | grep ^
        统计文件个数(包括子目录) ls -lR|grep "^-"|wc -l
        统计/home/han目录(包含子目录)下的所有js文件则: ls -lR /home/han|grep js|wc -l 或 ls -l "/home/han"|grep "js"|wc -l   


#### 5.1.3 HADOOP常用命令
* 列出目录及文件信息
      Hadoop fs –ls /home/......
* 删除某目录下的文件
      Hadoop fs –rm –r /lte/......
* 打印某目录下的文件
      Hadoop fs -cat /home/......
      Hadoop fs -tail -f /home/......
* 将本地目录下的文件推送到HDFS目录
      hadoop fs -put sourcePath targetPath
* 显示该目录中每个文件的大小
      hadoop fs -du PATH
      hadoop fs -du -s PATH
      hadoop fs -du -sh PATH
* 创建目录
      hadoop fs -mkdir newPath
* 复制文件
      hadoop fs -cp -f sourcePath targetPath
* 接受一个源目录和多个目标文件作为输入，并且将HDFS源目录中所有的文件连接成本地目标文件
      hadoop fs -getmerge sourcePath targetPath
* HDFS源目录下载文件到本地
      hadoop fs -get sourcePath targetPath

### 5.1.4 磁盘挂载
* 查看磁盘挂载信息
      df -h   
* 查看有没有空硬盘没挂载
      fdisk -l
* 磁盘自动分区
      fdisk /dev/sdb  
* 硬盘格式化(终端执行: partprobe)
      mkfs -t ext3 /dev/sdb1
      mkfs -t ext4 /dev/sda4
* 将分区挂载到 /mnt
      mount /dev/sdb /home/mnt
* 卸载挂载点
      umount /home/mnt
* 查看占用磁盘空间
      du -s
      du -sh
      du -h
      du --max-depth=1 -h  <--max-depth=N	显示目录总计(--all 一起使用计算文件)当N 为指定数值时计算深度为N；--max-depth=0 等于--summarize>

### 5.1.5 网络相关操作
* 查看某端口号的状态：netstat -tulnp |grep 端口号
* 根据端口列进程：netstat  -ntlp  |  grep 端口号
* 跟踪指定进程的PID：gdb -p pid
* 重启网络服务：service network restart
* route路由相关命令
  1. route 命令添加临时路由
    - route
    - route del default
    - route add default gw  10.9.234.1 (添加临时路由)
  2. 在/etc/rc.local里添加(设置永久路由)
    - 增加/删除路由表：
    route add -net 192.168.3.0/24 dev eth0
    route add -net 192.168.2.0/24 gw 192.168.2.254
    route del -net 192.168.1.1 netmask 192.168.1.1

    - 在/etc/sysconfig/network里添加到末尾
    方法：GATEWAY=gw-ip 或者 GATEWAY=gw-dev

    - /etc/sysconfig/static-routes : (没有static-routes的话就手动建立一个这样的文件)
    any net 192.168.3.0/24 gw 192.168.3.254
    any net 10.250.228.128 netmask 255.255.255.192 gw 10.250.228.129

    - 开启 IP 转发：
    echo "1" >/proc/sys/net/ipv4/ip_forward (临时)
    vi /etc/sysctl.conf --> net.ipv4.ip_forward=1 (永久开启)


* 配置IP地址
  - 修改网卡配置文件ifcfg-eth0
        vim /etc/sysconfig/network-scripts/ifcfg-eth0

  - 配置文件中的配置项
        ONBOOT=yes
        BOOTPROTO=static
        IPADDR=192.168.0.32
        GATEWAY=192.168.0.1
        DNS=192.168.1.9

  - 重启网络服务
        service NetworkManager restart
        service network restart

  - 测试网络
        ping网关
        pint外网

* ifconfig命令
  - 命令格式：
        ifconfig [网络设备] [参数]
  - 命令参数：
        up 启动指定网络设备/网卡。
        down 关闭指定网络设备/网卡。该参数可以有效地阻止通过指定接口的IP信息流，如果想永久地关闭一个接口，我们还需要从核心路由表中将该接口的路由信息全部删除。
        arp 设置指定网卡是否支持ARP协议。
        -promisc 设置是否支持网卡的promiscuous模式，如果选择此参数，网卡将接收网络中发给它所有的数据包
        -allmulti 设置是否支持多播模式，如果选择此参数，网卡将接收网络中所有的多播数据包
        -a 显示全部接口信息
        -s 显示摘要信息（类似于 netstat -i）
        add 给指定网卡配置IPv6地址
        del 删除指定网卡的IPv6地址
        <硬件地址> 配置网卡最大的传输单元
        mtu<字节数> 设置网卡的最大传输单元 (bytes)
        netmask<子网掩码> 设置网卡的子网掩码。掩码可以是有前缀0x的32位十六进制数，也可以是用点分开的4个十进制数。如果不打算将网络分成子网，可以不管这一选项；如果要使用子网，那么请记住，网络中每一个系统必须有相同子网掩码。
        tunel 建立隧道
        dstaddr 设定一个远端地址，建立点对点通信
        -broadcast<地址> 为指定网卡设置广播协议
        -pointtopoint<地址> 为网卡设置点对点通讯协议
        multicast 为网卡设置组播标志
        address 为网卡设置IPv4地址
        txqueuelen<长度> 为网卡设置传输列队的长度

### 5.1.6 用户/用户组 相关操作
* 添加新用户 / 删除用户
      useradd hadoop -m -d /home/hadoop;
      passwd hadoop  (设置密码);
      useradd -d /home/test test //增加用户test，并制定test用户的主目录为/home/test;
      passwd test //为test设置密码;
      userdel test //永久删除用户

* 添加组 / 删除组
      groupadd test //新建test工作组;
      useradd -g test phpq //新建phpq用户并增加到test工作组;
      usermod -G groupname username //给已有的用户增加工作组;
      gpasswd -d A GROUP //从GROUP组中删除用户A
      groupdel GROUP //永久删除GROUP组
      usermod –G GROUP GROUP //强制删除该用户的主目录和主目录下的所有文件和子目录

* 更改用户相应的权限设置：
      usermod -s /sbin/nologin test //限定用户test不能telnet，只能ftp;
      usermod -s /sbin/bash test //用户test恢复正常;
      usermod -d /test test //更改用户test的主目录为/test;
      usermod -s /usr/bin/passwd test //用户telnet后将直接进入改密界面;
      限制用户只能访问/home/test，不能访问其他路径{
        修改/etc/vsftpd/vsftpd.conf如下：
        chroot_list_enable=YES //限制访问自身目录
        # (default follows)
        chroot_list_file=/etc/vsftpd/vsftpd.chroot_list
        编辑 vsftpd.chroot_list文件，将受限制的用户添加进去，每个用户名一行
        改完配置文件，不要忘记重启vsFTPd服务器
        /etc/init.d/vsftpd restart
      };

* 显示用户信息
      id user
      cat /etc/passwd

### 5.1.7 shell脚本开发
* Shell浮点数比较大小
      value1=10.85
      value2=9.5
      if [ $(echo "$value1 < $value2"|bc) -eq 1 ];then
      res="较大的值为：$value2"
      else
      res="较大的值为：$value1"
      fi
* Shell脚本开发调试
      用法： set [--abefhkmnptuvxBCHP] [-o option] [arg ...]
      set -x
      set -e 这行代码之后的任何代码，如果返回一个非0的值，那么整个脚本立即退出
      set -o pipefail 告诉 bash 返回从右到左第一个以非0状态退出的管道命令的返回值，如果所有命令都成功执行时才返回0

      set指令能设置所使用shell的执行方式，可依照不同的需求来做设置
      -a 　标示已修改的变量，以供输出至环境变量。
      　 -b 　使被中止的后台程序立刻回报执行状态。
      　 -C 　转向所产生的文件无法覆盖已存在的文件。
      　 -d 　Shell预设会用杂凑表记忆使用过的指令，以加速指令的执行。使用-d参数可取消。
      　 -e 　若指令传回值不等于0，则立即退出shell。　　
      　 -f　 　取消使用通配符。
      　 -h 　自动记录函数的所在位置。
      　 -H Shell 　可利用"!"加<指令编号>的方式来执行history中记录的指令。
      　 -k 　指令所给的参数都会被视为此指令的环境变量。
      　 -l 　记录for循环的变量名称。
      　 -m 　使用监视模式。
      　 -n 　只读取指令，而不实际执行。
      　 -p 　启动优先顺序模式。
      　 -P 　启动-P参数后，执行指令时，会以实际的文件或目录来取代符号连接。
      　 -t 　执行完随后的指令，即退出shell。
      　 -u 　当执行时使用到未定义过的变量，则显示错误信息。
      　 -v 　显示shell所读取的输入值。
      　 -x 　执行指令后，会先显示该指令及所下的参数。
      　 +<参数> 　取消某个set曾启动的参数。

### 5.1.8 NBTSTAT命令详解

> 显示协议统计和当前使用 NBI 的 TCP/IP 连接
(在 TCP/IP 上的 NetBIOS)。

    NBTSTAT [ [-a RemoteName] [-A IP address] [-c] [-n]
    [-r] [-R] [-RR] [-s] [-S] [interval] ]

    -a   (适配器状态)    列出指定名称的远程机器的名称表
    -A   (适配器状态)    列出指定 IP 地址的远程机器的名称表。
    -c   (缓存)          列出远程[计算机]名称及其 IP 地址的 NBT 缓存
    -n   (名称)          列出本地 NetBIOS 名称。
    -r   (已解析)        列出通过广播和经由 WINS 解析的名称
    -R   (重新加载)      清除和重新加载远程缓存名称表
    -S   (会话)          列出具有目标 IP 地址的会话表
    -s   (会话)          列出将目标 IP 地址转换成计算机 NETBIOS 名称的会话表。
    -RR  (释放刷新)      将名称释放包发送到 WINS，然后启动刷新

    RemoteName   远程主机计算机名。
    IP address   用点分隔的十进制表示的 IP 地址。
    interval     重新显示选定的统计、每次显示之间暂停的间隔秒数。
    按 Ctrl+C 停止重新显示统计。

### 5.1.9 netstat命令详解
> netstat –s本选项能够按照各个协议分别显示其统计数据。如果我们的应用程序（如Web浏览器）运行速度比较慢，或者不能显示Web页之类的数据，那么我们就可以 用本选项来查看一下所显示的信息。我们需要仔细查看统计数据的各行，找到出错的关键字，进而确定问题所在。

  - netstat –e本选项用于显示关于以太网的统计数据。它列出的项目包括传送的数据报的总字节数、错误数、删除数、数据报的数量和广播的数量。这些统计数据既有发送的数据报数量，也有接收的数据报数量。这个选项可以用来统计一些基本的网络流量）。
  - netstat –r本选项可以显示关于路由表的信息，类似于后面所讲使用route print命令时看到的 信息。除了显示有效路由外，还显示当前有效的连接。
  - netstat –a本选项显示一个所有的有效连接信息列表，包括已建立的连接（ESTABLISHED），也包括监听连接请求（LISTENING）的那些连接。
  - netstat –n显示所有已建立的有效连接。

### 5.1.10 Sed 命令详解

> sed命令行格式为：
> sed [-nefri] ‘command’ 输入文本

  - 常用选项：
        -n∶使用安静(silent)模式。在一般 sed 的用法中，所有来自 STDIN的资料一般都会被列出到萤幕上。但如果加上 -n 参数后，则只有经过sed 特殊处理的那一行(或者动作)才会被列出来。
        -e∶直接在指令列模式上进行 sed 的动作编辑；
        -f∶直接将 sed 的动作写在一个档案内， -f filename 则可以执行 filename 内的sed 动作；
        -r∶sed 的动作支援的是延伸型正规表示法的语法。(预设是基础正规表示法语法)
        -i∶直接修改读取的档案内容，而不是由萤幕输出。    

  - 常用命令：
        a   ∶新增， a 的后面可以接字串，而这些字串会在新的一行出现(目前的下一行)～
        c   ∶取代， c 的后面可以接字串，这些字串可以取代 n1,n2 之间的行！
        d   ∶删除，因为是删除，所以 d 后面为空即可；
        i   ∶插入， i 的后面可以接字串，而这些字串会在新的一行出现(目前的上一行)；
        p  ∶列印，亦即将某个选择的资料印出。通常 p 会与参数 sed -n 一起运作～
        s  ∶取代，可以直接进行取代的工作哩！通常这个 s 的动作可以搭配正规表示法！例如 1,20s/old/new/g

  - 命令示例：
        sed -i 's/^/xxxx&/g' file.csv  (文件内容每行行首添加"xxxx")
        sed -i 's/$/&xxxx/g' file.csv  (文件内容每行行尾添加"xxxx")
        sed -i "/xxxx/d" file.csv (文件内容删除匹配"xxxx"行)

### 5.1.11 xargs命令详解
    -i 选项: 告诉 xargs 用每项的名称替换 {};
    -I {} 选项: 告诉 xargs 用每项的名称替换 {}
    -t 选项: 指示 xargs 先打印命令，然后再执行;
    -n 选项: 限制单个命令行的参数个数;
    -p 选项: 交互式提问y来确认命令的每次执行.
* ls | xargs -t -i mv {} {}.bak
* ls *.zip | xargs -t -i unzip -P SOPinU {}

### 5.1.12 grep命令详解
    选项与参数:
    -a ：将 binary 文件以 text 文件的方式搜寻数据
    -c ：计算找到 '搜寻字符串' 的次数
    -i ：忽略大小写的不同，所以大小写视为相同
    -n ：顺便输出行号
    -v ：反向选择，亦即显示出没有 '搜寻字符串' 内容的那一行！
    --color=auto ：可以将找到的关键词部分高亮

###  5.1.13 tr命令详解
    #!/bin/bash
    set -x
    set -e
    tempVal=`echo "Hello World" | tr [:upper:] [:lower:]`
    echo $tempVal

### 5.1.14 SSH命令详解
* ssh到多个节点，执行shell命令
      cat /etc/hosts |grep -v localhost|grep -v ICT|grep -v kafka |awk '{print $2}' | xargs -I {} ssh {} "rm -rf /home/temp/*"

### 5.1.15 cut命令详解
> cut是一个选取命令,就是将一段数据经过分析,筛选出需要的数据.

* 语法格式
      cut  [-bn] [file] 或 cut [-c] [file]  或  cut [-df] [file]
* 主要参数说明
      -b ：以字节为单位进行分割。这些字节位置将忽略多字节字符边界，除非也指定了 -n 标志。
      -c ：以字符为单位进行分割。
      -d ：自定义分隔符，默认为制表符。
      -f  ：与-d一起使用，指定显示哪个区域。
      -n ：取消分割多字节字符。仅和 -b 标志一起使用。如果字符的最后一个字节落在由 -b 标志的 List 参数指示的<br />范围之内，该字符将被写出；否则，该字符将被排除。

### 5.1.16 awk命令详解
> awk就是把文件逐行的读入，以空格为默认分隔符将每行切片，切开的部分再进行各种分析处理

* 使用方法
      awk '{pattern + action}' {filenames}
      awk [-F  field-separator]  'commands'  input-file(s)
* 参数说明
      ARGC    命令行参数的个数
      ARGV    命令行参数数组
      ARGIND 当前被处理文件的ARGV标志符
      NR 　　已经读出的记录数
      FNR   　当前文件的记录数
      NF：当前记录中的字段个数 => awk -F ':' '{if (NF == 3)print}' file
      RS：输入记录分隔符，缺省为"\n" => awk 'BEGIN{ RS = ";" } {print}' file
      ORS：输出记录分隔符，缺省为换行符，控制每个print语句后的输出符号  => awk 'BEGIN{ FS = "\n"; RS = ""; ORS = ";"} {print NF}' file

      -F re：允许awk更改其字段分隔符
      -v var=$v 把v值赋值给var，如果有多个变量要赋值，那么就写多个-v，每个变量赋值对应一个-v
      e.g. 要打印文件a的第num行到num+num1行之间的行: awk -v num=$num -v num1=$num1 'NR==num,NR==num+num1{print}' a
      awk -v var1=211 -v var2=12 'BEGIN{if(var1 < var2) {print var1} else {print var2}}'
      awk -v var1=2110 -v var2=1 'BEGIN{if(var1 < var2) {print "@2017-01-06 10:37:54 MinValue="var1} else {print "@2017-01-06 10:37:54  MinValue="var2}}'
      -f progfile：允许awk调用并执行progfile程序文件，当然progfile必须是一个符合awk语法的程序文件。

---

#  ___算法专题___
## 6.1 DBSCAN聚类算法
### 6.1.1 概念

* DBSCAN中的几个定义：
  - E邻域：给定对象半径为E内的区域称为该对象的E邻域;
  - 核心对象：如果给定对象Ε领域内的样本点数大于等于MinPts，则称该对象为核心对象;
  - 直接密度可达：对于样本集合D，如果样本点q在p的Ε领域内，并且p为核心对象，那么对象q从对象p直接密度可达;
  - 密度可达：对于样本集合D，给定一串样本点p1,p2….pn，p= p1,q= pn,假如对象pi从pi-1直接密度可达，那么对象q从对象p密度可达;
  - 密度相连：存在样本集合D中的一点o，如果对象o到对象p和对象q都是密度可达的，那么p和q密度相联;
      Eg: 假设半径Ε=3，MinPts=3，点p的E领域中有点{m,p,p1,p2,o}, 点m的E领域中有点{m,q,p,m1,m2},
      点q的E领域中有点{q,m},点o的E领域中有点{o,p,s},点s的E领域中有点{o,s,s1}.
      那么核心对象有p,m,o,s(q不是核心对象，因为它对应的E领域中点数量等于2，小于MinPts=3)；
      点m从点p直接密度可达，因为m在p的E领域内，并且p为核心对象；
      点q从点p密度可达，因为点q从点m直接密度可达，并且点m从点p直接密度可达；
      点q到点s密度相连，因为点q从点p密度可达，并且s从点p密度可达。

### 6.1.2 算法步骤
    DBScan需要二个参数： 扫描半径 (eps)和最小包含点数(minPts)。
    任选一个未被访问(unvisited)的点开始，找出与其距离在eps之内(包括eps)的所有附近点。
    如果 附近点的数量 ≥ minPts，则当前点与其附近点形成一个簇，并且出发点被标记为已访问(visited)。
    然后递归，以相同的方法处理该簇内所有未被标记为已访问(visited)的点，从而对簇进行扩展。
    如果 附近点的数量 < minPts，则该点暂时被标记作为噪声点。
    如果簇充分地被扩展，即簇内的所有点被标记为已访问，然后用同样的算法去处理未被访问的点

### 6.1.3 算法描述
* 输入： 包含n个对象的数据库，半径e,最少数目MinPts;
* 输出： 所有生成的簇，达到密度要求.
  - Repeat
  - 从数据库中抽出一个未处理的点；
  - IF抽出的点是核心点 THEN 找出所有从该点密度可达的对象，形成一个簇；
  - ELSE 抽出的点是边缘点(非核心对象)，跳出本次循环，寻找下一个点；
  - UNTIL 所有的点都被处理。
  - DBSCAN对用户定义的参数很敏感，细微的不同都可能导致差别很大的结果，而参数的选择无规律可循，只能靠经验确定。

* 其伪代码描述如下：
  - 输入：数据对象集合D，半径Eps，密度阈值MinPts
  - 输出：聚类C
        DBSCAN(D, Eps, MinPts)
        Begin
        init C=0; //初始化簇的个数为0
        for each unvisited point p in D
        mark p as visited; //将p标记为已访问
        N = getNeighbours (p, Eps);
        if sizeOf(N) < MinPts then
        mark p as Noise; //如果满足sizeOf(N) < MinPts，则将p标记为噪声
        else
        C= next cluster; //建立新簇C
        ExpandCluster (p, N, C, Eps, MinPts);
        end if
        end for
        End
        其中ExpandCluster算法伪码如下：
        ExpandCluster(p, N, C, Eps, MinPts)
        add p to cluster C; //首先将核心点加入C
        for each point p’ in N
        mark p' as visited;
        N’ = getNeighbours (p’, Eps); //对N邻域内的所有点在进行半径检查
        if sizeOf(N’) >= MinPts then
        N = N+N’; //如果大于MinPts，就扩展N的数目
        end if
        if p’ is not member of any cluster
        add p’ to cluster C; //将p' 加入簇C
        end if
        end for
        End ExpandCluster

## 6.2 哈希算法
### 6.2.1 算法描述(哈希值检验数据的完整性)
* 单向散列算法
      它把某个较大的集合P映射到另一个较小的集合Q中,假如这个算法叫H,那么就有 Q = H(P);
      对于P中任何一个值p都有唯一确定的q与之对应,但是一个q可以对应多个p;
      作为一个有用的Hash算法, H还应该满足:H(p)速度比较快;给出一个q,很难算出一个p满足 q = H(p);给出一个p1,很难算出一个不等于p1的p2使得 H(p1)=H(p2);
* 哈希算法其本质上就是将一个数据映射成另一个数据,通常情况下原数据的长度比hash后的数据容量大.
这种映射的关系我们叫做哈希函数或者散列函数.

### 6.2.2 算法示例

    def RSHash(value: String):Long = {
      var a = 63689
      val b = 378551
      var hash : Long = 0
      (0 to (value.size - 1)).foreach{
        i =>
          hash = hash * a + value.charAt(i).toString.toInt
          a = a * b
        }
      hash
    }

## 6.3 快速排序
### 6.3.1 算法实现
    def quickSort(ls: List[Int]): List[Int] = {
      if (ls.isEmpty) ls
      else quickSort(ls.filter(e => e < ls.head)) ::: ls.head :: quickSort(ls.filter(e => e > ls.head))
    }

## 6.4 三角定位算法
### 6.4.1 算法实现


## 6.5 椭圆第一偏心率、第二偏心率
* 基本概念:
  - a: 长轴半径
  - b: 短轴半径
  - c: 两焦点之间的距离的一半
  - F1、F2： 两焦点
  - 离心率范围：0<e<1
  - 离心率越大椭圆就越扁，越小则越接近于圆

* 计算公式：
  - 焦点在X轴时，标准方程为：x²/a²+y²/b²=1 (a>b>0)
  - 焦点在Y轴时，标准方程为：y²/a²+x²/b²=1 (a>b>0)
  - 椭圆的面积是πab
  - x=acosθ ， y=bsinθ
  - e为椭圆的离心率=c/a
  - 第一离心率 e1 = c/a;  c^2 = a^2 - b^2
  - 第二离心率 e2 = c/b;  c^2 = a^2 - b^2
