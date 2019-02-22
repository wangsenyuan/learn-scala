package set300.set380.p385

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[123,[456,[789]]]" should "work" in {
    val res = Solution.deserialize("[123,[456,[789]]]")

    res should not(be(null))


  }

  "[-1]" should "work" in {
    val res = Solution.deserialize("[-1]")

    res should not(be(null))
  }
}
