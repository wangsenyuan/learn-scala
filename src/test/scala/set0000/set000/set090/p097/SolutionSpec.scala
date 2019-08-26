package set0000.set000.set090.p097

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "aabcc and dbbca" should "be able to interleave aadbbcbcac" in {
    val s1 = "aabcc"
    val s2 = "dbbca"
    val s3 = "aadbbcbcac"

    Solution.isInterleave(s1, s2, s3) should be(true)
  }

  it should "not be able to interleave aadbbbaccc" in {
    val s1 = "aabcc"
    val s2 = "dbbca"
    val s3 = "aadbbbaccc"

    Solution.isInterleave(s1, s2, s3) should be(false)
  }
}
