package codejam.year2016.round1b.c

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/7/16.
  */
object Large extends App {

  def play(topics: List[(String, String)]): Int = {
    val g = new BipartiteGraph
    for {
      t <- topics
      (f, s) = t
    } {
      g.connect(f, s)
    }
    topics.size - g.maxBPM
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
}

class BipartiteGraph {

  case class Node(v: String, edges: List[String]) {
    def updateEdges(u: String): Node =
      this.copy(edges = u :: edges)
  }

  var us = Map[String, Node]()
  var vs = Map[String, Node]()

  private def getNode(vs: Map[String, Node], v: String): Node = {
    vs.get(v) match {
      case None => Node(v, Nil)
      case Some(n) => n
    }
  }

  def connect(u: String, v: String): Unit = {
    val uNode = getNode(us, u)
    us += u -> uNode.updateEdges(v)

    val vNode = getNode(vs, v)
    vs += v -> vNode.updateEdges(u)
  }


  def maxBPM: Int = {
    var pair = Map[String, String]()
    def bpm(u: String, seen: Set[String]): Boolean = {
      var success = false
      for {
        v <- us(u).edges
        if !success && !seen(v)
      } {
        pair.get(v) match {
          case None =>
            pair += (v -> u)
            success = true
          case Some(w) if (bpm(w, seen + v)) =>
            pair += (v -> u)
            success = true
          case _ =>
        }
      }
      success
    }

    var r = 0
    for {
      u <- us.keys
      if (bpm(u, Set()))
    } {
      r += 1
    }

    val pairedUsCnt = pair.values.size
    val pairedVsCnt = pair.keySet.size

    r + (us.size - pairedUsCnt) + (vs.size - pairedVsCnt)
  }

}


