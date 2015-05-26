package codejam.year2008.round1b

import java.util

import codejam.FileOp
import codejam.union.find.set.UFSet

import scala.collection.mutable.ListBuffer

/**
 * Created by senyuanwang on 15/5/26.
 */
object B extends App with FileOp {

  def primeNumbers(max: Int): util.BitSet = {
    val bs = new util.BitSet(max + 1)
    bs.set(1) //1 is not prime
    var x = bs.nextClearBit(1)

    while (x <= max) {
      for {
        y <- 2 * x to max by x
      } {
        bs.set(y)
      }
      x = bs.nextClearBit(x + 1)
    }
    bs
  }

  lazy val primes = {
    val nums = primeNumbers(1000000)
    val lb = new ListBuffer[Int]
    for {
      x <- 1 until 1000000
      if (!nums.get(x))
    } {
      lb += x
    }
    lb.toArray
  }

  /*for {
    i <- 2 until 101
    if(!primes.get(i))
  } {
    print(s"$i ")
  }*/

  def solve(a: Int, b: Int, p: Int): Int = {
    val len = b - a + 1
    val ufset = new UFSet(len)

    for {
      i <- 0 until primes.length
      if (primes(i) >= p)
    } {
      val start = (a + primes(i) - 1) / primes(i) * primes(i)
      val end = b / primes(i) * primes(i)

      for {
        j <- start to end by primes(i)
      } {
        ufset.union(start - a, j - a)
      }
    }

    (a to b).count(i => ufset.find(i - a) == i - a)
  }

  override val filePrefix = "src/main/scala/codejam/year2008/round1b/B-small-practice"

  val T = file.next().toInt

  for {
    t <- 1 to T
    line = file.next().split("\\s+").map(_.toInt)
    a = line(0)
    b = line(1)
    p = line(2)
  } {
    val res = solve(a, b, p)
    println(s"Case #$t: $res")
  }
}
