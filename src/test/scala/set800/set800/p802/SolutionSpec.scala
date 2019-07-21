package set800.set800.p802

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val graph: Array[Array[Int]] = Array(Array(1,2),Array(2,3),Array(5),Array(0),Array(5),Array(),Array())
    val res = Solution.eventualSafeNodes(graph)
    res should be(List(2, 4, 5, 6))
  }
}
