package rmq

import com.me.problem.rmq.{SparseTableRMQ, TrivalRMQ}
import org.junit.Test
import org.scalacheck.{Gen, Prop}
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers
import scala.language.postfixOps
/**
  * Created by wangsenyuan on 16/12/2016.
  */
class SparseTableRMQTest extends JUnitSuite with Checkers {

  @Test
  def queryMinFromASortedArray() {
    val intList = Gen.listOfN(100, Gen.alphaNumChar).map(_.map(_.toInt))

    Prop.forAll(intList.filter(_.size == 100)) {
      list =>
        val sorted = list.sorted.toArray
        val rmq = new SparseTableRMQ(sorted)
        rmq.query(1, 99) == sorted(1)
    } check
  }

  @Test
  def testSTWithTrival(): Unit = {
    val intList = Gen.listOfN(100, Gen.alphaNumChar).map(_.map(_.toInt))
    Prop.forAll(intList) {
      list =>
        val arr = list.toArray
        val trivalRMQ = new TrivalRMQ(arr)
        val sparseTableRMQ = new SparseTableRMQ(arr)
        (for {
          i <- 0 until arr.size
          j <- i until arr.size
        } yield {
          trivalRMQ.query(i, j) == sparseTableRMQ.query(i, j)
        }).forall(_ == true)
    } check
  }
}
