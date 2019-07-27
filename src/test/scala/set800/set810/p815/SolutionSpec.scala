package set800.set810.p815

import org.scalatest.{FlatSpec, Matchers}

import scala.io.Source

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val routes = Array(Array(1, 2, 7), Array(3, 6, 7))
    val res = Solution.numBusesToDestination(routes, 1, 6)
    res should be(2)
  }

  "example two" should "work" in {
    val file = Source.fromURL(getClass.getResource("/leetcode/p815/case41.in")).getLines()
    val firstLine = file.next()
    val routes = parseLineAsRoutes(firstLine)
    val S = file.next().toInt
    val T = file.next().toInt
    val res = Solution.numBusesToDestination(routes, S, T)

    res should be(2)
  }

  private def parseLineAsRoutes(line: String): Array[Array[Int]] = {
    val start = 2
    val end = line.length - 2
    val ss = line.substring(start, end).split("\\],\\[")
    ss.map(parseAsRoute)
  }

  private def parseAsRoute(str: String): Array[Int] = {
    str.split(",").map(_.toInt)
  }
}
