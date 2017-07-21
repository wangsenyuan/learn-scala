package codechef.easy.chefrrun

import scala.collection.mutable
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
    val n = StdIn.readInt()
    val dishes = StdIn.readLine().split("\\s+").map(_.toInt)

    val checked = Array.fill(n)(0)


    var i = 0
    while (i < n) {
      if (checked(i) == 0) {
        var path = mutable.Set.empty[Int]
        var j = i
        while (checked(j) == 0) {
          checked(j) += 1
          path += j
          j = (j + dishes(j) + 1) % n
        }
        if (path.contains(j)) {
          // a new loop
          while (checked(j) < 2) {
            checked(j) += 1
            j = (j + dishes(j) + 1) % n
          }
        }
      }

      i += 1
    }

    val res = checked.count(_ == 2)
    println(res)
  }
}
