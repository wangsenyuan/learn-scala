package codechef.easy.chefsign

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
    val s = StdIn.readLine()

    def process(i: Int, j: Int, tmp: Int, res: Int): Int = {
      if (i == s.length) {
        res max tmp
      } else s(i) match {
        case '=' => process(i + 1, j, tmp, res)
        case '>' =>
          if (s(j) == '>') {
            process(i + 1, j, tmp + 1, res)
          } else {
            process(i + 1, i, 1, tmp max res)
          }
        case '<' =>
          if (s(j) == '<') {
            process(i + 1, j, tmp + 1, res)
          } else {
            process(i + 1, i, 1, tmp max res)
          }
      }
    }

    var i = 0
    while (i < s.length && s(i) == '=') {
      i += 1
    }

    val ans =
      if (i == s.length) {
        1
      } else {
        process(i + 1, i, 1, 1) + 1
      }

    println(ans)
  }
}
