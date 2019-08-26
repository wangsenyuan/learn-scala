package set0000.set700.set760.p763

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val str = "ababcbacadefegdehijhklij"
    val res = Solution.partitionLabels(str)
    res should equal(List(9, 7, 8))
  }
}
