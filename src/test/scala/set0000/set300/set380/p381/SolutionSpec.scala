package set0000.set300.set380.p381

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val sol = new RandomizedCollection();
    sol.insert(1)
    sol.insert(1)
    sol.insert(2)
    sol.getRandom()
    sol.remove(1)
    sol.getRandom()
  }
}
