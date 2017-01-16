package codechef.easy.mgcrnk

import org.scalatest.FlatSpec

/**
  * Created by wangsenyuan on 16/01/2017.
  */
class MagicianRankSpec extends FlatSpec {

  "The magician presents before such judges" should "get maximum average score 0.0" in {
    val n = 2
    val judges = Array(Array(0, -4), Array(8, 0))
    val res = Main.evaluate(judges, n)
    assert(res === 8.0)
  }

  it should "fail due to Bad Judges" in {
    val n = 2
    val judges = Array(Array(0, -45), Array(-3, 0))
    val res = Main.evaluate(judges, n)
    assert(res < 0.0)
  }
}
