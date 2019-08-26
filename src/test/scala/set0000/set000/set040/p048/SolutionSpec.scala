package set0000.set000.set040.p048

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "work in example1" in {
    val mat = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9),
    )
    Solution.rotate(mat)

    val s = mat.map(row => row.mkString).mkString

    s shouldEqual "741852963"
  }

  it should "work in example2" in {
    val mat = Array(
      Array(5, 1, 9, 11),
      Array(2, 4, 8, 10),
      Array(13, 3, 6, 7),
      Array(15, 14, 12, 16),
    )
    Solution.rotate(mat)
    val s = mat.map(row => row.mkString(",")).mkString(",")
    s shouldEqual "15,13,2,5,14,3,4,1,12,6,8,9,16,7,10,11"

  }

  it should "work in example3" in {
    val mat = Array(
      Array(4, 8),
      Array(3, 6),

    )
    Solution.rotate(mat)
    val s = mat.map(row => row.mkString(",")).mkString(",")
    s shouldEqual "3,4,6,8"

  }
}
