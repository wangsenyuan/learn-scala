package set300.set320.p321

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[3, 4, 6, 5] & [9, 1, 2, 5, 8, 3]" should "get [9, 8, 6, 5, 3]" in {
    val num1 = Array(3, 4, 6, 5)
    val num2 = Array(9, 1, 2, 5, 8, 3)
    val k = 5
    val res = Solution.maxNumber(num1, num2, k)
    res should equal(Array(9, 8, 6, 5, 3))
  }

  "[6, 7] & [6, 0, 4]" should "get [6, 7, 6, 0, 4]" in {
    val num1 = Array(6, 7)
    val num2 = Array(6, 0, 4)
    val k = 5
    val res = Solution.maxNumber(num1, num2, k)
    res should equal(Array(6, 7, 6, 0, 4))
  }

  "[3, 9] & [8, 9]" should "get [9, 8, 9]" in {
    val num1 = Array(3, 9)
    val num2 = Array(8, 9)
    val k = 3
    val res = Solution.maxNumber(num1, num2, k)
    res should equal(Array(9, 8, 9))
  }

  "[] & [1]" should "get [1]" in {
    val num1 = Array.empty[Int]
    val num2 = Array(1)
    val k = 1
    val res = Solution.maxNumber(num1, num2, k)
    res should equal(Array(1))
  }

  "[2,5,6,4,4,0] & [7,3,8,0,6,5,7,6,2]" should "get [7,3,8,2,5,6,4,4,0,6,5,7,6,2,0]" in {
    val num1 = Array(2, 5, 6, 4, 4, 0)
    val num2 = Array(7, 3, 8, 0, 6, 5, 7, 6, 2)
    val k = 15
    val res = Solution.maxNumber(num1, num2, k)
    res should equal(Array(7, 3, 8, 2, 5, 6, 4, 4, 0, 6, 5, 7, 6, 2, 0))
  }
}
