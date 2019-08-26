package set0000.set000.set030.p030

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get [0,9] when given barfoothefoobarman, and [foo, bar]" in {
    val str = "barfoothefoobarman"
    val words = Array("foo", "bar")
    val res = Solution.findSubstring(str, words)
    res shouldEqual List(0, 9)
  }
}
