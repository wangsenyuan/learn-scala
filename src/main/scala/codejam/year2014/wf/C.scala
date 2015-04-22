package codejam.year2014.wf

import codejam.FileOp

import scala.collection.mutable.ListBuffer

/**
 * Created by senyuanwang on 15/4/22.
 */
object C extends App with FileOp {
  override val filePrefix = "src/main/scala/codejam/year2014/wf/C-small-practice";

  val T = file.next().toInt

  def process(t: Int): Boolean = {
    val n = file.next().toInt

    val colors = Array.fill(n + 1)("")

    for {
      i <- 1 to n
      c = file.next()
    } {
      colors(i) = c
    }

    val graph = (1 to n).foldLeft(Map.empty[Int, ListBuffer[Int]]) {
      (map, a) =>
        map + (a -> ListBuffer.empty[Int])
    }

    var edges = Map.empty[(Int, Int), String]

    def encodeTree(root: Int, parent: Int): String = {
      val children = ListBuffer.empty[String]
      for {
        i <- graph(root)
        if (i != parent)
        key = (root, i)
      } {
        edges.get(key) match {
          case Some(value) if (value.isEmpty) =>
            edges += key -> encodeTree(i, root)
          case _ => //do nothing
        }
        edges.get(key) match {
          case Some(value) =>
            children += value
          case None => //do nothing
        }
      }

      children.sorted.foldLeft("(" + colors(root)) {
        (res, cld) =>
          res + "," + cld.toString
      } + ")"
    }

    def symmetric(nodes: List[Int], edges: Map[(Int, Int), String], graph: Map[Int, ListBuffer[Int]]): Boolean = {

      def firstCase(nodes: List[Int]): Boolean = {
        var ok = false
        for {
          a <- nodes
          if (!ok)
          b <- graph(a)
          if (!ok)
          x <- edges.get((a, b))
          y <- edges.get((b, a))
        } {
          ok = x == y
        }
        ok
      }

      def secondCase(a: Int, parent: Int): Boolean = {
        def findFirstPair(children: List[Int], pairs: Map[String, Int]): Map[String, Int] =
          children match {
            case b :: tail if (b == parent) => findFirstPair(tail, pairs)
            case b :: tail =>
              val key = edges((a, b))
              pairs.get(key) match {
                //(a, b) is paired by other
                case Some(_) => findFirstPair(tail, pairs - key)
                case None => findFirstPair(tail, pairs + (key -> b))
              }
            case Nil => pairs
          }

        val firstPair = findFirstPair(graph(a).toList, Map.empty)
        val keys = firstPair.values.toList
        if (keys.size == 0) true
        else if (keys.size > 2) false
        else if (keys.size == 2 && parent != -1) false
        else if (keys.size == 2) {
          keys.foldLeft(true) {
            (rt, b) => rt && secondCase(b, a)
          }
        } else {
          secondCase(keys.head, a)
        }
      }

      nodes.foldLeft(firstCase(nodes)) {
        (rt, a) =>
          rt || secondCase(a, -1)
      }
    }

    for {
      i <- 0 until n - 1
      line = file.next().split("\\s+")
    } {
      val a = line(0).toInt
      val b = line(1).toInt

      edges += (a, b) -> ""
      edges += (b, a) -> ""

      graph(a) += b
      graph(b) += a
    }

    for {
      i <- 1 to n
    } {
      encodeTree(i, -1)
    }

    symmetric((1 to n).toList, edges, graph)
  }

  for {
    t <- 1 to T
    ok = process(t)
  } {
    if (ok) {
      println(s"Case #$t: SYMMETRIC")
    } else {
      println(s"Case #$t: NOT SYMMETRIC")
    }
  }
}
