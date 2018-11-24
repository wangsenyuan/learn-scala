package set000.set000.p006

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get PAYPALISHIRING for input: PAYPALISHIRING, 3" in {
    val s = "PAYPALISHIRING"
    val numRows = 3
    val res = Solution1.convert(s, numRows)
    res shouldEqual "PAHNAPLSIIGYIR"
  }

  it should "get PINALSIGYAHRPI for input: PAYPALISHIRING, 4" in {
    val s = "PAYPALISHIRING"
    val numRows = 4
    val res = Solution1.convert(s, numRows)
    res shouldEqual "PINALSIGYAHRPI"
  }
}
