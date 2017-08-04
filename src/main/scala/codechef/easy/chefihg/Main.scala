package codechef.easy.chefihg

import scala.collection.mutable
import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    val land = Array.fill[Array[Char]](n)(null)

    var i = 0
    while (i < n) {
      val row = StdIn.readLine().toCharArray
      land(i) = row
      i += 1
    }

    val ans = play(land, n, m)

    println(ans)
  }

  def play(land: Array[Array[Char]], n: Int, m: Int): String = {

    val path = bfs(land, n, m)

    def findPath(i: Int, j: Int, res: String): String = {
      if (land(i)(j) == 'C') {
        res
      } else {
        val di = path(i)(j)
        if (di == 'U') {
          findPath(i - 1, j, res + di)
        } else if (di == 'D') {
          findPath(i + 1, j, res + di)
        } else if (di == 'L') {
          findPath(i, j - 1, res + di)
        } else {
          findPath(i, j + 1, res + di)
        }
      }
    }

    def updateCommand(x: Int, y: Int, cmd: String): String = {

      def followCommand(i: Int, j: Int, k: Int): (Int, Int) = {
        if (k == cmd.length) {
          (i, j)
        } else if (land(i)(j) == 'C') {
          (i, j)
        } else {
          var a = i
          var b = j
          if (cmd(k) == 'R' && j < m - 1 && land(i)(j + 1) != '*') {
            b = j + 1
          } else if (cmd(k) == 'L' && j > 0 && land(i)(j - 1) != '*') {
            b = j - 1
          } else if (cmd(k) == 'U' && i > 0 && land(i - 1)(j) != '*') {
            a = i - 1
          } else if (cmd(k) == 'D' && i < n - 1 && land(i + 1)(j) != '*') {
            a = i + 1
          }
          followCommand(a, b, k + 1)
        }
      }

      val (a, b) = followCommand(x, y, 0)
      if (land(a)(b) == 'C') {
        cmd
      } else {
        cmd + findPath(a, b, "")
      }
    }

    var cmd = ""

    var i = 0
    while (i < n) {
      var j = 0
      while (j < m) {
        if (land(i)(j) == '.') {
          cmd = updateCommand(i, j, cmd)
        }

        j += 1
      }

      i += 1
    }

    cmd
  }

  val pos = Array(-1, 0, 1, 0, -1)
  val dir = Array('D', 'L', 'U', 'R')

  def bfs(land: Array[Array[Char]], n: Int, m: Int): Array[Array[Char]] = {
    val steps = Array.fill(n, m)(Int.MaxValue)

    var x = 0
    var y = 0

    (0 until n) foreach {
      i =>
        (0 until m) foreach {
          j =>
            if (land(i)(j) == 'C') {
              x = i
              y = j
            }
        }
    }
    steps(x)(y) = 0

    val pq = new mutable.PriorityQueue[(Int, Int, Int)]()(
      (a, b) => {
        val (_, _, ad) = a
        val (_, _, bd) = b
        if (ad < bd) {
          1
        } else if (ad > bd) {
          -1
        } else {
          0
        }
      }
    )
    pq.enqueue((x, y, 0))

    val res = Array.fill(n, m)('-')
    val visited = Array.fill(n, m)(false)

    while (!pq.isEmpty) {
      val (x, y, d) = pq.dequeue()
      if (!visited(x)(y)) {
        visited(x)(y) = true
        var i = 0
        while (i < 4) {
          val dx = pos(i)
          val dy = pos(i + 1)

          val a = x + dx
          val b = y + dy

          if (a >= 0 && a < n && b >= 0 && b < m && !visited(a)(b) && land(a)(b) == '.' && d + 1 < steps(a)(b)) {
            steps(a)(b) = d + 1
            res(a)(b) = dir(i)
            pq.enqueue((a, b, d + 1))
          }

          i += 1
        }
      }

    }

    res
  }
}
