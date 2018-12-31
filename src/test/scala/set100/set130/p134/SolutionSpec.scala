package set100.set130.p134

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "[1,2,3,4,5] and [3,4,5,1,2]" should "get 3" in {
    val gas = Array(1, 2, 3, 4, 5)
    val cost = Array(3, 4, 5, 1, 2)

    val res = Solution.canCompleteCircuit(gas, cost)

    res should be(3)
  }


  "[1] and [1]" should "get 0" in {
    val gas = Array(1)
    val cost = Array(1)

    val res = Solution.canCompleteCircuit(gas, cost)

    res should be(0)
  }

  "[2,3,4] and [3,4,3]" should "get -1" in {
    val gas = Array(2, 3, 4)
    val cost = Array(3, 4, 3)

    val res = Solution.canCompleteCircuit(gas, cost)

    res should be(-1)
  }
}
