package codejam.year2008.round3

import codejam.FileOp

import scala.annotation.tailrec

/**
 * Created by senyuanwang on 15/5/22.
 */
object C extends App with FileOp {
  override val filePrefix = "src/main/scala/codejam/year2008/round3/C-large-practice"

  type Board = Array[Array[Char]]


  def isBroken(board: Board, i: Int, j: Int) = board(i)(j) == 'x'

  def canCheat(i: Int, j: Int, i1: Int, j1: Int) =
    (i - 1 == i1 && j - 1 == j1) || (i - 1 == i1 && j + 1 == j1) || (i == i1 && j - 1 == j1)

  /**
   * 这个动态规划应该是错的，目前我不是很清楚要怎么搞，以后有机会再回过头来弄清楚
   * @param board
   * @param m
   * @param n
   * @return
   */
  def processByDp(board: Board, m: Int, n: Int): Int = {
    val dp = Array.fill(2)(Array.fill(m * n)(0))

    dp(0)(0) = 0
    dp(1)(0) = if (isBroken(board, 0, 0)) 0 else 1
    for {
      j <- 1 until n
    } {
      dp(0)(j) = dp(1)(j - 1)
      dp(1)(j) = dp(0)(j)
      if (!isBroken(board, 0, j)) {
        dp(1)(j) = dp(1)(j - 1) max (dp(0)(j - 1) + 1)
      }
    }

    for {
      x <- n until m * n
      i = x / n
      j = x % n
    } {
      dp(0)(x) = (x - n - 1 max (i - 1) * n until x).map(dp(1)(_)).max
      dp(1)(x) = dp(0)(x)
      if (!isBroken(board, i, j)) {
        for {
          y <- x - n - 1 max (i - 1) * n until x
          i1 = y / n
          j1 = y % n
        } {
          if (isBroken(board, i1, j1) || canCheat(i, j, i1, j1)) {
            dp(1)(x) = dp(0)(y) + 1 max dp(1)(x)
          } else {
            dp(1)(x) = dp(1)(y) + 1 max dp(1)(x)
          }
        }
      }
    }

    dp(0)(m * n - 1) max dp(1)(m * n - 1)
  }

  val dx = Array(-1, -1, 1, 1)
  val dy = Array(-1, 0, -1, 0)

  def processByBipartiteMatching(board: Board, m: Int, n: Int): Int = {
    var num = 0
    val graph = new Graph(m * n)
    for {
      y <- 0 until m
      x <- 0 until n
      if (board(y)(x) == '.')
    } {
      num += 1
      for {
        k <- 0 until 4
        x2 = x + dx(k)
        y2 = y + dy(k)
        if (x2 >= 0 && x2 < n)
        if (y2 >= 0 && y2 < m)
        if (board(y2)(x2) == '.')
      } {
        graph.addEdge(x * m + y, x2 * m + y2)
      }
    }

    num - graph.bipartiteMatching()
  }

  val T = file.next().toInt

  for {
    t <- 1 to T
  } {
    val line = file.next().split("\\s+").map(_.toInt)
    val m = line(0)
    val n = line(1)
    val board = Array.fill(m)(Array.fill(n)('a'))
    for {
      i <- 0 until m
      cs = file.next().toCharArray
      j <- 0 until n
    } {
      board(i)(j) = cs(j)
    }

    //    val res = processByDp(board, m, n)
    val res = processByBipartiteMatching(board, m, n)
    println(s"Case #$t: $res")
  }
}


class Graph(val size: Int) {
  val g = Array.fill(size)(Nil: List[Int])

  def addEdge(u: Int, v: Int): Unit = {
    require(u < size && u >= 0)
    require(v < size && v >= 0)
    g(u) = v :: g(u)
    g(v) = u :: g(v)
  }

  private def dfs(v: Int, used: Array[Boolean], pair: Array[Int]): Boolean = {
    used(v) = true

    def go(neighbors: List[Int]): Boolean =
      neighbors match {
        case Nil => false
        case u :: tail =>
          val w = pair(u)
          if (w < 0 || !used(w) && dfs(w, used, pair)) {
            pair(v) = u
            pair(u) = v
            true
          } else {
            go(tail)
          }
      }

    go(g(v))
  }

  def bipartiteMatching(): Int = {
    val pair = Array.fill(size)(-1)

    @tailrec
    def travel(v: Int, res: Int): Int =
      if (v >= size) res
      else if (pair(v) < 0 && dfs(v, Array.fill(size)(false), pair)) {
        travel(v + 1, res + 1)
      } else {
        travel(v + 1, res)
      }

    travel(0, 0)
  }
}