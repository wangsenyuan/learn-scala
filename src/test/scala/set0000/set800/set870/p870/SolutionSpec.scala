package set0000.set800.set870.p870

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val B = Array(1, 10, 4, 11)
    val res = Solution.advantageCount(Array(2, 7, 11, 15), Array(1, 10, 4, 11))
    val cnt = res.zip(B).count(x => x._1 > x._2)
    cnt should be(4)
  }

  "example two" should "work" in {
    val B = Array(13, 25, 32, 11)
    val res = Solution.advantageCount(Array(12, 24, 8, 32), Array(13, 25, 32, 11))
    val cnt = res.zip(B).count(x => x._1 > x._2)
    cnt should be(3)
  }
}
