package codechef.easy.collide

import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/05/2017.
  */
object Main {

  case class Planet(x: Int, y: Int, dir: Char) {
  }

  object Planet {
    def apply(line: String): Planet = {
      val parts = line.split("\\s+")
      val x = parts(0).toInt
      val y = parts(1).toInt
      val d = parts(2)
      Planet(x, y, d(0))
    }
  }

  def whenCollide(a: Planet, b: Planet): Double = {
    if (a.dir == 'U' && b.dir == 'D' && a.x == b.x && a.y < b.y) {
      0.5 * (b.y - a.y)
    } else if (a.dir == 'D' && b.dir == 'U' && a.x == b.x && a.y > b.y) {
      0.5 * (a.y - b.y)
    } else if (a.dir == 'R' && b.dir == 'L' && a.y == b.y && a.x < b.x) {
      0.5 * (b.x - a.x)
    } else if (a.dir == 'L' && b.dir == 'R' && a.y == b.y && a.x > b.x) {
      0.5 * (a.x - b.x)
    } else if ((a.x - b.x).abs == (a.y - b.y).abs) {
      if ((a.dir == 'R' && b.x > a.x) || (a.dir == 'L' && b.x < a.x)) {
        if ((b.dir == 'U' && a.y > b.y) || (b.dir == 'D' && a.y < b.y)) {
          (a.x - b.x).abs.toDouble
        } else {
          -1.0
        }
      } else if ((a.dir == 'U' && b.y > a.y) || (a.dir == 'D' && b.y < a.y)) {
        if ((b.dir == 'R' && b.x < a.x) || (b.dir == 'L' && b.x > a.x)) {
          (b.y - a.y).abs.toDouble
        } else {
          -1.0
        }
      } else {
        -1.0
      }
    } else {
      -1.0
    }
  }

  def solve() = {
    val earth = Planet(StdIn.readLine())
    var res = -1.0
    val n = StdIn.readInt()
    var i = 0
    while (i < n) {
      val asteroid = Planet(StdIn.readLine())
      val tmp = whenCollide(earth, asteroid)
      if (res < 0 || (tmp > 0 && tmp < res)) {
        res = tmp
      }

      i += 1
    }

    if (res < 0) {
      println("SAFE")
    } else {
      println(f"$res%.1f")
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
