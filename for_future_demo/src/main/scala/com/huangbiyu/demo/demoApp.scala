package com.huangbiyu.demo

/**
 * Created by Wallace on 2015/10/25.
 */
object demoApp extends App{
  val S99 = NineNine.apply
  //  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  //  var tempList = s_99.pack(ls)
  //  tempList.foreach(i => print(i + "\t"))

  //  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
  //  var tempList = s_99.encodeDirect(ls)
  //  tempList.foreach(i => print(i + "\t"))

  //  val ls = List('a, 'b, 'c,'c, 'd)
  //  var tempList = s_99.duplicate(ls)
  //  val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  //  var tempList = s_99.dropRecursive(3, ls)
  //  tempList.foreach(i => print(i + "\t"))

  //  var tempList1 = s_99.splitFunctional(3, ls)
  //  println("\n" + tempList1)

  //  val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  //  var tempList = s_99.sliceTailRecursive(3, 7, ls)
  //  tempList.foreach(i => print(i + "\t"))
  //  println(ls.reverse)

  //  val ls = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  //  var tempList = s_99.rotate(3, ls)
  //  tempList.foreach(i => print(i + "\t"))
  //  println("\n")
  //
  //  var tempList_1 = s_99.removeAt(1, ls)
  //  println(tempList_1)

  //  val ls = s_99.rangeFunctional(4, 9)
  //  var tempList_1 = s_99.insertAt(888, 2, ls)
  //  var tempList_2 = s_99.randomSelect(3, ls)
  //  var tempList_3 = s_99.lotto(10, 100)
  //  println(ls)
  //  println(tempList_1)
  //  println(tempList_2)
  //  println(tempList_3)

  val ls = List('a, 'b, 'c, 'd, 'e, 'f)
  var tempList = S99.randomPermute1(ls)
  var tempList_1 = S99.combinations(3, ls)
  println(tempList)
  println(tempList_1)

}
