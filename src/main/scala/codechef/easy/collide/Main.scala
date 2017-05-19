package codechef.easy.collide

import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/05/2017.
  */
object Main {

  def findDir(s: String) = s match {
    case "U" => 0
    case "D" => 2
    case "R" => 1
    case _ => 3
  }

  case class Planet(x: Int, y: Int, dir: Int) {
    def isMovingAlongY(): Boolean = {
      dir == 0 || dir == 2
    }

    def isMovingAlongX(): Boolean = {
      !isMovingAlongY()
    }

    def sign: Int = {
      if (dir == 0 || dir == 1) {
        1
      } else {
        -1
      }
    }
  }

  object Planet {
    def apply(line: String): Planet = {
      val parts = line.split("\\s+")
      val x = parts(0).toInt
      val y = parts(1).toInt
      val d = parts(2)
      Planet(x, y, findDir(d))
    }
  }

  def whenCollide(earth: Planet, asteroid: Planet): Double = {
    if (earth.dir == asteroid.dir) {
      -1.0
    } else if (earth.isMovingAlongY() && asteroid.isMovingAlongY()) {
      if (earth.x != asteroid.x) {
        -1.0
      } else if (earth.y > asteroid.y && earth.sign > 0) {
        -1.0
      } else if (earth.y < asteroid.y && earth.sign < 0) {
        -1.0
      } else {
        0.5 * (earth.y - asteroid.y).abs
      }
    } else if (earth.isMovingAlongX() && asteroid.isMovingAlongX()) {
      if (earth.y != asteroid.y) {
        -1.0
      } else if (earth.x > asteroid.x && earth.sign > 0) {
        -1.0
      } else if (earth.x < asteroid.x && earth.sign < 0) {
        -1.0
      } else {
        0.5 * (earth.x - asteroid.x).abs
      }
    } else if (earth.isMovingAlongY()) {
      val t = asteroid.sign * (earth.x - asteroid.x)
      if (t > 0 && earth.y + earth.sign * t == asteroid.y) {
        t.toDouble
      } else {
        -1.0
      }
    } else {
      val t = asteroid.sign * (earth.y - asteroid.y)
      if (t > 0 && earth.x + earth.sign * t == asteroid.x) {
        t.toDouble
      } else {
        -1.0
      }
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
      if (res < 0 || tmp < res) {
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
