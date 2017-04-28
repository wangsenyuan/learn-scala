package codechef.easy.graysc

import scala.io.StdIn

/**
  * Created by wangsenyuan on 28/04/2017.
  */
object Main {


  def binarySearch(len: Int, f: Int => Boolean): Int = {
    var i = 0
    var j = len
    while (i < j) {
      val k = (i + j) / 2
      if (!f(k)) {
        i = k + 1
      } else {
        j = k
      }
    }
    i
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val a = StdIn.readLine().split("\\s+").map(_.toLong)

    if (n >= 130) {
      println("Yes")
    } else {
      val b = a.sorted
      var found = false
      var i = 0
      while (i < n && !found) {
        var j = i + 1
        while (j < n && !found) {
          var k = j + 1
          while (k < n && !found) {
            val x = b(i) ^ b(j) ^ b(k)
            var m = binarySearch(n, m => b(m) >= x)

            while (m < n && b(m) == x && (m == i || m == j || m == k)) {
              m += 1
            }
            found = m < n && b(m) == x

            k += 1
          }
          j += 1
        }
        i += 1
      }

      if (found) {
        println("Yes")
      } else {
        println("No")
      }
    }
  }
}
