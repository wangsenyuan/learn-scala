package set0000.set900.set900.p909

import scala.collection.mutable

object Solution {
  def snakesAndLadders(board: Array[Array[Int]]): Int = {
    val (rm, mm) = precompute(board)
    val n = board.length
    val N = n * n

    val dist = Array.fill(n, n)(-1)

    val que = Array.ofDim[Int](N)
    var end = 0
    if (board(n - 1)(0) < 0) {
      dist(n - 1)(0) = 0
      que(end) = (n - 1) * n
      end += 1
    } else {
      val (u, v) = mm(board(n - 1)(0))
      dist(u)(v) = 0
      que(end) = u * n + v
      end += 1
    }

    val vis = Array.ofDim[Boolean](n, n)

    var front = 0
    while (front < end) {
      val cur = que(front)
      front += 1

      val x = cur / n
      val y = cur % n

      if (!vis(x)(y)) {
        vis(x)(y) = true
        val pos = rm(x)(y)
        var k = 1
        while (pos + k <= N && k <= 6) {

          val (u, v) = mm(pos + k)

          if (board(u)(v) > 0) {
            val (a, b) = mm(board(u)(v))
            if (dist(a)(b) < 0 || dist(a)(b) > dist(x)(y) + 1) {
              dist(a)(b) = dist(x)(y) + 1
              que(end) = a * n + b
              end += 1
            }
          } else if (dist(u)(v) < 0 || dist(u)(v) > dist(x)(y) + 1) {
            dist(u)(v) = dist(x)(y) + 1
            que(end) = u * n + v
            end += 1
          }

          k += 1
        }
      }

    }


    dist(mm(N)._1)(mm(N)._2)
  }

  private def precompute(board: Array[Array[Int]]): (Array[Array[Int]], Array[(Int, Int)]) = {
    val n = board.length
    val N = n * n

    val mm = Array.ofDim[(Int, Int)](N + 1)
    val rm = Array.fill(n, n)(-1)

    var a = n - 1
    var b = 0
    var xx = 1
    while (xx <= N) {
      mm(xx) = a -> b
      rm(a)(b) = xx

      if ((n - a) % 2 == 1) {
        // left to right
        b += 1
        if (b == n) {
          b = n - 1
          a -= 1
        }
      } else {
        // right to left
        b -= 1
        if (b < 0) {
          b = 0
          a -= 1
        }
      }

      xx += 1
    }
    (rm, mm)
  }

  def snakesAndLadders1(board: Array[Array[Int]]): Int = {
    val n = board.length
    val N = n * n

    val (rm, mm) = precompute(board)

    val dist = Array.fill(n, n)(-1)
    dist(n - 1)(0) = 0
    val pq = mutable.PriorityQueue.empty[Node](Ordering.fromLessThan((a, b) => a.d > b.d))

    if (board(n - 1)(0) > 0) {
      val (u, v) = mm(board(n - 1)(0))
      dist(u)(v) = 0
      pq.enqueue(Node(u, v, dist(u)(v)))
    } else {
      pq.enqueue(Node(n - 1, 0, 0))
    }

    val vis = Array.ofDim[Boolean](n, n)

    while (!pq.isEmpty) {
      val node = pq.dequeue()
      val x = node.x
      val y = node.y
      if (!vis(x)(y)) {
        vis(x)(y) = true
        // first take
        val pos = rm(x)(y)
        var k = 1
        while (pos + k <= N && k <= 6) {
          val (u, v) = mm(pos + k)

          if (board(u)(v) > 0) {
            val (a, b) = mm(board(u)(v))
            if (dist(a)(b) < 0 || dist(a)(b) > dist(x)(y) + 1) {
              dist(a)(b) = dist(x)(y) + 1
              pq.enqueue(Node(a, b, dist(a)(b)))
            }
          } else if (dist(u)(v) < 0 || dist(u)(v) > dist(x)(y) + 1) {
            dist(u)(v) = dist(x)(y) + 1
            pq.enqueue(Node(u, v, dist(u)(v)))
          }

          k += 1
        }

      }
    }

    dist(mm(N)._1)(mm(N)._2)
  }

  case class Node(x: Int, y: Int, d: Int)

}
