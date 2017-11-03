package codechef.easy.mtrwy

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val q = firstLine(2)

    val grid = Array.fill(n, m)(15)
    val queris = Array.fill[Query](q)(null)
    var idx = 0
    var i = 0
    while (i < q) {
      val line = StdIn.readLine()
      val query = Query.parse(line)

      query match {
        case HWall(x, y) =>
          if ((grid(x)(y) & 2) == 2) {
            grid(x)(y) ^= 2
            if (y + 1 < m) {
              grid(x)(y + 1) ^= 8
              queris(idx) = query
              idx += 1
            }
          }
        case VWall(x, y) =>
          if ((grid(x)(y) & 4) == 4) {
            grid(x)(y) ^= 4
            if (x + 1 < n) {
              grid(x + 1)(y) ^= 1
              queris(idx) = query
              idx += 1
            }
          }
        case _ =>
          queris(idx) = query
          idx += 1
      }


      i += 1
    }

    val set = Array.fill(n * m)(-1)

    def find(v: Int): Int = {
      if (set(v) == -1) {
        set(v) = v
      } else if (set(v) != v) {
        set(v) = find(set(v))
      }
      set(v)
    }

    val size = Array.fill(n * m)(1)

    var maj = 0
    i = 0
    while (i < n) {
      var j = 0
      while (j < m) {
        val a = i * m + j
        val pa = find(a)
        if (i > 0 && (grid(i)(j) & 1) == 1) {
          // go up
          val b = a - m
          val pb = find(b)
          if (pa != pb) {
            set(pb) = pa
            size(pa) += size(pb)
          }
        }
        if (i < n - 1 && (grid(i)(j) & 4) == 4) {
          // go down
          val b = a + m
          val pb = find(b)
          if (pa != pb) {
            set(pb) = pa
            size(pa) += size(pb)
          }
        }

        if (j > 0 && (grid(i)(j) & 8) == 8) {
          // go left
          val b = a - 1
          val pb = find(b)
          if (pa != pb) {
            set(pb) = pa
            size(pa) += size(pb)
          }
        }

        if (j < m - 1 && (grid(i)(j) & 2) == 2) {
          val b = a + 1
          val pb = find(b)
          if (pa != pb) {
            set(pb) = pa
            size(pa) += size(pb)
          }
        }

        if (size(pa) > maj) {
          maj = size(pa)
        }

        j += 1
      }
      i += 1
    }

    var ans = 0L

    i = idx - 1
    while (i >= 0) {
      queris(i) match {
        case Largest =>
          ans += maj
        case IsConnect(x1, y1, x2, y2) =>
          val a = x1 * m + y1
          val b = x2 * m + y2
          val pa = find(a)
          val pb = find(b)
          if (pa == pb) {
            ans += 1
          }
        case HWall(x, y) =>
          val a = x * m + y
          val b = a + 1
          val pa = find(a)
          val pb = find(b)
          if (pa != pb) {
            // connect them
            set(pa) = pb
            size(pb) += size(pa)
            if (size(pb) > maj) {
              maj = size(pb)
            }
          }
        case VWall(x, y) =>
          val a = x * m + y
          val b = a + m
          val pa = find(a)
          val pb = find(b)
          if (pa != pb) {
            // connect them
            set(pa) = pb
            size(pb) += size(pa)
            if (size(pb) > maj) {
              maj = size(pb)
            }
          }
      }
      i -= 1
    }

    println(ans)
  }

  trait Query

  object Query {
    def parse(str: String): Query = {
      val parts = str.split("\\s+")
      str(0) match {
        case '1' =>
          HWall(parts(1).toInt - 1, parts(2).toInt - 1)
        case '2' =>
          VWall(parts(1).toInt - 1, parts(2).toInt - 1)
        case '3' =>
          IsConnect(parts(1).toInt - 1, parts(2).toInt - 1, parts(3).toInt - 1, parts(4).toInt - 1)
        case _ =>
          Largest
      }
    }
  }

  case class HWall(x: Int, y: Int) extends Query

  case class VWall(x: Int, y: Int) extends Query

  case class IsConnect(x1: Int, y1: Int, x2: Int, y2: Int) extends Query

  case object Largest extends Query

}
