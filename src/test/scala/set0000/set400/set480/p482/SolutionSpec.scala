package set0000.set400.set480.p482

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "5F3Z-2e-9-w & 4" should "get 5F3Z-2E9W" in {
    val res = Solution.licenseKeyFormatting("5F3Z-2e-9-w", 4)
    res should be("5F3Z-2E9W")
  }

  "2-5g-3-J & 2" should "get 2-5G-3J" in {
    val res = Solution.licenseKeyFormatting("2-5g-3-J", 2)
    res should be("2-5G-3J")
  }
}
