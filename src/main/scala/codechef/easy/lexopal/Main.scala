package codechef.easy.lexopal

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/04/2017.
  */
object Main {

  def solve() = {
    val str = StdIn.readLine().toCharArray
    var i = 0
    var j = str.length - 1
    var fail = false
    while (i < j && !fail) {
      if (str(i) == '.' && str(j) != '.') {
        str(i) = str(j)
      } else if (str(i) != '.' && str(j) == '.') {
        str(j) = str(i)
      } else if (str(i) == '.' && str(j) == '.') {
        str(i) = 'a'
        str(j) = 'a'
      } else if (str(i) != str(j)) {
        fail = true
      }

      i += 1
      j -= 1
    }

    if (fail) {
      println("-1")
    } else {
      if (str(i) == '.') {
        str(i) = 'a'
      }
      println(new String(str))
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
