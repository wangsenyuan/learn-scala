package set800.set800.p801

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val A = Array(1,3,5,4)
    val B = Array(1,2,3,7)
    val res = Solution.minSwap(A, B)
    res should be(1)
  }
}
