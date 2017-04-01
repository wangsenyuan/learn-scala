package codechef.easy.stem

import scala.io.StdIn

/**
  * Created by wangsenyuan on 01/04/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val words = StdIn.readLine().split("\\s+")

    val shortest = words.minBy(_.length)
    var ans = ""
    var k = shortest.length
    while (k > 0 && ans.isEmpty) {
      var i = 0
      while (i + k <= shortest.length) {
        val j = i + k
        val test = shortest.substring(i, j)

        val found = words.forall(_.contains(test))

        if (found) {
          if (ans.isEmpty || test < ans) {
            ans = test
          }
        }

        i += 1
      }

      k -= 1
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
