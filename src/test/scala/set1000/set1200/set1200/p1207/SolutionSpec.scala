package set1000.set1200.set1200.p1207

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.uniqueOccurrences(Array(1, 2))
    res should be(false)
  }
}
