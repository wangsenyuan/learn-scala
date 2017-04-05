package codechef.easy.ankparen

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 04/04/2017.
  */
object Main {

  def isRegular(str: String): Boolean = {
    @tailrec
    def go(i: Int, level: Int): Boolean = {
      if (level < 0) {
        false
      } else if (i == str.length) {
        level == 0
      } else {
        str(i) match {
          case '(' => go(i + 1, level + 1)
          case _ => go(i + 1, level - 1)
        }
      }
    }

    go(0, 0)
  }


  def generateSeq(str: String, k: Int): String = {
    var i = 0
    var j = 0
    while (j < str.length && i < k) {
      if (str(j) == ')' && (j == str.length - 1 || str(j + 1) == '(')) {
        //remove ) at index j
        i += 1
      }
      j += 1
    }
    j -= 1

    if (i < k) {
      j = str.length - 1
      while (j >= 0 && i < k) {
        if (str(j) == '(' && (j == 0 || str(j - 1) == ')')) {
          //remove ( at index j
          i += 1
        }
        j -= 1
      }
      j += 1
    }
    if (i == k) {
      str.substring(0, j) + str.substring(j + 1)
    } else {
      ""
    }
  }

  def solve() = {
    val str = StdIn.readLine()
    val k = StdIn.readInt()

    if (k > str.length) {
      println(-1)
    } else {
      if (isRegular(str)) {
        val res = generateSeq(str, k)
        if (res.isEmpty) {
          println(-1)
        } else {
          println(res)
        }
      } else if (k == 1) {
        println(str)
      } else {
        println(-1)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
