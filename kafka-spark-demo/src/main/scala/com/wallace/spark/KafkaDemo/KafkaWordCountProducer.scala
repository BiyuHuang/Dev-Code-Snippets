package com.wallace.spark.KafkaDemo

import java.util

import com.wallace.spark.common.LogSupport
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import scala.io.Source

/**
  * Created by Wallace on 2016/5/5.
  */
object KafkaWordCountProducer extends LogSupport {
  def main(args: Array[String]) {
    if (args.length < 4) {
      System.err.println("Usage: KafkaWordCountProducer <metadataBrokerList> <topic> " +
        "<messagesPerSec> <wordsPerMessage>")
      System.exit(1)
    }

    val Array(brokers, topic, messagesPerSec, wordsPerMessage) = args
    // Zookeeper connection properties
    val props = new util.HashMap[String, Object]()
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers)
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
      "org.apache.kafka.common.serialization.StringSerializer")
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
      "org.apache.kafka.common.serialization.StringSerializer")

    val producer = new KafkaProducer[String, String](props)
    // Send some messages

    val file = Source.fromFile(".\\src\\main\\resources\\data-20160505.txt", "UTF-8")
    val lines = file.getLines.toArray

    while (true) {
      var j = 0
      (1 to messagesPerSec.toInt).foreach { messageNum =>
        //        val str = (1 to wordsPerMessage.toInt).map(x => scala.util.Random.nextInt(10).toString)
        //          .mkString(" ")

        for (i <- 0 to lines.length if j < messageNum) {
          val str: String = lines(scala.util.Random.nextInt(lines.length))
          try {
            val message = new ProducerRecord[String, String](topic, null, str)
            producer.send(message)
          } catch {
            case success => j += 1
            case _ => j
          }
        }

      }
      Thread.sleep(1000)
    }
  }


}
