package codechef.easy.lfstack

import scala.collection.mutable
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }

  def solve(): Unit = {
    val n = StdIn.readInt()
    val inputs = Array.fill[Array[Int]](n)(null)
    val state = Array.fill(n)(-1)
    var i = 0
    while (i < n) {
      inputs(i) = StdIn.readLine().split("\\s+").map(_.toInt).tail
      state(i) = inputs(i).size
      i += 1
    }
    val stack = StdIn.readLine().split("\\s+").map(_.toInt)
    val m = stack.length

    val cache = mutable.Map.empty[Vector[Int], Boolean]

    def solve(pos: Int, state: Vector[Int]): Boolean = {
      if (pos == m) {
        state.forall(_ == 0)
      } else if (!cache.contains(state)) {
        var res = false
        var i = 0
        while (i < state.size && !res) {
          if (state(i) > 0 && inputs(i)(state(i) - 1) == stack(pos)) {
            res = solve(pos + 1, state.updated(i, state(i) - 1))
          }
          i += 1
        }

        cache(state) = res
        res
      } else {
        cache(state)
      }
    }

    val ans = solve(0, state.toVector)
    if (ans) {
      println("Yes")
    } else {
      println("No")
    }
  }
}
