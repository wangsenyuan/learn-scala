package set800.set820.p828

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.uniqueLetterString("ABC")
    res should be(10)
  }

  "example two" should "work" in {
    val res = Solution.uniqueLetterString("ABA")
    res should be(8)
  }
}
