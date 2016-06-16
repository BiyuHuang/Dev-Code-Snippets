package common

import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.joran.JoranConfigurator
import org.slf4j.LoggerFactory

/**
  * Created by Wallace on 2015/12/28.
  */
trait LogSupport {
  //1. log4j.properties 日志配置
  // PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties")
  // protected val log = LoggerFactory.getLogger(this.getClass)
  
  //2. slf4j logback.xml 日志配置
  protected val log = LoggerFactory.getLogger(this.getClass)
}
