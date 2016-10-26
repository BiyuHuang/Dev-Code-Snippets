package com.wallace.common

/**
  * Created by Wallace on 2016/10/26.
  * 统计执行 Code 代码的时间，单位：ms
  */
trait TimeDiff {
  /**
    * @param code  Code block/ Methods
    * @param times Execute code times
    * @return res: Execute code cost time, unit <ms>
    **/
  def timeDiff[T <: Any](code: => T, times: Int = 1): Double = {
    val startTime = System.nanoTime() * 0.000001
    for (i <- 1 to times) {
      code
    }
    val endTime = System.nanoTime() * 0.000001
    val res = endTime - startTime
    res
  }
}
