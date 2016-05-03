package leetcode.p347.top.k

import org.junit.Test
import org.scalacheck.Gen
import org.scalacheck.Prop._
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers
import p347.top.k.Solution

import scala.collection.mutable.ListBuffer
import p347.top.k.App
/**
  * Created by wangsenyuan on 5/3/16.
  */
class TopKCheckers extends JUnitSuite with Checkers {

  val solution = new Solution

  @Test
  def testScalaWayAgainstJavaWay(): Unit = {
    val ints: Gen[Int] = for (n <- Gen.choose(-30, 30)) yield n
    val lists = Gen.listOfN(1000, ints)
    val prop = forAll(lists.filter(_.size > 30)) {
      list =>
        val k = 30

        val javaResult = toScalaList(solution.topKFrequent(list.toArray, k)).map(_.asInstanceOf[Int])
        val scalaResult = App.topKFrequent(list.toArray, k)

        javaResult == scalaResult
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
