package com.huangbiyu.demo

import common.LogSupport
import org.scalatest._

/**
 * Created by Wallace on 2015/12/28.
 */
trait AccSpec extends FeatureSpec with GivenWhenThen with ShouldMatchers with BeforeAndAfterAll with LogSupport{

}
object SlowAT extends Tag("com.demo.app.SlowAT")