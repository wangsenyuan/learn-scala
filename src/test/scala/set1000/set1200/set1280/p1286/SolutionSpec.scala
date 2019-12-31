package set1000.set1200.set1280.p1286

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val iter = new Solution.CombinationIterator("abc", 2)
    iter.hasNext() should be(true)
    iter.next() should be("ab")
    iter.next() should be("ac")
    iter.next() should be("bc")
    iter.hasNext() should be(false)
  }
}
