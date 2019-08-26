package set0000.set600.set640.p640

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "x+5-3+x=6+x-2" should "get x=2" in {
    val res = Solution.solveEquation("x+5-3+x=6+x-2")
    res should equal("x=2")
  }

  "0x=0" should "get Infinite solutions" in {
    val res = Solution.solveEquation("0x=0")
    res should equal("Infinite solutions")
  }

  "1-x+x-x+x=1-x+x-x+x" should "get Infinite solutions" in {
    val res = Solution.solveEquation("1-x+x-x+x=1-x+x-x+x")
    res should equal("Infinite solutions")
  }
}
