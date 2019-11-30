package set1000.set1100.set1170.p1178

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val words = Array("aaaa", "asas", "able", "ability", "actt", "actor", "access")
    val puzzles = Array("aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz")
    val res = Solution.findNumOfValidWords(words, puzzles)
    res should be(Array(1, 1, 3, 2, 4, 0))
  }
}
