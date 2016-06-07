package codejam.year2016.round2.a

import scala.io.StdIn

/**
  * Created by wangsenyuan on 6/7/16.
  */
object Small extends App {

  def beat(a: Char, b: Char): Option[Char] = {
    (a, b) match {
      case ('P', 'R') => Some('P')
      case ('R', 'P') => Some('P')
      case ('P', 'S') => Some('S')
      case ('S', 'P') => Some('S')
      case ('R', 'S') => Some('R')
      case ('S', 'R') => Some('R')
      case _ => None
    }
  }

  def check(cs: Vector[Char]): Boolean = {
    def go(cs: Vector[Char]): Option[Char] = {
      if (cs.length == 0) {
        None
      } else if (cs.length == 1) {
        Some(cs(0))
      } else if (cs.length % 2 == 0) {
        val mid = cs.length / 2
        val (prev, suffix) = cs.splitAt(mid)
        go(prev).flatMap(x => go(suffix).flatMap(y => beat(x, y)))
      } else {
        val last = cs.last
        go(cs.init).flatMap(x => beat(x, last))
      }
    }

    go(cs) match {
      case None => false
      case Some(_) => true
    }
  }

  class Result(val cs: Vector[Char]) extends RuntimeException

  def play(p: Int, r: Int, s: Int): Vector[Char] = {
    def go(p: Int, r: Int, s: Int, cs: Vector[Char]): Boolean = {
      if (p < 0 || r < 0 || s < 0) {
        false
      } else if (p == 0 && r == 0 && s == 0) {
        if (check(cs)) {
          throw new Result(cs)
        }
        false
      } else {
        go(p - 1, r - 1, s, cs ++ Vector('P', 'R')) ||
          go(p - 1, r, s - 1, cs ++ Vector('P', 'S')) ||
          go(p, r - 1, s - 1, cs ++ Vector('R', 'S'))
      }
    }

    try {
      go(p, r, s, Vector())
      Vector()
    } catch {
      case r: Result => r.cs
    }
  }

  val T = StdIn.readInt()

  for {
    t <- 1 to T
  } {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val r = line(1)
    val p = line(2)
    val s = line(3)
    val result = play(p, r, s)
    if (result.isEmpty) {
      println(s"Case #$t: IMPOSSIBLE")
    } else {
      println(s"Case #$t: ${result.mkString("")}")
    }
  }
}
