package set800.set840.p845

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(2, 3, 3, 2, 0, 2)
    val res = Solution.longestMountain(arr)
    res should be(0)
  }

  "example two" should "work" in {
    val arr = Array(2, 1, 4, 7, 3, 2, 5)
    val res = Solution.longestMountain(arr)
    res should be(5)
  }

  "example three" should "work" in {
    val arr = Array(875, 884, 239, 731, 723, 685)
    val res = Solution.longestMountain(arr)
    res should be(4)
  }

  "example four" should "work" in {
    val arr = Array(0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1)
    val res = Solution.longestMountain(arr)
    res should be(3)
  }
}
