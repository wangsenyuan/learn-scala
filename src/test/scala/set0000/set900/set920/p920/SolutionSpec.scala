package set0000.set900.set920.p920

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one " should "work" in {
    Solution.numMusicPlaylists(3, 3, 1) should be(6)
  }

  "example two " should "work" in {
    Solution.numMusicPlaylists(2, 3, 0) should be(6)
  }
}
