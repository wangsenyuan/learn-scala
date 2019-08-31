package set0000.set800.set880.p886

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.possibleBipartition(4, Array(Array(1, 2), Array(1, 3), Array(2, 4)))
    res should be(true)
  }
}
