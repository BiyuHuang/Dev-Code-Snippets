package common

import org.slf4j.LoggerFactory

/**
  * Created by Wallace on 2015/12/28.
  */
trait LogSupport {
<<<<<<< HEAD
  //  PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties")
=======
  //1. log4j.properties 日志配置
  // PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties")
  // protected val log = LoggerFactory.getLogger(this.getClass)
  
  //2. slf4j logback.xml 日志配置
>>>>>>> origin/master
  protected val log = LoggerFactory.getLogger(this.getClass)
}
