package set1000.set1000.set1050.p1052

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val customes = Array(1, 0, 1, 2, 1, 1, 7, 5)
    val grumpy = Array(0, 1, 0, 1, 0, 1, 0, 1)
    val X = 3
    val res = Solution.maxSatisfied(customes, grumpy, X)
    res should be(16)
  }
}
