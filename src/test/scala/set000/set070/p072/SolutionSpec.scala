package set000.set070.p072

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "editing distance of horse and ros" should "be 3" in {
    Solution.minDistance("horse", "ros") should be(3)
  }

  "editing distance of intention and ros" should "be 5" in {
    Solution.minDistance("intention", "execution") should be(5)
  }

  "editing distance of dinitrophenylhydrazine and phenylhydrazine" should "be 7" in {
    Solution.minDistance("dinitrophenylhydrazine", "phenylhydrazine") should be(7)
  }
}
