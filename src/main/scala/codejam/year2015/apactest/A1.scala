package codejam.year2015.apactest

import codejam.FileOp

/**
 * Created by senyuanwang on 15/5/1.
 */
object A1 extends App with FileOp {
  override val filePrefix = "src/main/scala/codejam/year2015/apactest/A-large-practice"

  type LED = List[Int]

  object LED {
    def apply(str: String): LED = (str.toCharArray().map(_ - '0')).toList
  }

  def markMask(a: LED, b: LED, mask: LED): Option[LED] = {
    (a, b, mask) match {
      case (1 :: at, 1 :: bt, 2 :: mt) => markMask(at, bt, mt).map(mask => 1 :: mask) //确认该节点是正常的
      case (1 :: at, 1 :: bt, 1 :: mt) => markMask(at, bt, mt).map(mask => 1 :: mask) //正常case
      case (1 :: at, 1 :: bt, 0 :: mt) => None //已确认损坏的节点被点亮了，和前面的case矛盾
      case (1 :: at, 0 :: bt, _) => None //不该点亮的节点被点亮了
      case (0 :: at, 1 :: bt, 1 :: mt) => None //已确认该节点work的情况下，该节点未点亮
      case (0 :: at, 1 :: bt, _ :: mt) => markMask(at, bt, mt).map(mask => 0 :: mask) //确认该节点是损坏的
      case (0 :: at, 0 :: bt, m :: mt) => markMask(at, bt, mt).map(mask => m :: mask) //无法确认该节点是否损坏
      case (Nil, Nil, Nil) => Some(Nil)
      case _ => throw new Error("")
    }
  }

  def light(led: LED, mask: LED): LED =
    (led, mask) match {
      case (1 :: at, 2 :: bt) => throw new Exception("ERROR")
      case (a :: at, b :: bt) => (a & b) :: light(at, bt)
      case _ => Nil
    }

  def solve(input: List[LED], path: List[LED], mask: LED): Option[LED] =
    (input, path) match {
      case (Nil, head :: tail) =>
        Some(light(head, mask))
      case (a :: at, b :: bt) =>
        markMask(a, b, mask).flatMap(solve(at, bt ++ List(b), _))
    }

  val ZERO = LED("1111110")
  val ONE = LED("0110000")
  val TWO = LED("1101101")
  val THREE = LED("1111001")
  val FOUR = LED("0110011")
  val FIVE = LED("1011011")
  val SIX = LED("1011111")
  val SEVEN = LED("1110000")
  val EIGHT = LED("1111111")
  val NINE = LED("1111011")

  val cycle = NINE :: EIGHT :: SEVEN :: SIX :: FIVE :: FOUR :: THREE :: TWO :: ONE :: ZERO :: Nil

  def startCycle(x: Int): List[LED] = {
    val (a, b) = cycle.splitAt(9 - x)
    b ++ a
  }

  def substract(leds: List[LED], list: List[LED], index: Int, result: List[LED]): Option[List[LED]] = {
    (leds, list) match {
      case (Nil, _) => Some(result.reverse)
      case (a :: at, b :: bt) if (index < 10) => substract(at, list, index + 1, a :: result)
      case (a :: at, b :: bt) if a != b => None
      case (a :: at, b :: bt) => substract(at, bt, index + 1, a :: result)
    }
  }

  def process(t: Int): Option[LED] = {
    val line = file.next().split("\\s+")
    val n = line(0).toInt

    val leds =
      (for {
        i <- 1 to n
        led = LED(line(i))
      } yield led).toList
    substract(leds, leds, 0, Nil).flatMap {
      leds =>
        val m = -1
        val mask = LED("2222222")
        try {
          val result = (for {
            i <- 9 to 0 by -1
            led <- solve(leds, startCycle(i), mask)
          } yield led).toSet

          if (result.size != 1) {
            None
          } else {
            Some(result.head)
          }
        } catch {
          case error: Exception => None
        }
    }
  }

  val T = file.next().toInt
  for {
    t <- 1 to T
  } {
    process(t) match {
      case Some(res) => println(s"Case #$t: ${res.mkString}")
      case None => println(s"Case #$t: ERROR!")
    }
  }
}
