package set0000.set900.set960.p967

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.numsSameConsecDiff(3, 7)
    val expect = Array(181, 292, 707, 818, 929)
    res.sorted should equal(expect.sorted)
  }

  "example two" should "work" in {
    val res = Solution.numsSameConsecDiff(2, 1)
    val expect = Array(10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98)
    res.sorted should equal(expect.sorted)
  }

  "example three" should "work" in {
    val res = Solution.numsSameConsecDiff(9, 0)
    val expect = Array(111111111, 222222222, 333333333, 444444444, 555555555, 666666666, 777777777, 888888888, 999999999)
    res.sorted should equal(expect.sorted)
  }

  "example four" should "work" in {
    val res = Solution.numsSameConsecDiff(5, 0)
    val expect = Array(11111, 22222, 33333, 44444, 55555, 66666, 77777, 88888, 99999)
    res.sorted should equal(expect.sorted)
  }
}
