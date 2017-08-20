package codechef.easy.dream

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val k = firstLine(1)

    val nums = StdIn.readLine().split("\\s+").map(_.toInt)
    val zipped = nums.zipWithIndex.sortBy(_._1)

    var ans = 0
    var i = 0
    while (i < n) {
      var start = zipped(i)._2
      var end = zipped(i)._2
      var j = i + 1
      while (j < n && zipped(j)._1 == zipped(i)._1) {
        val idx = zipped(j)._2
        if (idx < start) {
          start = idx
        }
        if (idx > end) {
          end = idx
        }
        j += 1
      }

      ans += (end - start + k) / k

      i = j
    }

    println(ans)
  }
}
