package com.wallace.unsafecode.demo2.common

import com.wallace.common.LogSupport

/**
 * Created by Wallace on 2016/3/9.
 */
trait Logger extends LogSupport {
  //  def log(msg: String) {
  //    println(msg)
  //  }
  val maxLength: Int

  def log(msg: String)

  def info(msg: String) {
    log("[INFO]:" + msg)
  }

  def warn(msg: String) {
    log("[WARN]:" + msg)
  }

  def sever(msg: String) {
    log("[SERVER]:" + msg)
  }
}
