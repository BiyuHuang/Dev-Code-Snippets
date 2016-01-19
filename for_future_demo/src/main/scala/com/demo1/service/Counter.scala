package com.demo1.service

/**
 * Created by Wallace on 2016/1/7.
 */
class Counter {
  private var value = 0

  def increment() {
    value += 1
  }

  def current = value
}
