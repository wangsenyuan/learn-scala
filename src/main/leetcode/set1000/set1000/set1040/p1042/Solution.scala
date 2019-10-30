package set1000.set1000.set1040.p1042

import scala.collection.mutable.ArrayBuffer

object Solution {
  def gardenNoAdj(N: Int, paths: Array[Array[Int]]): Array[Int] = {
    val outs = Array.ofDim[ArrayBuffer[Int]](N)
    (0 until N).foreach(i => outs(i) = ArrayBuffer.empty[Int])

    for {
      path <- paths
      x = path(0) - 1
      y = path(1) - 1
    } {
      outs(x) += y
      outs(y) += x
    }

    val ans = Array.ofDim[Int](N)
    val que = Array.ofDim[Int](N)

    def bfs(x: Int) = {
      var end = 0

      que(end) = x
      end += 1

      ans(x) = 1


      var front = 0
      while (front < end) {
        val x = que(front)
        front += 1

        for {
          y <- outs(x)
          if ans(y) == 0
        } {
          var flag = 0
          for {
            z <- outs(y)
            if ans(z) > 0
          } {
            flag |= 1 << ans(z)
          }
          // 1, 2, 3, 4
          var j = 1
          while ((flag & (1 << j)) > 0) {
            j += 1
          }
          ans(y) = j
          que(end) = y
          end += 1
        }
      }
    }

    for {
      x <- 0 until N
      if ans(x) == 0
    } {
      bfs(x)
    }


    ans
  }
}
