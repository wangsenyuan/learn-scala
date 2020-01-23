package set1000.set1300.set1320.p1320

import scala.collection.mutable

object Solution {

  private def getDist(a: Char, b: Char): Int = {
    val x = a - 'A'
    val y = b - 'A'

    distance(x, y)
  }

  private def distance(x: Int, y: Int): Int = {
    if (x < 0 || y < 0) {
      0
    } else {
      (x / 6 - y / 6).abs + (x % 6 - y % 6).abs
    }
  }

  val INF = 1 << 20

  def minimumDistance(word: String): Int = {
    val dp = Array.ofDim[Int](26)
    var save = 0
    var res = 0
    var i = 0
    while (i < word.length - 1) {
      val b = word(i)
      val c = word(i + 1)

      for {
        a <- 0 until 26
      } {
        dp(b - 'A') = dp(b - 'A') max (dp(a) + getDist(b, c) - getDist((a + 'A').toChar, c))
      }

      save = save max dp(b - 'A')

      res += getDist(b, c)
      i += 1
    }

    res - save
  }

  def minimumDistance2(word: String): Int = {
    var dp = mutable.Map.empty[(Int, Int), Int].withDefaultValue(INF)

    dp += (-1, (word(0) - 'A')) -> 0

    var i = 1
    while (i < word.length) {
      val x = word.charAt(i) - 'A'
      val dp2 = mutable.Map.empty[(Int, Int), Int].withDefaultValue(INF)
      for {
        (a, b) <- dp.keys
      } {
        dp2(a -> x) = dp2(a -> x) min (dp(a -> b) + distance(b, x))
        dp2(x -> b) = dp2(b -> x) min (dp(a -> b) + distance(a, x))
      }
      dp = dp2
      i += 1
    }

    dp.values.min
  }

  def minimumDistance1(word: String): Int = {

    val n = word.length

    val pq = mutable.PriorityQueue.empty[Item](Ordering.fromLessThan((a, b) => a.d > b.d))

    pq.enqueue(Item(0, 0, 0))

    while (pq.size > 0) {
      val cur = pq.dequeue()
      if (cur.x == n || cur.y == n) {
        return cur.d
      }

      val nxt = (cur.x max cur.y) + 1

      if (cur.x > 0) {
        val d1 = getDist(word.charAt(cur.x - 1), word.charAt(nxt - 1)) + cur.d
        pq.enqueue(Item(nxt, cur.y, d1))
      } else {
        pq.enqueue(Item(nxt, cur.y, cur.d))
      }

      if (cur.y > 0) {
        val d2 = getDist(word.charAt(cur.y - 1), word.charAt(nxt - 1)) + cur.d
        pq.enqueue(Item(cur.x, nxt, d2))
      } else {
        pq.enqueue(Item(cur.x, nxt, cur.d))
      }
    }

    0
  }

  case class Item(x: Int, y: Int, d: Int)

}
