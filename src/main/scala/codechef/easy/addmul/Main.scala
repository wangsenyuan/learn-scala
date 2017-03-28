package codechef.easy.addmul

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/28.
  */
object Main {

  val N_MAX = 131072

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    var q = line(1)

    val st = new SegTree(N_MAX)

    val nums = StdIn.readLine().split("\\s+").map(_.toLong)
    var i = 1
    while (i <= n) {
      val v = nums(i - 1) % MOD
      st.add(i, i, v)
      i += 1
    }

    while (q > 0) {
      val qus = StdIn.readLine().split("\\s+")
      if (qus(0) == "1") {
        val x = qus(1).toInt
        val y = qus(2).toInt
        val v = qus(3).toLong
        st.add(x, y, v)
      } else if (qus(0) == "2") {
        val x = qus(1).toInt
        val y = qus(2).toInt
        val v = qus(3).toLong
        st.mul(x, y, v)
      } else if (qus(0) == "3") {
        val x = qus(1).toInt
        val y = qus(2).toInt
        val v = qus(3).toLong
        st.reset(x, y, v)
      } else {
        val x = qus(1).toInt
        val y = qus(2).toInt
        val res = st.query(x, y)
        println(res)
      }

      q -= 1
    }
  }

  val MOD = 1000000007

  class SegTree(val size: Int) {
    val sum = Array.fill(2 * size)(0L)
    val li = Array.fill(2 * size)(0)
    val ls = Array.fill(2 * size)(0)
    val umul = Array.fill(2 * size)(1L)
    val uadd = Array.fill(2 * size)(0L)
    val uset = Array.fill(2 * size)(-1L)

    var i = size
    while (i < 2 * size) {
      li(i) = i - size + 1
      ls(i) = i - size + 1
      i += 1
    }
    i = size - 1
    while (i > 0) {
      val left = i << 1
      val right = left + 1
      li(i) = li(left)
      ls(i) = ls(right)
      i -= 1
    }

    private def pushAdd(v: Long)(node: Int): Unit = {
      uadd(node) = (uadd(node) + v) % MOD
      sum(node) = (sum(node) + 1L * (ls(node) - li(node) + 1) * v) % MOD
    }

    private def pushSet(v: Long)(node: Int): Unit = {
      umul(node) = 1L
      uadd(node) = 0L
      uset(node) = v
      sum(node) = (1L * (ls(node) - li(node) + 1) * v) % MOD
    }

    private def pushMul(v: Long)(node: Int): Unit = {
      umul(node) = (umul(node) * v) % MOD
      uadd(node) = (uadd(node) * v) % MOD
      sum(node) = (sum(node) * v) % MOD
    }

    private def visit(op: Int => Unit, i: Int, j: Int): Unit = {
      //      val ops = Array[(Int, Long) => Unit](null, pushAdd, pushMul, pushSet)
      def go(node: Int, i: Int, j: Int): Unit = {
        if (i <= li(node) && ls(node) <= j) {
          op(node)
        } else {
          val left = node << 1
          val right = left + 1
          if (uset(node) >= 0) {
            pushSet(uset(node))(left)
            pushSet(uset(node))(right)
            uset(node) = -1
          }

          if (umul(node) != 1) {
            pushMul(umul(node))(left)
            pushMul(umul(node))(right)
            umul(node) = 1
          }

          if (uadd(node) != 0) {
            pushAdd(uadd(node))(left)
            pushAdd(uadd(node))(right)
            uadd(node) = 0
          }

          if (i <= ls(left)) {
            go(left, i, j)
          }
          if (j >= li(right)) {
            go(right, i, j)
          }
          sum(node) = (sum(left) + sum(right)) % MOD
        }
      }

      go(1, i, j)
    }

    def add(i: Int, j: Int, v: Long): Unit = {
      visit(pushAdd(v) _, i, j)
    }

    def mul(i: Int, j: Int, v: Long): Unit = {
      visit(pushMul(v) _, i, j)
    }

    def reset(i: Int, j: Int, v: Long): Unit = {
      visit(pushSet(v) _, i, j)
    }

    def query(i: Int, j: Int): Long = {
      var ans = 0L

      def getSum(node: Int): Unit = {
        ans = (ans + sum(node)) % MOD
      }

      visit(getSum, i, j)
      ans
    }
  }

}
