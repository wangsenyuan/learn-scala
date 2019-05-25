package set600.set690.p692

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val res = Solution.topKFrequent(Array("i", "love", "leetcode", "i", "love", "coding"), 2)
    res should equal(List("i", "love"))
  }

  "example two" should "work" in {
    val res = Solution.topKFrequent(Array("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4)
    res should equal(List("the", "is", "sunny", "day"))
  }

  "example three" should "work" in {
    val res = Solution.topKFrequent(Array("i", "love", "leetcode", "i", "love", "coding"), 1)
    res should equal(List("i"))
  }
}
