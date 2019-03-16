package set400.set430.p433

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 1" in {
    val res = Solution.minMutation("AACCGGTT", "AACCGGTA", Array("AACCGGTA"))
    res should be(1)
  }

  "example two" should "get 2" in {
    val res = Solution.minMutation("AACCGGTT", "AAACGGTA", Array("AACCGGTA", "AACCGCTA", "AAACGGTA"))
    res should be(2)
  }

  "example three" should "get " in {
    val res = Solution.minMutation("AAAAACCC", "AACCCCCC", Array("AAAACCCC", "AAACCCCC", "AACCCCCC"))
    res should be(3)
  }
}
