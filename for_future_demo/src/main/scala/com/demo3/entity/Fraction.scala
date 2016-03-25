package com.demo3.entity

/**
 * Created by Wallace on 2016/3/24.
 */
class Fraction(n: Int, d: Int) {
  def plus = n + d
}

object Fraction {
  def apply(n: Int, d: Int) = new Fraction(n, d)
}