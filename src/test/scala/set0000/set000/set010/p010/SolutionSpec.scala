package set0000.set000.set010.p010

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get false when match aa against a" in {
    val res = Solution.isMatch("aa", "a")
    res shouldBe (false)
  }

  it should "get true when match aa against a*" in {
    val res = Solution.isMatch("aa", "a*")
    res shouldBe (true)
  }

  it should "get true when match aa against .*" in {
    val res = Solution.isMatch("aa", ".*")
    res shouldBe (true)
  }

  it should "get false when match mississippi against mis*is*p*." in {
    val res = Solution.isMatch("mississippi", "mis*is*p*.")
    res shouldBe (false)
  }

  it should "get true when match aab against c*a*b" in {
    val res = Solution.isMatch("aab", "c*a*b")
    res shouldBe (true)
  }

  it should "get true when match aab against a*b" in {
    val res = Solution.isMatch("aab", "a*b")
    res shouldBe (true)
  }

  it should "get true when match aaa against ab*a*c*a" in {
    val res = Solution.isMatch("aaa", "ab*a*c*a")
    res shouldBe (true)
  }

  it should "get true when match ab against .*" in {
    val res = Solution.isMatch("ab", ".*")
    res shouldBe (true)
  }


  it should "get true when match a against ab*" in {
    val res = Solution.isMatch("a", "ab*")
    res shouldBe (true)
  }

  it should "get true when match ab against .*c" in {
    val res = Solution.isMatch("ab", ".*c")
    res shouldBe (false)
  }

  it should "get true when match a against ab*a" in {
    val res = Solution.isMatch("a", "ab*a")
    res shouldBe (false)
  }
}
