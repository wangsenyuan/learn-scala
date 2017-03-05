package codechef.easy.maxcomp

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/5.
  */
object Main {

  case class Event(s: Int, e: Int, c: Int)

  def maxCompensation(events: Array[Event], n: Int) = {
    val sorted = events.sortWith {
      (a, b) =>
        a.s < b.s || (a.s == b.s && a.e < b.e)
    }

    val dp = Array.fill(n)(0L)

    (0 until n) foreach {
      i =>
        val x = sorted(i)
        var prev = 0L
        var j = 0
        while (j < i) {
          if (sorted(j).e <= x.s) {
            prev = prev max dp(j)
          }
          j += 1
        }
        dp(i) = prev + x.c
    }


    dp.max
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val n = StdIn.readInt()
        val events = Array.fill[Event](n)(null)
        (0 until n) foreach {
          i =>
            val line = StdIn.readLine().split("\\s+").map(_.toInt)
            events(i) = Event(line(0), line(1), line(2))
        }

        val res = maxCompensation(events, n)
        println(res)
    }
  }
}
