package codejam.year2016.round3.c

import codejam.year2016.round3.c.Small.Asteroid

import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/10/2016.
  */
object Large extends App {

  var T = StdIn.readInt

  var t = 1

  def jump(asteroids: Vector[Asteroid]) = ???

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

    def away(that: Asteroid): Int = {
      square(this.x - that.x) + square(this.y - that.y) + square(this.z - that.z)
    }
  }

  object Asteroid {
    def apply(str: String): Asteroid = {
      val parts = str.split("\\s+").map(_.toInt)
      Asteroid(parts(0), parts(1), parts(2), parts(3), parts(4), parts(5))
    }
  }

  case class Distance(val a: Int, val b: Int, val d: Int)

}
