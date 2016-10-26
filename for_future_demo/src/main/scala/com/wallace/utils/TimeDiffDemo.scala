package com.wallace.utils

/**
  * Created by Wallace on 2016/10/27.
  */
object TimeDiffDemo extends App with TimeDiff {
  val res = timeDiff[Unit](func(), 4)
  println("TimeDiff:" + res + "ms.")


  def func(): Unit = {
    Thread.sleep(1000 * 2)
  }
}
