package set200.set280.p282

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "123 and 6" should "get [1+2+3, 1*2*3]" in {
    val res = Solution.addOperators("123", 6)
    val expect = List("1+2+3", "1*2*3").sorted
    res.sorted should equal(expect)
  }

  "232 and 8" should "get [2*3+2, 2+3*2]" in {
    val res = Solution.addOperators("232", 8)
    val expect = List("2*3+2", "2+3*2").sorted
    res.sorted should equal(expect)
  }

  "105 and 5" should "get [1*0+5,10-5]" in {
    val res = Solution.addOperators("105", 5)
    val expect = List("1*0+5", "10-5").sorted
    res.sorted should equal(expect)
  }

  "00 and 0" should "get [0+0, 0-0, 0*0]" in {
    val res = Solution.addOperators("00", 0)
    val expect = List("0+0", "0-0", "0*0").sorted
    res.sorted should equal(expect)
  }


  "3456237490 and 9191" should "get []" in {
    val res = Solution.addOperators("3456237490", 9191)
    res should equal(Nil)
  }


  "2147483648 and -2147483648" should "get []" in {
    val res = Solution.addOperators("2147483648", -2147483648)
    res should equal(Nil)
  }
}
