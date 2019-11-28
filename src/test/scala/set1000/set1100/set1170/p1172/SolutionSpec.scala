package set1000.set1100.set1170.p1172

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val plates = new DinnerPlates(1)
    plates.push(1)
    plates.push(2)
    plates.push(3)
    var r = plates.popAtStack(1)
    r should be(2)
    r = plates.pop()
    r should be(3)
    r = plates.pop()
    r should be(1)
  }

  "example two" should "work" in {
    val plates = new DinnerPlates(1)
    plates.push(1)
    plates.push(2)
    plates.popAtStack(1) should be(2)
    plates.pop() should be(1)
    plates.push(1)
    plates.push(2)
    plates.pop() should be(2)
    plates.pop() should be(1)
  }
}
