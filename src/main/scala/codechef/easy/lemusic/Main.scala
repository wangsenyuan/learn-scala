package codechef.easy.lemusic

import scala.io.StdIn

/**
  * Created by wangsenyuan on 01/04/2017.
  */
object Main {

  def solve() = {
    val n = StdIn.readInt()
    val songs = Array.fill[(Long, Long)](n)(null)

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toLong)

      songs(i) = (line(0), line(1))

      i += 1
    }

    val sorted = songs.sortWith(
      (a, b) => (a._1 < b._1 || (a._1 == b._1 && a._2 < b._2))
    )
    var first = Vector.empty[Long]
    var ans = 0L

    i = 0
    while (i < n) {
      if (i == 0 || sorted(i)._1 > sorted(i - 1)._1) {
        first :+= sorted(i)._2
      } else {
        ans += sorted(i)._2
      }
      i += 1
    }

    val m = first.size
    ans *= m

    val sf = first.sorted
    i = 0
    while (i < m) {
      ans += (i + 1) * sf(i)
      i += 1
    }

    println(ans)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve()
    }
  }
}
