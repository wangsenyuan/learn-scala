package set0000.set900.set940.p948

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.bagOfTokensScore(Array(100, 200, 300, 400), 200)
    res should be(2)
  }

  "example two" should "work" in {
    val res = Solution.bagOfTokensScore(Array(100, 200), 50)
    res should be(0)
  }
}
