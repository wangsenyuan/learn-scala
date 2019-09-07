package set0000.set900.set910.p913

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val graph = Array(Array(3, 4), Array(3, 5), Array(3, 6), Array(0, 1, 2), Array(0, 5, 6), Array(1, 4), Array(2, 4))
    val res = Solution.catMouseGame(graph)
    res should be(0)
  }

  "example two" should "work" in {
    val graph = Array(Array(2, 3), Array(2), Array(0, 1), Array(0, 4), Array(3))
    val res = Solution.catMouseGame(graph)
    res should be(2)
  }

  "example three" should "work" in {
    val graph = Array(Array(2, 3, 4), Array(2, 4), Array(0, 1, 4), Array(0, 4), Array(0, 1, 2, 3))
    val res = Solution.catMouseGame(graph)
    res should be(2)
  }
}
