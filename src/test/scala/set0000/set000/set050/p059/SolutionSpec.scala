package set0000.set000.set050.p059

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "spiral matrix of 3" should "get [ 1, 2, 3 ],\n [ 8, 9, 4 ],\n [ 7, 6, 5 ]" in {
    val res = Solution.generateMatrix(3)
    val str = res.map(row => row.mkString(",")).mkString(",")
    str shouldBe "1,2,3,8,9,4,7,6,5"
  }
}
