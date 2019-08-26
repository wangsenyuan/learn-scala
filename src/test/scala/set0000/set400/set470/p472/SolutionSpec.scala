package set0000.set400.set470.p472

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val words = Array("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat")
    val res = Solution.findAllConcatenatedWordsInADict(words)
    val expect = List("catsdogcats","dogcatsdog","ratcatdogcat").sorted
    res.sorted should equal(expect)
  }
}
