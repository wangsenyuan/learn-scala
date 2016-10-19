package codejam.year2016.round3.c

import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/10/2016.
  */
object Small extends App {

  var T = StdIn.readInt

  var t = 1

  while (t <= T) {
    val ns = StdIn.readLine().split("\\s+").map(_.toInt)

    val n = ns(0)
    //val s = ns(1)
    var asteroids = Vector.empty[Asteroid]

    var i = 0
    while (i < n) {
      asteroids :+= Asteroid(StdIn.readLine())
      i += 1
    }

    val r = jump(asteroids)

    println(f"Case #$t: $r%.8f")

    t += 1
  }

  case class Asteroid(x: Int, y: Int, z: Int, vx: Int, vy: Int, vz: Int) {
    private def square(d: Int) = d * d

    private def sqrt(d: Int) = math.sqrt(d.toDouble)

    def away(that: Asteroid): Double = {
      sqrt(square(this.x - that.x) + square(this.y - that.y) + square(this.z - that.z))
    }
  }

  object Asteroid {
    def apply(str: String): Asteroid = {
      val parts = str.split("\\s+").map(_.toInt)
      Asteroid(parts(0), parts(1), parts(2), parts(3), parts(4), parts(5))
    }
  }

  case class Distance(val a: Int, val b: Int, val d: Double)

  private def distance(asteroids: Vector[Asteroid]) = {
    val ai = asteroids.zipWithIndex
    ai.flatMap {
      case (a, i) =>
        ai.map {
          case (b, j) => Distance(i, j, a away b)
        }
    }.sortBy(_.d).dropWhile(_.d == 0.0d)
  }

  class UF(n: Int) {
    val arr = Array.fill(n)(-1)

    def find(v: Int): Int = {
      if (arr(v) == -1) {
        arr(v) = v
      } else if (arr(v) != v) {
        arr(v) = find(arr(v))
      }
      arr(v)
    }

    def union(v: Int, w: Int): Int = {
      val a = find(v)
      val b = find(w)
      if (a != b) {
        arr(a) = b
      }

      b
    }
  }

  def jump(asteroids: Vector[Asteroid]): Double = {
    val ds = distance(asteroids)

    def check(d: Double): Boolean = {
      val uf = new UF(asteroids.length)
      ds.takeWhile(_.d <= d).foreach {
        x => uf.union(x.a, x.b)
      }

      uf.find(0) == uf.find(1)
    }


    var i = 0
    var j = ds.length - 1
    while (i <= j) {
      val mid = i + (j - i) / 2
      val x = ds(mid).d
      if (check(x)) {
        j = mid - 1
      } else {
        i = mid + 1
      }
    }
    ds(j + 1).d
  }


}
