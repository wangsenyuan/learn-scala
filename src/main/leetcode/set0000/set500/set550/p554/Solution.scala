package set0000.set500.set550.p554

import scala.collection.mutable

object Solution {
  def leastBricks(wall: List[List[Int]]): Int = {
    val map = mutable.Map.empty[Int, Int].withDefaultValue(0)

    for {
      row <- wall
    } {
      val all = row.sum
      var sum = 0
      row.foreach(x => {
        sum += x
        if(sum < all) {
          map.put(sum, map(sum) + 1)
        }
      })
    }

    val n = wall.size
    var ans = n

    for {
      (_, v) <- map
    } {
      ans = ans min (n - v)
    }

    ans
  }

  def leastBricks1(wall: List[List[Int]]): Int = {
    val n = wall.length
    if (n == 0) {
      0
    } else {
      val total = wall.head.sum

      def go(ans: Int, ps: List[Int], ws: List[List[Int]]): Int = {
        val mm = ps.min
        if (mm == total) {
          ans
        } else {
          val tmp = n - ps.count(_ == mm)
          val xx = ps.zip(ws)
          val qs = xx.map {
            case (q, w) if q == mm =>
              q + w.head
            case (q, _) => q
          }

          val vs = xx.map {
            case (q, w) if q == mm => w.tail
            case (_, w) => w
          }

          go(tmp min ans, qs, vs)
        }
      }

      val ps = wall.map(_.head)
      val ws = wall.map(_.tail)

      go(n, ps, ws)
    }
  }
}
