package codechef.easy.cheffa

import scala.io.StdIn

object Main {

  val MOD = 1000000007

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }

  def solve(): Unit = {
    val n = StdIn.readInt()
    var nums = StdIn.readLine().split("\\s+").map(_.toInt)

    if (n < 71) {
      nums = nums ++ (Array.fill(71 - n)(0))
    }

    var f = Array.fill(150, 150)(0)
    f(nums(0))(nums(1)) = 1
    var i = 2
    while (i < 71) {
      val g = Array.fill(150, 150)(0)
      for {
        x <- 0 until 150
        y <- 0 until 150
      } {
        if (f(x)(y) > 0) {
          for {
            k <- 0 to (x min y)
          } {
            g(y - k)(nums(i) + k) += f(x)(y)
            if (g(y - k)(nums(i) + k) >= MOD) {
              g(y - k)(nums(i) + k) -= MOD
            }
          }
        }
      }
      f = g
      i += 1
    }

    println(f(0)(0))
  }
}
