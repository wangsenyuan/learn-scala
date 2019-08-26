package set0000.set100.set160.p165

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "7.5.2.4 < 7.5.3" should "be true" in {
    val res = Solution.compareVersion("7.5.2.4", "7.5.3")
    res should be(-1)
  }

  "1.01 == 1.001" should "be true" in {
    val res = Solution.compareVersion("1.01", "1.001")
    res should be(0)
  }

  "1.0 == 1.0.0" should "be true" in {
    val res = Solution.compareVersion("1.0", "1.0.0")
    res should be(0)
  }
}
