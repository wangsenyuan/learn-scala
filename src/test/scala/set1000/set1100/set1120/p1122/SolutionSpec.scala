package set1000.set1100.set1120.p1122

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr1 = Array(28, 6, 22, 8, 44, 17)
    val arr2 = Array(22, 28, 8, 6)
    val res = Solution.relativeSortArray(arr1, arr2)
    res should be(Array(22, 28, 8, 6, 17, 44))
  }
}
