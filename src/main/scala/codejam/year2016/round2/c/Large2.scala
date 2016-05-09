package codejam.year2016.round2.c

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/9/16.
  */
object Large2 extends App {

  def play(topics: List[(String, String)]): Int = {
    val g = new BipartiteGraph(topics.size)
    for {
      t <- topics
      (f, s) = t
    } {
      g.connect(f, s)
    }
    topics.size - g.hopcroftKarp
  }

  val T = StdIn.readLine().toInt

  for {
    i <- 1 to T
  } {
    val n = StdIn.readLine().toInt
    var topics = List[(String, String)]()
    for {
      j <- 0 until n
    } {
      val line = StdIn.readLine().split("\\s+")
      topics = (line(0), line(1)) :: topics
    }
    val r = play(topics)
    println(s"Case #$i: $r")
  }

  class BipartiteGraph(n: Int) {
    var uIndex = 0;
    var vIndex = 0;
    var um = Map[String, Int]("" -> 0)
    var vm = Map[String, Int]("" -> 0)
    val g = Array.fill(n + 1, n + 1)(false)

    def connect(u: String, v: String): Unit = {
      val i = um.get(u) match {
        case None =>
          uIndex += 1
          um += (u -> uIndex)
          uIndex
        case Some(x) => x
      }

      val j = vm.get(v) match {
        case None =>
          vIndex += 1
          vm += (v -> vIndex)
          vIndex
        case Some(x) => x
      }

      g(i)(j) = true
    }

    private def bfs(pairU: Array[Int], pairV: Array[Int], dist: Array[Int]): Boolean = {
      val q = new mutable.Queue[Int]
      for {
        u <- 1 to uIndex
      } {
        if (pairU(u) == 0) {
          dist(u) = 0
          q.enqueue(u)
        } else {
          dist(u) = Int.MaxValue
        }
      }
      dist(0) = Int.MaxValue

      while (!q.isEmpty) {
        val u = q.dequeue()
        if (dist(u) < dist(0)) {
          for {
            v <- 1 to vIndex
            if (g(u)(v))
            w = pairV(v)
            if (dist(w) == Int.MaxValue)
          } {
            dist(w) = dist(u) + 1
            q.enqueue(w)
          }
        }
      }

      dist(0) < Int.MaxValue
    }

    private def dfs(u: Int, pairU: Array[Int], pairV: Array[Int], dist: Array[Int]): Boolean = {
      if (u == 0) {
        true
      } else {
        var paired = false

        for {
          v <- 1 to vIndex
          if (g(u)(v) && !paired)
        } {
          val w = pairV(v)
          if (dist(w) == dist(u) + 1 && dfs(w, pairU, pairV, dist)) {
            pairU(u) = v
            pairV(v) = u
            paired = true
          }
        }
        if (!paired) {
          dist(u) = Int.MaxValue
        }
        paired
      }
    }

    def hopcroftKarp: Int = {
      val pairU = Array.fill(n + 1)(0)
      val pairV = Array.fill(n + 1)(0)
      var matching = 0
      val dist = Array.fill(n + 1)(0)

      while (bfs(pairU, pairV, dist)) {
        for {
          u <- 1 to uIndex
          if (pairU(u) == 0 && dfs(u, pairU, pairV, dist))
        } {
          matching += 1
        }
      }

      matching + (uIndex - countPair(pairU)) + (vIndex - countPair(pairV))
    }

    private def countPair(pair: Array[Int]): Int = {
      pair.zipWithIndex.count(p => p._1 > 0 && p._2 > 0)
    }

  }

}
