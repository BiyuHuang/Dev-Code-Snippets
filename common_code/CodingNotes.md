# ___Coding Notes___

---
# ___前端/服务端 技能专题___

>     TCP/IP  XML  HTML  CSS  JavaScript Spray

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

>       TCP/IP使用32个比特或者4组0到255之间的数字来为计算机编址

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
            首先是复制 RequestContext 到下一层 Directive，RequestContext 在传输的过程中是 immutable 的。
            其次，它可以获取 requester 附带的参数，比如 parameters, formData, jsonData 等，还能完成 marshall， unmarshall 操作。
            最后，可以用返回结果到 requester，可以定义结果的类型和值.

### 1.3.3 Json Support
          从 parameter 到 case class 也有映射，

          case class Color(keyword: String, sort_order: Int, sort_key: String)

          val testRoute =
          path("test") {
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

>       Echarts: Enterprise Charts,商业级数据图表库

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

          1.模块化包引入
          2.标签式单文件引入
          3.模块化单文件引入(推荐)

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
                }
              )

### 1.4.2 RDK Doc

### 1.4.3 React Doc

>       React是一个用于构建用户界面的JavaScript库，主要用于构建UI，是MVC中的V
        MVC全名是Model View Controller，是模型(model)－视图(view)－控制器(controller)的缩写

* React 特点
    1. 声明式设计
    2. 高效
    3. 灵活
    4. JSX -- 支持JavaScript语法
    5. 组件
    6. 单向响应的数据流

## 1.5 __HTML模块__

### 1.5.1 HTML基础
       1. 基本标签、元素、属性
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

        2. HTML表单和输入
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
        1. div页面布局
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

        2. table页面布局
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
          <td style="background-color:#EEEEEE;height:200px;width:400px;">
          Content goes here</td>
          </tr>
          <tr>
          <td colspan="2" style="background-color:#FFA500;text-align:center;">
          Copyright © W3Schools.com</td>
          </tr>
          </table>

### 1.5.3 HTML统一资源定位器(URL)
---
# ___开发语言专题___
>     scala  SQL  Python  java  shell

## 2.1 scala模块

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

## 2.2 SQL模块

## 2.3 Python模块

## 2.4 java模块

## 2.5 shell模块
### 2.5.1 获取进程号
        #!/bin/bash
        echo "PID OF THIS SCRIPT: $$"
        echo "PPID OF THIS SCRIPT: $PPID"
        echo "UID OF THIS SCRIPT: $UID"

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

>     Spark  Sybase  GBase  HBase

## 3.1 Spark模块
### 3.1.1 Spark计算模型
#### 3.1.1.1 Spark算子

>     RDD(弹性分布式数据集)是Spark中的抽象数据结构类型，任何数据在Spark中都被表示为RDD.
    从编程角度来看，RDD可以简单看成一个数组；
    与普通数组的区别是，RDD中的数据是分区存储的，能够并行处理RDD.
    RDD计算操作算子：Transformation(变换) 与 Action(行动)

*  map

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

### 3.1.2 Spark组件

#### 3.1.2.1 Spark Streaming  + Kafka

>集群资源信息: CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181

        1. 创建Topic
        ./kafka-topics.sh --create --topic broker1_rep1_parti20 --zookeeper CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --replication-factor 1 --partitions 20

        2. 列出所有Topic
        ./kafka-topics.sh --list --zookeeper  CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181

        3. 查看Topic详情
        ./kafka-topics.sh --describe --zookeeper CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --topic broker1_rep1_parti20

        4. kafka生产命令行
        ./kafka-console-producer.sh --broker-list CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --topic broker1_rep1_parti20

        6. kafka消费命令行
        ./kafka-console-consumer.sh --zookeeper  CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --topic broker1_rep1_parti20

        7. kafka删除Topic
        ./kafka-topics.sh --delete --zookeeper CUNDAP:2181,CUNSPARK:2181,CUNHADOOP:2181 --topic broker1_rep1_parti20

        8. 启动kafka服务
        ./kafka-server-start.sh config/server.properties

#### 3.1.2.2 Spark Steaming 窗口操作

