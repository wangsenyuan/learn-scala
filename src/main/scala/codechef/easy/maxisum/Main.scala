package codechef.easy.maxisum

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/23.
  */
object Main {


  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val k = line(1)

    val as = StdIn.readLine().split("\\s+").map(_.toLong)
    val bs = StdIn.readLine().split("\\s+").map(_.toLong)
    var maxAt = -1
    var i = 0
    while (i < n) {
      if (maxAt == -1 || bs(i).abs > bs(maxAt).abs) {
        maxAt = i
      }
      i += 1
    }

    val B = bs(maxAt)
    if (B > 0) {
      as(maxAt) += k
    } else {
      as(maxAt) -= k
    }
    var ans = 0L
    i = 0
    while (i < n) {
      ans += as(i) * bs(i)
      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
