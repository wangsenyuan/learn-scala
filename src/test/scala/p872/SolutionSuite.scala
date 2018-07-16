package p872

import org.junit.Test
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers

class SolutionSuite extends JUnitSuite with Checkers {

  @Test
  def testGenerate100Times: Unit = {
    val res = (0 until 100).map(_ => Solution.rand10())
    val freq = res.groupBy(identity).mapValues(_.size)
    for {
      (x, f) <- freq
      if (Math.abs(f - 10) > 3)
    } {
      printf(s"frequency ${f} for $x is far from 10\n")
    }
  }

  @Test
  def testGenerate100TimesRand7: Unit = {
    val res = (0 until 98).map(_ => Solution.rand7())
    val freq = res.groupBy(identity).mapValues(_.size)
    println(f"${res}")
    println(f"${freq}")
    for {
      (x, f) <- freq
      if (Math.abs(f - 14) > 4)
    } {
      printf(s"frequency ${f} for $x is far from 14\n")
    }
  }
}
