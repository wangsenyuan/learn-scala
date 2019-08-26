package set0000.set000.set010.p018

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get [-1,  0, 0, 1],\n  [-2, -1, 1, 2],\n  [-2,  0, 0, 2] when input [1, 0, -1, 0, -2, 2], 0" in {
    val nums = Array(1, 0, -1, 0, -2, 2)
    val target = 0
    val res = Solution.fourSum(nums, target)
    val expect = List(
      List(-1, 0, 0, 1),
      List(-2, -1, 1, 2),
      List(-2, 0, 0, 2)
    ).sortWith(compareList)

    res.sortWith(compareList) shouldEqual expect
  }

  private def compareList(a: List[Int], b: List[Int]): Boolean = {
    var i = 0
    while (i < a.length && i < b.length && a(i) == b(i)) {
      i += 1
    }
    if (i < a.length && i < b.length) {
      a(i) < b(i)
    } else {
      i == a.length
    }
  }
}
