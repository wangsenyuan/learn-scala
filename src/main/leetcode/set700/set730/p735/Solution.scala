package set700.set730.p735

import scala.collection.mutable.ArrayBuffer

object Solution {
  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    val n = asteroids.length
    val stack = Array.ofDim[Int](n)
    var p = 0
    val res = ArrayBuffer.empty[Int]

    var i = 0
    while (i < n) {
      if (asteroids(i) < 0) {
        val v = -asteroids(i)
        while (p > 0 && stack(p - 1) < v) {
          p -= 1
        }

        if (p == 0) {
          // all destroyed by this
          res += asteroids(i)
        } else if (stack(p - 1) == v) {
          p -= 1
        } else {
          // this asteroid is destroyed by stack(p - 1)
        }
      } else {
        stack(p) = asteroids(i)
        p += 1
      }

      i += 1
    }

    res ++= stack.take(p)

    res.toArray
  }
}
