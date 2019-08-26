package set0000.set000.set010.p015

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  private def compareList(a: List[Int], b: List[Int]): Boolean = {
    var i = 0
    while (i < a.size && i < b.size && a(i) == b(i)) {
      i += 1
    }
    if (i < a.size && i < b.size) {
      a(i) < b(i)
    } else {
      i == a.size
    }
  }

  it should "get [-1, 0, 1],\n  [-1, -1, 2] on input [-1, 0, 1, 2, -1, -4]" in {
    val arr = Array(-1, 0, 1, 2, -1, -4)
    val res = Solution.threeSum(arr)
    val sr = res.sortWith(compareList)
    val expect = List(List(-1, 0, 1), List(-1, -1, 2)).sortWith(compareList)
    sr shouldEqual expect
  }


  it should "get [0, 0, 0] on input [0, 0, 0, 0]" in {
    val arr = Array(0, 0, 0, 0)
    val res = Solution.threeSum(arr)
    val expect = List(List(0, 0, 0))
    res shouldEqual expect
  }
}
