package com.me.problem.ramdom.walk

import codejam.gauss.jordan.GaussJordan

import scala.io.Source

/**
 * Created by senyuanwang on 15/5/28.
 */
object App extends App with GaussJordan {

  val dx = Array(-1, 1, 0, 0)
  val dy = Array(0, 0, -1, 1)

  def randomWalk(grid: Array[Array[Char]], n: Int, m: Int): Double = {
    val canGoal = Array.fill(n, m)(false)

    def dfs(x: Int, y: Int): Unit = {
      canGoal(x)(y) = true
      for {
        i <- 0 until dx.length
        nx = x + dx(i)
        if (nx >= 0 && nx < n)
        ny = y + dy(i)
        if (ny >= 0 && ny < m)
        if (!canGoal(nx)(ny))
        if (grid(nx)(ny) != '#')
      } {
        dfs(nx, ny)
      }
    }

    dfs(n - 1, m - 1)

    val a = Array.fill(n * m, n * m)(0d)
    val b = Array.fill(n * m)(0d)
    for {
      x <- 0 until n
      y <- 0 until m
    } {
      if (x == n - 1 && y == m - 1 || !canGoal(x)(y)) {
        a(x * m + y)(x * m + y) = 1
      } else {
        var move = 0
        for {
          k <- 0 until dx.length
          nx = x + dx(k)
          ny = y + dy(k)
          if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid(nx)(ny) == '.')
        } {
          a(x * m + y)(nx * m + ny) = -1
          move += 1
        }

        b(x * m + y) = move
        a(x * m + y)(x * m + y) = move
      }
    }

    (solve(a, b).get)(0)
  }


  val input = Source.fromFile("src/main/scala/com/me/problem/ramdom/walk/radom_walk.1.test").getLines()
  val fileLine = input.next().split("\\s+").map(_.toInt)
  val n = fileLine(0)
  val m = fileLine(1)
  val grid = Array.fill(n, m)(' ')
  for {
    i <- 0 until n
    line = input.next()
    j <- 0 until m
  } {
    grid(i)(j) = line(j)
  }

  val res = randomWalk(grid, n, m)
  println(f"$res%.8f")
}
