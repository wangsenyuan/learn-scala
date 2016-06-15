package geeks.sort.bitonic

import org.junit.Test
import org.scalacheck.Gen
import org.scalacheck.Prop._
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers

/**
  * Created by wangsenyuan on 6/15/16.
  */
class BitonicSuite extends JUnitSuite with Checkers with Sorter {

  val ints: Gen[Int] = for (n <- Gen.choose(-30, 30)) yield n
  val numsGen = (n: Int) => Gen.listOfN(n, ints)

  @Test
  def testArray101(): Unit = {
    val prop = forAll(numsGen(101)) {
      nums => {
        val vec = nums.toVector
        bitonic(vec) == vec.sorted
      }
    }
    prop.check
  }
}
