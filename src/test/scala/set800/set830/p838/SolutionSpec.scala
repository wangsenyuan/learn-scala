package set800.set830.p838

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val str = ".L.R...LR..L.."
    val res = Solution.pushDominoes(str)
    res should be("LL.RR.LLRRLL..")
  }

  "example two" should "work" in {
    val str = "RR.L"
    val res = Solution.pushDominoes(str)
    res should be("RR.L")
  }
}
