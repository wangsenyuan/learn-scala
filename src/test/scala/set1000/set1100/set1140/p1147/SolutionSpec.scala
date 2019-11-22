package set1000.set1100.set1140.p1147

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val text = "ghiabcdefhelloadamhelloabcdefghi"
    val res = Solution.longestDecomposition(text)
    res should be(7)
  }

  "example two" should "work" in {
    val text = "merchant"
    val res = Solution.longestDecomposition(text)
    res should be(1)
  }

  "example three" should "work" in {
    val text = "antaprezatepzapreanta"
    val res = Solution.longestDecomposition(text)
    res should be(11)
  }

  "example four" should "work" in {
    val text = "aaa"
    val res = Solution.longestDecomposition(text)
    res should be(3)
  }
}
