package set0000.set900.set930.p936

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Solution {

  case class Node(made: mutable.Set[Int], todo: mutable.Set[Int])

  def movesToStamp(stamp: String, target: String): Array[Int] = {
    val m = stamp.length
    val n = target.length

    val ans = ListBuffer.empty[Int]

    val A = ListBuffer.empty[Node]

    val que = ListBuffer.empty[Int]

    val done = Array.ofDim[Boolean](n)

    for {
      i <- 0 to n - m
    } {
      val made = mutable.Set.empty[Int]
      val todo = mutable.Set.empty[Int]
      for {
        j <- 0 until m
      } {
        if (stamp(j) == target(i + j)) {
          made += (i + j)
        } else {
          todo += (i + j)
        }
      }

      A += Node(made, todo)

      if (todo.isEmpty) {
        ans += i

        for {
          j <- made
          if !done(j)
        } {
          que += (j)
          done(j) = true
        }
      }
    }

    var front = 0
    while (front < que.length) {
      val i = que(front)
      front += 1
      for {
        j <- (0 max (i - m + 1)) to (i min (n - m))
        node = A(j)
        if (node.todo.contains(i))
      } {
        node.todo -= i
        if (node.todo.isEmpty) {
          ans += j

          for {
            x <- node.made
            if !done(x)
          } {
            que += x
            done(x) = true
          }
        }
      }
    }

    if (!done.forall(identity)) {
      Array()
    } else {
      ans.reverse.toArray
    }
  }
}
