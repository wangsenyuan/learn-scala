package set0000.set300.set330.p332

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[[\"MUC\", \"LHR\"], [\"JFK\", \"MUC\"], [\"SFO\", \"SJC\"], [\"LHR\", \"SFO\"]]" should "get [\"JFK\", \"MUC\", \"LHR\", \"SFO\", \"SJC\"]" in {
    val tickets = Array(Array("MUC", "LHR"), Array("JFK", "MUC"), Array("SFO", "SJC"), Array("LHR", "SFO"))
    val res = Solution.findItinerary(tickets)
    res should equal(List("JFK", "MUC", "LHR", "SFO", "SJC"))
  }

  "[[\"JFK\",\"SFO\"],[\"JFK\",\"ATL\"],[\"SFO\",\"ATL\"],[\"ATL\",\"JFK\"],[\"ATL\",\"SFO\"]]" should "get [\"JFK\",\"ATL\",\"JFK\",\"SFO\",\"ATL\",\"SFO\"]" in {
    val tickets = Array(Array("JFK", "SFO"), Array("JFK", "ATL"), Array("SFO", "ATL"), Array("ATL", "JFK"), Array("ATL", "SFO"))
    val res = Solution.findItinerary(tickets)
    res should equal(List("JFK", "ATL", "JFK", "SFO", "ATL", "SFO"))
  }

  "example three" should "work" in {
    val tickets = Array(Array("EZE", "AXA"), Array("TIA", "ANU"), Array("ANU", "JFK"), Array("JFK", "ANU"), Array("ANU", "EZE"), Array("TIA", "ANU"), Array("AXA", "TIA"), Array("TIA", "JFK"), Array("ANU", "TIA"), Array("JFK", "TIA"))
    val res = Solution.findItinerary(tickets)
    res should equal(List("JFK", "ANU", "EZE", "AXA", "TIA", "ANU", "JFK", "TIA", "ANU", "TIA", "JFK"))
  }
}
