package set0000.set100.set160.p168

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "26" should "get Z" in {
    val res = Solution.convertToTitle(26)
    res should be("Z")
  }

  "27" should "get AA" in {
    val res = Solution.convertToTitle(27)
    res should be("AA")
  }

  "28" should "get AB" in {
    val res = Solution.convertToTitle(28)
    res should be("AB")
  }

  "52" should "get AZ" in {
    val res = Solution.convertToTitle(52)
    res should be("AZ")
  }
  "2147483647" should "get FXSHRXW" in {
    val res = Solution.convertToTitle(2147483647)
    res should be("FXSHRXW")
  }
}
