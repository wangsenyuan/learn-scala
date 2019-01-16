package set200.set220.p225

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val stack = new MyStack()
    stack.push(1)
    stack.push(2)
    val x = stack.top()
    x should be(2)
    stack.pop()
    val y = stack.top()
    y should be(1)
    stack.pop()
    stack.empty() should be(true)
  }
}
