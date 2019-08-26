package set0000.set700.set770.p770

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val expr = "e + 8 - a + 5"
    val res = Solution.basicCalculatorIV(expr, Array("e"), Array(1))
    res should equal(List("-1*a","14"))
  }

  "example two" should "work" in {
    val expr = "e - 8 + temperature - pressure"
    val res = Solution.basicCalculatorIV(expr, Array("e", "temperature"), Array(1, 12))
    res should equal(List("-1*pressure","5"))
  }

  "example three" should "work" in {
    val expr = "(e + 8) * (e - 8)"
    val res = Solution.basicCalculatorIV(expr, Array(), Array())
    res should equal(List("1*e*e","-64"))
  }

  "example four" should "work" in {
    val expr = "7 - 7"
    val res = Solution.basicCalculatorIV(expr, Array(), Array())
    res should equal(List())
  }

  "example five" should "work" in {
    val expr = "a * b * c + b * a * c * 4"
    val res = Solution.basicCalculatorIV(expr, Array(), Array())
    res should equal(List("5*a*b*c"))
  }

  "example six" should "work" in {
    val expr = "((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))"
    val res = Solution.basicCalculatorIV(expr, Array(), Array())
    res should equal(List("-1*a*a*b*b","2*a*a*b*c","-1*a*a*c*c","1*a*b*b*b","-1*a*b*b*c","-1*a*b*c*c","1*a*c*c*c","-1*b*b*b*c","2*b*b*c*c","-1*b*c*c*c","2*a*a*b","-2*a*a*c","-2*a*b*b","2*a*c*c","1*b*b*b","-1*b*b*c","1*b*c*c","-1*c*c*c","-1*a*a","1*a*b","1*a*c","-1*b*c"))
  }

  "example seven" should "work" in {
    val expr = "0"
    val res = Solution.basicCalculatorIV(expr, Array(), Array())
    res should equal(List())
  }}
