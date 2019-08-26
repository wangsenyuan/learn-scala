package set0000.set000.set020.p028

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 2 when work with hello and ll" in {
    val res = Solution.strStr("hello", "ll")
    res shouldBe 2
  }

  it should "get -1 when work with aaaaa and aab" in {
    val res = Solution.strStr("aaaaa", "aab")
    res shouldBe -1
  }

  it should "get 4 when work with \"mississippi\"\n\"issip\"" in {
    val res = Solution.strStr("mississippi", "issip")
    res shouldBe 4
  }
}
