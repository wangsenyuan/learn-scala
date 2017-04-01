package codechef.easy.lemusic

import scala.collection.mutable
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

    val sorted = songs.sortBy(_._2)

    var ans = 0L
    val band = mutable.Set.empty[Long]
    i = 0
    while (i < n) {
      band += sorted(i)._1
      ans += (band.size) * sorted(i)._2
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
