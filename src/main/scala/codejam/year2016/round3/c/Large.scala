package codejam.year2016.round3.c

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 20/10/2016.
  */
object Large extends App {


  val INF = 1e10
  val PRECISION: Double = 1e-5

  //println(INF)
  //println(PRECISION)


  var T = StdIn.readInt

  var t = 1

  while (t <= T) {
    val ns = StdIn.readLine().split("\\s+").map(_.toInt)

    val n = ns(0)
    val s = ns(1)
    var asteroids = Vector.empty[Asteroid]

    var i = 0
    while (i < n) {
      asteroids :+= Asteroid(StdIn.readLine())
      i += 1
    }

    val r = jump(asteroids, s)

    println(f"Case #$t: $r%.8f")

    t += 1
  }

  case class Asteroid(x: Int, y: Int, z: Int, vx: Int, vy: Int, vz: Int)

  object Asteroid {
    def apply(str: String): Asteroid = {
      val parts = str.split("\\s+").map(_.toInt)
      Asteroid(parts(0), parts(1), parts(2), parts(3), parts(4), parts(5))
    }
  }

  implicit class IntOp(val x: Int) extends AnyVal {
    def **(power: Int) = {
      var i = 1
      var y = x
      while (i < power) {
        y *= x
        i += 1
      }
      y
    }
  }

  def jump(asteroids: Vector[Asteroid], s: Int): Double = {
    val n = asteroids.length

    val open = Array.fill(n, n)(0.0d)
    val close = Array.fill(n, n)(0.0d)

    def calculateOpenAndCloseTime(x: Double) = {
      for {
        i <- 0 until n
        pi = asteroids(i)
        j <- i + 1 until n
        pj = asteroids(j)
      } {
        val dp = Vector(pi.x - pj.x, pi.y - pj.y, pi.z - pj.z)
        val dv = Vector(pi.vx - pj.vx, pi.vy - pj.vy, pi.vz - pj.vz)
        val a = dv(0) ** 2 + dv(1) ** 2 + dv(2) ** 2
        val b = 2 * (dv(0) * dp(0) + dv(1) * dp(1) + dv(2) * dp(2))
        val c = dp(0) ** 2 + dp(1) ** 2 + dp(2) ** 2
        val d = 1.0d * (b ** 2 - 4 * a * (c - x))
        open(i)(j) = INF
        close(i)(j) = INF
        if (a == 0) {
          if (c <= x) {
            open(i)(j) = 0.0d
          }
        } else if (d >= 0) {
          open(i)(j) = (-b - Math.sqrt(d)) / 2.0 / a
          close(i)(j) = (-b + Math.sqrt(d)) / 2.0 / a
        }

        open(j)(i) = open(i)(j)
        close(j)(i) = close(i)(j)
      }
    }

    def check(x: Double): Boolean = {
      calculateOpenAndCloseTime(x)

      val stayBegin = Array.fill(n)(INF)
      val stayEnd = Array.fill(n)(INF)
      stayBegin(0) = 0.0d
      stayEnd(0) = s
      val q = new mutable.Queue[Int]()
      q.enqueue(0)
      var reachDestination = false
      while (!q.isEmpty && !reachDestination) {
        val i = q.dequeue()
        reachDestination = i == 1
        if (!reachDestination) {
          for {
            j <- 0 until n
            if i != j && open(i)(j) < close(i)(j)
            left = stayBegin(i) max open(i)(j)
            right = stayEnd(i) min close(i)(j)
            if left <= right
          } {
            if (j == 1) {
              q.enqueue(j)
            } else if (left < stayBegin(j) || close(i)(j) + s > stayEnd(j)) {
              stayBegin(j) = left min stayBegin(j)
              stayEnd(j) = close(i)(j) + s max stayEnd(j)
              q.enqueue(j)
            }
          }
        }
      }

      reachDestination
    }

    var left = 0.0d
    var right = INF
    val times = math.log10((right - left) / PRECISION / PRECISION) / math.log10(2)+ 1

    var i = 0
    while (i < times) {
      val mid = left + (right - left) / 2.0d
      if (check(mid)) {
        right = mid
      } else {
        left = mid
      }
      i += 1
    }

    math.sqrt(right)
  }
}
