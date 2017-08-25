package codechef.easy.tourists

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val e = firstLine(1)

    val edges = Array.fill[mutable.ListBuffer[Int]](n)(null)

    var i = 0
    while (i < n) {
      edges(i) = mutable.ListBuffer.empty[Int]
      i += 1
    }

    i = 0
    while (i < e) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt - 1)
      val a = line(0)
      val b = line(1)
      edges(a) += b
      edges(b) += a
      i += 1
    }

    val notEulerCircuit = edges.exists(lst => lst.isEmpty || lst.size % 2 == 1)

    if (notEulerCircuit) {
      println("NO")
    } else {
      println("YES")
      val res = ListBuffer.empty[String]
      val visited = mutable.Set.empty[(Int, Int)]

      def dfs(v: Int): Unit = {
        edges(v) foreach {
          w =>
            if (!visited(v -> w)) {
              res += s"${v + 1} ${w + 1}"
              visited += v -> w
              edges(w) -= v
              dfs(w)
            }
        }
      }

      dfs(0)

      res.foreach(println)
    }
  }

}
