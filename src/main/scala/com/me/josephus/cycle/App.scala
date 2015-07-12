package com.me.josephus.cycle

/**
 * Created by senyuanwang on 15/7/12.
 */
object App extends App {

  def native(n: Int): Int = {
    def dispatch(pre: Vector[Int], left: Vector[Int]): Vector[Int] =
      if(left.isEmpty) pre
      else if(left.size == 1) pre.tail :+ left.head
      else dispatch(pre :+ left.head, left.tail.tail)

    def play(list: Vector[Int]): Int =
      if(list.size == 1) list.head
      else {
        play(dispatch(Vector(), list))
      }

    play((1 to n).toVector)
  }

  def smart(n: Int): Int = {
    val j = Array.fill(n + 1)(1)

    def calc(k: Int): Unit = {
      if(k <= n) {
        if(k % 2 == 0) {
          j(k) = 2 * j(k / 2) - 1
        } else {
          j(k) = 2 * j(k / 2) + 1
        }
        calc(k + 1)
      }
    }
    calc(2)

    j(n)
  }


  def best(n: Int): Int = {
    def binaryRep(n: Int): List[Int] = {
      if(n == 0) {
        Nil
      } else if(n == 1) {
        List(1)
      } else {
        (n % 2) :: binaryRep(n >> 1)
      }
    }

    val br = binaryRep(n).reverse

    var cycleLeftShift = br.tail :+ br.head

    def toDecimal(list: List[Int], base: Int, result: Int): Int = {
      list match {
        case Nil => result
        case h :: tail => toDecimal(tail, base * 2, result + h * base)
      }
    }
    toDecimal(cycleLeftShift.reverse, 1, 0)
  }

  for {
    i <- 1 until 15
  } {
    println(s"native: J($i) = " + native(i))
  }


  for {
    i <- 1 until 15
  } {
    println(s"smart:  J($i) = " + smart(i))
  }

  for {
    i <- 1 until 15
  } {
    println(s"best:  J($i) = " + best(i))
  }
}
