package set200.set290.p299

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "secret = \"1807\", guess = \"7810\"" should "get \"1A3B\"" in {
    val secret = "1807"
    val guess = "7810"
    val res = Solution.getHint(secret, guess)
    res should equal("1A3B")
  }

  "secret = \"1123\", guess = \"0111\"" should "get \"1A1B\"" in {
    val secret = "1123"
    val guess = "0111"
    val res = Solution.getHint(secret, guess)
    res should equal("1A1B")
  }
}
