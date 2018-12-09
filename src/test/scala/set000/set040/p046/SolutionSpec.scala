package set000.set040.p046

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "work with example 1" in {
    val nums = Array(1, 2, 3)
    val expect = List(List(1, 2, 3),
      List(1, 3, 2),
      List(2, 1, 3),
      List(2, 3, 1),
      List(3, 1, 2),
      List(3, 2, 1)).sortWith(compareList)
    val res = Solution.permute(nums)
    res.sortWith(compareList) shouldEqual expect
  }

  private def compareList(a: List[Int], b: List[Int]): Boolean = {
    val c = a.zip(b).dropWhile(x => x._1 == x._2)
    if (c.isEmpty) {
      a.size < b.size
    } else {
      val x = c.head
      x._1 < x._2
    }
  }
}
