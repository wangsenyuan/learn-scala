package set100.set160.p162

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "1,2,3,1" should "get 2" in {
    val res = Solution.findPeakElement(Array(1, 2, 3, 1))
    res should be(2)
  }
}
