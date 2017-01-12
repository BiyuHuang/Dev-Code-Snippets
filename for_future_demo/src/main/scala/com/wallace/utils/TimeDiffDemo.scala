package com.wallace.utils

import com.wallace.common.LogSupport

/**
  * Created by Wallace on 2016/10/27.
  */
object TimeDiffDemo extends App with TimeDiff with LogSupport {
  val res = timeDiff[Unit](func(), 4)
  log.info("TimeDiff:" + res + "ms.")


  def func(): Unit = {
    Thread.sleep(1000 * 2)
  }
}
