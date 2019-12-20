package set1000.set1200.set1240.p1248

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(1, 1, 2, 1, 1)
    val k = 3
    val res = Solution.numberOfSubarrays(arr, k)
    res should be(2)
  }

  "example two" should "work" in {
    val arr = Array(2, 4, 6)
    val k = 1
    val res = Solution.numberOfSubarrays(arr, k)
    res should be(0)
  }

  "example three" should "work" in {
    val arr = Array(2, 2, 2, 1, 2, 2, 1, 2, 2, 2)
    val k = 2
    val res = Solution.numberOfSubarrays(arr, k)
    res should be(16)
  }

  "example four" should "work" in {
    val arr = Array(1, 1, 1, 1, 1)
    val k = 1
    val res = Solution.numberOfSubarrays(arr, k)
    res should be(5)
  }
}