<table class="table table-bordered table-condensed">
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
## 3.2 Sybase模块

## 3.3 GBase模块

## 3.4 HBase模块

---
# ___无线产品业务专题___

>     LTE  CDMA  UMTS  Pre5G

# 4.1 LTE业务模块

# 4.2 CDMA业务模块

---
# ___系统环境专题___

>     Linux

## 5.1 Linux系统模块
###    5.1.1 查看进程
          ps -ef| grep xxx
          ps -a
          ps -e
###    5.1.2 新建文件
          touch 文件名
####    5.1.3 HADOOP常用命令
*      5.1.3.1 列出目录及文件信息
              Hadoop fs –ls /home/......
*      5.1.3.2 删除某目录下的文件
              Hadoop fs –rm –r /lte/......
*      5.1.3.3 打印某目录下的文件
              Hadoop fs -cat /home/......
              Hadoop fs -tail -f /home/......
*      5.1.3.4 将本地目录下的文件推送到HDFS目录
              hadoop fs -put sourcePath targetPath
*      5.1.3.5 显示该目录中每个文件的大小
              hadoop fs -du PATH
              hadoop fs -du -s PATH
              hadoop fs -du -sh PATH
*      5.1.3.6 创建目录
              hadoop fs -mkdir newPath
*      5.1.3.7 复制文件
              hadoop fs -cp -f sourcePath targetPath
*      5.1.3.8 接受一个源目录和多个目标文件作为输入，并且将HDFS源目录中所有的文件连接成本地目标文件
              hadoop fs -getmerge sourcePath targetPath
*      5.1.3.9 HDFS源目录下载文件到本地
              hadoop fs -get sourcePath targetPath

###    5.1.4 磁盘挂载
*         a.查看磁盘挂载信息

            df -h   
*         b.查看有没有空硬盘没挂载

            fdisk -l
*         c.磁盘自动分区

            fdisk /dev/sdb  
*         d.硬盘格式化(终端执行: partprobe)

            mkfs -t ext3 /dev/sdb1
            mkfs -t ext4 /dev/sda4

*         e.将分区挂载到 /mnt

            mount /dev/sdb /mnt

###    5.1.5 查看占用磁盘空间
          du -s
          du -sh
          du -h
###    5.1.6 检查必要的服务，如系统定时任务管理
          crontab -l
###    5.1.7 主机之间的文件传输
          scp -r sourcePath hostname:/targetPath
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

         cp -u sourcePath targetPath #只复制更新的文件

###    5.1.8 kill全部检索出来的所有进程
          ps -ef | grep "nslookup" | awk '{print $2}' | xargs -t -i kill -9 {}

###    5.1.9 常见解压命令

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
</table>

###    5.1.10 显示网络状态
*         a.查看某端口号的状态：netstat -tulnp |grep 端口号
*         b.根据端口列进程：netstat  -ntlp  |  grep 端口号
*         c.跟踪指定进程的PID：gdb -p pid

###    5.1.11 添加用户、组
*          a.添加新用户

             useradd hadoop -m -d /home/hadoop
             passwd hadoop  (设置密码)
*          b.添加组

###    5.1.12 显示历史输入记录

           history
           history -c

###    5.1.13 统计文件的个数、行数、字数、字节数等信息

1.          wc(Word Count)命令

            命令参数：

            -c 统计字节数.

            -l 统计行数.

            -m 统计字符数,这个标志不能与 -c 标志一起使用.

            -w 统计字数,一个字被定义为由空白、跳格或换行字符分隔的字符串.

            -L 打印最长行的长度.

            -help 显示帮助信息.

            –version 显示版本信息.

2.          ls 命令

            只显示文件夹 ls -l | grep ^d

            只显示文件 ls -l | grep ^-

            查看文件夹个数 ls -l | grep ^d

            查看文件个数 ls -l | grep ^

            统计文件个数(包括子目录) ls -lR|grep "^-"|wc -l

            统计/home/han目录(包含子目录)下的所有js文件则: ls -lR /home/han|grep js|wc -l 或 ls -l "/home/han"|grep "js"|wc -l   

###     5.1.14 修改文件名

            修改后缀名
            rename .txt .csv *

