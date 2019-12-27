package set1000.set1200.set1280.p1284

import scala.collection.mutable.ArrayBuffer

object Solution {
  def minFlips(mat: Array[Array[Int]]): Int = {
    val N = 1 << 10
    val dist = Array.fill(N)(-1)

    val que = Array.ofDim[Int](N)

    val num = toNum(mat)
    dist(num) = 0
    var end = 0
    que(end) = num
    end += 1

    var front = 0
    while (front < end) {
      val cur = que(front)
      front += 1
      val nexts = nextNums(cur, mat)
      for {
        next <- nexts
        if (dist(next) < 0)
      } {
        dist(next) = dist(cur) + 1
        que(end) = next
        end += 1
      }
    }

    dist(0)
  }

  def toNum(mat: Array[Array[Int]]): Int = {
    var res = 0
    var i = 0
    while (i < mat.length) {
      var j = 0
      while (j < mat(i).length) {
        res = res << 1
        res |= mat(i)(j)
        j += 1
      }
      i += 1
    }
    res
  }

  def nextNums(num: Int, mat: Array[Array[Int]]): Array[Int] = {
    var res = num
    var i = mat.length - 1
    while (i >= 0) {
      var j = mat(i).length - 1
      while (j >= 0) {
        mat(i)(j) = res & 1
        res >>= 1
        j -= 1
      }
      i -= 1
    }

    val buf = ArrayBuffer.empty[Int]

    i = 0
    while (i < mat.length) {
      var j = 0
      while (j < mat(i).length) {
        flip(i, j, mat)
        buf += toNum(mat)
        flip(i, j, mat)

        j += 1
      }

      i += 1
    }

    buf.toArray
  }

  val dd = Array(-1, 0, 1, 0, -1)

  private def flip(x: Int, y: Int, mat: Array[Array[Int]]): Unit = {
    mat(x)(y) = 1 - mat(x)(y)

    var i = 0
    while (i < 4) {
      val u = x + dd(i)
      val v = y + dd(i + 1)
      if (u >= 0 && u < mat.length && v >= 0 && v < mat(u).length) {
        mat(u)(v) = 1 - mat(u)(v)
      }
      i += 1
    }
  }
}
