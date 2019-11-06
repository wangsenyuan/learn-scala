package set1000.set1000.set1070.p1071

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.gcdOfStrings("ABCABC", "ABC")
    res should be("ABC")
  }

  "example two" should "work" in {
    val res = Solution.gcdOfStrings("ABC", "ABCABC")
    res should be("ABC")
  }


  "example three" should "work" in {
    val res = Solution.gcdOfStrings("ABABAB", "ABAB")
    res should be("AB")
  }
  "example four" should "work" in {
    val res = Solution.gcdOfStrings("LEET", "ABAB")
    res should be("")
  }
}