###     5.1.15 配置IP地址

            修改网卡配置文件ifcfg-eth0
            vim /etc/sysconfig/network-scripts/ifcfg-eth0

            配置文件中的配置项
            ONBOOT=yes
            BOOTPROTO=static
            IPADDR=192.168.0.32
            GATEWAY=192.168.0.1
            DNS=192.168.1.9

            重启网络服务
            service NetworkManager restart
            service network restart

            测试网络
            ping网关
            pint外网

###     5.1.16 磁盘挂载

            fdisk -l  //先查询未挂载的硬盘名如：sdb1 等  
            mkfs.ext3 /dev/xvdb   开始格式化  
            df -h              
            mount /dev/xvdb /home   开始挂载  
            vi /etc/fstab        设置自动开启启动  
                按格式添加  
                /dev/xvdb  /home        ext3    defaults        0 0  
                硬盘名      需要挂载的位置   格式  

            卸载挂载点：  
            umount /home/ftp2  

###     5.1.17 系统监控

           vmstat -S M
           top #查看cpu利用率
           iostat -c -t 5
           iostat -x 1 10

###     5.1.18 IO实时监控

           iostat -d -k 2 #参数 -d 表示，显示设备（磁盘）使用状态；-k某些使用           block为单位的列强制使用Kilobytes为单位；2表示，数据显示每隔2秒刷新一次;
           iostat -x 2 #每隔2秒刷新一下磁盘使用状态
           iostat -d -k 1 10  #查看TPS和吞吐量信息(磁盘读写速度单位为KB)
           iostat -d -m 2     #查看TPS和吞吐量信息(磁盘读写速度单位为MB)
           iostat -d -x -k 1 10 #查看设备使用率（%util）、响应时间（await） iostat -c 1 10 #查看cpu状态

###     5.1.19 sz / rz 上传下载文件命令(SecureCRT)
            下载文件：sz finename1 filename2
            上传文件：rz

###     5.1.20 date命令使用

            $ date +%F' '%T
            2016-07-05 09:59:32

---

#  ___算法专题___
## 6.1 DBSCAN聚类算法
### 6.1.1 概念

      DBSCAN中的几个定义：
      E邻域：给定对象半径为E内的区域称为该对象的E邻域;
      核心对象：如果给定对象Ε领域内的样本点数大于等于MinPts，则称该对象为核心对象;
      直接密度可达：对于样本集合D，如果样本点q在p的Ε领域内，并且p为核心对象，那么对象q从对象p直接密度可达;
      密度可达：对于样本集合D，给定一串样本点p1,p2….pn，p= p1,q= pn,假如对象pi从pi-1直接密度可达，那么对象q从对象p密度可达;
      密度相连：存在样本集合D中的一点o，如果对象o到对象p和对象q都是密度可达的，那么p和q密度相联;

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

      输入： 包含n个对象的数据库，半径e,最少数目MinPts;
      输出： 所有生成的簇，达到密度要求.
      (1)Repeat
      (2)从数据库中抽出一个未处理的点；
      (3)IF抽出的点是核心点 THEN 找出所有从该点密度可达的对象，形成一个簇；
      (4)ELSE 抽出的点是边缘点(非核心对象)，跳出本次循环，寻找下一个点；
      (5)UNTIL 所有的点都被处理。
      DBSCAN对用户定义的参数很敏感，细微的不同都可能导致差别很大的结果，而参数的选择无规律可循，只能靠经验确定。

      其伪代码描述如下：
      输入：数据对象集合D，半径Eps，密度阈值MinPts
      输出：聚类C
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
          单向散列算法,它把某个较大的集合P映射到另一个较小的集合Q中,假如这个算法叫H,那么就有 Q = H(P);
          对于P中任何一个值p都有唯一确定的q与之对应,但是一个q可以对应多个p;
          作为一个有用的Hash算法, H还应该满足:H(p)速度比较快;给出一个q,很难算出一个p满足 q = H(p);给出一个p1,很难算出一个不等于p1的p2使得 H(p1)=H(p2);

          哈希算法其本质上就是将一个数据映射成另一个数据,通常情况下原数据的长度比hash后的数据容量大.
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
