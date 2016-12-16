package rmq

import com.me.problem.rmq.TrivalRMQ
import org.junit.Test
import org.scalacheck.{Gen, Prop}
import org.scalatest.junit.JUnitSuite
import org.scalatest.prop.Checkers

/**
  * Created by wangsenyuan on 16/12/2016.
  */
class TrivalRMQTest extends JUnitSuite with Checkers {

  @Test
  def queryMinFromASortedArray() {
    val intList = Gen.listOfN(100, Gen.alphaNumChar).map(_.map(_.toInt))

    Prop.forAll(intList) {
      list =>
        val sorted = list.sorted.toArray
        val rmq = new TrivalRMQ(sorted)
        rmq.query(1, 99) == sorted(1)
    } check
  }
}
