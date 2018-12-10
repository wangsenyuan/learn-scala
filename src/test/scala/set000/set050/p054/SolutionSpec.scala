package set000.set050.p054

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get [1,2,3,6,9,8,7,4,5] when given [\n [ 1, 2, 3 ],\n [ 4, 5, 6 ],\n [ 7, 8, 9 ]\n]" in {
    val matrix = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9),
    )
    val res = Solution.spiralOrder(matrix)

    res shouldEqual List(1, 2, 3, 6, 9, 8, 7, 4, 5)
  }

  it should "get [1,2,3,4,8,12,11,10,9,5,6,7] when given [\n[1, 2, 3, 4],\n  [5, 6, 7, 8],\n  [9,10,11,12]\n]" in {
    val matrix = Array(
      Array(1, 2, 3, 4),
      Array(5, 6, 7, 8),
      Array(9, 10, 11, 12),
    )
    val res = Solution.spiralOrder(matrix)

    res shouldEqual List(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
  }
}
