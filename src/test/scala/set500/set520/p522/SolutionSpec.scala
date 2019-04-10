package set500.set520.p522

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "[aba, cdc, eae]" should "get 3" in {
    val res = Solution.findLUSlength(Array("aba", "cdc", "eae"))
    res should be(3)
  }

  "[aaa, aaa, aa]" should "get -1" in {
    val res = Solution.findLUSlength(Array("aaa", "aaa", "aa"))
    res should be(-1)
  }
}
