package set0000.set300.set320.p320

import org.scalatest._
import Matchers._
import scala.collection.JavaConverters._

/**
  * Created by senyuanwang on 15/12/22.
  */
class GenAbbreSpec extends FlatSpec {

  val solution = new Solution

  val expected = List("word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4")

  "word abbreviation" should "get the expected list by solution" in {
    solution.generateAbbreviations("word").asScala should contain theSameElementsAs expected
  }

  "word abbreviation" should "get the expected list by app" in {
    App.generateAbbreviations("word") should contain theSameElementsAs expected
  }

}
