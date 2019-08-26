package set0000.set700.set750.p752

import scala.collection.mutable.ArrayBuffer

object Solution {
  def openLock(deadends: Array[String], target: String): Int = {
    val blocks = deadends.map(toNum).toSet
    if(blocks(0)) {
      return -1
    }

    val res = toNum(target)

    val que = Array.ofDim[Int](10000)
    val dist = Array.fill(10000)(-1)
    val arr = Array.ofDim[Int](4)
    var front = 0
    var end = 0
    que(end) = 0
    end += 1
    dist(0) = 0
    while(front < end) {
      val cur = que(front)
      front += 1
      if(cur == res) {
        return dist(cur)
      }

      val nexts = turn(cur, arr)
      nexts.foreach(next => {
        if(!blocks(next) && dist(next) == -1) {
          dist(next) = dist(cur) + 1
          que(end) = next
          end += 1
        }
      })
    }

    return -1
  }

  private def toNum(s: String): Int = s.toInt

  private def toNum(arr: Array[Int]): Int = {
    arr(0) * 1000 + arr(1) * 100 + arr(2) * 10 + arr(3)
  }

  private def turn(cur: Int, arr: Array[Int]): Array[Int] = {
    arr(0) = cur / 1000
    arr(1) = (cur % 1000) / 100
    arr(2) = (cur % 100) / 10
    arr(3) = cur % 10

    val res = ArrayBuffer.empty[Int]

    var i = 0
    while(i < 4) {
      val x = arr(i)

      if(x == 0) {
        arr(i) = 9
      } else {
        arr(i) = x - 1
      }

      res += toNum(arr)

      if(x == 9) {
        arr(i) = 0
      } else {
        arr(i) = x + 1
      }

      res += toNum(arr)

      arr(i) = x

      i += 1
    }

    res.toArray
  }
}
