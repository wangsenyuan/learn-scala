package set1000.set1200.set1200.p1202

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val s = "dcab"
    val pairs = List(List(0, 3), List(1, 2))
    val res = Solution.smallestStringWithSwaps(s, pairs)
    res should be("bacd")
  }
}
