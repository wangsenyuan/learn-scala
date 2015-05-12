package codejam.year2014.wf

import codejam.FileOp

import scala.collection.mutable.{Set => MSet}

/**
 * Created by senyuanwang on 15/4/24.
 */
object D extends App with FileOp {

  override val filePrefix = "src/main/scala/codejam/year2014/wf/D-large-practice";

  val T = file.next().toInt

  def process(t: Int): List[Int] = {
    val line = file.next().split("\\s+")
    val n = line(0).toInt
    val a = line(1).toInt

    val prefer = Array.fill(n, n)('-')

    for {
      i <- 0 until n
      l = file.next()
      j <- 0 until n
    } {
      prefer(i)(j) = l(j)
    }

    def dfs(i: Int, removed: Set[Int], visited: MSet[Int]): Unit = {
      visited += i
      for {
        j <- 0 until n
        if (prefer(i)(j) == 'Y')
        if (!removed.contains(j) && !visited.contains(j))
      } {
        dfs(j, removed, visited)
      }
    }

    def valid(partial: List[Int]): Boolean = {
      val b = (partial.head /: partial.tail) {
        (b, i) =>
          if (prefer(i)(b) == 'Y') i else b
      }

      val removed = partial.toSet.filterNot(_ == b)

      if (removed.contains(a)) false
      else if (a == b) {
        var ok = true
        for {
          i <- 0 until n
          if (ok)
          if (i != a)
          if (!removed.contains(i))
        } {
          ok = prefer(a)(i) == 'Y'
        }
        ok
      } else {
        val visited = MSet(b)
        dfs(a, removed, visited)

        for {
          i <- 0 until n
          if (i != b)
          if (prefer(b)(i) == 'Y')
        } {
          visited += i
        }

        (visited ++ removed).size == n
      }
    }

    val visited = MSet.empty[Int]
    dfs(a, Set.empty, visited)
    if (visited.size < n) {
      throw new Exception("NO SOLUTION")
    }

    var partial = Nil: List[Int]

    for {
      i <- 0 until n
    } {
      var found = false
      for {
        j <- 0 until n
        if (!found)
        if (!partial.contains(j))
      } {
        found = valid((j :: partial).reverse)
        if (found) {
          partial = j :: partial
        }
      }
    }
    partial.reverse
  }

  for {
    t <- 1 to T
  } {
    try {
      val result = process(t)
      println(s"Case #$t: ${result.mkString(" ")}")
    } catch {
      case e: Exception => println(s"Case #$t: IMPOSSIBLE")
    }
  }
}
