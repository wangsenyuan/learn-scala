package set1000.set1300.set1340.p1342

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)
    val res = Solution.minSetSize(arr)
    res should be(2)
  }
}
