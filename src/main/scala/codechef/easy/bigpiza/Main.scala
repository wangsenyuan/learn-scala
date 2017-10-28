package codechef.easy.bigpiza

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val N = 10000
    val g = Array.fill(N + 3)(0)

    var i = 2
    while (i <= N) {
      val vis = Array.fill(N + 3)(false)

      var x = 0
      var y = i - 2
      while (x <= y) {
        vis(g(x) ^ g(y)) = true
        x += 1
        y -= 1
      }

      var j = 0
      while (vis(j)) {
        j += 1
        g(i) = j
      }

      i += 1
    }


    val t = StdIn.readInt()

    i = 0
    while (i < t) {
      val n = StdIn.readInt()
      if (g(n) > 0) {
        println("Arjuna")
      } else {
        println("Bhima")
      }
      i += 1
    }
  }

}
