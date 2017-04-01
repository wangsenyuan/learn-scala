package codechef.easy.cletab

import scala.io.StdIn

/**
  * Created by wangsenyuan on 01/04/2017.
  */
object Main {

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val orders = StdIn.readLine().split("\\s+").map(_.toInt)
    val lastUse = Array.fill(401)(-1)
    val seenBefore = Array.fill(401)(-1)
    val present = Array.fill(401)(false)
    var i = 0
    while (i < m) {
      lastUse(orders(i)) = i
      i += 1
    }

    var ans = 0
    i = 0

    while (i < m && (ans < n || present(orders(i)))) {
      if (!present(orders(i))) {
        present(orders(i)) = true
        ans += 1
      }

      i += 1
    }

    while (i < m) {
      if (!present(orders(i))) {
        var victim = -1

        var j = i - 1
        while (j >= 0 && victim == -1) {
          if (present(orders(j)) && lastUse(orders(j)) == j) {
            //will not use in the future
            victim = orders(j)
          }
          j -= 1
        }

        if (victim == -1) {
          //find the farthest person will be served
          j = i + 1
          while (j < m) {
            if (present(orders(j)) && seenBefore(orders(j)) != i) {
              seenBefore(orders(j)) = i
              victim = orders(j)
            }
            j += 1
          }
        }
        present(victim) = false
        present(orders(i)) = true
        ans += 1
      }

      i += 1
    }

    println(ans)
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
