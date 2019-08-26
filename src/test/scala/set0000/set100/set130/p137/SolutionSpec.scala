package set0000.set100.set130.p137

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[2,2,3,2]" should "get 3" in {
    val res = Solution.singleNumber(Array(2, 2, 3, 2))
    res should be(3)
  }

  "[0,1,0,1,0,1,99]" should "get 99" in {
    val res = Solution.singleNumber(Array(0, 1, 0, 1, 0, 1, 99))
    res should be(99)
  }
}
