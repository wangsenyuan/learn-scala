package codechef.notatri

import scala.io.StdIn

/**
  * Created by senyuanwang on 2016/12/13.
  */
object Main {

  def main(args: Array[String]): Unit = {
    process(StdIn.readInt())
  }

  def process(n: Int): Unit = {
    if (n > 0) {
      val sticks = StdIn.readLine().split("\\s+").map(_.toInt)
      val res = choose(sticks)
      println(res)
      process(StdIn.readInt())
    }
  }

  def choose(sticks: Array[Int]): Int = {
    val sorted = sticks.sorted
    var res = 0
    for {
      i <- 0 until sorted.length
      x = sorted(i)
      j <- i + 1 until sorted.length
      y = sorted(j)
      k = binarySearch(sorted, x + y)
    } {
      res += sorted.length - k
    }

    res
  }

  def binarySearch(arr: Array[Int], x: Int): Int = {
    var i = 0
    var j = arr.length
    while (i < j) {
      val k = i + (j - i) / 2
      if (arr(k) <= x) {
        i = k + 1
      } else {
        j = i - 1
      }
    }
    i
  }
}
