package codechef.easy.prpaln

import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/02/2017.
  */
object Main {

  def isPalindrome(str: String): Boolean = {
    var i = 0
    var j = str.length - 1

    while (i < j && str(i) == str(j)) {
      i += 1
      j -= 1
    }

    i >= j
  }

  def canGetPalindrome(line: String): Boolean = {
    var i = 0
    var j = line.length - 1

    while (i < j && line(i) == line(j)) {
      i += 1
      j -= 1
    }

    if (i >= j) {
      true
    } else {
      isPalindrome(line.substring(i, j)) || isPalindrome(line.substring(i + 1, j + 1))
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine()
      val res = canGetPalindrome(line)

      if (res) {
        println("YES")
      } else {
        println("NO")
      }

      t -= 1
    }
  }
}
