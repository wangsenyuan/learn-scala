package codechef.easy.issnake

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/7/8.
  */
object Main {


  def solve() = {
    val n = StdIn.readInt()
    val plate = Array.fill[Array[Char]](2)(null)
    plate(0) = StdIn.readLine().toCharArray
    plate(1) = StdIn.readLine().toCharArray

    var black0 = 0
    var black1 = 0
    var foundGap = false
    var snake = true
    var i = 0
    while (i < n && snake) {
      if (plate(0)(i) == '.' && plate(1)(i) == '.') {
        if (black0 > 0 || black1 > 0) {
          foundGap = true
        }
      } else if (foundGap) {
        snake = false
      } else if (plate(0)(i) == '.') {
        // plate(1)(i) == '#'
        if (black0 > black1) {
          snake = black1 % 2 == 1 // can stop at row1
        } else if (black0 < black1) {
          snake = black0 % 2 == 0 // can stop at row1
        }
        black0 = 0
        black1 += 1
      } else if (plate(1)(i) == '.') {
        if (black1 > black0) {
          snake = black0 % 2 == 1
        } else if (black1 < black0) {
          snake = black1 % 2 == 0
        }
        black1 = 0
        black0 += 1
      } else {
        black0 += 1
        black1 += 1
      }

      i += 1
    }

    if (snake) {
      println("yes")
    } else {
      println("no")
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()

      i += 1
    }
  }
}
