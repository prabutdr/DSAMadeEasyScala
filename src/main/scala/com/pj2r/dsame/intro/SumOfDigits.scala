package com.pj2r.dsame.intro

object SumOfDigits {

  def sum(number: Int): Int = {
    var sum = 0
    var n = number.abs
    while (n > 0) {
      sum += (n % 10)
      n /= 10
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    println(sum(12345))
  }
}