package codechef.easy.abroads

import scala.collection.mutable
import scala.io.StdIn

object Main {


  sealed class Query

  case class D(k: Int) extends Query

  case class P(a: Int, x: Int) extends Query

  def main(args: Array[String]): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val q = firstLine(2)

    val ps = StdIn.readLine().split("\\s+").map(_.toInt)
    val roads = Array.fill[(Int, Int)](n)(null)
    val usable = Array.fill(n)(true)
    var i = 0
    while (i < m) {
      val road = StdIn.readLine().split("\\s+").map(_.toInt - 1)
      roads(i) = road(0) -> road(1)
      i += 1
    }

    val queries = Array.fill[Query](q)(null)
    i = 0
    while (i < q) {
      val line = StdIn.readLine().split("\\s+")
      line(0) match {
        case "D" =>
          val j = line(1).toInt - 1
          queries(i) = D(j)
          usable(j) = false
        case _ =>
          val k = line(1).toInt - 1
          val x = line(2).toInt
          queries(i) = P(k, x - ps(k))
          ps(k) = x
      }

      i += 1
    }

    val set = (0 until n).toArray

    def find(x: Int): Int = {
      val p = set(x)
      if (p == x) {
        x
      } else {
        set(x) = find(p)
        set(x)
      }
    }


    i = 0
    while (i < m) {
      if (usable(i)) {
        val (a, b) = roads(i)
        val pa = find(a)
        val pb = find(b)
        if (pa != pb) {
          set(pa) = pb
          ps(pb) += ps(pa)
        }
      }
      i += 1
    }

    val tree = new mutable.TreeSet[(Int, Int)]()(
      (x, y) => {
        if (x._1 > y._1 || (x._1 == y._1 && x._2 > y._2)) {
          -1
        } else if (x._1 < y._1 || (x._1 == y._1 && x._2 < y._2)) {
          1
        } else {
          0
        }
      }
    )

    i = 0
    while (i < n) {
      val pi = set(i)
      tree.add(ps(pi) -> pi)
      i += 1
    }

    val result = Array.fill(q)(0)
    result(q - 1) = tree.head._1
    i = q - 1
    while (i > 0) {
      val query = queries(i)

      query match {
        case D(j) =>
          if (!usable(j)) {
            val (a, b) = roads(j)
            val pa = find(a)
            val pb = find(b)
            if (pa != pb) {
              val pax = ps(pa)
              val pbx = ps(pb)
              tree.remove(pax -> pa)
              tree.remove(pbx -> pb)

              set(pa) = pb
              ps(pb) += ps(pa)
              tree.add(ps(pb) -> pb)
            }
            usable(j) = true
          }
        case P(a, x) =>
          val pa = find(a)
          tree.remove(ps(pa) -> pa)
          ps(pa) -= x
          tree.add(ps(pa) -> pa)
        case _ =>
      }
      result(i - 1) = tree.head._1

      i -= 1
    }

    result foreach println

  }

}
