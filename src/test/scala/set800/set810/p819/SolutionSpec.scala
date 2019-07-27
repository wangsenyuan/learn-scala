package set800.set810.p819

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = Array("hit")
    val res = Solution.mostCommonWord(paragraph, banned)
    res should be("ball")
  }
}
