package set0000.set900.set910.p913

import scala.collection.mutable

object Solution {
  def catMouseGame(graph: Array[Array[Int]]): Int = {
    val n = graph.length
    val DRAW = 0
    val MOUSE = 1
    val CAT = 2

    val color = Array.ofDim[Int](n, n, 3)
    val degree = Array.ofDim[Int](n, n, 3)

    for {
      m <- 0 until n
      c <- 0 until n
    } {
      degree(m)(c)(1) = graph(m).length
      degree(m)(c)(2) = graph(c).length
      if (graph(c).contains(0)) {
        // cat can't go to hole 0
        degree(m)(c)(2) -= 1
      }
    }

    val que = mutable.Queue.empty[Array[Int]]

    for {
      t <- 1 to 2
      i <- 0 until n
    } {
      color(0)(i)(t) = MOUSE
      que.enqueue(Array(0, i, t, MOUSE))
      if (i > 0) {
        color(i)(i)(t) = CAT
        que.enqueue(Array(i, i, t, CAT))
      }
    }

    def findParentNodes(i: Int, j: Int, t: Int): Array[Array[Int]] = {
      if (t == 2) {
        // current is a CAT move, we need to find mouse move
        for {
          x <- graph(i)
        } yield {
          Array(x, j, 3 - t)
        }
      } else {
        for {
          x <- graph(j)
          if (x > 0)
        } yield {
          Array(i, x, 3 - t)
        }
      }
    }

    while (!que.isEmpty) {
      val cur = que.dequeue()
      val i = cur(0)
      val j = cur(1)
      val t = cur(2)
      val c = cur(3)
      val parents = findParentNodes(i, j, t)

      for {
        parent <- parents
      } {
        val i2 = parent(0)
        val j2 = parent(1)
        val t2 = parent(2)
        // if a MOUSE can move to a MOUSE win state, it would choose it
        if (color(i2)(j2)(t2) == DRAW) {
          if (t2 == c) {
            color(i2)(j2)(t2) = c
            que.enqueue(Array(i2, j2, t2, c))
          } else {
            // still a DRAW
            degree(i2)(j2)(t2) -= 1
            if (degree(i2)(j2)(t2) == 0) {
              // if a MOUSE can't have a way out but only CAT win state
              color(i2)(j2)(t2) = 3 - t2
              que.enqueue(Array(i2, j2, t2, 3 - t2))
            }
          }
        }
      }
    }

    color(1)(2)(1)
  }
}
