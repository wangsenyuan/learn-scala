package three.sum.p015

import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers
import scala.collection.JavaConverters._
import org.junit.Test
import org.scalacheck.Gen
import org.scalacheck.Prop._

import scala.collection.mutable.ListBuffer

/**
  * Created by wangsenyuan on 1/2/16.
  */
class ThreeSumCheckers extends JUnitSuite with Checkers {
  val solution = new Solution()

  implicit val intListOrdering = new Ordering[List[Int]] {
    override def compare(x: List[Int], y: List[Int]): Int = {
      val diffAt = x.zip(y).dropWhile(a => a._1 == a._2)
      diffAt match {
        case Nil => 0
        case (a, b) :: _ =>
          if (a > b) 1
          else -1
      }
    }
  }

  @Test
  def testThreeSum(): Unit = {
    val nums = Array(-1, 0, 1, 2, -1, -4)
    val expected = toScalaList(solution.threeSum(nums)).map(toScalaList(_).map(_.asInstanceOf[Int]))
    val target = App.threeSum(nums)
    assert(expected.sorted == target.sorted)
  }

  @Test
  def testThreeSumWithMultipleInput(): Unit = {
    val ints: Gen[Int] = for (n <- Gen.choose(-100, 100)) yield n
    val lists = Gen.listOfN(100, ints)
    val prop = forAll(lists) {
      list =>
       val nums = list.toArray
        val expected = toScalaList(solution.threeSum(nums)).map(toScalaList(_).map(_.asInstanceOf[Int]))
        val target = App.threeSum(nums)
        expected.sorted == target.sorted
        //println(list)
        //true
    }

    prop.check
  }

  def toScalaList[A](list: java.util.List[A]): List[A] = {
    val listBuffer = ListBuffer.empty[A]

    for {
      i <- 0 until list.size()
    } {
      listBuffer += list.get(i)
    }

    listBuffer.toList
  }
}
