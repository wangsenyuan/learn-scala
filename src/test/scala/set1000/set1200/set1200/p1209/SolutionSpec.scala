package set1000.set1200.set1200.p1209

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.removeDuplicates("abcd", 2)
    res should be("abcd")
  }

  "example two" should "work" in {
    val res = Solution.removeDuplicates("deeedbbcccbdaa", 3)
    res should be("aa")
  }

  "example three" should "work" in {
    val res = Solution.removeDuplicates("pbbcggttciiippooaais", 2)
    res should be("ps")
  }
}
