package set800.set860.p861

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val A = Array(
      Array(0, 0, 1, 1), Array(1, 0, 1, 0), Array(1, 1, 0, 0)
    )
    val res = Solution.matrixScore(A)
    res should be(39)
  }
}
