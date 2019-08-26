package set0000.set600.set640.p645

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "[2, 2]" should "get [2, 1]" in {
    val res = Solution.findErrorNums(Array(2, 2))
    res should be(Array(2, 1))
  }

  "[1,2,2,4]" should "get [2, 3]" in {
    val res = Solution.findErrorNums(Array(1,2,2,4))
    res should be(Array(2, 3))
  }
}
