package codechef.easy.qhouse

import scala.io.StdIn

object Main {

  def outOfHouse(x: Int, y: Int): Boolean = {
    println(s"? $x $y")
    Console.flush()
    val ans = StdIn.readLine()
    ans == "NO"
  }

  def binarySearch(left: Int, right: Int, f: (Int) => Boolean): Int = {
    var min = left
    var max = right
    while (min < max) {
      val mid = (min + max) / 2
      val ans = f(mid)
      if (ans) {
        max = mid
      } else {
        min = mid + 1
      }
    }
    min - 1
  }

  def queryTopY(): Int = {
    binarySearch(0, 1001, y => outOfHouse(0, y))
  }

  def queryBottomX(): Int = {
    binarySearch(0, 1001, x => outOfHouse(x, 0))
  }

  def main(args: Array[String]): Unit = {
    val y = queryTopY()
    val x = queryBottomX()
    val h = 2 * x
    val z = binarySearch(x, 1001, x => outOfHouse(x, h))
    val square = h * h
    val th = y - h
    val ts = 2 * z
    val triangle = ts * th / 2
    val area = square + triangle
    println(s"! $area")
    Console.flush()
  }
}
