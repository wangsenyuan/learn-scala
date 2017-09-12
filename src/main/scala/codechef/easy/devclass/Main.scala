package codechef.easy.devclass

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val tp = StdIn.readInt()
    val str = StdIn.readLine()
    val bs = str.count(_ == 'B')
    val gs = str.count(_ == 'G')

    val n = str.length
    val ans =
      if (bs == gs) {
        play("BG", "", tp, str) min play("GB", "", tp, str)
      } else if (bs == gs + 1) {
        play("BG", "B", tp, str)
      } else if (gs == bs + 1) {
        play("GB", "G", tp, str)
      } else {
        -1
      }

    println(ans)
  }

  def play(seed: String, last: String, tp: Int, str: String): Int = {
    val n = str.length
    val res = seed * (n / 2) + last

    val cs = str.toCharArray

    var j = 0
    var k = 0
    var ans = 0



    ans
  }

  def cost(d: Int, tp: Int): Int = {
    def go(n: Int): Int = {
      if (n == 0) {
        1
      } else {
        val x = go(n / 2)
        val y = x * x
        if (n % 2 == 1) {
          d * y
        } else {
          y
        }
      }
    }

    go(tp)
  }

}
