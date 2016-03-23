package com.demo2.entity

import java.io.PrintStream

import com.demo2.common.Logger

/**
 * Created by Wallace on 2016/3/9.
 */
//class ConsoleLogger extends Logger with Cloneable with Serializable {
//
//}



//class SavingAccount extends Account with TimestampLogger with ShortLogger{
//  def withdraw(amount: Double): Unit = {
//    if (amount >= balance)
//      log(new java.util.Date() + ": Insufficient funds")
//    else
//      balance -= amount
//  }
//}
// 构造器执行顺序：Account(超类)、Logger(第一个特质的父特质)、TimestampLogger(第一个特质)、ShortLogger(第二个特质，相同的父特质只构造一次)、SavingAccount(类)
// (构造器的顺度是类的线性化的反向)类的线性化如下：
// lin(SavingAccount) = SavingAccount >> lin(ShortLogger) >> lin(TimestampLogger)  >> lin(Account)
//                    = SavingAccount >> (ShortLogger >> Logger) >> (TimestampLogger >> Logger) >> lin(Account)
//                    = SavingAccount >> ShortLogger >> TimestampLogger >> Logger >> Account ..........  >> SaclaObject >> AnyRef >> Any


//
//class Account {
//  var balance: Double = 20.0
//}

//trait TimestampLogger extends Logger {
//  override def log(msg: String): Unit = {
//    super.log(new java.util.Date() + " " + msg)
//  }
//}

trait TimestampLogger extends Logger {
  abstract override def log(msg: String): Unit = {
    super.log(new java.util.Date() + " " + msg)
  }
}


trait FileLogger extends Logger{
  val filename:String
  lazy val out = new PrintStream(filename)
  def log(msg:String): Unit ={
    out.print(msg);
    out.flush()
  }
}
//class SavingAcount extends Logger{
//  override def log(msg: String): Unit = ???
//
//  val maxLength: Int = 20
//}
//trait ShortLogger extends Logger {
//  val maxLength = 15
//
//  override def log(msg: String): Unit = {
//    super.log {
//      //该方法中每次修改的msg都传递给super.log
//      if (msg.length <= maxLength)
//        msg
//      else
//        msg.substring(0, maxLength - 3) + "..."
//    }
//  }
//}