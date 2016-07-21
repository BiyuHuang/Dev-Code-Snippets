package com.wallace.spark.DataProcess

import java.io.{File, FileWriter}

import com.wallace.spark.common.LogSupport
import scala.io.Source
import scala.util.Random

/**
  * Created by Wallace on 2016/5/5.
  * Produce Data And Save File on Local Path
  */
object DataProducer extends LogSupport {
  def main(args: Array[String]) {
    val eNodeBID = List("614255,49", "614234,40", "615234,1", "625121,32", "623001,33")
    val random = new Random
    random.setSeed(10)
    val score: Double = random.nextDouble
    val lon: Float = random.nextFloat
    val lat: Float = random.nextFloat
    val sign: Boolean = random.nextBoolean
    val writer = new FileWriter(new File("D:\\Data-20160505-Text.csv"))
    for (i <- 0 to 10000) {
      val str: String = s"${eNodeBID(random.nextInt(5))},${(score * 10).toString},${(lon * 100 + 50.0).toString},${(lat * 100 + 100.0).toString},${sign.toString}"
      log.info(s"str = $str, writer = ${writer.flush()}")
      writer.write(str)
    }
    writer.close()


    //写入到本地文件
    //    val out = new PrintWriter(new File("D:\\Data.txt"))
    //    for (i <- 0 to 100) out.println(i)
    //    out.close()

    //读取本地文件

    val file = Source.fromFile(".\\src\\main\\resources\\Data-20160505-Text.csv", "UTF-8")
    val lines = file.getLines.toArray
    while (lines.length >= 0) {
      //      val outputFile = new File(".\\data\\TestSpendTime.csv")
      //      val out = new FileWriter(outputFile, true)
      val startTime = System.currentTimeMillis()
      (0 to 10000).foreach { messageNum =>
        val str = lines(Random.nextInt(lines.length))

        str.split(",", -1).toList
        log.error(s"${str.split(",", -1).toList}")
        //        out.write(str + "\n")
      }
      val endTime = System.currentTimeMillis()
      val costTime = endTime - startTime
      log.error(s"[Costing Time]: $costTime ms")
      val outputFile = new File(".\\data\\TestSpendTime.csv")
      val out = new FileWriter(outputFile, true)
      out.write(costTime.toInt + "\n")
      out.close()
      Thread.sleep(1000)
    }

    file.close()


    //网络资源读取
    //    val webFile=Source.fromURL("http://spark.apache.org")
    //    webFile.foreach(print)
    //    webFile.close()

  }
}
