package set1000.set1000.set1040.p1044

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.longestDupSubstring("banana")
    res should be("ana")
  }
}
