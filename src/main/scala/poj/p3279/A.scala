package poj.p3279

import scala.io.{Source, StdIn}

/**
 * Created by senyuanwang on 15/4/19.
 */
object A extends App {

  val neighbors = Array((-1, 0), (0, -1), (0, 0), (0, 1), (1, 0))

  def flipTile(grid: Array[Array[Int]], flip: Array[Array[Int]]): Option[Int] = {
    val m = grid.length
    val n = grid(0).length

    def get(i: Int, j: Int): Int = {
      var c = grid(i)(j)

      for {
        k <- 0 until neighbors.length
        x = neighbors(k)._1 + i
        y = neighbors(k)._2 + j
      } {
        if (x >= 0 && x < m && y >= 0 && y < n) {
          c += flip(x)(y)
        }
      }
      c % 2
    }

    for {
      i <- 1 until m
      j <- 0 until n
    } {
      if (get(i - 1, j) > 0) {
        flip(i)(j) = 1
      }
    }
    val valid = (0 until n).foldLeft(true) {
      (flag, idx) =>
        flag && get(m - 1, idx) == 0
    }

    if (valid) {
      Some {
        var res = 0
        for {
          i <- 0 until m
          j <- 0 until n
        } {
          res += flip(i)(j)
        }
        res
      }
    } else {
      None
    }
  }

  def solve(grid: Array[Array[Int]]): Option[Array[Array[Int]]] = {
    var theFlip: Option[Array[Array[Int]]] = None
    val n = grid(0).length
    var res: Option[Int] = Some(grid.length * n)
    for {
      i <- 0 until (1 << n)
    } {
      val flip = Array.fill(grid.length, n)(0)
      for {
        j <- 0 until n
      } {
        flip(0)(n - j - 1) = (i >> j) & 1
      }

      val got = flipTile(grid, flip)

      for {
        x <- got
        y <- res
        if (x < y)
      } {
        theFlip = Some(flip)
        res = Some(x)
      }
    }

    theFlip
  }

  val file = Source.fromFile("src/main/scala/poj/p3279/console.in").getLines()
  val firstLine = file.next().split("\\s+").map(_.toInt)
  val m = firstLine(0)
  val n = firstLine(1)

  val grid = Array.fill(m, n)(0)
  for {
    i <- 0 until m
  } {
    val line = file.next().split("\\s+").map(_.toInt)
    for {
      j <- 0 until n
    } {
      grid(i)(j) = line(j)
    }
  }

  solve(grid) match {
    case None => println("IMPOSSIBLE")
    case Some(flip) =>
      flip.foreach {
        array =>
          println(array.mkString(" "))
      }
  }
}
