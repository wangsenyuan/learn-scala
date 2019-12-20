package set1000.set1200.set1250.p1253

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.reconstructMatrix(2, 1, Array(1, 1, 1))
    res should be(List(List(1, 1, 0), List(0, 0, 1)))
  }

  "example two" should "work" in {
    val res = Solution.reconstructMatrix(2, 3, Array(2, 2, 1, 1))
    res should be(Nil)
  }

  "example three" should "work" in {
    val res = Solution.reconstructMatrix(4, 7, Array(2, 1, 2, 2, 1, 1, 1))
    res should be(Nil)
  }
}
