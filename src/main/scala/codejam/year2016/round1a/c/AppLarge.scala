package codejam.year2016.round1a.c

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/4/16.
  */
object AppLarge extends App {


  def play(n: Int, f: Array[Int]): Int = {
    val fr = Array.fill(n)(Nil: List[Int])

    for {
      i <- 0 until n
    } {
      fr(f(i)) = i :: fr(f(i))
    }


    def loop(i: Int, path: Vector[Int]): Int = {
      val index = path.indexOf(i)
      if (index >= 0) {
        path.length - index
      } else {
        loop(f(i), path :+ i)
      }
    }

    val r1 = (0 until n).foldLeft(0) {
      (x, i) => x max loop(f(i), Vector(i))
    }

    def dfs(i: Int, p: Int, length: Int): Int = {
      fr(i).foldLeft(length) {
        (l, j) =>
          if (p != j) {
            l max dfs(j, i, length + 1)
          } else {
            l
          }
      }
    }

    val r2 = (0 until n).filter(i => i == f(f(i))).map {
      i =>
        dfs(f(i), i, 0) + 1
    }.sum

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
