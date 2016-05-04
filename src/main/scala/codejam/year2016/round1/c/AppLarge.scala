package codejam.year2016.round1.c

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/4/16.
  */
object AppLarge extends App {

  def findLoop(path: Vector[Int], v: Int) = {
    val at = path.indexOf(v)
    path.length - at
  }

  def play(n: Int, f: Array[Int]): Int = {

    def dfs(v: Int, path: Vector[Int], visited: Array[Int]): (Int, Int) = {
      visited(v) = 1
      val w = f(v)
      if (visited(w) == 1) {
        (path.length, findLoop(path, w))
      } else {
        dfs(w, path ++ Vector(w), visited)
      }
    }

    val visited = Array.fill(n)(0)

    var cycle2CompoentSize = 0
    var cycle3PCompnentMax = 0
    for {
      i <- 0 until n
      if visited(i) == 0
    } {
      val (path, cycle) = dfs(i, Vector(i), visited)
      if (cycle > 2) {
        cycle3PCompnentMax = cycle3PCompnentMax max path
      } else {
        cycle2CompoentSize += path
      }
    }

    cycle2CompoentSize max cycle3PCompnentMax
  }

  var T = StdIn.readLine().toInt

  for {
    i <- 1 to T
  } {
    val n = StdIn.readLine().toInt
    val friends = StdIn.readLine().split("\\s+").map(_.toInt - 1)
    val r = play(n, friends)
    println(s"Case #$i: $r")
  }
}
