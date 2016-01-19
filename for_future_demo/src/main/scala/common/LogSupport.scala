package common

import org.slf4j.LoggerFactory

/**
 * Created by Wallace on 2015/12/28.
 */
trait LogSupport {
  protected  val log = LoggerFactory.getLogger(this.getClass)
}
