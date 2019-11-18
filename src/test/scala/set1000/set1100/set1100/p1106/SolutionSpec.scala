package set1000.set1100.set1100.p1106

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val expr = "!(f)"
    val res = Solution.parseBoolExpr(expr)
    res should be(true)
  }

  "example two" should "work" in {
    val expr = "|(f,t)"
    val res = Solution.parseBoolExpr(expr)
    res should be(true)
  }

  "example three" should "work" in {
    val expr = "&(t,f)"
    val res = Solution.parseBoolExpr(expr)
    res should be(false)
  }

  "example four" should "work" in {
    val expr = "|(&(t,f,t),!(t))"
    val res = Solution.parseBoolExpr(expr)
    res should be(false)
  }
}
