package com.me.problem.nim.game

/**
 * Created by senyuanwang on 15/5/29.
 *
 * alice & bob take nims(from a1, a2, ... an) in turn, alice try first. determine who will win.
 */
object A extends App {

  type ACTOR = String

  val ALICE: ACTOR = "Alice"
  val BOB: ACTOR = "Bob"

  def play(a: Array[Int], x: Int): ACTOR = {
    val win = Array.fill(x + 1)(false)
    win(0) = false
    for {
      j <- 1 to x
      i <- 0 until a.length
      if (a(i) <= j)
    } {
      win(j) |= !win(j - a(i))
    }

    if (win(x)) {
      ALICE
    } else {
      BOB
    }
  }

  println(play(Array(1, 4), 10))
  println(play(Array(1, 4), 9))
}
