package codejam.year2015.round1

import codejam.FileOp

import scala.annotation.tailrec

/**
 * Created by senyuanwang on 15/5/19.
 */
object B extends App with FileOp {
  override val filePrefix = "/Users/senyuanwang/IdeaProjects/ALG/src/main/scala/codejam/year2015/round1/B-large-practice"

  def naiveGetBarberNumber(n: Int, ms: Array[Int]): Int = {
    @tailrec
    def travel(barber: Int, customer: Int, t: Int): Int = {
      val nextBarber = (barber + 1) % ms.length
      val nextT = if (nextBarber == 0) t + 1 else t
      if (t % ms(barber) == 0) {
        if (customer == n) {
          barber
        } else {
          travel(nextBarber, customer + 1, nextT)
        }
      } else {
        travel(nextBarber, customer, nextT)
      }
    }
    travel(0, 1, 0)
  }

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def slowGetBarberNumber(n: Long, ms: Array[Int]): Int = {
    val period = ms.reduce((p, m) => p / gcd(p, m) * m)

    val customersPerPhase = ms.foldLeft(0)((r, m) => r + period / m)

    val nInLastPhase = (n % customersPerPhase).asInstanceOf[Int]

    naiveGetBarberNumber(if (nInLastPhase > 0) nInLastPhase else customersPerPhase, ms)
  }

  def countServedCustomers(t: Long, ms: Array[Int]): Long = {
    if (t < 0) 0
    else {
      ms.foldLeft(0L)((res, m) => res + t / m + 1)
    }
  }

  def fastGetBarberNumber(n: Long, ms: Array[Int]): Int = {
    @tailrec
    def bsTime(low: Long, high: Long): Long =
      if (low + 1 >= high) high
      else if (countServedCustomers((low + high) / 2, ms) < n) {
        bsTime((low + high) / 2, high)
      } else {
        bsTime(low, (low + high) / 2)
      }

    val t = bsTime(-1, 10000 * n)

    val customerServedBefore = countServedCustomers(t - 1, ms)
    val customerToBeServed = n - customerServedBefore

    @tailrec
    def findBarber(barber: Int, customer: Long): Int = {
      if (customer == 0) barber - 1
      else if (t % ms(barber) == 0) {
        findBarber(barber + 1, customer - 1)
      } else {
        findBarber(barber + 1, customer)
      }
    }

    findBarber(0, customerToBeServed)
  }

  val T = file.next().toInt

  for {
    t <- 1 to T
    firstLine = file.next().split("\\s+")
    _ = firstLine(0).toInt
    n = firstLine(1).toLong
    ms = file.next().split("\\s+").map(_.toInt)
  } {
    val barber = fastGetBarberNumber(n, ms) + 1
    println(s"Case #$t: $barber")
  }
}
