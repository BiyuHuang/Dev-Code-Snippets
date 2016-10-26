package com.wallace.common

import java.util.Date

import com.UnitSpec


/**
 * Created by Wallace on 2016/1/7.
 */
class TimeParaUnitSpec extends UnitSpec {
  //  log.info(s"[Test-Start-Time]: ${TimePara.getCurrentTime}")
  it should "test time function: getCurrentDate " in {
    //    val currentTime = TimePara.getCurrentTime
    //    val expect1 = "2016-01-10"
    //    Thread.sleep(10 * 60 * 10)
    //    val temp1 = TimePara.timeFormat(s"$currentTime")
    //val temp = TimePara.getCoreTime("1436457603" ,"1436457604")
    log.info(s"[StartTime]${TimePara.getCurrentDate}")
    val startTime = TimePara.getTimeMillis
    Thread.sleep(10 * 60 * 10)
    val endTime = TimePara.getTimeMillis
    log.info(s"[EndTime]${TimePara.getCurrentDate}")
    log.info(s"[CostTime]${(1.0 * (endTime - startTime) / 1000).toString} s")
    log.info(s"[CostTime]${TimePara.getCostTime(startTime, endTime)} \n")
    // currentTime should be(expect1)
  }
  //
  //  it should "test time function: getYesterday " in {
  //    val yesterday = TimePara.getYesterday
  //    val expect2 = "2016-01-09"
  //
  //    yesterday should be(expect2)
  //  }
  //log.info(s"[Test-End-Time]:${TimePara.getCurrentDate}")

  it should "Test getCostTime()" in {
    val dt1 = new Date()
    Thread.sleep(10 * 60 * 100)
    val dt2 = new Date()
    val costTime = TimePara.getCostTime(dt1, dt2)
    log.info(s"[CostTime]${costTime}")
  }
}
