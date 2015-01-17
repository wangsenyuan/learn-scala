package poj.p1064

import scala.io.Source

/**
 * Created by senyuanwang on 14/12/6.
 */
object App extends App {

  val lines = Source.fromFile("src/main/scala/poj/p1064/console.in").getLines()

  val firstLine = lines.next().split("\\s+")

  val n = firstLine(0).toInt
  val k = firstLine(1).toInt

  val xs = Array.fill(n)(0.0)

  for(i <- 0 until n) {
    xs(i) = lines.next().toDouble
  }

  def check(len: Double): Boolean = {
    var cnt = 0

    for {
      x <- xs
    } {
      cnt += (x / len).toInt
    }

    cnt >= k
  }

  var low = 0.0
  var up = xs.max
  for {
    i <- 0 until 100
  } {
    val mid = (low + up) / 2
    if(check(mid)) {
      low = mid
    } else {
      up = mid
    }
  }

  val ans = (up * 100).floor / 100

  println(f"$ans%.2f");

}
