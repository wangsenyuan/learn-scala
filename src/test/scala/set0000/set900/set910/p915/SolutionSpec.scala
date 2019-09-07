package set0000.set900.set910.p915

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(90, 47, 69, 10, 43, 92, 31, 73, 61, 97)
    val res = Solution.partitionDisjoint(arr)
    res should be(9)
  }
}
