package set600.set640.p649

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "RDD" should "get Dire" in {
    val res = Solution.predictPartyVictory("RDD")
    res should be("Dire")
  }

  "DRRDRDRDRDDRDRDR" should "get Radiant" in {
    val res = Solution.predictPartyVictory("DRRDRDRDRDDRDRDR")
    res should be("Radiant")
  }
}
