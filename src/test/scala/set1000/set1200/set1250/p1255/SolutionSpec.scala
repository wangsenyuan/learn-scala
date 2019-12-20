package set1000.set1200.set1250.p1255

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.maxScoreWords(Array("dog", "cat", "dad", "good"),
      Array('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'),
      Array(1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    res should be(23)
  }
}
