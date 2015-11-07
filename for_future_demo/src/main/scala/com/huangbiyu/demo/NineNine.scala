package com.huangbiyu.demo

import scala.util.Random

/**
 * Created by Wallace on 2015/10/25.
 */
class NineNine {
  //P08 去掉数组中重复的元素
  def compressRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR(result: List[A], curList: List[A]): List[A] = curList match {
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
      case Nil => result.reverse
    }
    compressR(Nil, ls)
  }

  def compressFunctional[A](ls: List[A]): List[A] =
    ls.foldRight(List[A]()) {
      (h, r) =>
        if (r.isEmpty || r.head != h) h :: r
        else r
    }


  // P09 Pack consecutive duplicates of list elements into sublists.
  //If a list contains repeated elements they should be placed in separate sublists.
  def pack[A](ls: List[A]): List[List[A]] = {
    if (ls.isEmpty) List(List())
    else {
      val (packed, next) = ls span {
        _ == ls.head
      }
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  //  P10
  //     Example:
  //     scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //     res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  def encode[A](ls: List[A]): List[(Int, A)] = {
    pack(ls) map { e => (e.length, e.head) }
  }

  //  P11
  //     Example:
  //     scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //     res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  def encodeModified[A](ls: List[A]): List[Any] = encode(ls) map { t => if (t._1 == 1) t._2 else t }

  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] = encode(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }

  //  P12
  //     Example:
  //     scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //     res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  //  def decode[A](ls: List[(Int, A)]) = ls flatMap { e => List.make(e._1, e._2) }

  //  P13
  //     Example:
  //     scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  //     res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
  def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
    if (ls.isEmpty) Nil
    else {
      val (packed, next) = ls span {
        _ == ls.head
      }
      (packed.length, packed.head) :: encodeDirect(next)
    }
  }

  //  P14
  //     scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  //     res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  def duplicate[A](ls: List[A]): List[A] = ls flatMap (e => List(e, e))

  //P15
  //  Duplicate the elements of a list a given number of times.
  //  def duplicateN[A](n: Int, ls: List[A]): List[A] = ls flatMap {
  //    List.make(n, _)
  //  }

  //  P16
  //  Drop every Nth element from a list
  def dropRecursive[A](n: Int, ls: List[A]): List[A] = {
    def dropR(c: Int, curList: List[A]): List[A] = (c, curList) match {
      case (_, Nil) => Nil
      case (1, _ :: tail) => dropR(n, tail)
      case (_, h :: tail) => h :: dropR(c - 1, tail)
    }
    dropR(n, ls)
  }

  def dropTailRecursive[A](n: Int, ls: List[A]): List[A] = {
    def dropR(c: Int, curList: List[A], result: List[A]): List[A] = (c, curList) match {
      case (_, Nil) => result.reverse
      case (1, _ :: tail) => dropR(n, tail, result)
      case (_, h :: tail) => dropR(c - 1, tail, h :: result)
    }
    dropR(n, ls, Nil)
  }

  def dropFunctional[A](n: Int, ls: List[A]): List[A] =
    ls.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map {
      _._1
    }

  //  P17
  // Split a list into two parts.
  // The length of the first part is given.  Use a Tuple for your result.
  def splitRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = (n, ls) match {
    case (_, Nil) => (Nil, Nil)
    case (0, list) => (Nil, list)
    case (n, h :: tail) => {
      val (pre, post) = splitRecursive(n - 1, tail)
      (h :: pre, post)
    }
  }

  def splitTailRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = {
    def splitR(curN: Int, curL: List[A], pre: List[A]): (List[A], List[A]) = (curN, curL) match {
      case (_, Nil) => (pre.reverse, Nil)
      case (0, list) => (pre.reverse, list)
      case (n, h :: tail) => splitR(n - 1, tail, h :: pre)
    }
    splitR(n, ls, Nil)
  }

  def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) = (ls.take(n), ls.drop(n))

  //  P18
  //Extract a slice from a list
  //  Given two indices,I and K,the slice is the list containing the elements
  //  from and including the Ith element up to but not including the Kth element
  //    of the original list.Start counting the elements with
  def sliceBuiltin[A](start: Int, end: Int, ls: List[A]): List[A] = ls.slice(start, end)

  def sliceRecursive[A](start: Int, end: Int, ls: List[A]): List[A] = (start, end, ls) match {
    case (_, _, Nil) => Nil
    case (_, e, _) if e <= 0 => Nil
    case (s, e, h :: tail) if s <= 0 => h :: sliceRecursive(0, e - 1, tail)
    case (s, e, h :: tail) => sliceRecursive(s - 1, e - 1, tail)
  }

  def sliceTailRecursive[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR(count: Int, curList: List[A], result: List[A]): List[A] = (count, curList) match {
      case (_, Nil) => result.reverse
      case (c, h :: tail) if end <= c => result.reverse
      case (c, h :: tail) if start <= c => sliceR(c + 1, tail, h :: result)
      case (c, _ :: tail) => sliceR(c + 1, tail, result)
    }
    sliceR(0, ls, Nil)

  }

  //  P19
  //  Rotate a list N places to the left.
  def rotate[A](n: Int, ls: List[A]): List[A] = {
    val nBounded = if (ls.isEmpty) 0 else n % ls.length
    if (nBounded < 0) rotate(nBounded + ls.length, ls)
    //drop(n:Int)>>>Selects all elements except first n ones.
    //take(n:Int)>>>Selects first n elements.
    else (ls drop nBounded) ::: (ls take nBounded)
  }

  //  P20
  //  Remove the Kth element from a list
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post) => (pre ::: post, e)
    case (pre, Nil) => throw new NoSuchElementException
  }

  def removeAt2[A](n: Int, ls: List[A]): (List[A], A) =
    if (n < 0) throw new NoSuchElementException
    else (n, ls) match {
      case (_, Nil) => throw new NoSuchElementException
      case (0, h :: tail) => (tail, h)
      case (_, h :: tail) => {
        val (t, e) = removeAt(n - 1, ls.tail)
        (ls.head :: t, e)
      }
    }

  //  P21
  //  Insert an element at a given position into a list.
  def insertAt[A](e: A, pos: Int, ls: List[A]): List[A] = ls.splitAt(pos) match {
    //:: 是右操作数的方法     ::: 连接两个List()
    case (pre, post) => pre ::: e :: post
  }

  //P22
  //  Create a list containing all integers within a given range(区间)
  def rangeBuiltin(start: Int, end: Int): List[Int] = List.range(start, end + 1)

  def rangeRecursive(start: Int, end: Int): List[Int] = {
    if (end < start) Nil
    else start :: rangeRecursive(start + 1, end)
  }

  //尾递归函数Tail Recursive
  def rangeTailRecursive(start: Int, end: Int): List[Int] = {
    def rangeR(end: Int, result: List[Int]): List[Int] = {
      if (end < start) result
      else rangeR(end - 1, end :: result)
    }
    rangeR(end, Nil)
  }

  //Classic Functional approach
  def unfoldRight[A, B](s: B)(f: B => Option[(A, B)]): List[A] =
    f(s) match {
      case None => Nil
      case Some((r, n)) => r :: unfoldRight(n)(f)
    }

  def rangeFunctional(start: Int, end: Int): List[Int] =
    unfoldRight(start) { n =>
      if (n > end) None
      else Some((n, n + 1))
    }

  //  P23
  //  Extract a given number of randomly selected elements from a list.
  def randomSelect1[A](n: Int, ls: List[A]): List[A] = {
    if (n <= 0) Nil
    else {
      val (rest, e) = removeAt((new Random()).nextInt(ls.length), ls)
      e :: randomSelect1(n - 1, rest)
    }
  }

  def randomSelect[A](n: Int, ls: List[A]): List[A] = {
    def randomSelectR(n: Int, ls: List[A], r: util.Random): List[A] =
      if (n <= 0) Nil
      else {
        val (rest, e) = removeAt(r.nextInt(ls.length), ls)
        e :: randomSelectR(n - 1, rest, r)
      }
    randomSelectR(n, ls, new Random())
  }

  // P24
  //  Lotto: Draw N different random numbers from the set 1..M.
  def lotto(count: Int, max: Int): List[Int] =
    randomSelect(count, List.range(1, max + 1))

  //  P25
  //  Generate a random permutation of the elements of a list.
  def randomPermute1[A](ls: List[A]): List[A] = randomSelect(ls.length, ls)

  //  def randomPermute[A](ls: List[A]): List[A] = {
  //    val rand = new Random()
  //    val a = ls.toArray
  //    for (i <- a.length - 1 to 1 by -1) {
  //      val il = rand.nextInt(i + 1)
  //      val t = a(i)
  //      a.update(i, a(il))
  //      a.update(il, t)
  //    }
  //    a.toList
  //  }

  // P26
  //  Generate the combinations of K distinct objects chosen from the N elements of a list.
  def flatMapSublists[A, B](ls: List[A])(f: (List[A]) => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@(_ :: tail) => f(sublist) ::: flatMapSublists(tail)(f)
    }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { s1 =>
      combinations(n - 1, s1.tail) map {
        s1.head :: _
      }
    }

  //  P27
  //  Group the elements of a set into disjoint subsets.
    def group3[A](ls: List[A]): List[List[A]] =
      for {
        a <- combinations(2, ls)
        noA = ls -- a
        b <- combinations(3, noA)
      } yield List(a, b, noA -- b)
}

object NineNine {
  def apply: NineNine = new NineNine
}

