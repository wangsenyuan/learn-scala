package codejam.year2016.round1b.c

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/6/16.
  */
object Small extends App {

  case class Topic(first: String, second: String)

  def play(topics: Vector[Topic]): Int = {
    val firstSet = topics.map(_.first).toSet.size
    val secondSet = topics.map(_.second).toSet.size

    def findMinResult(results: Option[List[Topic]]*): Option[List[Topic]] = {
      results.filter(_.isDefined).map(_.get).sortBy(_.size).headOption
    }

    def findUnFakeSet(result: List[Topic], list: List[Topic]): Option[List[Topic]] = {
      val fs = result.map(_.first).toSet
      val ss = result.map(_.second).toSet
      if (fs.size == firstSet && ss.size == secondSet) {
        Some(result)
      } else list match {
        case Nil => None
        case h :: tail =>
          val result1 = findUnFakeSet(h :: result, tail)
          val result2 = findUnFakeSet(result, tail)
          findMinResult(result1, result2)
      }
    }

    topics.size - findUnFakeSet(Nil, topics.toList).get.size
  }

  val T = StdIn.readLine().toInt

  for {
    i <- 1 to T
  } {
    val n = StdIn.readLine().toInt
    var topics = Vector[Topic]()
    for {
      j <- 0 until n
    } {
      val line = StdIn.readLine().split("\\s+")
      val topic = Topic(line(0), line(1))
      topics = topics :+ topic
    }
    val r = play(topics)
    println(s"Case #$i: $r")
  }
}
