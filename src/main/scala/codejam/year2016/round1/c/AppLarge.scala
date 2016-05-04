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

    val p = Array.fill(n)(-1)
    val c = Array.fill(n)(0)
    var pi = 0
    def dfs(v: Int, path: Vector[Int]): Int = {
      if (p(v) >= 0) {
        p(v)
      } else {
        val w = f(v)
        if (path.contains(w)) {
          p(v) = pi
          c(pi) = findLoop(path, w)
          pi += 1
          p(v)
        } else {
          p(v) = dfs(w, path ++ Vector(w))
          p(v)
        }
      }
    }

    for {
      i <- 0 until n
      if p(i) < 0
    } {
      dfs(i, Vector(i))
    }

    val r1 = p.max
    val r2 = p.filter(c(_) == 2).sum
    r1 max r2
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
