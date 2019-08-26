package set0000.set700.set730.p736

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.evaluate("(add 1 2)")
    res should be(3)
  }

  "example two" should "work" in {
    val res = Solution.evaluate("(mult 3 (add 2 3))")
    res should be(15)
  }

  "example three" should "work" in {
    val res = Solution.evaluate("(let x 2 (mult x 5))")
    res should be(10)
  }

  "example four" should "work" in {
    val res = Solution.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))")
    res should be(14)
  }

  "example five" should "work" in {
    val res = Solution.evaluate("(let x 3 x 2 x)")
    res should be(2)
  }

  "example six" should "work" in {
    val res = Solution.evaluate("(let x 1 y 2 x (add x y) (add x y))")
    res should be(5)
  }

  "example seven" should "work" in {
    val res = Solution.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))")
    res should be(6)
  }

  "example eight" should "work" in {
    val res = Solution.evaluate("(let a1 3 b2 (add a1 1) b2) ")
    res should be(4)
  }

  "example nine" should "work" in {
    val res = Solution.evaluate("(let x -2 y x y)")
    res should be(-2)
  }

  "example ten" should "work" in {
    val res = Solution.evaluate("(let x 7 -12)")
    res should be(-12)
  }
}
