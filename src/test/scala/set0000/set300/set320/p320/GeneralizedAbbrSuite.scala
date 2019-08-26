package set0000.set300.set320.p320


import org.junit.Test
import org.scalacheck.Gen
import org.scalacheck.Prop._
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers

import scala.collection.JavaConverters._


/*class MySuite extends JUnitSuite with Checkers {
  @Test
  def testConcat() {
    check((a: List[Int], b: List[Int]) => a.size + b.size == (a ::: b).size)
  }
}*/
/**
  * Created by senyuanwang on 15/12/22.
  */
class GeneralizedAbbrSuite extends JUnitSuite with Checkers {
  val solution = new Solution

  @Test
  def testConcat() {
    check((a: List[Int], b: List[Int]) => a.size + b.size == (a ::: b).size)
    //println (strGen(5).sample)
  }

  val strGen: Int => Gen[String] = (n: Int) => Gen.listOfN(n, Gen.alphaChar).map(_.mkString)


  @Test
  def testGenAbbre() {
    val prop = forAll(strGen(7)) {
      str => {
        val correct = solution.generateAbbreviations(str).asScala
        val target = App.generateAbbreviations(str)
        correct.sorted == target.sorted
      }
    }
    prop.check
  }
}
