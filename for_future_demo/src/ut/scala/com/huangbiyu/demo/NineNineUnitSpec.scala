package com.huangbiyu.demo

import com.UnitSpec

/**
 * Created by Wallace on 2015/10/25.
 */
class NineNineUnitSpec extends UnitSpec{
 it should "" in {
   val ls_1 = List('a,'a,'b,'c,'d)
   val S99 = NineNine.apply
   val result = S99.compressRecursive(ls_1)
   val expect = List('a, 'b, 'c, 'd)
   log.info(s"################## $result")
   result should be(expect)
}
}
