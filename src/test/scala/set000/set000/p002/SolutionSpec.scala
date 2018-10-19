package set000.set000.p002

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "add two numbers with equal length correctly" in {
    val l1 = Solution.constructList(2, 4, 3)
    val l2 = Solution.constructList(5, 6, 4)

    val res = Solution.addTwoNumbers(l1, l2)

    val expect = Solution.constructList(7, 0, 8)

    res shouldEqual expect
  }

  it should "add two numbers with unequal length correctly" in {
    val l1 = Solution.constructList(2, 4, 3)
    val l2 = Solution.constructList(5, 6, 4, 1)

    val res = Solution.addTwoNumbers(l1, l2)

    val expect = Solution.constructList(7, 0, 8, 1)

    res shouldEqual expect
  }

  it should "work correctly when add carry on" in {
    val l1 = Solution.constructList(6, 2, 4, 3)
    val l2 = Solution.constructList(5, 6, 4, 1)

    val res = Solution.addTwoNumbers(l1, l2)

    val expect = Solution.constructList(1, 9, 8, 4)

    res shouldEqual expect
  }
}
