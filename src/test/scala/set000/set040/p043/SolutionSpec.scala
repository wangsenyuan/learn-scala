package set000.set040.p043

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 220 when add(123, 97)" in {
    val res = Solution.add("123", "97")
    res shouldEqual "220"
  }

  it should "get 26 when sub(123, 97)" in {
    val res = Solution.sub("123", "97")
    res shouldEqual "26"
  }

  it should "get 26 when add(123, -97)" in {
    val res = Solution.add("123", "-97")
    res shouldEqual "26"
  }

  it should "get 220 when sub(123, -97)" in {
    val res = Solution.sub("123", "-97")
    res shouldEqual "220"
  }

  it should "get -220 when add(-123, -97)" in {
    val res = Solution.add("-123", "-97")
    res shouldEqual "-220"
  }

  it should "get 152 when sub(1440, 1288)" in {
    val res = Solution.sub("1440", "1288")
    res shouldEqual "152"
  }

  it should "get 1288 when mul(23, 56)" in {
    val res = Solution.multiply("23", "56")
    res shouldEqual ("1288")
  }

  it should "get 56088 when mul(123, 456)" in {
    val res = Solution.multiply("123", "456")
    res shouldEqual ("56088")
  }


  it should "get 998001 when mul(999, 999)" in {
    val res = Solution.multiply("999", "999")
    res shouldEqual ("998001")
  }

  it should "get 12955873296249231871440 when mul(2498002655, 5186493004848)" in {
    val res = Solution.multiply("2498002655", "5186493004848")
    res shouldEqual "12955873296249231871440"
  }
}
