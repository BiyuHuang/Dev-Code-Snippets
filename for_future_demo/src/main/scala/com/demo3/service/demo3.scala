package com.demo3.service

import java.util.Date

import com.demo3.entity.Fraction
import common.LogSupport


/**
 * Created by Wallace on 2016/3/24.
 */
object demo3 extends LogSupport{
  def main(args: Array[String]) {
    log.info(s"############ ${new Date(System.currentTimeMillis()).toString}")
    print(Fraction(1,2).plus)
  }


}
