package com.me.problem.grundy

/**
 * Created by senyuanwang on 15/5/31.
 */
object Nim extends App {

  /**
   * n piles of nim with size of x1, x2, ..., xn, and two persons take nim from one pile in turn, and the taken number
   * is in a1, a2, ... ak; determine who, Bob or Alice, will win if both take the right decision;
   */

  type Person = String

  val Bob = "Bob"
  val Alice = "Alice"

  def solve(x: Array[Int], a: Array[Int]): Person = {
    val n = x.length
    val k = a.length
    val maxX = x.max
    val grundy = Array.fill(maxX + 1)(0)

    for {
      j <- 1 to maxX
    } {
      var set = Set.empty[Int]
      for {
        i <- 0 until k
        if (a(i) <= j)
      } {
        set += grundy(j - a(i))
      }

      grundy(j) = Stream.from(0).filter(!set(_)).head
    }

    val y = x.foldLeft(0)((res, xi) => res ^ grundy(xi))

    if (y != 0) Alice
    else Bob
  }

  println(solve(Array(5, 6, 8), Array(1, 3, 4))) //Bob will win
  println(solve(Array(5, 6, 7), Array(1, 3, 4))) //Alice will win
}
