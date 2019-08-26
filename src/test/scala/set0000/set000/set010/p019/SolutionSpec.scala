package set0000.set000.set010.p019

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get [1, 2, 3, 5] in remove 2nd last from [1,2,3,4,5]" in {
    val head = Solution.parseAsList("[1,2,3,4,5]")
    val res = Solution.removeNthFromEnd(head, 2)
    val resStr = "[" + res.toString + "]"
    resStr shouldEqual "[1,2,3,5]"
  }
}
