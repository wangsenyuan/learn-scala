package set800.set850.p852

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(0, 1, 0)
    val res = Solution.peakIndexInMountainArray(arr)
    res should be(1)
  }

  "example two" should "work" in {
    val arr = Array(0, 2, 1, 0)
    val res = Solution.peakIndexInMountainArray(arr)
    res should be(1)
  }

  "example three" should "work" in {
    val arr = Array(40, 48, 61, 75, 100, 99, 98, 39, 30, 10)
    val res = Solution.peakIndexInMountainArray(arr)
    res should be(4)
  }
}
