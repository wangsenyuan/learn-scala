package codechef.easy.kingcon

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/2/25.
  */
object Main {

  def getArticulationPoints(cities: Array[Seq[Int]], n: Int): Int = {
    val parent = Array.fill(n)(-1)
    val low = Array.fill(n)(2 * n)
    val depth = Array.fill(n)(0)
    val articulation = Array.fill(n)(false)
    val visited = Array.fill(n)(false)

    def dfs(v: Int, d: Int): Unit = {
      visited(v) = true
      depth(v) = d
      low(v) = d
      var childCnt = 0
      var isArticulation = false

      cities(v) foreach {
        w =>
          if (!visited(w)) {
            parent(w) = v
            dfs(w, d + 1)
            childCnt += 1

            isArticulation ||= (low(w) >= depth(v))

            low(v) = low(v) min low(w)
          } else if (w != parent(v)) {
            low(v) = low(v) min depth(w)
          }
      }

      articulation(v) = ((parent(v) != -1 && isArticulation) || (parent(v) == -1 && childCnt > 1))
    }

    dfs(0, 0)

    articulation.count(identity)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        val n = line(0)
        val m = line(1)
        val k = line(2)
        val cities = Array.fill(n)(Seq.empty[Int])

        (0 until m) foreach {
          _ =>
            val road = StdIn.readLine().split("\\s+").map(_.toInt)
            val a = road(0)
            val b = road(1)
            cities(a) = cities(a) :+ b
            cities(b) = cities(b) :+ a
        }

        val cnt = getArticulationPoints(cities, n)

        println(cnt * k)
    }

  }
}
