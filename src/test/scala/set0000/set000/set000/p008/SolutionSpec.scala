package set0000.set000.set000.p008

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 0 when atoi('words and 987')" in {
    val res = Solution.myAtoi("words and 987")
    res shouldEqual 0
  }

  it should "get -2147483648 when atoi('-91283472332')" in {
    val res = Solution.myAtoi("-91283472332")
    res shouldEqual -2147483648
  }

  it should "get 42 when atoi('42')" in {
    val res = Solution.myAtoi("42")
    res shouldEqual 42
  }

  it should "get 2147483647 when atoi('9223372036854775808')" in {
    val res = Solution.myAtoi("9223372036854775808")
    res shouldEqual Int.MaxValue
  }

  it should "get 2147483647 when atoi('2147483648')" in {
    val res = Solution.myAtoi("2147483648")
    res shouldEqual Int.MaxValue
  }
}
