package set0000.set800.set850.p854

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val A = "ab"
    val B = "ba"
    val res = Solution.kSimilarity(A, B)
    res should be(1)
  }

  "example two" should "work" in {
    val A = "abc"
    val B = "bca"
    val res = Solution.kSimilarity(A, B)
    res should be(2)
  }

  "example three" should "work" in {
    val A = "abac"
    val B = "baca"
    val res = Solution.kSimilarity(A, B)
    res should be(2)
  }

  "example four" should "work" in {
    val A = "aabc"
    val B = "abca"
    val res = Solution.kSimilarity(A, B)
    res should be(2)
  }

  "example five" should "work" in {
    val A = "abbcac"
    val B = "abcbca"
    val res = Solution.kSimilarity(A, B)
    res should be(2)
  }
}
