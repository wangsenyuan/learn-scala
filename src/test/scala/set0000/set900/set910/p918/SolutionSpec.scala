package set0000.set900.set910.p918

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.maxSubarraySumCircular(Array(5, -3, 5))
    res should be(10)
  }
}
