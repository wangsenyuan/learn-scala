package set700.set740.p743

import scala.collection.mutable.ArrayBuffer

object Solution {
  def networkDelayTime(times: Array[Array[Int]], N: Int, K: Int): Int = {
    val outs = Array.ofDim[ArrayBuffer[Int]](N)
    (0 until N) foreach (i => outs(i) = ArrayBuffer.empty[Int])

    times foreach {
      case time => {
        val u = time(0) - 1
        val v = time(1) - 1
        val w = time(2)
        outs(u) += v
        outs(u) += w
      }
    }

    val items = Array.fill[Item](N)(null)
    val dist = Array.fill(N)(Int.MaxValue)
    val pq = new PQ(N)

    (0 until N) foreach (i => items(i) = pq.add(i))

    dist(K - 1) = 0

    pq.update(items(K - 1).index, K - 1, 0)

    while (pq.size > 0) {
      val cur = pq.pop()
      val u = cur.value
      val d = dist(u)
      if (d < Int.MaxValue) {
        var i = 0
        while (i < outs(u).length) {
          val v = outs(u)(i)
          val w = outs(u)(i + 1)
          if (dist(v) > d + w) {
            dist(v) = dist(u) + w
            pq.update(items(v).index, v, dist(v))
          }
          i += 2
        }
      }
    }

    val res = dist.max
    if (res == Int.MaxValue) {
      -1
    } else {
      res
    }
  }

  class Item(val value: Int) {
    var index = -1
    var priority = Int.MaxValue
  }

  class PQ(n: Int) {
    val arr = Array.ofDim[Item](n + 1)
    var sz = 1

    def add(x: Int): Item = {
      val item = new Item(x)
      arr(sz) = item
      swim(sz)
      sz += 1
      item
    }

    private def swim(pos: Int): Unit = {
      val item = arr(pos)
      var i = pos
      while (i > 1 && (arr(i >> 1).priority) > item.priority) {
        arr(i) = arr(i >> 1)
        arr(i).index = i
        i >>= 1
      }
      arr(i) = item
      arr(i).index = i
    }

    private def sink(pos: Int): Unit = {
      val item = arr(pos)
      var i = pos
      while ((i << 1) < sz && (arr(i << 1).priority < item.priority || ((i << 1 | 1) < sz && arr(i << 1 | 1).priority < item.priority))) {
        val left = i << 1
        val right = left + 1
        if (right < sz && arr(left).priority > arr(right).priority) {
          arr(i) = arr(right)
          arr(i).index = i
          i = right
        } else {
          arr(i) = arr(left)
          arr(i).index = i
          i = left
        }
      }
      arr(i) = item
      arr(i).index = i
    }

    def pop(): Item = {
      val head = arr(1)
      sz -= 1
      if (sz > 1) {
        val last = arr(sz)
        arr(1) = last
        arr(1).index = 1
        arr(sz) = null
        sink(1)
      }

      head.index = -1
      head
    }

    def update(index: Int, v: Int, p: Int): Item = {
      val item = arr(index)
      item.priority = p
      swim(index)
      item
    }

    def size = sz - 1

    def check(): Boolean = {

      def loop(i: Int): Boolean = {
        if (i >= sz) {
          true
        } else if ((i << 1) < sz && arr(i).priority > arr(i << 1).priority) {
          false
        } else if ((i * 2 + 1) < sz && arr(i).priority > arr(2 * i + 1).priority) {
          false
        } else {
          loop(i << 1) && loop((i << 1) | 1)
        }
      }

      loop(1)
    }
  }


}
