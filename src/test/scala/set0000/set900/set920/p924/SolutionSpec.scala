package set0000.set900.set920.p924

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val graph = Array(Array(1, 1, 0), Array(1, 1, 0), Array(0, 0, 1))
    val initial = Array(0, 1)
    val res = Solution.minMalwareSpread(graph, initial)
    res should be(0)
  }

  "example two" should "work" in {
    val graph = Array(Array(1, 0, 0), Array(0, 1, 0), Array(0, 0, 1))
    val initial = Array(0, 2)
    val res = Solution.minMalwareSpread(graph, initial)
    res should be(0)
  }

  "example three" should "work" in {
    val graph = Array(Array(1, 1, 1), Array(1, 1, 1), Array(1, 1, 1))
    val initial = Array(1, 2)
    val res = Solution.minMalwareSpread(graph, initial)
    res should be(1)
  }

  "example four" should "work" in {
    val graph = Array(Array(1, 0, 0, 0), Array(0, 1, 1, 0), Array(0, 1, 1, 0), Array(0, 0, 0, 1))
    val initial = Array(1, 3)
    val res = Solution.minMalwareSpread(graph, initial)
    res should be(1)
  }
}
