package codechef.easy.icpc16d

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    0 until t foreach {
      _ => solve()
    }
  }

  val mod = 1000000007

  def solve(): Unit = {
    val _ = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toInt)
    val arr = Array.fill(750001)(0)
    nums foreach {
      x => arr(x) = 1
    }

    var ans = 0L

    (750000 to 1 by -1) foreach {
      x =>
        if (arr(x) > 0) {
          var sum = 1L
          var y = 2 * x
          while (y < 750001) {
            sum = (sum + arr(y)) % mod
            y += x
          }
          arr(x) = (sum % mod).toInt
          ans = (arr(x) + ans) % mod
        }
    }

    println(ans)
  }
}
