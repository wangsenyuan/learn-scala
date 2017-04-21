package codechef.easy.chefspl

import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/04/2017.
  */
object Main {

  def checkEven(str: String) = {
    var i = 0
    var j = str.length / 2

    while (j < str.length && str(i) == str(j)) {
      i += 1
      j += 1
    }
    j == str.length
  }

  def checkRemoveOneFirstHalf(str: String) = {
    var i = 0
    var j = str.length / 2 + 1
    var remove = 0

    while (j < str.length && remove < 2) {
      if (str(i) == str(j)) {
        i += 1
      } else {
        remove += 1
        i += 2
      }

      j += 1
    }
    j == str.length && remove == 1
  }

  def checkRemoveOneSecondHalf(str: String): Boolean = {
    var i = 0
    var j = str.length / 2
    var remove = 0
    while (i < str.length / 2) {
      if (str(i) == str(j)) {
        j += 1
      } else {
        remove += 1
        j += 2
      }
      i += 1
    }

    i == str.length / 2 && remove == 1
  }

  def checkOdd(str: String) = {
    checkRemoveOneFirstHalf(str) || checkRemoveOneSecondHalf(str)
  }

  def check(str: String) = {
    val n = str.length
    if (n < 2) {
      false
    } else if (n % 2 == 0) {
      checkEven(str)
    } else {
      checkOdd(str)
    }
  }

  def main(args: Array[String]): Unit = {
    var d = StdIn.readInt()
    while (d > 0) {

      val str = StdIn.readLine()

      val res = check(str)

      if (res) {
        println("YES")
      } else {
        println("NO")
      }

      d -= 1
    }

  }
}
