package set0000.set300.set330.p331

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "9,3,4,#,#,1,#,#,2,#,6,#,#" should "get true" in {
    Solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#") should be(true)
  }

  "9,3,4,#,#,1,#,#,#,2,#,6,#,#" should "get false" in {
    Solution.isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#") should be(false)
  }

  "1,#" should "get false" in {
    Solution.isValidSerialization("1,#") should be(false)
  }

  "9,#,#,1" should "get false" in {
    Solution.isValidSerialization("9,#,#,1") should be(false)
  }
}
