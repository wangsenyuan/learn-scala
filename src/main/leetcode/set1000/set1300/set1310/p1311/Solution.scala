package set1000.set1300.set1310.p1311

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def watchedVideosByFriends(watchedVideos: List[List[String]], friends: Array[Array[Int]], id: Int, level: Int): List[String] = {
    val n = watchedVideos.size
    val dp = Array.fill(n)(-1)
    dp(id) = 0
    var end = 0
    val que = Array.ofDim[Int](n)
    que(end) = id
    end += 1
    var front = 0
    while (front < end) {
      val u = que(front)
      front += 1
      friends(u).foreach(v => {
        if (dp(v) < 0) {
          dp(v) = dp(u) + 1
          que(end) = v
          end += 1
        }
      })
    }
    val cnt = mutable.Map.empty[String, Int].withDefaultValue(0)
    (0 until n).filter(i => dp(i) == level).foreach(v => {
      watchedVideos(v).foreach(x => cnt(x) += 1)
    })

    val ps = cnt.toArray
    Sorting.quickSort(ps)(Ordering.fromLessThan((a, b) => {
      a._2 < b._2 || (a._2 == b._2 && a._1 < b._1)
    }))

    ps.map(_._1).toList
  }
}
