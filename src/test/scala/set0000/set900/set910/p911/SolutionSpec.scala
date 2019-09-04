package set0000.set900.set910.p911

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val persons = Array(0, 1, 1, 0, 0, 1, 0)
    val times = Array(0, 5, 10, 15, 20, 25, 30)
    val solution = new Solution.TopVotedCandidate(persons, times)
    solution.q(3) should be(0)
    solution.q(12) should be(1)
    solution.q(25) should be(1)
    solution.q(15) should be(0)
    solution.q(24) should be(0)
    solution.q(8) should be(1)
  }
}
