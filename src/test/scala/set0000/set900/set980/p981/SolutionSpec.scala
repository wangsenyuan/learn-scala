package set0000.set900.set980.p981

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val set = new Solution.TimeMap
    set.set("foo", "bar", 1)
    set.get("foo", 1) should be("bar")
    set.get("foo", 3) should be("bar")
    set.set("foo", "bar2", 4)
    set.get("foo", 4) should be("bar2")
    set.get("foo", 5) should be("bar2")
  }
}
