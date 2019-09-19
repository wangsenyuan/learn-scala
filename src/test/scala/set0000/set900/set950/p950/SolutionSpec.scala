package set0000.set900.set950.p950

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val deck = Array(1, 2)
    val res = Solution.deckRevealedIncreasing(deck)

    res should equal(Array(1, 2))
  }

  "example two" should "work" in {
    val deck = Array(1, 2, 3)
    val res = Solution.deckRevealedIncreasing(deck)

    res should equal(Array(1, 3, 2))
  }

  "example three" should "work" in {
    val deck = Array(1, 2, 3, 4)
    val res = Solution.deckRevealedIncreasing(deck)

    res should equal(Array(1, 3, 2, 4))
  }

  "example five" should "work" in {
    val deck = Array(17, 13, 11, 2, 3, 5, 7)
    val res = Solution.deckRevealedIncreasing(deck)

    res should equal(Array(2, 13, 3, 11, 5, 17, 7))
  }

  "example six" should "work" in {
    val deck = Array(1, 2, 3, 4, 5)
    val res = Solution.deckRevealedIncreasing(deck)

    res should equal(Array(1, 5, 2, 4, 3))
  }
}
