package codechef.easy.discrepanciesinthevoterslist

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/15/16.
  */
object Main {

  def readInput(n: Int) = {
    val array = Array.fill(n)(0)

    var i = 0
    while (i < n) {
      array(i) = StdIn.readLine().trim.toInt
      i += 1
    }

    array
  }


  def process(a: Array[Int], b: Array[Int], c: Array[Int]): Vector[Int] = {
    val votes = List((a, 0), (b, 0), (c, 0))

    def go(votes: List[(Array[Int], Int)], rs: Vector[Int]): Vector[Int] = {
      if (votes.size < 2) {
        rs
      } else {
        val values = votes.map(x => x._1(x._2))
        val majorities = values.groupBy(identity).filter(_._2.size > 1)
        if (majorities.size == 0) {
          val min = values.min
          val xvotes = votes.map(x => (x._1, if (x._1(x._2) == min) x._2 + 1 else x._2)).filter(x => x._2 < x._1.size)
          go(xvotes, rs)
        } else {
          val majority = majorities.head._1
          val xvotes = votes.map(x => (x._1, if (x._1(x._2) <= majority) x._2 + 1 else x._2)).filter(x => x._2 < x._1.size)
          go(xvotes, rs :+ majority)
        }
      }
    }

    go(votes, Vector())
  }

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n1 = line(0)
    val n2 = line(1)
    val n3 = line(2)

    val a = readInput(n1)
    val b = readInput(n2)
    val c = readInput(n3)
    val d = process(a, b, c)
    println(d.size)
    d.foreach(println)
  }
}
