package set1000.set1300.set1320.p1320

import scala.collection.mutable

object Solution {
  def minimumDistance(word: String): Int = {
    val keyboard = Array("ABCDEF", "GHIJKL", "MNOPQR", "STUVWX", "YZ")

    val pos = Array.ofDim[(Int, Int)](26)

    for {
      i <- 0 until keyboard.length
      j <- 0 until keyboard(i).length
    } {
      val x = keyboard(i)(j) - 'A'
      pos(x) = i -> j
    }

    def getDist(i: Int, j: Int): Int = {
      val x = word(i) - 'A'
      val y = word(j) - 'A'
      (pos(x)._1 - pos(y)._1).abs + (pos(x)._2 - pos(y)._2).abs
    }

    val n = word.length
    //    val INF = 1 << 20

    val pq = mutable.PriorityQueue.empty[Item](Ordering.fromLessThan((a, b) => a.d > b.d))

    pq.enqueue(Item(0, 0, 0))

    while (pq.size > 0) {
      val cur = pq.dequeue()
      if (cur.x == n || cur.y == n) {
        return cur.d
      }

      val nxt = (cur.x max cur.y) + 1

      if (cur.x > 0) {
        val d1 = getDist(cur.x - 1, nxt - 1) + cur.d
        pq.enqueue(Item(nxt, cur.y, d1))
      } else {
        pq.enqueue(Item(nxt, cur.y, cur.d))
      }

      if (cur.y > 0) {
        val d2 = getDist(cur.y - 1, nxt - 1) + cur.d
        pq.enqueue(Item(cur.x, nxt, d2))
      } else {
        pq.enqueue(Item(cur.x, nxt, cur.d))
      }
    }

    0
  }

  case class Item(x: Int, y: Int, d: Int)

}
