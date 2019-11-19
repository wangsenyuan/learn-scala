package set1000.set1100.set1120.p1125

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val req_skills = Array("java", "nodejs", "reactjs")
    val people = List(List("java"), List("nodejs"), List("nodejs", "reactjs"))
    val res = Solution.smallestSufficientTeam(req_skills, people)
    res should be(Array(0, 2))
  }
}
