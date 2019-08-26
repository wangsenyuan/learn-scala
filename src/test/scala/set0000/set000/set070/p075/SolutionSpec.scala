package set0000.set000.set070.p075

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2,0,2,1,1,0" should "be 0,0,1,1,2,2" in {
    val arr = Array(2, 0, 2, 1, 1, 0)
    Solution.sortColors(arr)
    arr shouldEqual Array(0, 0, 1, 1, 2, 2)
  }
}
