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

  def play(seed: String, last: String, tp: Int, str: String): Long = {
    val n = str.length
    val res = seed * (n / 2) + last

    if (tp == 0) {
      playType0(res, str)
    } else {
      playTypeN(res, str, tp)
    }
  }

  def playType0(res: String, str: String): Long = {
    res.zip(str).count(x => x._1 != x._2) / 2
  }

  def playTypeN(res: String, str: String, tp: Int): Long = {

    def letterPositionDiffSum(letter: Char): Long = {
      var i = 0
      var j = 0
      var ans = 0L
      while (i < res.length) {
        if (res(i) == letter) {
          while (str(j) != letter) {
            j += 1
          }
          ans += (j - i).abs
          j += 1
        }
        i += 1
      }
      ans
    }

    (letterPositionDiffSum('B') + letterPositionDiffSum('G')) / 2
  }
}
