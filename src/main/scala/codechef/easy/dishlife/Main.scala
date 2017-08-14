package codechef.easy.dishlife

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
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)
    val ingredients = Array.fill(k)(0)

    var redudent = false
    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val p = line(0)

      var tmpRedudent = true
      var j = 0
      while (j < p) {
        val x = line(j + 1)

        if (ingredients(x - 1) == 0) {
          tmpRedudent = false
        }

        ingredients(x - 1) += 1

        j += 1
      }

      redudent = redudent || tmpRedudent

      i += 1
    }

    val sad = ingredients.exists(_ == 0)

    if (sad) {
      println("sad")
    } else {
      if (redudent) {
        println("some")
      } else {
        println("all")
      }
    }
  }
}
