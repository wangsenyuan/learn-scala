package set0000.set100.set180.p187

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" should "get [\"AAAAACCCCC\",\"CCCCCAAAAA\"]" in {
    val res = Solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
    res.sorted should equal(List("AAAAACCCCC", "CCCCCAAAAA"))
  }

  "AAAAAAAAAAAA" should "get [AAAAAAAAAA]" in {
    val res = Solution.findRepeatedDnaSequences("AAAAAAAAAAAA")
    res should equal(List("AAAAAAAAAA"))
  }
}
