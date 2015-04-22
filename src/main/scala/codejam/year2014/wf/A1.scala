package codejam.year2014.wf

import codejam.FileOp

/**
 * Created by senyuanwang on 15/4/22.
 */
object A1 extends App with FileOp{

  override val filePrefix = "src/main/scala/codejam/year2014/wf/A-large-practice";

  val T = file.next().toInt

  def process(t: Int): Unit = {
    val n = file.next().toInt
    val m = 2 * n

    val grid = Array.fill(m, m)(0)

    for {
      i <- 0 until m
      line = file.next().toCharArray
      j <- 0 until m
    } {
      grid(i)(j) = line(j) - '0'
    }

    def inverse(str: String): String = str.map(c => (1 - (c - '0') + '0').asInstanceOf[Char])

    def countSwaps(position: List[Int]): Int = position.count(_ % 2 != 0)

    def minSwaps(f: Int => String): Int = {
      val typeA = f(0)
      val typeB = inverse(typeA)
      var positionA = Nil: List[Int]
      var positionB = Nil: List[Int]

      for {
        i <- 0 until m
        line = f(i)
      } {
        if (line == typeA) {
          positionA = i :: positionA
        } else if (line == typeB) {
          positionB = i :: positionB
        } else {
          throw new RuntimeException("IMPOSSIBLE")
        }
      }

      if (positionA.size != positionB.size) {
        throw new RuntimeException("IMPOSSIBLE")
      }

      countSwaps(positionA) min countSwaps(positionB)
    }

    try {
      val count =
        minSwaps {
          i => grid(i).mkString
        } +
          minSwaps {
            j =>
              (for (i <- 0 until m) yield grid(i)(j)).mkString
          }
      println(s"Case #$t: $count")
    } catch {
      case _: Throwable => println(s"Case #$t: IMPOSSIBLE")
    }
  }

  for {
    i <- 1 to T
  } {
    process(i)
  }
}
